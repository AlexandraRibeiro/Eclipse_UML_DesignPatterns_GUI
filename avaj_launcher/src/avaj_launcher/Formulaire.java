package avaj_launcher;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class Formulaire {
	
	/**
	 * 		active Components.
	 */
	private JDialog frame;
	private JTextField textField_0;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JComboBox<String> comboBox;
	
	private JLabel label;
	
	/**
	 * Create the class.
	 */
	public Formulaire() {
		initialize(Tools.arrAircrafts, null);		
	}
	
	public void makeVisible(){
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the jDialog.
	 */
	private void initialize(String[] types, JFrame f0) {
		frame = new JDialog(f0, "Aircraft parameters", true);
		frame.setBounds(800, 200, 350, 449);
		frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		textField_0 = new JTextField();
		textField_0.setToolTipText("max value 999");
		textField_0.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_0.setBounds(128, 160, 46, 22);
		frame.getContentPane().add(textField_0);
		textField_0.setColumns(10);

		JLabel idnum = new JLabel("Id number");
		idnum.setFont(new Font("Tahoma", Font.PLAIN, 14));
		idnum.setBounds(186, 160, 66, 20);
		frame.getContentPane().add(idnum);

		JLabel lblongi = new JLabel("Longitude");
		lblongi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblongi.setBounds(186, 193, 66, 20);
		frame.getContentPane().add(lblongi);

		textField_1 = new JTextField();
		textField_1.setToolTipText("Max value 999");
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_1.setBounds(128, 193, 46, 22);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		JLabel lblati = new JLabel("Latitude");
		lblati.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblati.setBounds(186, 226, 66, 20);
		frame.getContentPane().add(lblati);

		textField_2 = new JTextField();
		textField_2.setToolTipText("Max value 999");
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_2.setBounds(128, 226, 46, 22);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);

		JLabel lbhei = new JLabel("Height");
		lbhei.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbhei.setBounds(186, 259, 66, 20);
		frame.getContentPane().add(lbhei);

		textField_3 = new JTextField();
		textField_3.setToolTipText("Max value 999");
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_3.setBounds(128, 259, 46, 22);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);


		JButton btnClear = new JButton("Clear");
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 14));

		btnClear.setBounds(52, 319, 79, 23);
		frame.getContentPane().add(btnClear);


		JLabel lbtype = new JLabel("Type");
		lbtype.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbtype.setBounds(76, 108, 40, 20);
		frame.getContentPane().add(lbtype);

		comboBox = new JComboBox<String>();
		comboBox.setToolTipText("Select the aircraft type");
		comboBox.setForeground(Color.BLUE);
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBox.addItem("Select");
		int jj = 0;
		while (jj < types.length){
			comboBox.addItem(types[jj]);
			jj++;
		}
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String stemp = (String)comboBox.getSelectedItem();
				label.setText("" + stemp.charAt(0));
			}
		});
		comboBox.setBounds(128, 107, 149, 24);
		frame.getContentPane().add(comboBox);


		JButton btnSubmit = new JButton("Save");
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 14));

		btnSubmit.setForeground(Color.RED);
		btnSubmit.setBounds(198, 319, 79, 23);
		frame.getContentPane().add(btnSubmit);
		
		label = new JLabel("");
		label.setForeground(Color.BLUE);
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setBounds(115, 160, 11, 20);
		frame.getContentPane().add(label);


//		btnSubmit.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				if(textField_0.getText().isEmpty() || (textField_1.getText().isEmpty())
//						|| (textField_2.getText().isEmpty()) || (textField_3.getText().isEmpty())
//						|| (comboBox.getSelectedItem().equals("Select")))
//					JOptionPane.showMessageDialog(null, "Data Missing!");
//				else {		
//					/*JOptionPane.showMessageDialog(null, 
//							textField_0.getText() + "\n" +
//							textField_1.getText() + "\n" +
//							textField_2.getText() + "\n" +
//							textField_3.getText() + "\n" +
//							comboBox.getSelectedItem());*/
////					String stemp = (String)comboBox.getSelectedItem();
////					Gui.returned =  stemp + " " +
////							stemp.charAt(0) + textField_0.getText() + " " + 
////							textField_1.getText() + " " +
////							textField_2.getText() + " " +
////							textField_3.getText();
//					/*JOptionPane.showMessageDialog(null,Gui.returned); */
//					frame.setVisible(false); //you can't see me!
//					frame.dispose(); //Destroy the JFrame object
//					
//				}
//			}
//		});

		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox.setSelectedItem("Select");	
				textField_0.setText(null);
				textField_1.setText(null);
				textField_2.setText(null);
				textField_3.setText(null);
				label.setText(null);
			}
		});

	}
}
