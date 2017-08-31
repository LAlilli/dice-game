import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class TestDice extends Applet implements MouseListener{
	int die1 = 4;
	int die2 = 3;
	
	public void init(){
		//initialize applet, register applet to listen
		//for mouse events on itself. Also set a light blue 
		//background color.
		
		addMouseListener(this);
		setBackground( new Color (200,200,255));
	}
	
	public void paint(Graphics g){
		//paint method draws blue border and two dice
		
		g.setColor(Color.blue);
		drawDie(g, die1, 10, 10);
		drawDie(g, die2, 55, 55);
	}
	
	void drawDie(Graphics g, int val, int x, int y){
		//Draw die with upper left corner at (x,y). Die is
		//35 x 35 pixels in size. Val parameter gives
		//value showing on die - # of dots.
		int scX, scY, scSz;
		
		scX = getWidth()/20;
		scY = getHeight()/8;
		if (scX <= scY)
		{
			scSz = scX;
		}
		else
		{
			scSz = scY;
		}
		
		g.setColor(Color.white);
		g.fillRect(x, y, 3*scX, 3*scY);
		g.setColor(Color.black);
		g.drawRect(x, y, 3*scX, 3*scY);
		if (val > 1)
			g.fillOval(x+3, y+3, scX, scY);
		if (val > 3)
			g.fillOval(x+23, y+3, scX, scY);
		if (val == 6)
			g.fillOval(x+3, y+13, scX, scY);
		if (val % 2 == 1)
			g.fillOval(x+13, y+13, scX, scY);
		if (val == 6)
			g.fillOval(x+23, y+13, scX, scY);
		if (val > 3)
			g.fillOval(x+3, y+23, scX, scY);
		if (val > 1)
			g.fillOval(x+23, y+23, scX, scY);
	}
	
	void roll(){
		//roll dice by randomizing values. tell system
		//to repaint applet to show new values.
		//play sound when clicked.
		
		die1 = (int)(Math.random()*6) + 1;
		die2 = (int)(Math.random()*6) + 1;
		play(getCodeBase(), "click.au");
		repaint();
	}
	
	public void mousePressed(MouseEvent evt){
		//when user clicks applet, roll dice.
		
		roll();
	}
	
	public void mouseReleased(MouseEvent evt){}
	public void mouseClicked(MouseEvent evt) {}
	public void mouseEntered(MouseEvent evt){}
	public void mouseExited(MouseEvent evt){}

}
