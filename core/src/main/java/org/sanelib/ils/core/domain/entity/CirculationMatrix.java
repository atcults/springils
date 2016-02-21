package org.sanelib.ils.core.domain.entity;

import com.google.common.base.Strings;
import org.sanelib.ils.common.utils.RegularExpressionHelper;
import org.sanelib.ils.core.enums.LoanDurationType;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.persistence.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "cir_privilage_matrix")
public class CirculationMatrix implements DomainEntity {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private CirculationMatrixId circulationMatrixId;

    @Column(name = "loan_limit")
    private Integer overAllLoanLimit;

    @Column(name = "renewal_limit")
    private Integer renewalLimit;

    @Column(name = "fine_per_day")
    private Double finePerDay;

    @Column(name = "max_ceil_on_fine")
    private Double maxCeilOnFine;

    @Column(name = "renewal_through_opac")
    private String renewalThroughOPAC;

    @Column(name = "other_details")
    private String otherDetails;

    @Column(name = "entry_id")
    private String auditUserCode;

    @Column(name = "patron_category_library_id")
    private Integer patronCategoryLibraryId;

    @Column(name = "entry_date")
    private Date entryDate;

    @Transient
    private LoanDurationType loanDurationType;

    public CirculationMatrixId getCirculationMatrixId() {
        return this.circulationMatrixId;
    }

    public void setCirculationMatrixId(Integer libraryId, Integer patronCategoryId, Integer materialTypeId, Date withEffectFrom) {

        if(this.circulationMatrixId == null){
            this.circulationMatrixId = new CirculationMatrixId();
        }

        this.circulationMatrixId.setLibraryId(libraryId);
        this.circulationMatrixId.setPatronCategoryId(patronCategoryId);
        this.circulationMatrixId.setMaterialTypeId(materialTypeId);
        this.circulationMatrixId.setWithEffectFrom(withEffectFrom);
    }

    public Integer getOverAllLoanLimit() {
        return overAllLoanLimit;
    }

    public void setOverAllLoanLimit(Integer overAllLoanLimit) {
        this.overAllLoanLimit = overAllLoanLimit;
    }

    public Integer getRenewalLimit() {
        return renewalLimit;
    }

    public void setRenewalLimit(Integer renewalLimit) {
        this.renewalLimit = renewalLimit;
    }

    public Double getFinePerDay() {
        return finePerDay;
    }

    public void setFinePerDay(Double finePerDay) {
        this.finePerDay = finePerDay;
    }

    public Double getMaxCeilOnFine() {
        return maxCeilOnFine;
    }

    public void setMaxCeilOnFine(Double maxCeilOnFine) {
        this.maxCeilOnFine = maxCeilOnFine;
    }

    public boolean getRenewalThroughOPAC() {
        return Objects.equals(renewalThroughOPAC, "Y");
    }

    public void setRenewalThroughOPAC(boolean renewalThroughOPAC) {
        this.renewalThroughOPAC = renewalThroughOPAC ? "Y" : "N";
    }

    public String getOtherDetails() {
        return otherDetails;
    }

    public void setOtherDetails(String otherDetails) {
        this.otherDetails = otherDetails;
    }

    public String getAuditUserCode() {
        return auditUserCode;
    }

    public void setAuditUserCode(String auditUserCode) {
        this.auditUserCode = auditUserCode;
    }

    public LoanDurationType getLoanDurationType() {
        return loanDurationType;
    }

    public void setLoanDurationType(LoanDurationType loanDurationType) {
        this.loanDurationType = loanDurationType;
    }

    @PostLoad
    public void postLoad() {
        System.out.println("Post load called");
        System.out.println(this.otherDetails);

        if(Strings.isNullOrEmpty(this.otherDetails)){
            return;
        }

        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            InputSource is = new InputSource();
            is.setCharacterStream(new StringReader(this.otherDetails));

            Document doc = dBuilder.parse(is);
            doc.getDocumentElement().normalize();
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

            Element rootElm = doc.getDocumentElement();

            //Reading OverallLoanLimit
            NodeList nodes = rootElm.getElementsByTagName("OverallLoanLimit");
            if(nodes.getLength() > 0) {
                String value = nodes.item(0).getTextContent();
                System.out.println("Overall Loan Limit: " + value);
                if(RegularExpressionHelper.checkIdFormat(value) && this.overAllLoanLimit == null){
                    this.overAllLoanLimit = Integer.parseInt(value);
                }
            }

            nodes = rootElm.getElementsByTagName("DurationType");
            if(nodes.getLength() > 0) {
                String value = nodes.item(0).getTextContent();
                System.out.println("Duration Type: " + value);
                this.loanDurationType = LoanDurationType.getByValue(value);
            }

        } catch (Exception ex){
            System.out.println(ex);
        }
    }

    @PrePersist
    public void prePersist() {
        this.patronCategoryLibraryId = this.circulationMatrixId.getLibraryId();
        this.entryDate = new Date();

        try {
            DocumentBuilderFactory dFact = DocumentBuilderFactory.newInstance();
            DocumentBuilder build = dFact.newDocumentBuilder();
            Document doc = build.newDocument();
            doc.setXmlStandalone(true);
            Element root = doc.createElement("Root");
            doc.appendChild(root);

            Element overallLoanLimit = doc.createElement("OverallLoanLimit");
            overallLoanLimit.appendChild(doc.createTextNode(String.valueOf(this.overAllLoanLimit)));
            root.appendChild(overallLoanLimit);

            Element loanPeriod = doc.createElement("LoanPeriod");
            root.appendChild(loanPeriod);

            Element durationType = doc.createElement("DurationType");
            durationType.appendChild(doc.createTextNode(this.loanDurationType.toString()));
            loanPeriod.appendChild(durationType);

            TransformerFactory tFact = TransformerFactory.newInstance();
            Transformer transformer = tFact.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

            StringWriter writer = new StringWriter();
            StreamResult result = new StreamResult(writer);
            DOMSource source = new DOMSource(doc);
            transformer.transform(source, result);
            this.otherDetails = writer.toString();
            System.out.println(this.otherDetails);
        } catch (Exception ex){
            System.out.println(ex);
        }

    }
}
