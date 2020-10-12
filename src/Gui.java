import java.awt.EventQueue;
import java.io.File;
import java.io.IOException;

import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.Component;



public class gui {

	private JFrame frmvouchersGeneradorDe;
	//creamos las variables para manejar el png y el csv
	String archIMG = null;
	String archCSV = null;
	String salCSV = null;
	String rdyI = "No seleccionado"; 
	String rdyC = "No seleccionado"; 
	BufferedImage prevIMG;

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
	public void initialize() {
		frmvouchersGeneradorDe = new JFrame();
		frmvouchersGeneradorDe.setTitle("99Vouchers Generador de Fichas");
		frmvouchersGeneradorDe.setResizable(false);
		frmvouchersGeneradorDe.setBounds(100, 100, 680, 480);
		frmvouchersGeneradorDe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		JPanel panel = new JPanel();
		frmvouchersGeneradorDe.getContentPane().add(panel, BorderLayout.SOUTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
		panel.add(panel_3);
		
		JLabel lblNewLabel = new JLabel("Tama\u00F1o en pixeles");
		panel_3.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Alto");
		panel_2.add(lblNewLabel_1);
		
		JLabel cordY = new JLabel("CorY");
		panel_2.add(cordY);
		
		JLabel lblNewLabel_3 = new JLabel("Ancho");
		panel_2.add(lblNewLabel_3);
		
		JLabel cordX = new JLabel("CorX");
		panel_2.add(cordX);
		
		JButton genV = new JButton("Generar Fichas");
		genV.setAlignmentX(Component.CENTER_ALIGNMENT);
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
		
		JLabel lblSEL = new JLabel(rdyI);
		lblSEL.setForeground(Color.red);
		JLabel lblCSV = new JLabel(rdyC);
		lblCSV.setForeground(Color.red);
		
		JLabel wIcon = new JLabel(new ImageIcon());
		
		JButton loadIMG = new JButton("Cargar Plantilla");
		loadIMG.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarIMG();
				lblSEL.setText(rdyI);
				lblSEL.setForeground(Color.BLUE);
				try {
					prevIMG = PngGen.imgGENP(archIMG);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				int ancho = prevIMG.getWidth();
				int largo = prevIMG.getHeight();
				cordX.setText(ancho+"");
				cordY.setText(largo+"");
				ImageIcon preICO = new ImageIcon(prevIMG);
				wIcon.setIcon(preICO);
				
						
			}
		});
		
		
		JButton loadCSV = new JButton("Cargar Usuarios");
		loadCSV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarCSV();
				lblCSV.setText(rdyC);
				lblCSV.setForeground(Color.blue);
			}
		});
		
		panel_1.add(loadIMG);
		panel_1.add(lblSEL);
		panel_1.add(loadCSV);
		panel_1.add(lblCSV);
		
		JPanel visPREP = new JPanel();
		frmvouchersGeneradorDe.getContentPane().add(visPREP, BorderLayout.CENTER);
		
		visPREP.add(wIcon);
		
		
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
