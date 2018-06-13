package adro.hms.services.helper;

import java.awt.Component;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * The class models printing JFrame or JPanel to PDF
 * @author ADRO
 *
 */
public class PDFPrinter {
    /**
     * Prints the awtImage to pdf file with name fileName
     * @param awtImage awtImage to be printed
     * @param filePath of pdf where image is printed
     * @throws DocumentException 
     * @throws IOException 
     */
    public static void printCwToPdf (java.awt.Image awtImage, String filePath, String docTitle) throws DocumentException, IOException{

	Document doc = new Document();
	doc.addTitle(docTitle);
	doc.addCreationDate();
	doc.setMargins(0, 0, 0, 0);
	PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream(
		filePath));
	doc.open();
	Image iTextImage = Image.getInstance(writer, awtImage, 1);
	iTextImage.setAlignment(0);
	//iTextImage.scaleToFit(PageSize.A4.getWidth(), PageSize.A4.getHeight());
	doc.add(iTextImage);
	doc.close();


    }
	
    /**
     * Creates the awt file based on component (ex. JFrame, JPanel)
     * @param component, Component to be printed
     * @return
     */
    public static java.awt.Image getImageFromPanel(Component component) {
	System.out.println(component.getSize().getWidth());
	BufferedImage image = new BufferedImage(component.getWidth(),
		component.getHeight(), BufferedImage.TYPE_INT_RGB);
	component.paint(image.getGraphics());
	return image;
    }


	public static void createPDF(String content, String dest) throws DocumentException, IOException {
		Document document = new Document();
		PdfWriter.getInstance(document, new FileOutputStream(dest));
		document.open();
		Paragraph p;
		Font normal = new Font(FontFamily.TIMES_ROMAN, 14);
		Font bold = new Font(FontFamily.TIMES_ROMAN, 14, Font.BOLD);
		boolean title = true;

		p = new Paragraph(content, title ? bold : normal);
		p.setAlignment(Element.ALIGN_JUSTIFIED);
		title = content.isEmpty();
		document.add(p);
		document.close();
		
	}
}
