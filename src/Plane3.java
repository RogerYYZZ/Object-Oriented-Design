//package comp86hw3;

import java.awt.Color;
import java.awt.Graphics;

public class Plane3 extends Plane {
//    public int x1;
//    public int y1;
	public Plane3(int init_x, int init_y, String color,Main parent){
		super(init_x, init_y, color, parent);	
	}
	public void draw(Graphics g){
//		x1 = getInitX();
//		y1 = getInitY()+this.parent.getFrame();
		g.drawRect(x1, y1, 50, 50);
		g.drawString("Plane3"+"Position_x:"+x1+"      Position_y:"+y1, 10, 55);
		if(y1-30 <= 0){
			currentX1 = x1;
			currentY1 = y1+5;
			isChange = false;
			parent.setFrame_3(0);
		}
		else if(y1+50 >= 400){
			currentX1 = x1;
			currentY1 = y1-5;
			isChange = true;
			parent.setFrame_3(0);
		}
//		g.drawLine(getInitX()-50, getInitY()+25+this.parent.getFrame(), getInitX(), getInitY()+25+this.parent.getFrame());
//		g.drawLine(getInitX()-50, getInitY()+25+this.parent.getFrame(), getInitX(), getInitY()+this.parent.getFrame());
//		g.drawLine(getInitX()+50, getInitY()+this.parent.getFrame(), getInitX()+100, getInitY()+25+this.parent.getFrame());
//		g.drawLine(getInitX()+50, getInitY()+25+this.parent.getFrame(), getInitX()+100, getInitY()+25+this.parent.getFrame());
		 
		if (parent.canvas.p3Pressed == true) {
			g.setColor(Color.RED);
			g.fillRect(x1, y1, 50, 50);}
	
	        
			 
	}
	
}
