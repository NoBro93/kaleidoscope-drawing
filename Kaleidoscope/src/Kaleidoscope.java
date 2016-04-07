import processing.core.PApplet;

public class Kaleidoscope extends PApplet {
  private static final long serialVersionUID = 1L;
  
  //in order to have a main method
  public static void main(String[] args) {
      PApplet.main(Kaleidoscope.class.getSimpleName());
  }
  
  int windowX=500, windowY=500;
  boolean gox2=false, goy2=false, go4=false, clear=false;
  public void setup() {
	    size(windowX, windowY);
	    background(0);
	  }
  private boolean onScreen() {
	  return (mouseX < windowX && mouseX > 0 && mouseY < windowY && mouseY > 0);
  }
  private boolean onX2(){
	  return (mouseX < 60 && mouseX > 10 && mouseY > windowY-60 && mouseY < windowY-10);
  }
  private boolean onY2(){
	  return (mouseX > 70 && mouseX < 120 && mouseY > windowY-60 && mouseY < windowY-10);
  }
  private boolean onClear(){
	  return (mouseX > 10 && mouseX < 60 && mouseY > 10 && mouseY < 35);
  }
  private boolean on4(){
	  return (mouseX > 130 && mouseX < 180 && mouseY > windowY-60 && mouseY < windowY-10);
  }
  public void draw() {
    options();
    if (gox2)
    	X2();
    if (goy2)
    	Y2();
    if (go4)
    	C4();
    if (clear){
    	background(0);
    	clear = false;
    }
  }
  public void mouseClicked() {
	  if (onX2()){
		  goy2 = false;
		  go4 = false;
		  gox2 = true;
	  }
	  if (onY2()){
		  gox2 = false;
		  go4 = false;
		  goy2 = true;
	  }
	  if (on4()){
		  go4 = true;
		  gox2 = false;
		  goy2 = false;
	  }
	  if (onClear()){
		  clear = true;
	  }
  }
  private void options(){
	stroke(255);
	//X2 box
    fill(0,0,0);
    rect(10, windowY-60, 50, 50);
    textSize(25);
    fill(255,255,255);
    text("X2", 20, windowY-25);
    
    //Y2 box
    fill(0,0,0);
    rect(70, windowY-60, 50, 50);
    textSize(25);
    fill(255,255,255);
    text("Y2", 80, windowY-25);
    
    //4 box
    fill(0,0,0);
    rect(130, windowY-60, 50, 50);
    textSize(25);
    fill(255,255,255);
    text("4", 145, windowY-25);
    
    //clear
    fill(0,0,0);
    rect(10, 10, 50, 25);
    textSize(15);
    fill (255, 255, 255);
    text("clear", 17, 27);
  }
  private void X2(){
	int x2, px2;
	if (mousePressed && onScreen()) {
	    line(mouseX,mouseY,pmouseX,pmouseY);
	  	x2 = windowX - mouseX;
	    px2 = windowX - pmouseX;
	    line(x2,mouseY,px2,pmouseY);
	}
  }
  private void Y2(){
	int y2, py2;
	if (mousePressed && onScreen()) {
	    line(mouseX,mouseY,pmouseX,pmouseY);
	  	y2 = windowY - mouseY;
	  	py2 = windowY - pmouseY;
	    line(mouseX,y2,pmouseX,py2);
	}
  }
  private void C4(){
	int x2, y2, px2, py2;
	if (mousePressed && onScreen()) {
	    line(mouseX,mouseY,pmouseX,pmouseY);
	  	x2 = windowX - mouseX;
	    px2 = windowX - pmouseX;
	  	y2 = windowY - mouseY;
	  	py2 = windowY - pmouseY;
	    line(mouseX,y2,pmouseX,py2);
	    line(x2,mouseY,px2,pmouseY);
	    line(x2,y2,px2,py2);
	}
  }
}