int pin_button = 7;
int pin_LED1 = 13, pin_LED2 = 12;
boolean LED_state1 = false;
boolean LED_state2 = false;

unsigned long time_previous, time_current;
unsigned long count = 0;

void setup() {
  // put your setup code here, to run once:

  pinMode(pin_button, INPUT);
  pinMode(pin_LED1, OUTPUT);
  digitalWrite(pin_LED1, LED_state1);
  
  
  pinMode(pin_LED2, OUTPUT);
  digitalWrite(pin_LED2, LED_state2);

  time_previous= millis();
  //pinMode(pin_LED2, OUTPUT);
  //digitalWrite(pin_LED2, LED_state2);
}

void loop() {
  // put your main code here, to run repeatedly:

  time_current = millis();
  
  if(time_current - time_previous >= 1000){
    time_previous = time_current;

    LED_state1 = !LED_state1;
    digitalWrite(pin_LED1, LED_state1);
  }

  if(digitalRead(pin_button)){

    LED_state2 = !LED_state2;
    digitalWrite(pin_LED2, LED_state2);
    delay(500);
  }
  
}
