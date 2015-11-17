//package comp86hw3;

import java.awt.Color;
import java.awt.Graphics;

public class Plane2 extends Plane {
	public int x1;
	public int y1;
	public Plane2(int init_x, int init_y, String color,Main parent){
		super(init_x, init_y, color, parent);	
	
	}
public void draw(Graphics g){
		
		 x1 = getInitX()+2*this.parent.getFrame();
		 y1 =  getInitY()+2*this.parent.getFrame();
		g.drawOval(x1, y1, 50, 50);
//		g.drawLine(getInitX()+2*this.parent.getFrame(), getInitY()+2*this.parent.getFrame(), getInitX()+25+2*this.parent.getFrame(), getInitY()-50+2*this.parent.getFrame());
//		g.drawLine(getInitX()+25+2*this.parent.getFrame(), getInitY()-50+2*this.parent.getFrame(), getInitX()+50+2*this.parent.getFrame(), getInitY()+2*this.parent.getFrame());
//		g.drawLine(getInitX()+2*this.parent.getFrame(), getInitY()+2*this.parent.getFrame(), getInitX()+50+2*this.parent.getFrame(), getInitY()+2*this.parent.getFrame());
		if (parent.canvas.p2Pressed == true) {
			g.setColor(Color.RED);
			g.fillOval(x1, y1, 50, 50);}
		
	    if ((getInitX()+2*this.parent.getFrame())>500 || (getInitY()+2*this.parent.getFrame())>450){
        	g.drawString("the plane is out of visable area", 10, 35);
        }
        else{
		 g.drawString("Plane2"+"Position_x:"+(getInitX()+2*this.parent.getFrame())+"      Position_y:"+(getInitY()+2*this.parent.getFrame())+"      altitude:"+(500-getInitY()-2*this.parent.getFrame()), 10, 35);}
	
	
	}
	
}
	
