
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
import java.util.*;

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

    public String GenerarReporte(String Ruta, int id) throws FileNotFoundException, BadElementException, IOException, Exception {
        try {
            //Se crea el documento
            Document documento = new Document();

            //Ruta donde vamos a dejar el archivo
            FileOutputStream ruta = new FileOutputStream(Ruta + ".pdf");

            PdfWriter.getInstance(documento, ruta).setInitialLeading(20);

            //Abrimos el documento para añadir sus componentes
            documento.open();

            //Se establece la imagen de encabezado
            Image imagen = null;
            //Imagen
            imagen = Image.getInstance("src\\Imagenes\\REPORTE2.png");

            //Tamaño de la imagen
            imagen.scaleAbsolute(450, 70);
            //Alineación de donde empieza la imagen
            imagen.setAlignment(Chunk.ALIGN_CENTER);
            //Agregamos la imagen al documento
            documento.add(imagen);

            //Parrafo que contiene el titulo del documento
            Paragraph Titulo = new Paragraph("Datos de vehículo", FontFactory.getFont(
                    FontFactory.TIMES_ROMAN, 14, Font.BOLD, BaseColor.RED));
            Titulo.setAlignment(Chunk.ALIGN_CENTER);
            documento.add(Titulo);
            //Salto de linea(Parrafo en blanco)
            Paragraph salto = new Paragraph(" ");

            //Encabezado de Datos del vehiculo 
            PdfPTable tabla = new PdfPTable(1);
            Phrase frase = new Phrase();
//            
            //Datos del Vehiculo
            BD mbd = new BD();
            mbd.Conectar();
            vehiculo mVehiculo = mbd.ConsultaReporte(id);
            List list = new List(List.UNORDERED);
            ListItem item = new ListItem("Marca: " + mVehiculo.getMarca(), FontFactory.getFont(FontFactory.TIMES_ROMAN, 12));
            ListItem item1 = new ListItem("Modelo: " + mVehiculo.getModelo(), FontFactory.getFont(FontFactory.TIMES_ROMAN, 12));
            ListItem item2 = new ListItem("Año: " + mVehiculo.getAnio(), FontFactory.getFont(FontFactory.TIMES_ROMAN, 12));
            ListItem item3 = new ListItem("Descripción: " + mVehiculo.getDesc_Extra(), FontFactory.getFont(FontFactory.TIMES_ROMAN, 12));

            list.add(item);
            list.add(item1);
            list.add(item2);
            list.add(item3);
            documento.add(list);

            frase = new Phrase("-Rendimiento calculado en kilometros por litro: " + mbd.ConsultaRendimiento(id), FontFactory.getFont(FontFactory.TIMES_ROMAN, 12));
            PdfPTable tabla5 = new PdfPTable(1);
            documento.add(frase);

            frase = new Phrase(" \n-Estado de vehículo : " + mbd.ConsultaEstado(id), FontFactory.getFont(FontFactory.TIMES_ROMAN, 12));
            PdfPTable tabla6 = new PdfPTable(1);
            documento.add(frase);
            documento.add(salto);

            Paragraph Titulo2 = new Paragraph("Mantenimientos realizados", FontFactory.getFont(
                    FontFactory.TIMES_ROMAN, 14, Font.BOLD, BaseColor.RED));
            Titulo2.setAlignment(Chunk.ALIGN_CENTER);
            documento.add(Titulo2);
            documento.add(salto);

            frase = new Phrase("Mantenimiento", FontFactory.getFont(FontFactory.TIMES_ROMAN, 14, Font.BOLD));
            PdfPTable tabla3 = new PdfPTable(2);
            tabla3.addCell(frase);
            frase = new Phrase("Fecha", FontFactory.getFont(FontFactory.TIMES_ROMAN, 14, Font.BOLD));
            tabla3.addCell(frase);
            tabla3.setHorizontalAlignment(Chunk.ALIGN_LEFT);
            documento.add(tabla3);
            java.util.List<Mantenimiento> listamant = mbd.ConsultaMantimiento(id);
            for (Mantenimiento mMantenimiento : listamant) {
                PdfPTable tabla4 = new PdfPTable(2);
                String tipo = "";
                if (mMantenimiento.getTipo().equals("a")) {
                    tipo = "Afinación";
                } else if (mMantenimiento.getTipo().equals("n")) {
                    tipo = "Neumaticos";
                } else if (mMantenimiento.getTipo().equals("c")) {
                    tipo = "Carrocería";
                } else if (mMantenimiento.getTipo().equals("s")) {
                    tipo = "Suspensión y Frenos";
                }
                Phrase mantenimiento = new Phrase(tipo, FontFactory.getFont(FontFactory.TIMES_ROMAN, 12));
                tabla4.addCell(mantenimiento);
                Phrase fecha = new Phrase(mMantenimiento.getFecha_consulta(), FontFactory.getFont(FontFactory.TIMES_ROMAN, 12));
                tabla4.addCell(fecha);
                tabla4.setHorizontalAlignment(Chunk.ALIGN_LEFT);
                documento.add(tabla4);
            }
            documento.add(salto);
            documento.close();
            //Mostrar el pdf
            Ruta = Ruta + ".pdf";

        } catch (DocumentException ex) {
            Logger.getLogger(Reporte.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.out.println("Image IOException " + ex);
        }
        return Ruta;
    }
}
