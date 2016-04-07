import processing.core.PApplet;

public class Kaleidoscope extends PApplet {
  private static final long serialVersionUID = 5291616140901535524L;
//in order to have a main method
  public static void main(String[] args) {
      PApplet.main(Kaleidoscope.class.getSimpleName());
  }
  
  private int windowX=500, windowY=500, but_height = windowY-60, but_size = 50, x2, y2, px2, py2;
  private boolean clear=false;
  
//TODO: make clear an option object
  Option X = new Option(this, "X2", 10, but_height, but_size, but_size);
  Option Y = new Option(this, "Y2", 70, but_height, but_size, but_size);
  Option F = new Option(this, "4", 130, but_height, but_size, but_size);
  Option E = new Option(this, "8", 190, but_height, but_size, but_size);
  
  public void setup() {
	  size(windowX, windowY);
	  background(0);
  }
  private boolean onScreen() {
	  return (mouseX < windowX && mouseX > 0 && mouseY < windowY && mouseY > 0);
  }
  private boolean onClear(){
	  return (mouseX > 10 && mouseX < 60 && mouseY > 10 && mouseY < 35);
  }
  public void draw() {
    options();
    if (clear){
    	background(0);
    	clear = false;
    }
	if (mousePressed && onScreen()) { //TODO: stop it from picking up clicks on buttons
	  	x2 = windowX - mouseX;
	    px2 = windowX - pmouseX;
	  	y2 = windowY - mouseY;
	  	py2 = windowY - pmouseY;
	    if (X.go)
	    	X2();
	    if (Y.go)
	    	Y2();
	    if (F.go)
	    	C4();
	    if (E.go)
	    	C8();
	}
  }
  public void mouseClicked() {
	  if (X.on()){
		  X.go = true;
		  Y.go = F.go = E.go = false;		  
	  }
	  if (Y.on()){
		  Y.go = true;
		  X.go = F.go = E.go = false;
	  }
	  if (F.on()){
		  F.go = true;
		  X.go = Y.go = E.go = false;
	  }
	  if (E.on()){
		  E.go = true;
		  X.go = Y.go = F.go = false;
	  }
	  if (onClear()){
		  clear = true;
	  }
  }
  private void options(){
	stroke(255);
	X.show();    
    Y.show();
    F.show();
    E.show();
    
    //clear
    fill(0,0,0);
    rect(10, 10, 50, 25);
    textSize(15);
    fill (255, 255, 255);
    text("clear", 17, 27);
  }
  private void X2(){
	if (mousePressed && onScreen()) {
	    line(mouseX,mouseY,pmouseX,pmouseY);
	    line(x2,mouseY,px2,pmouseY);
	}
  }
  private void Y2(){
	if (mousePressed && onScreen()) {
	    line(mouseX,mouseY,pmouseX,pmouseY);
	    line(mouseX,y2,pmouseX,py2);
	}
  }
  private void C4(){
	if (mousePressed && onScreen()) {
	    line(mouseX,mouseY,pmouseX,pmouseY);
	    line(mouseX,y2,pmouseX,py2);
	    line(x2,mouseY,px2,pmouseY);
	    line(x2,y2,px2,py2);
	}
  }
  private void C8(){
	if (mousePressed && onScreen()) {
	  	line(mouseX,mouseY,pmouseX,pmouseY);
	    line(mouseX,y2,pmouseX,py2);
	    line(x2,mouseY,px2,pmouseY);
	    line(x2,y2,px2,py2);
	    
	    line(mouseY,mouseX,pmouseY,pmouseX);
	    line(mouseY,x2,pmouseY,px2);
	    line(y2,mouseX,py2,pmouseX);
	    line(y2,x2,py2,px2);
	}
  }
}