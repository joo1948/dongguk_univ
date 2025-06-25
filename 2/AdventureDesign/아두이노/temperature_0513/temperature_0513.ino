#include <DHT11.h>

//#include <DHT.h>
#include <DHT_U.h>
#define DHTPIN 8
#define DHTTYPE DHT11

DHT11 dht(DHTPIN, DHTTYPE);


void setup() {
  // put your setup code here, to run once:

  Serial.begin(9600);
  dht.begin();
}

void loop() {
  // put your main code here, to run repeatedly:

  int h = dht.readHumidity();
  int t = dht.readTemperature();

  Serial.print("Humidity : ");
  Serial.print(h);
  Serial.print("%\t");

  Serial.print("Temperature: ");
  Serial.print(t);
  Serial.println(" C");

}
