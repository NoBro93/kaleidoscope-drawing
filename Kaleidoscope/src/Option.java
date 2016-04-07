import processing.core.PApplet;
public class Option {
	private static final long serialVersionUID = 5658020044405226932L;
	
	public Option(PApplet parent, String n, int mX, int mY, int x, int y){
		par = parent;
		this.minX = mX;
		this.maxX = mX + x;
		this.minY = mY;
		this.maxY = mY + y;
		this.name = n;
	}
	private PApplet par;
	public boolean go = false;
	public int minX, maxX, minY, maxY;
	public String name;		
	public boolean on(){
		return (par.mouseX > minX && par.mouseX < maxX && par.mouseY > minY && par.mouseY < maxY);
	}
	public void show(){
	    par.fill(0,0,0);
	    par.rect(minX, minY, maxX-minX, maxY-minY);
	    par.textSize(25);
	    par.fill(255,255,255);
	    if (name.length()>1)
	    	par.text(name, minX+10, minY+35);
	    else
	    	par.text(name,  minX+15, minY+35);
	}
}
