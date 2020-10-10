import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException; // incluir en liberia de datos de imagen
import java.io.FileNotFoundException;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
//librerias leer datois imgen
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;



public class Eltodo {

    public static void main(String[] args) {
    	csvRead();
    

    }

    public static void csvRead() {
    	// creamos las variables para cargar el csv
        String csvFile = "C:\\Users\\ghost\\eclipse-workspace\\99vouchers\\src\\userman.csv";
        BufferedReader br = null;
        String line = "";
     // usamos coma como separador
        String cvsSplitBy = ",";
        
     //creamos las variables para manejar el png
        String pngFile = "C:\\Users\\ghost\\eclipse-workspace\\99vouchers\\src\\Ficha1.png";
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
            imgWrite (pngFile,vouchers[0],vouchers[1], j);
           
       
            }
        
      
        
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
        	System.out.println("Se ah terminado de conertir el csv");
        	System.out.println("Se generaron " + j + " fichas del csv");  
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
    public static void imgWrite(String imgFile, String usuario, String contra, int j  ){
       
    	try {
    	//agregamos el texto a la bufered image
    	Font font = new Font("Calibri", Font.BOLD, 62);
        BufferedImage bi = ImageIO.read(new File(imgFile));       
        String outPng = "test" + j + ".png";
        Graphics g = bi.getGraphics();
        g.setFont(font);
        g.setColor(Color.BLACK);
        g.drawString(usuario.replace( '"', ' '), 270, 150);
        g.drawString(contra.replace( '"', ' '), 270, 300);
        ImageIO.write(bi, "png", new File(outPng));
        bi = null;
    	 } catch (FileNotFoundException e) {
             e.printStackTrace();
         } catch (IOException e) {
             e.printStackTrace();

    }
    }
}

    	
     
 

