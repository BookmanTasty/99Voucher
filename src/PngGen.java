import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class PngGen {
	
	    public static void csvRead(String pngFile,  String csvFile, String salCSV) {
	    	// creamos las variables para cargar el csv
	        BufferedReader br = null;
	        String line = "";
	     // usamos coma como separador
	        String cvsSplitBy = ",";
	        
	     

	     //asignamos las variables para la salida y fuentes del png        
	        int j = 0;     
	        
	        try {
	        	
	        br = new BufferedReader(new FileReader(csvFile));
	     //skipeamos la primer linea para proseguir con las lineas faltantes
	        br.readLine();
	        while ((line = br.readLine()) != null) {

	     // usamos coma como separador
	            String[] vouchers = line.split(cvsSplitBy);
	            System.out.println(vouchers[0].replace( '"', ' ') + vouchers[1]);
	     //remplazamos los 
	            j++;
	            imgWrite (pngFile,vouchers[0],vouchers[1], j, salCSV);
	           
	       
	            }
	        
	      
	        
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
	        	System.out.println("Se generaron " + j + " fichas a partir del csv");
	        	JOptionPane.showMessageDialog (null, "Se generaron " + j + " fichas a partir del csv");
	        } finally {
	            if (br != null) {
	                try {
	                    br.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	        }
	
	    	
	    
	    public static void imgWrite(String imgFile, String usuario, String contra, int j  ,String salDir){
	       
	    	try {
	    	//agregamos el texto a la bufered image
	    	Font font = new Font("Calibri", Font.BOLD, 62);
	        BufferedImage bi = ImageIO.read(new File(imgFile));
	        String dirPNG = salDir+"/";
	        String outPng = "test" + j + ".png";
	        Graphics g = bi.getGraphics();
	        g.setFont(font);
	        g.setColor(Color.BLACK);
	        g.drawString(usuario.replace( '"', ' '), 270, 150);
	        g.drawString(contra.replace( '"', ' '), 270, 300);
	        ImageIO.write(bi, "png", new File(dirPNG+outPng));
	        bi = null;
	    	 } catch (FileNotFoundException e) {
	             e.printStackTrace();
	         } catch (IOException e) {
	             e.printStackTrace();

	    }
	    }
		
	}

