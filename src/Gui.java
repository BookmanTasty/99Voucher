import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import java.awt.Button;
import java.awt.BorderLayout;
import java.awt.Label;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

public class Gui {

	private JFrame frmvoucherGeneredorDe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui window = new Gui();
					window.frmvoucherGeneredorDe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Gui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmvoucherGeneredorDe = new JFrame();
		frmvoucherGeneredorDe.setTitle("99Voucher Generedor de fichas");
		frmvoucherGeneredorDe.setBounds(100, 100, 320, 182);
		frmvoucherGeneredorDe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frmvoucherGeneredorDe.getContentPane().setLayout(springLayout);
		
		JButton btnNewButton_1 = new JButton("Cargar CSV");
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton_1, 205, SpringLayout.WEST, frmvoucherGeneredorDe.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton_1, -103, SpringLayout.SOUTH, frmvoucherGeneredorDe.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton_1, -10, SpringLayout.EAST, frmvoucherGeneredorDe.getContentPane());
		frmvoucherGeneredorDe.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Cargar PNG");
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton_2, 23, SpringLayout.SOUTH, btnNewButton_1);
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton_2, 0, SpringLayout.WEST, btnNewButton_1);
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton_2, -10, SpringLayout.EAST, frmvoucherGeneredorDe.getContentPane());
		frmvoucherGeneredorDe.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton = new JButton("New button");
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton, 0, SpringLayout.WEST, btnNewButton_1);
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton, -10, SpringLayout.SOUTH, frmvoucherGeneredorDe.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton, -10, SpringLayout.EAST, frmvoucherGeneredorDe.getContentPane());
		frmvoucherGeneredorDe.getContentPane().add(btnNewButton);
	}
}
