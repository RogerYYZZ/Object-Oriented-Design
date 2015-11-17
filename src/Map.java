import java.awt.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JTextField;

public class Map extends JComponent implements MouseListener{
//SECOND COMMIT
private ArrayList<Plane> planes;
private Plane plane;
//set the original color of the plane
private int red = 255;
private int green = 0;
private int blue = 0;
private Plane1 one;
private Plane2 two;
private Plane3 three;
public boolean isAll;
private Main parent;
private Plane current;
public boolean p1Pressed;
public boolean p2Pressed;
public boolean p3Pressed;
/*
 * add planes to arrayList
 */
public Map(Main parent){
	addMouseListener (this);
	this.parent = parent;
	 one = new Plane1(150,150,"BLACK", parent); 
	 two = new Plane2(150,150,"BLACK", parent);
	 three = new Plane3(225,225,"BLACK", parent);
	 planes = new ArrayList<Plane>();
	 planes.add(one);
	 planes.add(two);
	 planes.add(three);	
	this.setSize(200,200);
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
	
	if(plane != null && isAll == false){
		g.setColor(new Color (red, green, blue));
		plane.draw(g);
	}
	else if (isAll == true){
		g.setColor(new Color (red, green, blue));
		
		one.draw(g);
		two.draw(g);
		three.draw(g);
	}
	
  
	
}
public Plane1 getOne() {
	return one;
}
public Plane2 getTwo() {
	return two;
}
public Plane3 getThree() {
	return three;
}
public void setPlane(Plane plane) {
	this.plane = plane;
	parent.setFrame(0);
	repaint();
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

public ArrayList<Plane> getPlanes() {
	return planes;
}

public Plane getPlane() {
	return plane;
}
/** MouseListener callbacks */
public void mousePressed (MouseEvent event) {
	int point_X = event.getX();
	int point_Y = event.getY();
	
	
System.out.println ("Mouse down at " + event.getPoint().x + ", " + event.getPoint().y);
}
public void mouseClicked (MouseEvent event) {}
public void mouseReleased (MouseEvent event) {}
public void mouseEntered (MouseEvent event) {}
public void mouseExited (MouseEvent event) {}

}
