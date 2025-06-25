int pins[] = {2,3,4,5};
  int state = -1 ;

  
void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);

  for (int i=0;i<4;i++){
    pinMode(pins[i], OUTPUT);
    digitalWrite(pins[i], LOW);
  }
  

}

void loop() {
  // put your main code here, to run repeatedly:
  if(Serial.available()){
    char data = Serial.read();
    Serial.println(String("You entered \'") + data + '\'');
    if (data >= '1' && data <= '4'){
      state = data - '0' -1;
      Serial.print("LED ");
      Serial.print(state + 1);
      Serial.println(" is ON...");

    }else{
      Serial.println("* Invalid LED number...");
      state = -1;
    }

    for(int i=0;i<4;i++){
      if(i==state){
        Serial.print("0 ");
        digitalWrite(pins[i], HIGH);
      }else{
        Serial.print("X ");
        digitalWrite(pins[i], LOW);
      }
    }

    Serial.println();
  }

}
