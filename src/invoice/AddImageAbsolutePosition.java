package invoice;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Font;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFPicture;
import org.apache.poi.xwpf.usermodel.XWPFPictureData;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class AddImageAbsolutePosition {

    public static void convertWordToPdf(String src, String desc) {
        try {
            //create file inputstream object to read data from file 
            FileInputStream fs = new FileInputStream(src);
            //create document object to wrap the file inputstream object
            XWPFDocument doc = new XWPFDocument(fs);
            //72 units=1 inch
            Document pdfdoc = new Document(PageSize.A4, 72, 72, 72, 72);
            //create a pdf writer object to write text to mypdf.pdf file
            PdfWriter pwriter = PdfWriter.getInstance(pdfdoc, new FileOutputStream(desc));
            //specify the vertical space between the lines of text
            pwriter.setInitialLeading(20);
            //get all paragraphs from word docx
            List plist = doc.getParagraphs();

            //open pdf document for writing
            pdfdoc.open();
            for (int i = 0; i < plist.size();
                    i++) {
                //read through the list of paragraphs
                XWPFParagraph pa = (XWPFParagraph) plist.get(i);
                //get all run objects from each paragraph
                List runs = pa.getRuns();
                //read through the run objects
                for (int j = 0; j < runs.size();
                        j++) {
                    XWPFRun run = (XWPFRun) runs.get(j);
                    //get pictures from the run and add them to the pdf document
                    List piclist = run.getEmbeddedPictures();
                    //traverse through the list and write each image to a file
                    Iterator iterator = piclist.iterator();
                    while (iterator.hasNext()) {
                        XWPFPicture pic = (XWPFPicture) iterator.next();
                        XWPFPictureData picdata = pic.getPictureData();
                        byte[] bytepic = picdata.getData();
                        Image imag = Image.getInstance(bytepic);
                        pdfdoc.add(imag);

                    }
                    //get color code
                    int color = getCode(run.getColor());
                    //construct font object
                   
                    //construct unicode string
                    String text = run.getText(-1);
                    byte[] bs;
                    if (text != null) {
                        bs = text.getBytes();
                        String str = new String(bs, "UTF-8");
                        //add string to the pdf document
                        Chunk chObj1 = new Chunk(str);
                        pdfdoc.add(chObj1);
                    }

                }
                //output new line
                pdfdoc.add(new Chunk(Chunk.NEWLINE));
            }
            //close pdf document  
            pdfdoc.close();
                    XWPFDocument docx = new XWPFDocument(new FileInputStream(new File("generated.docx")));
        FileOutputStream f = new FileOutputStream("generated.pdf");
        docx.write(f);

            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int getCode(String code) {
        int colorCode;
        if (code != null) {
            colorCode = Long.decode("0x" + code).intValue();
        } else {
            colorCode = Long.decode("0x000000").intValue();
        }
        return colorCode;
    }

    public static void converter() throws FileNotFoundException, IOException {

        
    }

    public static void add() throws DocumentException, MalformedURLException, IOException {

        try {
            PdfReader pdfReader = new PdfReader("generated.pdf");

            PdfStamper pdfStamper = new PdfStamper(pdfReader,
                    new FileOutputStream("generated1.pdf"));

            Image image = Image.getInstance("rsz_1logo.png");

            for (int i = 1; i <= pdfReader.getNumberOfPages(); i++) {
                
                PdfContentByte content = pdfStamper.getUnderContent(i);

                image.setAbsolutePosition(50f, 650f);

                content.addImage(image);
            }

            pdfStamper.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    public static String readDocxFile() {
        String output = "";
        try {
            File file = new File("generated.docx");
            FileInputStream fis = new FileInputStream(file.getAbsolutePath());
            XWPFDocument document = new XWPFDocument(fis);
            List<XWPFParagraph> paragraphs = document.getParagraphs();
            for (XWPFParagraph para : paragraphs) {
                output = output + "\n" + para.getText() + "\n";
            }
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return output;
    }

    public static void writePdfFile(String output) throws FileNotFoundException, DocumentException {
        File file = new File("gen.pdf");
        FileOutputStream fileout = new FileOutputStream(file);
        Document document = new Document();
        PdfWriter.getInstance(document, fileout);
        document.addAuthor("Milind");
        document.addTitle("My Converted PDF");
        document.open();
        String[] splitter = output.split("\\n");
        for (int i = 0; i < splitter.length; i++) {
            Chunk chunk = new Chunk(splitter[i]);
            // Font font = new Font();
            //font.setStyle(Font.UNDERLINE);
            //font.setStyle(Font.ITALIC);
            //chunk.setFont(font);
            document.add(chunk);
            Paragraph paragraph = new Paragraph();
            paragraph.add("");
            document.add(paragraph);
        }
        document.close();

    }

}
