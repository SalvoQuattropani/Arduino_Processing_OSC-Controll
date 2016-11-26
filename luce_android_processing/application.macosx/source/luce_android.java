import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import oscP5.*; 
import netP5.*; 
import processing.serial.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class luce_android extends PApplet {




Serial ardu;
OscP5 oscP5;
int degr;

public void setup()
{
  size(200,400);
  frameRate(30);
  oscP5 = new OscP5(this,3333);
  ardu = new Serial(this,"COM8",9600);
 }

 public void oscEvent(OscMessage theOscMessage) 
{
  String addr = theOscMessage.addrPattern();
  if(addr.indexOf("/degree") !=-1)
    {                  
      degr  = PApplet.parseInt(theOscMessage.get(0).floatValue());     
    }
 }

public void draw() 
{
  background(0,0,0);
  ardu.write(degr); 
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "luce_android" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
