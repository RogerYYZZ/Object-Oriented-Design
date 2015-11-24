//package comp86hw3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class Plane1 extends Plane {
   
	public Plane1(int init_x, int init_y, String color,Main parent){
		super(init_x, init_y, color, parent);	
	}
	@Override
	public void draw(Graphics g){
//		x1 = getInitX()+this.parent.getFrame();
//		y1 = getInitY();
		//g.drawRect(getInitX()+this.parent.getFrame(), getInitY(), 50, 50);
		g.drawLine(x1, y1, x1+25, y1-50);
		g.drawLine(x1+25, y1-50,x1+50, y1);
		g.drawLine(x1, y1,x1+50, y1);
		g.setColor(Color.RED);
		g.fillPolygon(new int[]{x1, x1+25, x1+50},new int[]{y1, y1-50, y1}, 3);
//		if (parent.canvas.p1Pressed == true) {
//			g.setColor(Color.RED);
//			g.fillPolygon(new int[]{x1, x1+25, x1+50},new int[]{y1, y1-50, y1}, 3);}
//        if ((getInitX()+this.parent.getFrame())>500 || getInitY()>450){
//        	//parent.timer.stop();
//        	g.drawString("the plane is out of visable area", 10, 15);
//        }
        
	 g.drawString("Plane1"+"Position_x:"+x1+"      Position_y:"+y1, 10, 15);
}
	 //		g.drawArc (
//				// Moves by 2 pixels on each frame
//				10 + 2 * this.parent.getFrame(),
//				10 + 2 * this.parent.getFrame(),
//				// size
//				100, 100,
//				// degrees
//				0, 360);
	
	

}
