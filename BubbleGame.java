import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import java.util.Random;
/*
<applet code=BubbleGame.class width=600 height=600>
</applet>
*/
public class BubbleGame extends Applet implements Runnable,KeyListener{
	private Bubble b;
	private LinkedList ls;
	private Image i;
	private Graphics gb;
	private int score=0;
	public void init()
	{
		setSize(600,600);
		ls=new LinkedList();
		addKeyListener(this);
	}
	public void start()
	{
		Thread th=new Thread(this);
		th.start();
	}
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			Random r=new Random();
			int random=r.nextInt(1000);
			if(random%29==0)
			{
				b=new Bubble();
				ls.add(b);
			}
			if(ls.size()!=0)
			{
				for(int i=0;i<ls.size();i++)
				{
					b=(Bubble)ls.get(i);
					if(!b.getDestroy())
					b.update();
				}
			}
			repaint();
			try{
				Thread.sleep(75);
			}
			catch(Exception e){}
			
		}
	}
	
	/*public void update(Graphics g) {
		// TODO Auto-generated method stub
		if(i==null)
		{
			i=createImage(this.getSize().width, this.getSize().height);
			gb=i.getGraphics();
		}
		gb.setColor(getBackground());
		gb.fillRect(0,0,this.getSize().width,this.getSize().height);
		gb.setColor(getForeground());
		paint(gb);
		g.drawImage(i,0,0,this);
	}*/
	
	public void paint(Graphics g)
	{
		if(ls.size()!=0)
		{
			for(int i=0;i<ls.size();i++)
			{
				b=(Bubble)ls.get(i);
				if(b.getDestroy()==false)
					b.setGraphics(this.getGraphics());
			}
		}
		String sc=Integer.toString(score);
		Font f=new Font("DS-Digital",Font.BOLD,32);
		g.setFont(f);
		g.setColor(Color.RED);
		g.drawString("Score: "+sc,this.getWidth()-200+2,50);
	}
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		char ch=(char) e.getKeyCode();
		System.out.println(ch);
		if(ls.size()!=0)
		{
			for(int i=0;i<ls.size();i++)
			{
				b=(Bubble)ls.get(i);
				if(b.getKey()==ch)
				{
					b.setDestroy();
					score+=10;
				}
			}
		}
		repaint();
	}
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
