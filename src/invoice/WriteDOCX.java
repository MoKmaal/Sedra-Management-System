package invoice;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
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

    public void createInvoce() throws IOException, XmlException {
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        document.write(b); // doc should be a XWPFDocument 
        InputStream inputStream = new ByteArrayInputStream(b.toByteArray());
        XWPFDocument docx = new XWPFDocument(inputStream);

        CTSectPr sectPr = docx.getDocument().getBody().addNewSectPr();
        XWPFHeaderFooterPolicy policy = new XWPFHeaderFooterPolicy(docx, sectPr);

        //write header content
        CTP ctpHeader = CTP.Factory.newInstance();
        CTR ctrHeader = ctpHeader.addNewR();
        CTText ctHeader = ctrHeader.addNewT();

        CTP ctpHeader1 = CTP.Factory.newInstance();
        CTR ctrHeader1 = ctpHeader1.addNewR();
        CTText ctHeader1 = ctrHeader1.addNewT();
        ctHeader1.setStringValue(id + "\n" + invoiceID + "\n" + date);
        ctHeader.setStringValue(name + "\n" + email + "\n" + number + "\n" + address + "\n");
        XWPFParagraph headerParagraph = new XWPFParagraph(ctpHeader, docx);
        headerParagraph.setAlignment(ParagraphAlignment.RIGHT);
        XWPFParagraph headerParagraph1 = new XWPFParagraph(ctpHeader1, docx);
        headerParagraph1.setAlignment(ParagraphAlignment.CENTER);
        XWPFParagraph[] parsHeader = new XWPFParagraph[2];
        parsHeader[0] = headerParagraph;
        parsHeader[1] = headerParagraph1;
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
