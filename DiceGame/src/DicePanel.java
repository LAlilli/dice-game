import java.awt.*;
import javax.swing.*;
import javax.swing.*;

public class DicePanel extends JPanel{

	int dieValue1 = 4;
	int dieValue2 = 2;
	int dieValue3;
	int dieValue4;
	int counter = 0;
	
	//paint method - draw die
	public void paintComponent (Graphics g)
	{
		//scaling for resizing window
		//moved methods up for easier troubleshooting
		//reduced to 4 die for simplicity
		
		g.setColor( Color.blue ); //source for this code http://math.hws.edu/eck/cs124/javanotes3/c6/ex-6-1-answer.html
        g.drawRect(0,0,99,99);
        g.drawRect(1,1,97,97);
        drawDie(g, dieValue1, 10, 10);
        drawDie(g, dieValue2, 55, 55);
		/*int scX, scY, scSz, textX, textY;
		
		scX = getWidth()/20;
		scY = getHeight()/8;
		if (scX <= scY)
		{
			scSz = scX;
			textX = scSz * (3/2);
			textY = scSz * (5/2);
		}
		else
		{
			scSz = scY;
			textX = scSz * (3/2);
			textY = scSz * (5/2);
		}

		g.setColor(Color.blue);
		g.fillRoundRect(2*scX, 2*scY, 4*scSz, 4*scSz, scSz, scSz);
		g.setColor(Color.black);
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 2*scSz));
		g.drawString(String.valueOf(dieValue1), 2*scX+textX, 2*scY+textY);
		
		g.setColor(Color.yellow);
		g.fillRoundRect(6*scX, 2*scY, 4*scSz, 4*scSz, scSz, scSz);
		g.setColor(Color.black);
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 2*scSz));
		g.drawString(String.valueOf(dieValue2), 6*scX+textX, 2*scY+textY);
		
		g.setColor(Color.green);
		g.fillRoundRect(10*scX, 2*scY, 4*scSz, 4*scSz, scSz, scSz);
		g.setColor(Color.black);
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 2*scSz));
		g.drawString(String.valueOf(dieValue3), 10*scX+textX, 2*scY+textY);
		
		g.setColor(Color.red);
		g.fillRoundRect(14*scX, 2*scY, 4*scSz, 4*scSz, scSz, scSz);
		g.setColor(Color.black);
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 2*scSz));
		g.drawString(String.valueOf(dieValue4), 14*scX+textX, 2*scY+textY);
		
		/*
		OLD code to call methods below
		setBlueDie(g); 
		setYellowDie(g);
		setGreenDie(g);
		setOrangeDie(g);
		setRedDie(g);*/
	}
	
	/*void setBlueDie(Graphics g, int scX, int scY, int scSz, int textX, int textY)
	{
		g.setColor(Color.blue);
		g.fillRoundRect(2*scX, 2*scY, 4*scSz, 4*scSz, scSz, scSz);
		g.setColor(Color.black);
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 2*scSz));
		g.drawString(String.valueOf(dieValue1), 2*scX+textX, 2*scY+textY);
	}
	
	void setYellowDie(Graphics g)
	{
		g.setColor(Color.yellow);
		g.fillRoundRect(200, 50, 100, 100, 25, 25);
		g.setColor(Color.black);
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));
		g.drawString(String.valueOf(dieValue2), 240, 115);
	}
	
	void setGreenDie(Graphics g)
	{
		g.setColor(Color.green);
		g.fillRoundRect(350, 50, 100, 100, 25, 25);
		g.setColor(Color.black);
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));
		g.drawString(String.valueOf(dieValue3), 390, 115);
	}
	
	void setOrangeDie(Graphics g)
	{
		g.setColor(Color.orange);
		g.fillRoundRect(500, 50, 100, 100, 25, 25);
		g.setColor(Color.black);
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));
		g.drawString(String.valueOf(dieValue4), 540, 115);
	}*/
	
	 void drawDie(Graphics g, int val, int x, int y) {
         // Draw a die with upper left corner at (x,y).  The die is
         // 35 by 35 pixels in size.  The val parameter gives the
         // value showing on the die (that is, the number of dots).
      g.setColor(Color.white);
      g.fillRect(x, y, 35, 35);
      g.setColor(Color.black);
      g.drawRect(x, y, 34, 34);
      if (val > 1)  // upper left dot
         g.fillOval(x+3, y+3, 9, 9);
      if (val > 3)  // upper right dot
         g.fillOval(x+23, y+3, 9, 9);
      if (val == 6) // middle left dot
         g.fillOval(x+3, y+13, 9, 9);
      if (val % 2 == 1) // middle dot (for odd-numbered val's)
         g.fillOval(x+13, y+13, 9, 9);
      if (val == 6) // middle right dot
         g.fillOval(x+23, y+13, 9, 9);
      if (val > 3)  // bottom left dot
         g.fillOval(x+3, y+23, 9, 9);
      if (val > 1)  // bottom right dot
         g.fillOval(x+23, y+23, 9,9);
   }

	//manually set die value
	void setDieValue (int dieValue1, int dieValue2, int dieValue3, int dieValue4)
	{
		this.dieValue1 = dieValue1;
		this.dieValue2 = dieValue2;
		this.dieValue3 = dieValue3;
		this.dieValue4 = dieValue4;
	}
	
	//roll die, set die to random values
	void rollDie ()
	{
		dieValue1 = (int)(Math.random() * 6 + 1);
		dieValue2 = (int)(Math.random() * 6 + 1);
		dieValue3 = (int)(Math.random() * 6 + 1);
		dieValue4 = (int)(Math.random() * 6 + 1);
	}
	
	int counterSet ()
	{
		return this.counter;
	}
	
	//calculate and return die total if three of a kind
	//has been rolled 3 times
	//if 3 of kind 3 times, reset score to 0 - you win
	int dieTotal ()
	{
		if(counter == 3)
		{
			return 0;
		}
		else
		{
			return dieValue1 + dieValue2 + dieValue3 + dieValue4;
		}
	}

	//logic to determine if 3 of kind rolled
	boolean threeOfKindDie()
	{
		if(dieValue1 == dieValue2 && dieValue1 == dieValue3)
		{
			counter++;
			return true;
		}
		else if(dieValue2 == dieValue3 && dieValue2 == dieValue4)
		{
			counter++;
			return true;
		}
		else if(dieValue3 == dieValue4 && dieValue3 == dieValue2)
		{
			counter++;
			return true;
		}
		else if(dieValue1 == dieValue3 && dieValue1 == dieValue4)
		{
			counter++;
			return true;
		}
		else if(dieValue2 == dieValue4 && dieValue2 == dieValue1)
		{
			counter++;
			return true;
		}
		else if(dieValue1 == dieValue2 && dieValue1 == dieValue4)
		{
			counter++;
			return true;
		}
		else
		{
			return false;
		}
	}
}
