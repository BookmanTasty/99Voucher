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
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JPanel;
import javax.swing.JInternalFrame;
import javax.swing.JLayeredPane;
import javax.swing.JTabbedPane;

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
	public void initialize() {
		String j = "hola";
		frmvoucherGeneredorDe = new JFrame();
		frmvoucherGeneredorDe.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewButton = new JButton("New button");
		frmvoucherGeneredorDe.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		frmvoucherGeneredorDe.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		frmvoucherGeneredorDe.getContentPane().add(btnNewButton_2);
	}
}
