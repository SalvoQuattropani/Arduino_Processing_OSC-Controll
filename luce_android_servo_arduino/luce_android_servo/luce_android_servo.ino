 #include <Servo.h>

Servo eins;                          
int degr = 0;

void setup()
{
   Serial.begin(9600);                  
   eins.attach(9);       
}

void loop()
{
   if (Serial.available() > 0) 
   {        
    degr = Serial.read();               
   }                           
   eins.write(degr);
}
