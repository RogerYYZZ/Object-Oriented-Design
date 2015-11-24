//package comp86hw3;

import java.awt.Color;
import java.awt.Graphics;

public class Plane2 extends Plane {
//    public int x1;
//    public int y1;
	public Plane2(int init_x, int init_y, String color,Main parent){
		super(init_x, init_y, color, parent);	
	}
	public void draw(Graphics g){
		
//		x1 = getInitX()+2*this.parent.getFrame();
//		y1 =  getInitY()+2*this.parent.getFrame();
	
		g.drawOval(x1, y1, 50, 50);
		g.drawString("Plane2"+"Position_x:"+x1+"      Position_y:"+y1,10, 35);
		if(y1-50 <= 0){
			currentX1 = x1;
			currentY1 = y1+2;
			isChange = true;
			parent.setFrame_2(0);
			
		}
		else if(y1+50 >= 400){
			currentX1 = x1;
			currentY1 = y1-2;
			isChange = false;
			parent.setFrame_2(0);
		}
//		g.drawLine(getInitX()+2*this.parent.getFrame(), getInitY()+2*this.parent.getFrame(), getInitX()+25+2*this.parent.getFrame(), getInitY()-50+2*this.parent.getFrame());
//		g.drawLine(getInitX()+25+2*this.parent.getFrame(), getInitY()-50+2*this.parent.getFrame(), getInitX()+50+2*this.parent.getFrame(), getInitY()+2*this.parent.getFrame());
//		g.drawLine(getInitX()+2*this.parent.getFrame(), getInitY()+2*this.parent.getFrame(), getInitX()+50+2*this.parent.getFrame(), getInitY()+2*this.parent.getFrame());
		if (parent.canvas.p2Pressed == true) {
			g.setColor(Color.RED);
			g.fillOval(x1, y1, 50, 50);}
		
	 
       
		
	
	
	}
	
}