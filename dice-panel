import java.awt.*;
import javax.swing.*;
import javax.swing.*;

public class DicePanel extends JPanel{

	int dieValue1;
	int dieValue2;
	int dieValue3;
	int dieValue4;
	int dieValue5;
	int counter = 0;
	
	//paint method - draw die
	public void paintComponent (Graphics g)
	{
		//scaling for resizing window
		//moved methods up for easier troubleshooting
		//reduced to 4 die for simplicity
		
		int scX, scY, scSz, textX, textY;
		
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
	}
	
	void setRedDie(Graphics g)
	{
		g.setColor(Color.red);
		g.fillRoundRect(650, 50, 100, 100, 25, 25);
		g.setColor(Color.black);
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));
		g.drawString(String.valueOf(dieValue5), 690, 115);
	}*/
	
	//manually set die value
	void setDieValue (int dieValue1, int dieValue2, int dieValue3, int dieValue4, int dieValue5)
	{
		this.dieValue1 = dieValue1;
		this.dieValue2 = dieValue2;
		this.dieValue3 = dieValue3;
		this.dieValue4 = dieValue4;
		this.dieValue5 = dieValue5;
	}
	
	//roll die, set die to random values
	void rollDie ()
	{
		dieValue1 = (int)(Math.random() * 6 + 1);
		dieValue2 = (int)(Math.random() * 6 + 1);
		dieValue3 = (int)(Math.random() * 6 + 1);
		dieValue4 = (int)(Math.random() * 6 + 1);
		dieValue5 = (int)(Math.random() * 6 + 1);
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
			return dieValue1 + dieValue2 + dieValue3 + dieValue4 + dieValue5;
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
		else if(dieValue3 == dieValue4 && dieValue3 == dieValue5)
		{
			counter++;
			return true;
		}
		else if(dieValue1 == dieValue3 && dieValue1 == dieValue4)
		{
			counter++;
			return true;
		}
		else if(dieValue2 == dieValue4 && dieValue2 == dieValue5)
		{
			counter++;
			return true;
		}
		else if(dieValue1 == dieValue3 && dieValue1 == dieValue5)
		{
			counter++;
			return true;
		}
		else if(dieValue1 == dieValue2 && dieValue1 == dieValue5)
		{
			counter++;
			return true;
		}
		else if(dieValue1 == dieValue2 && dieValue1 == dieValue4)
		{
			counter++;
			return true;
		}
		else if(dieValue1 == dieValue4 && dieValue1 == dieValue5)
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
