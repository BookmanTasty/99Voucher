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
import net.miginfocom.swing.MigLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

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
		frmvoucherGeneredorDe.setBounds(100, 100, 295, 165);
		frmvoucherGeneredorDe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnNewButton_1 = new JButton("Cargar CSV");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JLabel lblNewLabel = new JLabel("Ruta del archivo CSV");
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		
		JButton btnNewButton_2 = new JButton("Cargar PNG");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JLabel lblNewLabel_2 = new JLabel("Ruta del archivo PNG");
		
		JLabel lblNewLabel_1_1 = new JLabel("New label");
		
		JButton btnNewButton = new JButton("Generar Fichas");
		frmvoucherGeneredorDe.getContentPane().setLayout(new MigLayout("", "[89px][6px][101px]", "[23px][14px][23px][14px][23px]"));
		frmvoucherGeneredorDe.getContentPane().add(btnNewButton_1, "cell 0 0,alignx right,aligny top");
		frmvoucherGeneredorDe.getContentPane().add(lblNewLabel, "cell 2 0,alignx left,aligny center");
		frmvoucherGeneredorDe.getContentPane().add(lblNewLabel_1, "cell 2 1,alignx left,aligny top");
		frmvoucherGeneredorDe.getContentPane().add(btnNewButton_2, "cell 0 2,alignx left,aligny top");
		frmvoucherGeneredorDe.getContentPane().add(lblNewLabel_2, "cell 2 2,alignx left,aligny center");
		frmvoucherGeneredorDe.getContentPane().add(lblNewLabel_1_1, "cell 2 3,alignx left,aligny top");
		frmvoucherGeneredorDe.getContentPane().add(btnNewButton, "cell 0 4 3 1,alignx right,aligny top");
	}
}
