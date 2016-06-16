import java.awt.Graphics;
import java.util.Random;


public class Bubble {
private int x;
private int y;
private float dx=4;
private float dy=(float) -4;
private int radius=40;
String s;
private boolean destroy=false;
public Bubble()
{
	Random r=new Random();
	int random=r.nextInt(600);
	int random2=r.nextInt(26)+65;
	s=(""+(char)random2);
//	System.out.println(s);
	x=random;
	y=600+random/4;
}
public void update()
{
	y+=dy;
}
public void update1()
{
	x+=dx;
}
public void setDestroy() {
	destroy = true;
}
public boolean getDestroy(){return destroy;}
public char getKey()
{
	return s.charAt(0);
}
public void setGraphics(Graphics g)
{
	g.drawOval(x, y, radius, radius);
	g.drawString(s, x+20, y+20);
}
}
