import oscP5.*;
import netP5.*;
import processing.serial.*;
Serial ardu;
OscP5 oscP5;
int degr;

void setup()
{
  size(200,400);
  frameRate(30);
  oscP5 = new OscP5(this,3333);
  ardu = new Serial(this,"COM8",9600);
 }

 void oscEvent(OscMessage theOscMessage) 
{
  String addr = theOscMessage.addrPattern();
  if(addr.indexOf("/degree") !=-1)
    {                  
      degr  = int(theOscMessage.get(0).floatValue());     
    }
 }

void draw() 
{
  background(0,0,0);
  ardu.write(degr); 
}
