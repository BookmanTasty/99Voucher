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
	private JTextField ingUX;
	private JTextField ingUY;
	private JTextField ingCX;
	private JTextField ingCY;
	int perUX = 270;
	int perUY = 150;
	int perCX = 270;
	int perCY = 300;
	String fuePER = "Calibri";
	int fueTAM = 62;
	String archSAL = "ficha";
	
	
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
		
		JPanel panel = new JPanel();
		MenuGEN.add(panel);
		
		JLabel lblNewLabel_7 = new JLabel("Posicion del cursor");
		panel.add(lblNewLabel_7);
		
		JPanel panel_1 = new JPanel();
		MenuGEN.add(panel_1);
		
		JLabel lblNewLabel_14 = new JLabel("X");
		panel_1.add(lblNewLabel_14);
		
		JLabel corRX = new JLabel("0");
		panel_1.add(corRX);
		
		JLabel lblNewLabel_16 = new JLabel("Y");
		panel_1.add(lblNewLabel_16);
		
		JLabel corRY = new JLabel("0");
		panel_1.add(corRY);
		MenuGEN.add(genV);
		
		JButton actuFICH = new JButton("Actualizar");
		JComboBox fonSEL = new JComboBox(fuentes);
		
		JPanel MenuCarga = new JPanel();
		frmvouchersGeneradorDe.getContentPane().add(MenuCarga, BorderLayout.NORTH);
		
		JLabel lblSEL = new JLabel(rdyI);
		lblSEL.setForeground(Color.red);
		JLabel lblCSV = new JLabel(rdyC);
		lblCSV.setForeground(Color.red);
		JSlider tamSEL = new JSlider();
		
		JLabel wIcon = new JLabel(new ImageIcon());
		wIcon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (prevIMG != null) {
					int coimgx = e.getX();
					int coimgy = e.getY();
					corRX.setText(coimgx+"");
					corRY.setText(coimgy+"");
					
					
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
				ingUX.setEnabled(true);
				ingUY.setEnabled(true);
				ingCX.setEnabled(true);
				ingCY.setEnabled(true);
				fonSEL.setEnabled(true);
				actuFICH.setEnabled(true);
				tamSEL.setEnabled(true);
				
						
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
		
		JPanel perPU = new JPanel();
		MenuPER.add(perPU);
		
		JLabel lblNewLabel_8 = new JLabel("X");
		perPU.add(lblNewLabel_8);
		
		ingUX = new JTextField();
		ingUX.setEnabled(false);
		ingUX.setText(perUX+"");
		perPU.add(ingUX);
		ingUX.setColumns(3);
		
		JLabel lblNewLabel_9 = new JLabel("Y");
		perPU.add(lblNewLabel_9);
		
		ingUY = new JTextField();
		ingUY.setEnabled(false);
		ingUY.setText(perUY+"");
		perPU.add(ingUY);
		ingUY.setColumns(3);
		
		JLabel lblNewLabel_5 = new JLabel("\u00A0\u00A0Posici\u00F3n Contrase\u00F1a \u00A0\u00A0");
		MenuPER.add(lblNewLabel_5);
		
		JPanel perPC = new JPanel();
		MenuPER.add(perPC);
		
		JLabel lblNewLabel_10 = new JLabel("X");
		perPC.add(lblNewLabel_10);
		
		ingCX = new JTextField();
		ingCX.setEnabled(false);
		ingCX.setText(perCX+"");
		perPC.add(ingCX);
		ingCX.setColumns(3);
		
		JLabel lblNewLabel_11 = new JLabel("Y");
		perPC.add(lblNewLabel_11);
		
		ingCY = new JTextField();
		ingCY.setEnabled(false);
		ingCY.setText(perCY+"");
		perPC.add(ingCY);
		ingCY.setColumns(3);
		
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
		perFU.add(fonSEL);
		
		JLabel lblNewLabel_12 = new JLabel("\u00A0\u00A0Tama\u00F1o");
		MenuPER.add(lblNewLabel_12);
		
		JPanel peTA = new JPanel();
		MenuPER.add(peTA);
		
		JLabel lblTAM = new JLabel(fueTAM+"");
		
		
		tamSEL.setEnabled(false);
		tamSEL.setMaximum(99);
		tamSEL.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				fueTAM = tamSEL.getValue();
				lblTAM.setText(fueTAM+"");
				
			}
		});
		tamSEL.setValue(62);
		tamSEL.setMinimum(5);
		tamSEL.setPreferredSize(new Dimension(100, 26));
		peTA.add(tamSEL);
		
		
		peTA.add(lblTAM);
		
		JPanel perCO = new JPanel();
		MenuPER.add(perCO);
		
		
		actuFICH.setEnabled(false);
		actuFICH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				perUX = Integer.parseInt(ingUX.getText());
				perUY = Integer.parseInt(ingUY.getText());
				perCX = Integer.parseInt(ingCX.getText());
				perCY = Integer.parseInt(ingCY.getText());
				
				String fueTEM = fonSEL.getSelectedItem().toString();
				String[] fueREC = fueTEM.split(",");
				fuePER = fueREC[1].replace("name=", "");
				
				fueTAM = tamSEL.getValue();
				
				
				try {
					prevIMG = PngGen.imgGENP(archIMG, perUX, perUY, perCX, perCY, fuePER,fueTAM);
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
				 System.out.println(fuePER);
			}
			
		});
		MenuPER.add(actuFICH);
		
		
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
	}
