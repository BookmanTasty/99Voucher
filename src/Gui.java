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

import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;



public class gui {

	private JFrame frmvouchersGeneradorDe;
	//creamos las variables para manejar el png y el csv
	String archIMG = null;
	String archCSV = null;
	String salCSV = null;
	String rdyI = "No seleccionado"; 
	String rdyC = "No seleccionado"; 
	BufferedImage prevIMG;
	int perUX = 270;
	int perUY = 150;
	int perCX = 270;
	int perCY = 300;
	String fuePER = "Calibri";
	int fueTAM = 62;
	String archSAL = "ficha";
	int setX = 270;
	int setY = 150; 
	
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
		frmvouchersGeneradorDe.setBounds(100, 100, 718, 502);
		frmvouchersGeneradorDe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//cargamos las fuentes l combo box
		
		GraphicsEnvironment graphEnviron = 
			       GraphicsEnvironment.getLocalGraphicsEnvironment();
			Font[] fuentes = graphEnviron.getAllFonts();
		
		
		
		JPanel MenuGEN = new JPanel();
		frmvouchersGeneradorDe.getContentPane().add(MenuGEN, BorderLayout.SOUTH);
		MenuGEN.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel_3 = new JPanel();
		MenuGEN.add(panel_3);
		
		JLabel lblNewLabel = new JLabel("Tama\u00F1o en pixeles");
		panel_3.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		MenuGEN.add(panel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Alto");
		panel_2.add(lblNewLabel_1);
		
		JLabel cordY = new JLabel("000");
		panel_2.add(cordY);
		
		JLabel lblNewLabel_3 = new JLabel("Ancho");
		panel_2.add(lblNewLabel_3);
		
		JLabel cordX = new JLabel("000");
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
		MenuGEN.add(genV);
		JComboBox fonSEL = new JComboBox(fuentes);
		
		JLabel upX = new JLabel(perUX+"");
		JLabel upY = new JLabel(perUY+"");
		JLabel cpX = new JLabel(perCX+"");
		
		
		
		JPanel MenuCarga = new JPanel();
		frmvouchersGeneradorDe.getContentPane().add(MenuCarga, BorderLayout.NORTH);
		
		JLabel lblSEL = new JLabel(rdyI);
		lblSEL.setForeground(Color.red);
		JLabel lblCSV = new JLabel(rdyC);
		lblCSV.setForeground(Color.red);
		JSlider tamSEL = new JSlider();
		
		
		// definimos el menu de carga 
		JSlider slUX = new JSlider();
		slUX.setMaximum(500);
		slUX.setValue(270);
		slUX.setEnabled(false);
		JSlider slUY = new JSlider();
		slUY.setMaximum(500);
		slUY.setValue(150);
		slUY.setEnabled(false);
		JSlider slCX = new JSlider();
		slCX.setMaximum(500);
		slCX.setValue(270);
		JSlider slCY = new JSlider();
		slCY.setMaximum(500);
		slCY.setValue(300);
		
		
		JLabel wIcon = new JLabel(new ImageIcon());
		wIcon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (prevIMG != null) {
					int coimgx = e.getX();
					int coimgy = e.getY();
					setX = coimgx;
					setY = coimgy;
	
				}
					
			}
		});
		
		JButton loadIMG = new JButton("Cargar Plantilla");
		loadIMG.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarIMG();
				lblSEL.setText(rdyI);
				lblSEL.setForeground(Color.BLUE);
				try {
					prevIMG = PngGen.imgGENP(archIMG, perUX, perUY, perCX, perCY, fuePER, fueTAM);
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
				
				//activamos el menu de edicion
				
								
				fonSEL.setEnabled(true);
				tamSEL.setEnabled(true);
				slUX.setEnabled(true);
				slUX.setMaximum(ancho);
				slUY.setEnabled(true);
				slUY.setMaximum(largo);
				slCX.setEnabled(true);
				slCX.setMaximum(ancho);
				slCY.setEnabled(true);
				slCY.setMaximum(largo);
				
				
				
				
				
				
						
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
		
		MenuCarga.add(loadIMG);
		MenuCarga.add(lblSEL);
		MenuCarga.add(loadCSV);
		MenuCarga.add(lblCSV);
		JLabel cpY = new JLabel(perCY+"");
		
		JPanel visPREP = new JPanel();
		visPREP.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		frmvouchersGeneradorDe.getContentPane().add(visPREP, BorderLayout.CENTER);
		
		visPREP.add(wIcon);
		
		JPanel MenuPER = new JPanel();
		frmvouchersGeneradorDe.getContentPane().add(MenuPER, BorderLayout.EAST);
		MenuPER.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("\u00A0\u00A0Personalizar");
		lblNewLabel_2.setPreferredSize(new Dimension(40, 14));
		lblNewLabel_2.setMinimumSize(new Dimension(40, 14));
		lblNewLabel_2.setMaximumSize(new Dimension(40, 14));
		MenuPER.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("\u00A0\u00A0Posici\u00F3n Usuario");
		MenuPER.add(lblNewLabel_4);
		
		JPanel perPUX = new JPanel();
		MenuPER.add(perPUX);
		
		
		slUX.setPreferredSize(new Dimension(90, 26));
		perPUX.add(slUX);
		slUX.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e)throws  java.lang.NullPointerException {
				perUX = slUX.getValue();
				upX.setText(perUX+"");
				if (archIMG != null) {
					actualizaIMG();
					ImageIcon preICO = new ImageIcon(prevIMG);
					wIcon.setIcon(preICO);
				}
				
				
				
			}
		});
		
		JLabel lblNewLabel_8 = new JLabel("X:");
		perPUX.add(lblNewLabel_8);
		
		
		perPUX.add(upX);
		
		JPanel perPUY = new JPanel();
		MenuPER.add(perPUY);
		
		
		slUY.setPreferredSize(new Dimension(90, 26));
		perPUY.add(slUY);
		slUY.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e)throws  java.lang.NullPointerException {
				perUY = slUY.getValue();
				upY.setText(perUY+"");
				if (archIMG != null) {
					actualizaIMG();
					ImageIcon preICO = new ImageIcon(prevIMG);
					wIcon.setIcon(preICO);
				}
				
				
				
			}
		});
		
		JLabel lblNewLabel_9 = new JLabel("Y:");
		perPUY.add(lblNewLabel_9);
		
		perPUY.add(upY);
		
		JLabel lblNewLabel_5 = new JLabel("\u00A0\u00A0Posici\u00F3n Contrase\u00F1a \u00A0\u00A0");
		MenuPER.add(lblNewLabel_5);
		
		JPanel perPC = new JPanel();
		MenuPER.add(perPC);
		
		
		slCX.setEnabled(false);
		slCX.setPreferredSize(new Dimension(90, 26));
		slCX.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e)throws  java.lang.NullPointerException {
				perCX = slCX.getValue();
				cpX.setText(perCX+"");
				if (archIMG != null) {
					actualizaIMG();
					ImageIcon preICO = new ImageIcon(prevIMG);
					wIcon.setIcon(preICO);
				}
				
				
				
			}
		});
		perPC.add(slCX);
		
		JLabel lblNewLabel_10 = new JLabel("X:");
		perPC.add(lblNewLabel_10);
		

		perPC.add(cpX);
		
		JPanel panel_4 = new JPanel();
		MenuPER.add(panel_4);
		
		
		slCY.setEnabled(false);
		slCY.setPreferredSize(new Dimension(90, 26));
		slCY.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e)throws  java.lang.NullPointerException {
				perCY = slCY.getValue();
				cpY.setText(perCY+"");
				if (archIMG != null) {
					actualizaIMG();
					ImageIcon preICO = new ImageIcon(prevIMG);
					wIcon.setIcon(preICO);
				}
				
				
				
			}
		});
		panel_4.add(slCY);
		
		JLabel lblNewLabel_11 = new JLabel("Y:");
		panel_4.add(lblNewLabel_11);
		
		panel_4.add(cpY);
		
		JLabel lblNewLabel_6 = new JLabel("\u00A0\u00A0Fuente");
		MenuPER.add(lblNewLabel_6);
		
		JPanel perFU = new JPanel();
		MenuPER.add(perFU);
		
		
		fonSEL.setEnabled(false);
		fonSEL.setPreferredSize(new Dimension(120, 20));
		fonSEL.setRenderer(new DefaultListCellRenderer() {
			   @Override
			   public Component getListCellRendererComponent(JList<?> list,
			         Object value, int index, boolean isSelected, boolean cellHasFocus) {
			      if (value != null) {
			         Font font = (Font) value;
			         value = font.getName();
			      }
			      return super.getListCellRendererComponent(list, value, index,
			            isSelected, cellHasFocus);
			   }
			});
		fonSEL.addActionListener (new ActionListener () {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("Rulea");
				String fueTEM = fonSEL.getSelectedItem().toString();
				String[] fueREC = fueTEM.split(",");
				fuePER = fueREC[1].replace("name=", "");
				if (archIMG != null) {
					actualizaIMG();
					ImageIcon preICO = new ImageIcon(prevIMG);
					wIcon.setIcon(preICO);
				}
			}
			
		});
		perFU.add(fonSEL);
		
		
		JLabel lblNewLabel_12 = new JLabel("\u00A0\u00A0Tama\u00F1o");
		MenuPER.add(lblNewLabel_12);
		
		JPanel peTA = new JPanel();
		MenuPER.add(peTA);
		
		JLabel lblTAM = new JLabel(fueTAM+"");
		
		
		tamSEL.setEnabled(false);
		tamSEL.setMaximum(99);
		tamSEL.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e)throws  java.lang.NullPointerException {
				fueTAM = tamSEL.getValue();
				lblTAM.setText(fueTAM+"");
				if (archIMG != null) {
					actualizaIMG();
					ImageIcon preICO = new ImageIcon(prevIMG);
					wIcon.setIcon(preICO);
				}
				
				
				
			}
		});
		tamSEL.setValue(62);
		tamSEL.setMinimum(5);
		tamSEL.setPreferredSize(new Dimension(100, 26));
		peTA.add(tamSEL);
		
		
		peTA.add(lblTAM);
		
		JPanel perCO = new JPanel();
		MenuPER.add(perCO);
		
		
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
			jfc.setDialogTitle("Elija un directorio para guardar sus archivos");
			jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			//jfc.setAcceptAllFileFilterUsed(false);
			//FileNameExtensionFilter filtro = new FileNameExtensionFilter("Guardar archivos", "PNG");
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
			
			PngGen.csvRead(archIMG, archCSV, salCSV, perUX, perUY, perCX, perCY, fuePER, fueTAM);
		}
		else {
			JOptionPane.showMessageDialog(null, "No se han seleccionado los archivos o directorio de salida",  "Error", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	private void actualizaIMG() {
	
		try {
			prevIMG = PngGen.imgGENP(archIMG, perUX, perUY, perCX, perCY, fuePER, fueTAM);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
	
	}
	
}
