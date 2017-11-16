
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import com.itextpdf.text.pdf.PdfPTable;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author juanj
 */
public class Reporte {
    
    public void GenerarReporte(String Ruta, int id) throws FileNotFoundException, BadElementException, IOException, Exception{
        try {
            //Se crea el documento
            Document documento = new Document();
            
            //Ruta donde vamos a dejar el archivo
            FileOutputStream ruta = new FileOutputStream(Ruta+".pdf");
            
            PdfWriter.getInstance(documento, ruta).setInitialLeading(20);
            
            //Abrimos el documento para añadir sus componentes
            documento.open();
            
            //Se establece la imagen de encabezado
            Image imagen = null;
            //Imagen
            imagen = Image.getInstance("src\\Imagenes\\REGISTRO BIEN.png");
            //Tamaño de la imagen
            imagen.scaleAbsolute(500, 70);
            //Alineación de donde empieza la imagen
            imagen.setAlignment(Chunk.ALIGN_LEFT);
            //Agregamos la imagen al documento
            documento.add(imagen);
            
            //Parrafo que contiene el titulo del documento
            Paragraph Titulo = new Paragraph("Reporte De Vehículo",FontFactory.getFont(
                    FontFactory.TIMES_ROMAN, 18, Font.BOLD, BaseColor.BLACK));
            Titulo.setAlignment(Chunk.ALIGN_CENTER);
            documento.add(Titulo);
            //Salto de linea(Parrafo en blanco)
            Paragraph salto = new Paragraph(" ");
            documento.add(salto);
            
            //Encabezado de Datos del vehiculo 
            PdfPTable tabla = new PdfPTable(1);
            Phrase frase = new Phrase("Datos Del Vehículo", FontFactory.getFont(FontFactory.TIMES_BOLDITALIC,14));
            PdfPCell celda = new PdfPCell(frase);
            tabla.addCell(celda);
            tabla.setHorizontalAlignment(Chunk.ALIGN_LEFT);
            documento.add(tabla);
            
            //Datos del Vehiculo
            BD mbd = new BD();
            mbd.Conectar();
            vehiculo mVehiculo = mbd.ConsultaReporte(id);
            List list = new List(List.UNORDERED);
            ListItem item = new ListItem("Marca: " + mVehiculo.getMarca(), FontFactory.getFont(FontFactory.TIMES_BOLDITALIC, 12));
            ListItem item1 = new ListItem("Modelo: " + mVehiculo.getModelo(),FontFactory.getFont(FontFactory.TIMES_BOLDITALIC,12));
            ListItem item2 = new ListItem("Año: " + mVehiculo.getAnio(),FontFactory.getFont(FontFactory.TIMES_BOLDITALIC,12));
            ListItem item3 = new ListItem("Descripción: " + mVehiculo.getDesc_Extra(),FontFactory.getFont(FontFactory.TIMES_BOLDITALIC,12));

            list.add(item);
            list.add(item1);
            list.add(item2);
            list.add(item3);
            documento.add(list);
            documento.add(salto);
            documento.close();
            
        } catch (DocumentException ex) {
            Logger.getLogger(Reporte.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
                System.out.println("Image IOException " +  ex);
         }
    }
}
