import processing.core.PApplet;

public class Kaleidoscope extends PApplet {
  private static final long serialVersionUID = 5291616140901535524L;
//in order to have a main method
  public static void main(String[] args) {
      PApplet.main(Kaleidoscope.class.getSimpleName());
  }
  
  private int windowX=500, windowY=500, but_height = windowY-60, but_size = 50, x2, y2, px2, py2;
  private boolean goShow = true;

  Option X = new Option(this, "X2", 10, but_height, but_size, but_size);
  Option Y = new Option(this, "Y2", 70, but_height, but_size, but_size);
  Option F = new Option(this, "4", 130, but_height, but_size, but_size);
  Option E = new Option(this, "8", 190, but_height, but_size, but_size);
  Option clear = new Option(this, "Clear", 10, 10, 50, 25);
  Option save = new Option(this, "Save", windowX-60, 10, 50, 25);
  Option hide = new Option(this, "Hide", windowX-60, windowY-30, 50, 25);
  
  public void setup() {
	  size(windowX, windowY);
	  background(0);
	  showAll();
  }
  private boolean onScreen() {
	  return (  mouseX < windowX && mouseX > 0 && mouseY < windowY && mouseY > 0 && 
			  !( X.on() && goShow || Y.on() && goShow || F.on() && goShow || E.on() && goShow 
					  || clear.on() && goShow || save.on() || hide.on()) );
  }
  public void draw() {
	if (goShow)
		showAll();
	save.show();
	hide.show(); //Can't have whole screen if need unhide button...
    if (clear.go){
    	background(0);
    	clear.go = false;
    }
	if (mousePressed && onScreen()) {
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
	if (goShow){
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
	  if (clear.on()){
		  clear.go = true;
	  }  
	}
	if (save.on()){
		if (goShow)
			hideAll();
		save.hide();
		hide.hide();
	    saveFrame();
	    save.show();
	    hide.show();
	}
    if (hide.on()) {
	  if (goShow){
		  hideAll();
	  	  goShow = false;
	  }
	  else {
		  goShow = true;
		  showAll();
		  stroke(70, 35, 123);
	  }  
    }
  }
  private void showAll(){
	X.show();
	Y.show();
	F.show();
	E.show();
	clear.show();    
  }
  private void hideAll(){
	X.hide();
	Y.hide();
	F.hide();
	E.hide();
	clear.hide();
  }
  private void X2(){
	line(mouseX,mouseY,pmouseX,pmouseY);
	line(x2,mouseY,px2,pmouseY);
  }
  private void Y2(){
    line(mouseX,mouseY,pmouseX,pmouseY);
    line(mouseX,y2,pmouseX,py2);
  }
  private void C4(){
    line(mouseX,mouseY,pmouseX,pmouseY);
    line(mouseX,y2,pmouseX,py2);
    line(x2,mouseY,px2,pmouseY);
    line(x2,y2,px2,py2);
  }
  private void C8(){
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