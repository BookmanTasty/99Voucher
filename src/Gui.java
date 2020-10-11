import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JSplitPane;
import java.awt.Canvas;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class gui {

	private JFrame frmvouchersGeneradorDe;
	//creamos las variables para manejar el png y el csv
	String archIMG = null;
	String archCSV = null;
	String salCSV = null;
	String rdyI = "No seleccionado"; 
	String rdyC = "No seleccionado"; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gui window = new gui();
					window.frmvouchersGeneradorDe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public gui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmvouchersGeneradorDe = new JFrame();
		frmvouchersGeneradorDe.setTitle("99Vouchers Generador de Fichas");
		frmvouchersGeneradorDe.setResizable(false);
		frmvouchersGeneradorDe.setBounds(100, 100, 568, 302);
		frmvouchersGeneradorDe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frmvouchersGeneradorDe.getContentPane().add(panel, BorderLayout.SOUTH);
		
		JButton genV = new JButton("Generar Fichas");
		genV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selDIR();
				generarIMG();
				System.out.println(salCSV);
				
				
			}
		});
		panel.add(genV);
		
		JPanel panel_1 = new JPanel();
		frmvouchersGeneradorDe.getContentPane().add(panel_1, BorderLayout.NORTH);
		
		JButton loadIMG = new JButton("Cargar Plantilla");
		loadIMG.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarIMG();

				
			}
		});
		panel_1.add(loadIMG);
		
		JButton loadCSV = new JButton("Cargar Usuarios");
		loadCSV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarCSV();
			}
		});
		
		JLabel lblSEL = new JLabel(rdyI);
		panel_1.add(lblSEL);
		panel_1.add(loadCSV);
		
		
		JLabel lblCSV = new JLabel(rdyC);
		panel_1.add(lblCSV);
		
		Canvas canvas = new Canvas();
		frmvouchersGeneradorDe.getContentPane().add(canvas, BorderLayout.CENTER);
	}
	private void cargarIMG() {
		
	
		JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());	
		jfc.setDialogTitle("Selecciona plantilla");
		jfc.setAcceptAllFileFilterUsed(false);
		FileNameExtensionFilter filtro = new FileNameExtensionFilter("Imagenes PNG y GIF", "png", "gif");
		jfc.addChoosableFileFilter(filtro);
		
		int returnValue = jfc.showOpenDialog(null);
		// int returnValue = jfc.showSaveDialog(null); esta linea la utilizaremos en caso de querer grabar archivos

		if (returnValue == JFileChooser.APPROVE_OPTION) {
			File selectedFile = jfc.getSelectedFile();		
			archIMG = selectedFile.getAbsolutePath();
			rdyI = "Seleccionado";
			
		}
		
		}
	private void cargarCSV() {
		
		
		JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());	
		jfc.setDialogTitle("Selecciona CSV de User Manager");
		jfc.setAcceptAllFileFilterUsed(false);
		FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos CSV", "CSV");
		jfc.addChoosableFileFilter(filtro);
		
		int returnValue = jfc.showOpenDialog(null);
		// int returnValue = jfc.showSaveDialog(null); esta linea la utilizaremos en caso de querer grabar archivos

		if (returnValue == JFileChooser.APPROVE_OPTION) {
			File selectedFile = jfc.getSelectedFile();		
			archCSV = selectedFile.getAbsolutePath();
			rdyC = "Seleccionado";
		}
	}
		private void selDIR() {
			
			
			JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());	
			jfc.setDialogTitle("Elija un directorio para guardar su archivo");
			jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			//jfc.setAcceptAllFileFilterUsed(false);
			//FileNameExtensionFilter filtro = new FileNameExtensionFilter("Selecciona directorio", "PNG");
			//jfc.addChoosableFileFilter(filtro);
			
			int returnValue = jfc.showSaveDialog(null);
			// int returnValue = jfc.showSaveDialog(null); esta linea la utilizaremos en caso de querer grabar archivos

			if (returnValue == JFileChooser.APPROVE_OPTION) {
				File selectedFile = jfc.getSelectedFile();		
				salCSV = selectedFile.getAbsolutePath();
			}
		
		}
		
	private void generarIMG() {
		if (archIMG != null && archCSV != null && salCSV != null){
			
			PngGen.csvRead(archIMG, archCSV, salCSV);
		}
		else {
			JOptionPane.showMessageDialog(null, "No se han seleccionado los archivos o directorio de salida",  "Error", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	}
