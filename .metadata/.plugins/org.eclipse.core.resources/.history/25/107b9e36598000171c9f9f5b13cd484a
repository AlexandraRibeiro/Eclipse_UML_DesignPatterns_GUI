package avaj_launcher;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

public class swing1 extends JFrame implements ActionListener
{
	/**
	 * c
	 */
	private static final long serialVersionUID = 1L;
	
	
	JFrame fenetre1;
	JPanel panel1;
	JPanel panel2;
	JScrollPane jsp;
	JSplitPane splitPane,splitPane2;
	JPanel panelboutton;
	JButton pre,nex,fin,can;
	JPanel panelgen;
	

	public swing1() {
		
		fenetre1 = new JFrame("Generator");
		
		panel1 = new JPanel(new BorderLayout());
		panel1.setBackground(new Color(255,255,255));
		panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
		panel1.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder("New Aircraft"),
                BorderFactory.createEmptyBorder(10,10,10,10)));
		
		
		ButtonGroup groupe = new ButtonGroup();
		JRadioButton button1 = new JRadioButton("JetPlane");
		groupe.add(button1);
		panel1.add(button1);
		JRadioButton button2 = new JRadioButton("Helicopter");
		groupe.add(button2);
		panel1.add(button2);
		JRadioButton button3 = new JRadioButton("Baloon");
		groupe.add(button3);
		panel1.add(button3);
		JRadioButton button4 = new JRadioButton("Rocket");
		groupe.add(button4);
		panel1.add(button4);
		JRadioButton button5 = new JRadioButton("Drone");
		groupe.add(button5);
		panel1.add(button5);
		
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		button5.addActionListener(this);

		
		
//		panel2 = new JPanel();
//		panel2.setLayout(null);
//		panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS)); // Specifies that components should be laid out top to bottom.
//		panel2.setBorder(BorderFactory.createCompoundBorder(
//				BorderFactory.createTitledBorder("File"),
//				BorderFactory.createEmptyBorder(1,1,1,1)));
				
		

//		
//		splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT,panel1,panel2);
//		splitPane.setDividerLocation(200);
//		splitPane.setOneTouchExpandable(true);
		
		 panelboutton = new JPanel(new BorderLayout());
		  panelboutton.setLayout(null);
		  panelboutton.setSize(50, 100);
		  
		  pre = new JButton ("<html><body><u>P</u>revious</body></html>");
		  pre.setBounds(295, 15, 90, 25);
		  panelboutton.add(pre);
		  
		  nex = new JButton ("<html><body><u>N</u>ext</body></html>");
		  nex.setBounds(390, 15, 90, 25);
//		  nex.addActionListener((ActionListener) this);
		  //nex.setEnabled(false);
		  panelboutton.add(nex);
//		  pre.addActionListener((ActionListener) this);
		  
		  fin = new JButton ("<html><body><u>F</u>inish</body></html>");
		  fin.setBounds(485, 15, 90, 25);
		  fin.setEnabled(false);
		  panelboutton.add(fin);
		  
		  can = new JButton ("<html><body><u>C</u>ancel</body></html>");
		  can.setBounds(580, 15, 90, 25);
		  panelboutton.add(can);
		  
		  splitPane2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT,splitPane,panelboutton);
		  splitPane2.setDividerLocation(455);
		  		  
		  fenetre1.add(panel1);
		  fenetre1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  fenetre1.setResizable(false);
		  fenetre1.setBounds(150, 150, 685, 550);
		  fenetre1.setVisible(true);
		
		setSize(500,100);
		setResizable(false);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) 
	{}

}
                                                                                                                        