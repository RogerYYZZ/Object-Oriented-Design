
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JTextField;

public class MapZoom extends JComponent implements MouseListener{

private ArrayList<Plane> planes;
private Plane plane;
//set the original color of the plane
private int red = 255;
private int green = 0;
private int blue = 0;
private Main parent;
private Point init_Plane1;
private Point init_Plane2;
private Point init_Plane3;
//public boolean zoom;
private int x1;
private int y1;
private int x2;
private int y2;
private int x3;
private int y3;

/*
 * add planes to arrayList
 */
public MapZoom(Main parent){
	addMouseListener (this);
	this.parent = parent;
	this.setSize(200,200);
}

public Point getInit_Plane1() {
	return init_Plane1;
}
public void setInit_Plane1(Point init_Plane1) {
	this.init_Plane1 = init_Plane1;
}
public Point getInit_Plane2() {
	return init_Plane2;
}
public void setInit_Plane2(Point init_Plane2) {
	this.init_Plane2 = init_Plane2;
}
public Point getInit_Plane3() {
	return init_Plane3;
}
public void setInit_Plane3(Point init_Plane3) {
	this.init_Plane3 = init_Plane3;
}


/*
 * paint the plane
 */
@Override
public void paintComponent (Graphics g){
	// super.paintComponent(g);
	//background color
	Dimension size = getSize();
	
	g.setColor(Color.YELLOW);
	g.fillRect(0, 0, size.width, size.height);
	//set the location for planes on canvasZoom
	if(parent.zoom){
		if(parent.getZoomFrame() == 0 && parent.getFrame() == 0){
			x1 = parent.canvas.getOne().getInit_x();
			y1 = parent.canvas.getOne().getInit_y();
			x2 = parent.canvas.getOne().getInit_x()+(int)(Math.sqrt(2)*(parent.canvas.getTwo().getInit_x()-parent.canvas.getOne().getInit_x()));
			y2 = parent.canvas.getOne().getInit_y()+(int)(Math.sqrt(2)*(parent.canvas.getTwo().getInit_y()-parent.canvas.getOne().getInit_y()));
			x3 = parent.canvas.getOne().getInit_x()+(int)(Math.sqrt(2)*(parent.canvas.getThree().getInit_x()-parent.canvas.getOne().getInit_x()));
			y3 = parent.canvas.getOne().getInit_y()+(int)(Math.sqrt(2)*(parent.canvas.getThree().getInit_y()-parent.canvas.getOne().getInit_y())); 
		}
		else{
		x1 = init_Plane1.x+2*this.parent.getZoomFrame();
		y1 = init_Plane1.y;
		
		x2 = init_Plane1.x+(int)(Math.sqrt(2)*(init_Plane2.x-init_Plane1.x))+(int)(2*Math.sqrt(1.8)*this.parent.getZoomFrame());
		y2 = init_Plane1.y+(int)(Math.sqrt(2)*(init_Plane2.y-init_Plane1.y))+(int)(2*Math.sqrt(1.8)*this.parent.getZoomFrame());
		x3 = init_Plane1.x+(int)(Math.sqrt(2)*(init_Plane3.x-init_Plane1.x));
		y3 = init_Plane1.y+(int)(Math.sqrt(2)*(init_Plane3.y-init_Plane1.y))+(int)(Math.sqrt(1.7)*this.parent.getZoomFrame());
		}
		g.setColor(new Color (red, green, blue));
		if (parent.canvas.p1Disappear == false) {
		g.drawLine(x1, y1, x1+25, y1-50);
		g.drawLine(x1+25, y1-50,x1+50, y1);
		g.drawLine(x1, y1,x1+50, y1);}
		if (parent.canvas.p2Disappear == false) 
		g.drawOval(x2, y2, 50, 50);
		if (parent.canvas.p3Disappear == false)
		g.drawRect(x3, y3, 50, 50);
	}
	
  	
}


/*
 * Called from the ColorScrollbar's
 */
public void setColor (String whichColor, int newValue) {
	if ( whichColor.equals("Red")) red = newValue;
	else if ( whichColor.equals("Green")) green = newValue;
	else if ( whichColor.equals("Blue")) blue = newValue;
	repaint();
}


/** MouseListener callbacks */
public void mousePressed (MouseEvent event) {}
public void mouseClicked (MouseEvent event) {}
public void mouseReleased (MouseEvent event) {}
public void mouseEntered (MouseEvent event) {}
public void mouseExited (MouseEvent event) {}

}



