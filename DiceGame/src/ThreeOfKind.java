	
	import java.awt.* ;
	import java.awt.event.* ;
	import javax.swing.* ;
	import java.io.* ;
	import java.util.Scanner;
	
	//Three of a Kind 
	//Roll 3 of a kind 3 times and you win!

	public class ThreeOfKind {

		static boolean verbose = false;
		String name;
		JFrame frame;
		JButton rollButton;
		JButton scoreButton;
		JLabel statusLabel;
		JLabel scoreLabel;
		JLabel nameLabel;
		DicePanel diePanel;
	    JButton  saveButton ;
	    JButton  clearButton ;
	    JButton  logButton ;
	    JLabel   historyLabel ;
	    SaveInfo history ;
	    boolean  logEnabled = false ;
	    FileWriter logFile ;
		
		public static void main(String[] args) {
			//create GUI instance, run go()
			ThreeOfKind gui = new ThreeOfKind();
			
			//code to save file & key info
			try
			{
				FileInputStream historyFileStream = new FileInputStream("GameHistory.ser");
				ObjectInputStream historyObjectStream = new ObjectInputStream(historyFileStream);
				Object historyObject = historyObjectStream.readObject();
				gui.history = (SaveInfo)historyObject;
				historyObjectStream.close();
				historyFileStream.close();
				System.out.println("Restoring existing game history");
			}
			catch (FileNotFoundException e)
			{
				gui.history = new SaveInfo();
				System.out.println("Creating new game history object");
			}
			catch (ClassNotFoundException e)
			{
				System.out.println("Failed to load game history file. ");
				return;
			}
			catch (IOException e)
			{
				System.out.println("Failed to load game history file. ");
				return;
			}
			//Start game
			gui.go();
			if (verbose)System.out.println("Exiting main method");
		}
		
		public void userName()
		{
			Scanner scan = new Scanner(System.in);
			System.out.print("Enter user name (blocking): ");
			name = scan.nextLine();
			if(nameLabel != null)
			{
				nameLabel.setText(name + "   ");
			}
		}
		
		public void go ()
		{
			//create name thread
			userName();
			Runnable enterNameJob = new NameEntry();
			Thread enterNameThread = new Thread(enterNameJob);
			enterNameThread.start();
			
			//create and configure frame
			frame = new JFrame();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(800, 500);
			frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
			
			//create panels and add to frame
			JPanel buttonPanel = new JPanel();
			buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
			buttonPanel.setSize(500,100);
			frame.getContentPane().add(buttonPanel);
			JPanel graphicsPanel = new JPanel();
			graphicsPanel.setLayout(new BoxLayout(graphicsPanel, BoxLayout.X_AXIS));
			graphicsPanel.setSize(500,100);
			frame.getContentPane().add(graphicsPanel);
			JPanel messagePanel = new JPanel();
			messagePanel.setSize(500,100);
			frame.getContentPane().add(messagePanel);
			
			//create dice panel
			diePanel = new DicePanel();
			graphicsPanel.add(diePanel);
			
			//create buttons and add to panel
			rollButton = new JButton("Roll Die");
			rollButton.addActionListener(new RollListener());
			buttonPanel.add(rollButton);
			
			scoreButton = new JButton("Score Points");
			scoreButton.addActionListener(new ScoreListener());
			buttonPanel.add(scoreButton);
			
			saveButton = new JButton("Save History");
			saveButton.addActionListener(new SaveListener());
			buttonPanel.add(saveButton);
			
			clearButton = new JButton("Clear History");
			clearButton.addActionListener(new ClearListener());
			buttonPanel.add(clearButton);
			
			logButton = new JButton("Click to enable log");
			logButton.addActionListener(new LogListener());
			buttonPanel.add(logButton);
			
			//create text objects and add to panel
			Font labelFont = new Font(Font.SANS_SERIF, Font.BOLD, 20);
			nameLabel = new JLabel();
			if(name!=null)
			{
				nameLabel.setText(name + "    ");
			}
			nameLabel.setFont(labelFont);
			messagePanel.add(nameLabel);
			
			scoreLabel = new JLabel("Score = 0");
			scoreLabel.setFont(labelFont);
			messagePanel.add(scoreLabel);
			
			statusLabel = new JLabel("   Ready to Play");
			statusLabel.setFont(labelFont);
			messagePanel.add(statusLabel);
			
			historyLabel = new JLabel(history.returnStatus());
			historyLabel.setFont(labelFont);
			messagePanel.add(historyLabel);
			
			//make frame visible
			frame.setVisible(true);
			if(verbose)System.out.println("Exiting go method");
		}
		
		//listener for roll button
		class RollListener implements ActionListener
		{
			public void actionPerformed(ActionEvent event)
			{
				diePanel.rollDie();
				frame.repaint();
			}
		}
		
		//listener for score button
		class ScoreListener implements ActionListener
		{
			public void actionPerformed(ActionEvent event)
			{
				int total;
				int counter;
				boolean threeOfKind;
				
				threeOfKind = diePanel.threeOfKindDie();
				total = diePanel.dieTotal();
				counter = diePanel.counterSet();
				
				scoreLabel.setText("Score = " + Integer.toString(total));
				
				//determine how player wins
				if (threeOfKind == true && counter == 3)
				{
					statusLabel.setText("    You win!");
				}
				else if(threeOfKind == true)
				{
					statusLabel.setText("    You got 3 of a kind!");
				}
				else
				{
					statusLabel.setText("    Try again.");
				}
			}
		}
		
		//Listener for save
		class SaveListener implements ActionListener
		{
			public void actionPerformed(ActionEvent event)
			{
				history.saveHistory();
			}
		}
		
		//Listener for clear
		class ClearListener implements ActionListener
		{
			public void actionPerformed(ActionEvent event)
			{
				history.clearHistory();
				history.saveHistory();
				historyLabel.setText(history.returnStatus());
			}
		}
		
		//Listener for log
		class LogListener implements ActionListener
		{
			public void actionPerformed(ActionEvent event)
			{
				logEnabled =! logEnabled;
				if(logEnabled == true)
				{
					try
					{
						logFile = new FileWriter("LogFile.txt");
					}
					catch (IOException e)
					{
						System.out.println("Open log file failed");
					}
					logButton.setText("Log enabled");
				}
				else
				{
					try
					{
						logFile.close();
					}
					catch (IOException e)
					{
						System.out.println("Close log file failed");
					}
					logButton.setText("Log disabled");
				}
			}
		}
		
		class NameEntry implements Runnable
		{
			public void run()
			{
				userName();
			}
			
			public void userName()
			{
				Scanner scan = new Scanner(System.in);
				System.out.print("Enter your name (non-blocking): ");
				name = scan.nextLine();
				if(nameLabel != null)
				{
					nameLabel.setText(name + "    ");
				}
			}
		}
	}
