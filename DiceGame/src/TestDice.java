import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class TestDice extends Applet implements MouseListener{
	int die1 = 2;
	int die2 = 3;
	
	public void init(){
		//initialize applet, register applet to listen
		//for mouse events on itself. Also set a light blue 
		//background color.
		
		addMouseListener(this);
		setBackground(new Color (200,200,255));
	}
	
	public void paint(Graphics g){
		//paint method draws two dice
		drawDie(g, die1, 10, 10);
		drawDie(g, die2, 55, 55);

	}

	void drawDie(Graphics g, int val, int x, int y){
		//Draw die with upper left corner at (x,y). Die is
		//35 x 35 pixels in size. Val parameter gives
		//value showing on die - # of dots.
		
		g.setColor(Color.white);
		g.fillRect(x, y, 35, 35);
		g.setColor(Color.black);
		g.drawRect(x, y, 34, 34);
		if (val > 1)
			g.fillOval(x+3, y+3, 9, 9);
		if (val > 3)
			g.fillOval(x+23, y+3, 9, 9);
		if (val == 6)
			g.fillOval(x+3, y+13, 9, 9);
		if (val % 2 == 1)
			g.fillOval(x+13, y+13, 9, 9);
		if (val == 6)
			g.fillOval(x+23, y+13, 9, 9);
		if (val > 3)
			g.fillOval(x+3, y+23, 9, 9);
		if (val > 1)
			g.fillOval(x+23, y+23, 9, 9);
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
