import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;


public class Ball {
private int x;
private int y;
private float dx=0;
private float dy=-40;
private int radius=40;
private boolean destroy=false;
private double gravity=5;
private double dt=0.2;
public Ball(int x,int y)
{
	this.x=x;
	this.y=y;
}
public void moveUp()
{
	y-=dy;
}
public void moveDown()
{
	y+=dy;
}
public void update1()
{
	x+=dx;
}

public double getDt() {
	return dt;
}
public float getDx() {
	return dx;
}
public float getDy() {
	return dy;
}
public int getX() {
	return x;
}
public int getY() {
	return y;
}
public int getRadius() {
	return radius;
}
public boolean update2(boolean clicked)
{
	if(clicked)
	{
		dy=-1*Math.abs(dy);
		clicked=false;
	}
	dy+=gravity*dt;
	y+=dy*dt+0.5*gravity*Math.pow(dt, 2);
	return clicked;
}
public void setDestroy() {
	destroy = true;
}
public boolean getDestroy(){return destroy;}
public void setGraphics(Graphics g)
{
	g.setColor(new Color(240,200,120));
	g.fillOval(x, y, radius, radius);
}
}
