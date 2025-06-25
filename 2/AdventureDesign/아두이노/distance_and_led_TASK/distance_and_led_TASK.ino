int trigPin = 5;           //초음파 센서 trig에 달린 번호
int echoPin = 6;           //초음파 센서 echo 에 달린 번호
void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);
  pinMode(echoPin, INPUT);   // echo 초음파 돌아옴
  pinMode(trigPin, OUTPUT);  // trig 초음파
}

void loop() {
  // put your main code here, to run repeatedly:

  long duration, distance;

    Serial.println("loop start");

  //초음파 발사 trig
  digitalWrite(trigPin, HIGH);
  delayMicroseconds(10);  //10초
  digitalWrite(trigPin, LOW);

  //초음파가 사물 맞도 돌아온 시간 저장   
  duration = pulseIn(echoPin, HIGH);
  //시간을 거리로 cm단위 환산
  distance = ((duration * 340) / 10000) / 2;


  //시리얼 모니터에 거리 출력 >
  Serial.print("Distance : ");
  Serial.print(distance);
  Serial.println("cm\n");

  delay(1000);
 
}
