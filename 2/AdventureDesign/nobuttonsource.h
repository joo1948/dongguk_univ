#include <Servo.h>
#include <Wire.h>
#include <LiquidCrystal_I2C.h>
LiquidCrystal_I2C lcd(0x27,16,2);

#define trigPin1 11
#define echoPin1 12
#define trigPin2 9
#define echoPin2 10

#define servoPin 3
#define openButtonPin 4 //여는 
#define closeButtonPin 5 //닫히는 잠그는
#define testButtonPin 6

unsigned long startTime = 0;
bool isNear = false;


Servo myServo;

int servoState = 0; //1: 뚜껑 닫힘(ervo(0)), 0:뚜껑 열림(servo(1))

void setup()
{

  pinMode(trigPin1,OUTPUT);
  pinMode(echoPin1,INPUT);
  pinMode(trigPin2,OUTPUT);
  pinMode(echoPin2,INPUT);

  pinMode(openButtonPin,INPUT);
  pinMode(closeButtonPin,INPUT);
  pinMode(testButtonPin,INPUT);


  myServo.attach(servoPin);
  Serial.println(myServo.attached());

  Serial.begin(9600);
  lcd.init();
  lcd.backlight();

}

void loop(){
 
  int checkButton = digitalRead(testButtonPin);
  
  int angle;
  Serial.println("loop start");
  
  int distance_result = check_distance();

  work_servo(distance_result);
  
  
  if(servoState == 1){
    //서보모터 
    if(digitalRead(openButtonPin)==HIGH){
      myServo.write(90);
      servoState=0;
      delay(500);
    }
  }
  else {
    //완전히 닫기, 24시간동안 열리지 않음
    if(digitalRead(closeButtonPin)==HIGH){
      myServo.write(0);
      servoState=90;
      delay(80000);
    }
  }
  
}

int work_servo(int distance){
  if(distance){
    // 1 :: 미만 쓰레기가 꽉 찬 상태 > 0 도
    Serial.println("쓰레기 꽉 참");
    servoState = 1;
    myServo.write(0);
    delay(500);           // 잠깐 유지 (0.5초 정도)
    
  }else{
    //0 :: 20초과 >> 쓰레기 다 차지 않은 상태 > 90도
    // 
    Serial.println("쓰레기 아직 괜찮음");
    servoState = 0;
    myServo.write(90);
    delay(500);           // 잠깐 유지 (0.5초 정도)
  }
}

void resistor_servo(){
   
}

int check_distance(){

  int result = 0; 
  int result_distance=0;
  //0이면 20cm 이하, 1이면 20cm초과

  long duration1, distance1;
  long duration2, distance2;

  //초음파 발사 trig1번

  digitalWrite(trigPin1, HIGH);
  delayMicroseconds(10);  //10초
  digitalWrite(trigPin1, LOW);

  //초음파가 사물 맞도 돌아온 시간 저장 -- 1번
  duration1 = pulseIn(echoPin1, HIGH);
  distance1 = duration1*0.034/2;
   Serial.print("distance 1 :: ");
   Serial.println(distance1);

  delay(1000);

  //초음파 발사 trig2번
  digitalWrite(trigPin2, HIGH);
  delayMicroseconds(10);  //10초
  digitalWrite(trigPin2, LOW);

  //초음파가 사물 맞도 돌아온 시간 저장 -- 2번
  duration2 = pulseIn(echoPin2, HIGH);
  distance2 = duration2*0.034/2;
  Serial.print("distance 2 :: ");
  Serial.println(distance2);

  delay(1000);

  //lcd에 출력하기 위한 거리 >> 작은 값을 측정하는 것으로 판단
  if(distance1>distance2){
    result_distance = distance2;
  }else{
    result_distance = distance1;
  }

  print_lcd(result_distance);

  //두개의 초음파 측정 거리 판단하기 위함
  //두개의 초음파센서 거리 값이 20cm 이하면 result = 1, 아니면 result = 0;
   if (distance1 <= 15 && distance2 <= 15) {
    if (!isNear) {
      // 처음으로 가까워짐
      startTime = millis(); 
      isNear = true;
    } else {
      // 이미 가까운 상태 → 얼마나 지속됐는지 확인
      if (millis() - startTime > 2000) {
        Serial.println("3초 동안 가까운 상태 유지됨!");
        result = 1;
      }
    }
  } else {
    // 거리가 멀어지면 초기화
    isNear = false;
    result =0;
  }
  
  return result;
}

void print_lcd(int distance){
  
  lcd.clear();
  lcd.setCursor(1,0);
  
  //확인용 print - log 느낌?
  Serial.print("Distance1 : ");
  Serial.print(distance);
  Serial.println("cm\n");


  //25 > 안찬상태
  // 20 > 30% 참
  // 15 > 50 
  //10 > 80 ~ 
  //7 > 동작그만
  int p = 0;
  if(distance >= 25) {
    p = 10;
  }else if(distance <= 7){
    p = 100;
  }else if(distance <= 15){
    p = 50;
  }else if(distance <= 20){
    p = 30;
  }


  Serial.print(p);
  Serial.println("% 참");

  lcd.setCursor(2,1);
  lcd.print(p);
  lcd.println("%");

  delay(1000);
}