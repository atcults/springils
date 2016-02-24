package org.sanelib.ils.core.domain.entity;

import com.google.common.base.Strings;
import org.sanelib.ils.common.utils.RegularExpressionHelper;
import org.sanelib.ils.core.enums.DurationType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.PostLoad;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "cir_privilage_matrix")
public class CirculationMatrix implements DomainEntity {

    private static final Logger logger = LoggerFactory.getLogger(CirculationMatrix.class);

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
    private Double maxFine;

    @Column(name = "renewal_through_opac")
    private String renewalThroughOPAC;

    @Column(name = "other_details")
    private String otherDetails;

    @Column(name = "entry_id")
    private String userCode;

    @Column(name = "patron_category_library_id")
    private Integer patronCategoryLibraryId;

    @Column(name = "entry_date")
    private Date entryDate;

    @Transient
    private DurationType loanDurationType;

    @Transient
    private Integer loanDuration;

    @Transient
    private boolean includeHolidaysInDateDue;

    @Transient
    private List<FixedDate> fixedDateDues;

    @Transient
    private DurationType chargeDurationType;

    @Transient
    private boolean includeHolidaysInCharges;

    @Transient
    private List<ChargeDetail> chargeDetails;

    public class FixedDate{
        private Integer day;
        private Integer month;

        public Integer getDay() {
            return day;
        }

        public void setDay(Integer day) {
            this.day = day;
        }

        public Integer getMonth() {
            return month;
        }

        public void setMonth(Integer month) {
            this.month = month;
        }
    }

    public class ChargeDetail{
        private Integer from;
        private Integer to;
        private Double amount;

        public Integer getFrom() {
            return from;
        }

        public void setFrom(Integer from) {
            this.from = from;
        }

        public Integer getTo() {
            return to;
        }

        public void setTo(Integer to) {
            this.to = to;
        }

        public Double getAmount() {
            return amount;
        }

        public void setAmount(Double amount) {
            this.amount = amount;
        }
    }

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

    public Double getMaxFine() {
        return maxFine;
    }

    public void setMaxFine(Double maxFine) {
        this.maxFine = maxFine;
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

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public DurationType getLoanDurationType() {
        return loanDurationType;
    }

    public void setLoanDurationType(DurationType loanDurationType) {
        this.loanDurationType = loanDurationType;
    }

    public Integer getLoanDuration() {
        return this.loanDuration;
    }

    public void setLoanDuration(Integer loanDuration) {
        this.loanDuration = loanDuration;
    }

    public boolean isIncludeHolidaysInDateDue() {
        return includeHolidaysInDateDue;
    }

    public void setIncludeHolidaysInDateDue(boolean includeHolidaysInDateDue) {
        this.includeHolidaysInDateDue = includeHolidaysInDateDue;
    }

    public List<FixedDate> getFixedDateDues() {
        return fixedDateDues;
    }

    public void addFixedDateDue(int day, int month) {
        if(fixedDateDues == null){
            fixedDateDues = new ArrayList<>();
        }

        FixedDate fixedDateDue = new FixedDate();
        fixedDateDue.setDay(day);
        fixedDateDue.setMonth(month);
        fixedDateDues.add(fixedDateDue);
    }

    public DurationType getChargeDurationType() {
        return chargeDurationType;
    }

    public void setChargeDurationType(DurationType chargeDurationType) {
        this.chargeDurationType = chargeDurationType;
    }

    public boolean isIncludeHolidaysInCharges() {
        return includeHolidaysInCharges;
    }

    public void setIncludeHolidaysInCharges(boolean includeHolidaysInCharges) {
        this.includeHolidaysInCharges = includeHolidaysInCharges;
    }

    public List<ChargeDetail> getChargeDetails() {
        return chargeDetails;
    }

    public void addChargeDetail(int from, int to, Double amount) {
        if(chargeDetails == null){
            chargeDetails = new ArrayList<>();
        }

        ChargeDetail chargeDetail = new ChargeDetail();
        chargeDetail.setFrom(from);
        chargeDetail.setTo(to);
        chargeDetail.setAmount(amount);
        chargeDetails.add(chargeDetail);
    }

    @PostLoad
    public void postLoad() {

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

            Element rootElm = doc.getDocumentElement();

            //Reading OverallLoanLimit
            NodeList nodes = rootElm.getElementsByTagName("OverallLoanLimit");
            if(nodes.getLength() > 0) {
                String value = nodes.item(0).getTextContent();
                if(RegularExpressionHelper.checkIdFormat(value) && this.overAllLoanLimit == null){
                    this.overAllLoanLimit = Integer.parseInt(value);
                }
            }

            //Selecting LoanPeriod
            Element loanPeriodNode = (Element) rootElm.getElementsByTagName("LoanPeriod").item(0);

            //Reading DurationType
            nodes = loanPeriodNode.getElementsByTagName("DurationType");
            if(nodes.getLength() > 0) {
                String value = nodes.item(0).getTextContent();
                this.loanDurationType = DurationType.getByValue(value);
            }

            //Reading Duration
            nodes = loanPeriodNode.getElementsByTagName("Duration");
            if(nodes.getLength() > 0) {
                String value = nodes.item(0).getTextContent();
                if(RegularExpressionHelper.checkIdFormat(value)){
                    this.loanDuration = Integer.parseInt(value);
                }
            }

            //Reading IncludeHolidaysInDateDue
            nodes = loanPeriodNode.getElementsByTagName("Holidays");
            if(nodes.getLength() > 0) {
                String value = nodes.item(0).getTextContent();
                this.includeHolidaysInDateDue = Objects.equals(value, "INCLUDE");
            }

            //Reading fixed date due
            nodes = loanPeriodNode.getElementsByTagName("Occurrances");
            if(nodes.getLength() > 0){
                NodeList occurrences = ((Element) nodes.item(0)).getElementsByTagName("Occurrance");
                for (int temp = 0; temp < occurrences.getLength(); temp++) {
                    Node node = occurrences.item(temp);
                    if (node.getNodeType() == Node.ELEMENT_NODE) {
                        Element element = (Element) node;
                        Integer day = Integer.parseInt(element.getElementsByTagName("day").item(0).getTextContent());
                        Integer month = Integer.parseInt(element.getElementsByTagName("month").item(0).getTextContent());
                        addFixedDateDue(day, month);
                    }
                }
            }

            //Selecting OverDue
            Element overDueElement = (Element) rootElm.getElementsByTagName("OverDue").item(0);

            //Reading DurationType
            nodes = overDueElement.getElementsByTagName("DurationType");
            if(nodes.getLength() > 0) {
                String value = nodes.item(0).getTextContent();
                this.chargeDurationType = DurationType.getByName(value);
            }

            //Reading IncludeHolidaysInOverDue
            nodes = overDueElement.getElementsByTagName("Holidays");
            if(nodes.getLength() > 0) {
                String value = nodes.item(0).getTextContent();
                this.includeHolidaysInCharges = Objects.equals(value, "INCLUDE");
            }

            //Reading fixed date due
            nodes = overDueElement.getElementsByTagName("Charges");
            if(nodes.getLength() > 0){
                NodeList chargeNodes = ((Element) nodes.item(0)).getElementsByTagName("Charge");
                for (int temp = 0; temp < chargeNodes.getLength(); temp++) {
                    Node node = chargeNodes.item(temp);
                    if (node.getNodeType() == Node.ELEMENT_NODE) {
                        Element element = (Element) node;
                        Integer from = Integer.parseInt(element.getElementsByTagName("From").item(0).getTextContent());
                        Integer to = Integer.parseInt(element.getElementsByTagName("To").item(0).getTextContent());
                        Double amount = Double.parseDouble(element.getElementsByTagName("Amount").item(0).getTextContent());
                        addChargeDetail(from, to, amount);
                    }
                }
            }

        } catch (Exception ex){
            logger.error("Error in post load", ex);
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

            Element loanDuration = doc.createElement("Duration");
            loanDuration.appendChild(doc.createTextNode(String.valueOf(this.getLoanDuration())));
            loanPeriod.appendChild(loanDuration);

            if(fixedDateDues != null && fixedDateDues.size() > 0){
                Element occurrencesElement = doc.createElement("Occurrances");
                for(FixedDate fixedDateDue : fixedDateDues){
                    Element occurrenceElement = doc.createElement("Occurrance");
                    Element day = doc.createElement("day");
                    day.appendChild(doc.createTextNode(String.valueOf(fixedDateDue.getDay())));
                    Element month = doc.createElement("month");
                    month.appendChild(doc.createTextNode(String.valueOf(fixedDateDue.getMonth())));
                    occurrenceElement.appendChild(day);
                    occurrenceElement.appendChild(month);
                    occurrencesElement.appendChild(occurrenceElement);
                }
                loanPeriod.appendChild(occurrencesElement);
            }

            Element includeHolidaysInDateDue = doc.createElement("Holidays");
            includeHolidaysInDateDue.appendChild(doc.createTextNode(this.includeHolidaysInDateDue ? "INCLUDE" : "EXCLUDE"));
            loanPeriod.appendChild(includeHolidaysInDateDue);

            Element overDueDetails = doc.createElement("OverDue");
            root.appendChild(overDueDetails);

            Element overDueDurationType = doc.createElement("DurationType");
            overDueDurationType.appendChild(doc.createTextNode(this.chargeDurationType.getName()));
            overDueDetails.appendChild(overDueDurationType);

            if(chargeDetails != null && chargeDetails.size() > 0){
                Element chargesElement = doc.createElement("Charges");
                for(ChargeDetail chargeDetail : chargeDetails){
                    Element chargeElement = doc.createElement("Charge");
                    Element fromElement = doc.createElement("From");
                    fromElement.appendChild(doc.createTextNode(String.valueOf(chargeDetail.getFrom())));
                    Element toElement = doc.createElement("To");
                    toElement.appendChild(doc.createTextNode(String.valueOf(chargeDetail.getTo())));
                    Element amountElement = doc.createElement("Amount");
                    amountElement.appendChild(doc.createTextNode(String.valueOf(chargeDetail.getAmount())));
                    chargeElement.appendChild(fromElement);
                    chargeElement.appendChild(toElement);
                    chargeElement.appendChild(amountElement);
                    chargesElement.appendChild(chargeElement);
                }
                overDueDetails.appendChild(chargesElement);
            }

            Element includeHolidaysInCharges = doc.createElement("Holidays");
            includeHolidaysInCharges.appendChild(doc.createTextNode(this.includeHolidaysInCharges ? "INCLUDE" : "EXCLUDE"));
            overDueDetails.appendChild(includeHolidaysInCharges);

            TransformerFactory tFact = TransformerFactory.newInstance();
            Transformer transformer = tFact.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

            StringWriter writer = new StringWriter();
            StreamResult result = new StreamResult(writer);
            DOMSource source = new DOMSource(doc);
            transformer.transform(source, result);
            this.otherDetails = writer.toString();
        } catch (Exception ex){
            logger.error("Error in pre persist", ex);
        }

    }
}
