//package comp86hw3;

import java.awt.Color;
import java.awt.Graphics;

public class Plane3 extends Plane {
	 public int x1;
	 public int y1;
	public Plane3(int init_x, int init_y, String color,Main parent){
		super(init_x, init_y, color, parent);
		
	}
	public void draw(Graphics g){
		 x1 = getInitX();
		 y1 = getInitY()+this.parent.getFrame();
		g.drawRect(x1, y1, 50, 50);
//		g.drawLine(getInitX()-50, getInitY()+25+this.parent.getFrame(), getInitX(), getInitY()+25+this.parent.getFrame());
//		g.drawLine(getInitX()-50, getInitY()+25+this.parent.getFrame(), getInitX(), getInitY()+this.parent.getFrame());
//		g.drawLine(getInitX()+50, getInitY()+this.parent.getFrame(), getInitX()+100, getInitY()+25+this.parent.getFrame());
//		g.drawLine(getInitX()+50, getInitY()+25+this.parent.getFrame(), getInitX()+100, getInitY()+25+this.parent.getFrame());
		 
		if (parent.canvas.p3Pressed == true) {
			g.setColor(Color.RED);
			g.fillRect(x1, y1, 50, 50);}
		if (getInitX()>500 || (getInitY()+this.parent.getFrame())>450){
	        	g.drawString("the plane is out of visable area", 10, 55);
	        }
	        else{
			 g.drawString("Plane3"+"Position_x:"+(getInitX())+"      Position_y:"+(getInitY()+this.parent.getFrame())+"      altitude:"+(500-getInitY()-this.parent.getFrame()), 10, 55);}
	}
	
}
	

