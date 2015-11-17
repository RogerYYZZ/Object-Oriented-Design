//package comp86hw3;

import java.awt.Graphics;

import javax.swing.JLabel;

public abstract class Plane {
private int init_x;
private int init_y;
private String direction;
private int speed;
private int altitude;
private String color;
public Main parent;

public Plane(int init_x, int init_y, String color, Main parent){
	this.init_x = init_x;
	this.init_y = init_y;
	this.color = color;
	this.parent = parent;
	
}

public void changeColor(String color){
	this.color = color;
}


public int getInit_x() {
	return init_x;
}

public void setInit_x(int init_x) {
	this.init_x = init_x;
}

public int getInit_y() {
	return init_y;
}

public void setInit_y(int init_y) {
	this.init_y = init_y;
}


public abstract void draw(Graphics g);

public int getInitX(){
	return init_x;
}
public int getInitY(){
	return init_y;
}

}
