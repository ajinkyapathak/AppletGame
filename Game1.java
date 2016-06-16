import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.util.LinkedList;
import java.util.Random;


public class Game1 extends Applet implements Runnable,KeyListener,MouseListener{
Ball b;
Thread th;
Sticks s[] = new Sticks[3];
LinkedList ls;
boolean flg=false;
boolean clicked=false;
Image img;
Image i;
Graphics gb;
URL url;
double score=0.0;
double imgX=0;
double imgDx=0.3;

public void init()
{
	setSize(600,600);
	for(int i=0;i<s.length;i++){
		s[i] = new Sticks(this,s,i);
	}
	b=new Ball(50,this.getHeight()/2);
	addKeyListener(this);
	th=new Thread(this);
	ls=new LinkedList();
	th.start();
	addMouseListener(this);
	try{
		url= getDocumentBase();
		}
	catch(Exception e){}
	img=getImage(url, "images/galaxy.jpg");
}
public void run() {
	// TODO Auto-generated method stub
	while(true)
	{
		if(imgX>this.getWidth()*-1)
			imgX-=imgDx;
		else
			imgX=0;
		
		for(int i=0;i<s.length;i++){
			if(s[i].collisionOcurred(b)){
					flg=true;
					break;
			}	
			else
			{
				score+=0.01;
			}
		}
		if(flg){repaint(); break;}
		clicked=b.update2(clicked);
		/*Random r=new Random();
		int random=r.nextInt(1000);
		int x=150;
		if(random%107==0)
		{
			if(ls.size()>1)
			{
			Sticks s=(Sticks)ls.get(ls.size()-1);
			x = s.x+300+r.nextInt(30);
			}
			s=new Sticks(this,ls,x);
			ls.add(s);
			
		}
		if(ls.size()!=0)
		{
			for(int i=0;i<ls.size();i++)
			{
				s=(Sticks)ls.get(i);
				s.update1();
			}
		}*/
		for(int i=0;i<s.length;i++)
			s[i].update2(this,s,i);
		repaint();
		try{
			Thread.sleep(10);
		}
		catch(Exception e){}
	}
}
public void paint(Graphics g)
{
	g.drawImage(img,(int)imgX,0,this.getWidth(),this.getHeight(),this);
	g.drawImage(img,(int)imgX+this.getWidth(),0,this.getWidth(),this.getHeight(),this);
	
	b.setGraphics(g);
	Font f=new Font("Comic Sans MS", 30, 30);
	String sc=""+(int)score;
	
	
	/*if(ls.size()!=0)
	{
		for(int i=0;i<ls.size();i++)
		{
			s=(Sticks)ls.get(i);
			s.setGraphics(g);
		}
	}*/
	for(int i=0;i<s.length;i++)
		s[i].setGraphics(g);
	g.setColor(Color.orange);
	g.setFont(f);
	g.drawString("Score :"+sc, this.getWidth()-200, 50);
	if(flg==true)
	{	g.setColor(Color.darkGray);
		g.drawString("Score :"+sc+"  "+"Game Over !!", this.getWidth()/2-200,this.getHeight()/2);
	}
}
public void update(Graphics g) {
		// TODO Auto-generated method stub
		if(i==null)
		{
			i=createImage(this.getSize().width,this.getSize().height);
			gb=i.getGraphics();
		}
		gb.setColor(getBackground());
		gb.fillRect(0, 0, this.getSize().width,this.getSize().height);
		gb.setColor(getForeground());
		paint(gb);
		g.drawImage(i,0,0,this);
	}
public void keyPressed(KeyEvent e) {
	// TODO Auto-generated method stub
	switch(e.getKeyCode())
	{
	case KeyEvent.VK_UP:b.moveUp();
			break;
	case KeyEvent.VK_DOWN:b.moveDown();
			break;
	}
}
public void keyReleased(KeyEvent arg0) {
	// TODO Auto-generated method stub
	
}
public void keyTyped(KeyEvent arg0) {
	// TODO Auto-generated method stub
	
}
public void mouseClicked(MouseEvent arg0) {
	// TODO Auto-generated method stub
	clicked=true;
}
public void mouseEntered(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}
public void mouseExited(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}
public void mousePressed(MouseEvent arg0) {
	// TODO Auto-generated method stub
	clicked=true;
}
public void mouseReleased(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}
}
