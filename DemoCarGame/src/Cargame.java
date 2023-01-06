import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Cargame extends JFrame implements KeyListener{

	private int xpos=300,ypos=700;
	private ImageIcon car;
	Random random=new Random();
	private int num1=400,delay=100, score=0,speed=90;
	private int roadmove=0;
	private int tree1ypos=400,tree2ypos=-200,tree3ypos=-500,tree4ypos=100,tree5ypos=-300,tree6ypos=500;
	private ImageIcon tree1,tree2,tree3;
	private ImageIcon car1,car2,car3;
	private int carxpos[]= {100,200,300,400,500};
	private int carypos[]= {-240,-480,-720,-960,-1200};
	private int carxpos1=0,carxpos2=2,carxpos3=4;
	private int carypos1=random.nextInt(5),carypos2=random.nextInt(5),carypos3=random.nextInt(5);
	private int y1pos=carypos[carypos1],y2pos=carypos[carypos2],y3pos=carypos[carypos3];
	
	private boolean gameover=false,paint=false;
	
	
	public Cargame(String name)
	{
		super(name);
		setBounds(300, 10, 700, 700);
		setVisible(true);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addKeyListener(this);
		setResizable(false);
		setFocusable(true);
	}
	
	public void paint(Graphics g)
	{
		g.setColor(Color.green);
		g.fillRect(0, 0, 700, 700);
		g.setColor(Color.gray);
		g.fillRect(90, 0, 10, 700);
		g.fillRect(600, 0, 10, 700);
		g.setColor(Color.black);
		g.fillRect(100, 0, 500, 700);
		
		if(roadmove==0)
		{
			for(int i=0;i<=700;i=i+100)
			{
				g.setColor(Color.white);
				g.fillRect(350, i, 10, 70);
			}
			roadmove=1;
		}
		else if(roadmove==1)
		{
			for(int i=50;i<=700;i=i+100)
			{
				g.setColor(Color.white);
				g.fillRect(350, i, 10, 70);
			}
			roadmove=0;
		}
		
		tree1=new ImageIcon("tree1.png");
		tree1.paintIcon(this, g, 0, tree1ypos);
		num1=random.nextInt(500);
		tree1ypos=tree1ypos+50;
		
		tree2=new ImageIcon("tree2.png");
		tree2.paintIcon(this, g, 0, tree2ypos);
		tree2ypos=tree2ypos+50;
		
		tree3=new ImageIcon("tree3.png");
		tree3.paintIcon(this, g, 0, tree3ypos);
		tree3ypos=tree3ypos+50;
		
		tree1.paintIcon(this, g, 600, tree4ypos);
		tree4ypos=tree4ypos+50;
		
		tree2.paintIcon(this, g, 600, tree5ypos);
		tree5ypos=tree5ypos+50;
		
		tree3.paintIcon(this, g, 600, tree6ypos);
		tree6ypos=tree6ypos+50;
		
		if(tree1ypos>700)
		{
			num1=random.nextInt(500);
			tree1ypos=tree1ypos-num1;
		}
		if(tree2ypos>700)
		{
			num1=random.nextInt(500);
			tree2ypos=tree2ypos-num1;
		}
		if(tree3ypos>700)
		{
			num1=random.nextInt(500);
			tree3ypos=tree3ypos-num1;
		}
		if(tree4ypos>700)
		{
			num1=random.nextInt(500);
			tree4ypos=tree4ypos-num1;
		}
		if(tree5ypos>700)
		{
			num1=random.nextInt(500);
			tree5ypos=tree5ypos-num1;
		}
		if(tree6ypos>700)
		{
			num1=random.nextInt(500);
			tree6ypos=tree6ypos-num1;
		}
		
		car=new ImageIcon("car1.png");
		car.paintIcon(this, g, xpos, ypos);
		ypos=ypos-40;
		if(ypos<500)
		{
			ypos=500;
		}
		
		car1=new ImageIcon("car2.png");
		car2=new ImageIcon("car3.png");
		car3=new ImageIcon("car4.png");
		
		car1.paintIcon(this, g, carxpos[carxpos1], y1pos);
		car2.paintIcon(this, g, carxpos[carxpos2], y2pos);
		car3.paintIcon(this, g, carxpos[carxpos3], y3pos);
		
		y1pos=y1pos+50;
		y2pos=y2pos+50;
		y3pos=y3pos+50;
		
		if(y1pos>700)
		{
			carxpos1=random.nextInt(5);
			carypos1=random.nextInt(5);
			y1pos=carypos[carypos1];
		}
		if(y2pos>700)
		{
			carxpos2++;
			if(carxpos2>4)
			{
				carxpos2=0;
			}
			carxpos2=random.nextInt(5);
			carypos2=random.nextInt(5);
			y2pos=carypos[carypos2];
		}
		if(y3pos>700)
		{
			carxpos3++;
			if(carxpos3>4)
			{
				carxpos3=0;
			}
			carxpos3=random.nextInt(5);
			carypos3=random.nextInt(5);
			y3pos=carypos[carypos3];
		}
		
		if(carxpos1==carxpos2 && carypos1>-100 && carypos2>-100)
		{
			
			
			carxpos1-=1;
			if(carxpos1<0)
			{
				carxpos1+=2;
			}
		}
		if(carxpos1==carxpos3&& carypos1>-100 && carypos3>-100)
		{
			carxpos3-=1;
			if(carxpos3<0)
			{
				carxpos3+=2;
			}
		}
		if(carxpos2==carxpos3&& carypos3>-100 && carypos2>-100)
		{
			carxpos2-=1;
			if(carxpos2<0)
			{
				carxpos2+=2;
			}
		}
		if(carxpos1<2 && carxpos2<2 && carxpos3<2)
		{
			if(carxpos1==0 && carxpos2==0 && carxpos3==1)
			{
				carxpos3++;
				carxpos2++;
			}
			else if(carxpos1==0 && carxpos2==1 && carxpos3==0)
			{
				carxpos3++;
				carxpos2++;
			}
			else if(carxpos1==1 && carxpos2==0 && carxpos3==0)
			{
				carxpos1++;
				carxpos2++;
			}
		}
		
		if(y1pos<ypos && y1pos+175>ypos && carxpos[carxpos1]==xpos)
		{
		gameover=true;	
		}
		if(y2pos<ypos && y2pos+175>ypos && carxpos[carxpos2]==xpos)
		{
		gameover=true;	
		}
		if(y3pos<ypos  && y3pos+175>ypos && carxpos[carxpos3]==xpos)
		{
		gameover=true;	
		}
		if(ypos<y1pos && ypos+175>y1pos && carxpos[carxpos1]==xpos)
		{
		gameover=true;	
		}
		if(ypos<y2pos && ypos+175>y2pos && carxpos[carxpos2]==xpos)
		{
		gameover=true;	
		}
		if(ypos<y3pos  && ypos+175>y3pos && carxpos[carxpos3]==xpos)
		{
		gameover=true;	
		}
		
		
		g.setColor(Color.green);
		g.fillRect(120,35,220,50);
		g.setColor(Color.DARK_GRAY);
		g.fillRect(125,40, 210, 40);
		g.setColor(Color.green);
		g.fillRect(385,35,180,50);
		g.setColor(Color.DARK_GRAY);
		g.fillRect(390,40, 170, 40);
		g.setColor(Color.white);
		g.setFont(new Font("Arial",Font.BOLD,30));
		g.drawString(" Score : "+score, 130, 67);
		g.drawString(" "+speed+" Km/h", 400, 67);
		score++;
		speed++;
		if(speed>140)
		{
			speed=240-delay;
		
		}
		if(score%50==0)
		{
			delay-=10;
			if(delay<60)
			{
				delay=60;
			}
		}
		try
		{
			
			TimeUnit.MILLISECONDS.sleep(delay);
		} 
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(y1pos<ypos && y1pos+175>ypos && carxpos[carxpos1]==xpos)
		{
		gameover=true;	
		}
		if(y2pos<ypos && y2pos+175>ypos && carxpos[carxpos2]==xpos)
			
		{
		gameover=true;	
		}
		if(y3pos<ypos  && y3pos+175>ypos && carxpos[carxpos3]==xpos)
		{
		gameover=true;	
		}
		if(gameover)
		{
		g.setColor(Color.green);
		g.fillRect(120, 210, 460, 200);	
		g.setColor(Color.DARK_GRAY);
		g.fillRect(130, 220, 440, 180);
		g.setFont(new Font("Serif",Font.BOLD,50));
		g.setColor(Color.red);
		g.drawString("Game Over !",210, 270);
		g.setColor(Color.white);
		g.setFont(new Font("Arial",Font.BOLD,30));
		g.drawString("Press Enter to Restart", 190, 340);
		
		if(!paint)
		{
			repaint();
			paint=true;
		}
		}
		else
		{
			repaint();
		}
	}
	
	public static void main(String[] args) {
		
		Cargame obj=new Cargame("Car_Racing . . . . ");

	}

	@Override
	public void keyPressed(KeyEvent ke) {
		
		
		if(ke.getKeyCode()==KeyEvent.VK_LEFT)
		{
			xpos=xpos-100;
			if(xpos<100)
			{
				xpos=100;
			}
		}
		if(ke.getKeyCode()==KeyEvent.VK_RIGHT)
		{
			xpos=xpos+100;
			if(xpos>500)
			{
				xpos=500;
			}
		}
		
		if(ke.getKeyCode()==KeyEvent.VK_ENTER)
		{
			gameover=false;
			paint=false;
			carxpos1=0;
			carxpos2=2;
			carxpos3=4;
			carypos1=random.nextInt(5);
			carypos2=random.nextInt(5);
			carypos3=random.nextInt(5);
			y1pos=carypos[carypos1];
			y2pos=carypos[carypos2];
			y3pos=carypos[carypos3];
			speed=90;
			score=0;
			delay=100;
			xpos=300;
			ypos=700;
			
			
		}
	
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent ke) {
		if(ke.getKeyChar()=='a'&&!gameover)
		{
			xpos-=100;
			
		}
		if(ke.getKeyChar()=='s'&&!gameover)
		{
			xpos+=100;
		}
		
		repaint();
		
	}

}
