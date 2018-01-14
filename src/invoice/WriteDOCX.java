package invoice;

import com.itextpdf.text.DocumentException;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import javax.swing.text.Document;
import org.apache.poi.xwpf.model.XWPFHeaderFooterPolicy;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.xmlbeans.XmlException;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText;

public class WriteDOCX {

    private XWPFDocument document;
    private String name;
    private String email;
    private String number;
    private String address;
    private Date date;
    private String id;

    public XWPFDocument getDocument() {
        return document;
    }

    public void setDocument(XWPFDocument document) {
        this.document = document;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInvoiceID() {
        return invoiceID;
    }

    public void setInvoiceID(String invoiceID) {
        this.invoiceID = invoiceID;
    }
    private String invoiceID;

    public void createInvoce() throws IOException, XmlException, FileNotFoundException, DocumentException {
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        document.write(b); // doc should be a XWPFDocument 
        InputStream inputStream = new ByteArrayInputStream(b.toByteArray());
        XWPFDocument docx = new XWPFDocument(inputStream);

        CTSectPr sectPr = docx.getDocument().getBody().addNewSectPr();
        XWPFHeaderFooterPolicy policy = new XWPFHeaderFooterPolicy(docx, sectPr);

        //name
        CTP ctpHeader = CTP.Factory.newInstance();
        CTR ctrHeader = ctpHeader.addNewR();
        CTText ctHeader = ctrHeader.addNewT();
        //phone
        CTP ctpHeader1 = CTP.Factory.newInstance();
        CTR ctrHeader1 = ctpHeader1.addNewR();
        CTText ctHeader1 = ctrHeader1.addNewT();

        //address
        CTP ctpHeader2 = CTP.Factory.newInstance();
        CTR ctrHeader2 = ctpHeader2.addNewR();
        CTText ctHeader2 = ctrHeader2.addNewT();

        //email
        CTP ctpHeader4 = CTP.Factory.newInstance();
        CTR ctrHeader4 = ctpHeader4.addNewR();
        CTText ctHeader4 = ctrHeader4.addNewT();
        //customer ID
        CTP ctpHeader5 = CTP.Factory.newInstance();
        CTR ctrHeader5 = ctpHeader5.addNewR();
        CTText ctHeader5 = ctrHeader5.addNewT();

        //invoice id
        CTP ctpHeader6 = CTP.Factory.newInstance();
        CTR ctrHeader6 = ctpHeader6.addNewR();
        CTText ctHeader6 = ctrHeader6.addNewT();

        //date of day
        CTP ctpHeader7 = CTP.Factory.newInstance();
        CTR ctrHeader7 = ctpHeader7.addNewR();
        CTText ctHeader7 = ctrHeader7.addNewT();

        ctHeader.setStringValue(name);

        ctHeader1.setStringValue(number);
        ctHeader2.setStringValue(address);
        ctHeader4.setStringValue(email);
        ctHeader5.setStringValue("Employee ID: " + id);
        ctHeader6.setStringValue("Invoice ID: " + invoiceID);
        ctHeader7.setStringValue("" + date);

        XWPFParagraph headerParagraph = new XWPFParagraph(ctpHeader, docx);
        headerParagraph.setAlignment(ParagraphAlignment.LEFT);

        XWPFParagraph headerParagraph1 = new XWPFParagraph(ctpHeader1, docx);
        headerParagraph1.setAlignment(ParagraphAlignment.LEFT);

        XWPFParagraph headerParagraph2 = new XWPFParagraph(ctpHeader2, docx);
        headerParagraph2.setAlignment(ParagraphAlignment.LEFT);

        XWPFParagraph headerParagraph3 = new XWPFParagraph(ctpHeader4, docx);
        headerParagraph3.setAlignment(ParagraphAlignment.LEFT);

        XWPFParagraph headerParagraph4 = new XWPFParagraph(ctpHeader5, docx);
        headerParagraph4.setAlignment(ParagraphAlignment.CENTER);

        XWPFParagraph headerParagraph5 = new XWPFParagraph(ctpHeader6, docx);
        headerParagraph5.setAlignment(ParagraphAlignment.CENTER);

        XWPFParagraph headerParagraph6 = new XWPFParagraph(ctpHeader7, docx);
        headerParagraph6.setAlignment(ParagraphAlignment.CENTER);

        XWPFParagraph[] parsHeader = new XWPFParagraph[7];
        parsHeader[0] = headerParagraph;
        parsHeader[1] = headerParagraph1;
        parsHeader[2] = headerParagraph2;
        parsHeader[3] = headerParagraph3;
        parsHeader[4] = headerParagraph4;
        parsHeader[5] = headerParagraph5;
        parsHeader[6] = headerParagraph6;
        policy.createHeader(XWPFHeaderFooterPolicy.DEFAULT, parsHeader);

        //write footer content
        CTP ctpFooter = CTP.Factory.newInstance();
        CTR ctrFooter = ctpFooter.addNewR();
        CTText ctFooter = ctrFooter.addNewT();
        String footerText = "تم استلام البضاعة على سبيل الامانة واتعهد بالحفاظ عليها لحين سداد قيمتها    توقيع .....";
        ctFooter.setStringValue(footerText);
        XWPFParagraph footerParagraph = new XWPFParagraph(ctpFooter, docx);
        XWPFParagraph[] parsFooter = new XWPFParagraph[1];
        parsFooter[0] = footerParagraph;
        policy.createFooter(XWPFHeaderFooterPolicy.DEFAULT, parsFooter);

        //write body content
        XWPFParagraph bodyParagraph = docx.createParagraph();
        bodyParagraph.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun r = bodyParagraph.createRun();
        r.setBold(true);

        FileOutputStream out = new FileOutputStream("generated.docx");
        docx.write(out);
        out.close();
        System.out.println("Done");

        File archive = new File("Archive");
        if (!archive.isDirectory()) {
            archive.mkdir();
        }
        File archiveName = new File("Archive/" + name);
        if (!archiveName.isDirectory()) {
            archiveName.mkdir();
        }
        File archiveNameDate;

        archiveNameDate = new File("Archive/" + name + "/" + date + "_" + Math.random() + ".docx");
        if (!archiveNameDate.exists()) {
            FileOutputStream outArchive = new FileOutputStream(archiveNameDate);

            docx.write(outArchive);

        }

        // AddImageAbsolutePosition.add();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
