package pdf;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;

public class CreatingPDF {
	
	public static void doc(int id, String brand, String engine, String navi, String available, double fuel, int power,
			String name,String surname, String city, String street, String localNumber,String postCode, String humanID) 
					throws FileNotFoundException, DocumentException
	{
		Rectangle rectrangle = new Rectangle(PageSize.A4);
		Document document = new Document();
		Font font = new Font(Font.FontFamily.TIMES_ROMAN,16,Font.NORMAL,new BaseColor(0,0,0));
		document.setPageSize(rectrangle);
		PdfWriter.getInstance(document, new FileOutputStream(name+"_"+surname+"_"+"Contract.pdf"));
		document.open();
		document.add(new Paragraph("Ja "+name+" " + surname + " zamieszak³y przy ulicy " + street + " " +localNumber + " w " + city +
				" " + postCode + " o numerze PESEL: " + humanID + " wynajmuje auto marki " + brand +" o numerze seryjnym w systemie." + id,font));
		document.close();
	}

}
