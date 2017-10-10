import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Rectangle;

public class DicePanelBuilder {

	DicePanel diePanel = new DicePanel(); //Ricky
	
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DicePanelBuilder window = new DicePanelBuilder();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DicePanelBuilder() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[][][][][][][]", "[][121.00]"));
		
		
		JButton btnRollDie = new JButton("Roll Die");
		frame.getContentPane().add(btnRollDie, "cell 1 0");
		
		JButton btnNewButton = new JButton("Score Points");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		frame.getContentPane().add(btnNewButton, "cell 2 0");
		
		JButton btnSaveHistory = new JButton("Save History");
		frame.getContentPane().add(btnSaveHistory, "cell 3 0");
		
		JButton btnClearHistory = new JButton("Clear History");
		frame.getContentPane().add(btnClearHistory, "cell 4 0");
		
		JButton btnClickToEnable = new JButton("Click to enable log");
		frame.getContentPane().add(btnClickToEnable, "cell 5 0");
		
		//create dice panel
		JPanel graphicsPanel = new JPanel();
		graphicsPanel.setLayout(new MigLayout("", "[]", "[]"));
		frame.getContentPane().add(graphicsPanel, "cell 6 0");
		
		diePanel = new DicePanel();
		frame.getContentPane().add(diePanel, "cell 1 1 4,grow");
		
		//adjust positioning of die, add event handlers
	}

}
