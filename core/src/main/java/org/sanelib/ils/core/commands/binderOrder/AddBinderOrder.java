package org.sanelib.ils.core.commands.binderOrder;

import org.sanelib.ils.core.commands.ProcessCommandWithLibraryId;
import org.sanelib.ils.core.domain.entity.BinderOrder;

import java.util.Date;

public class AddBinderOrder extends ProcessCommandWithLibraryId {

    @Override
    public Class getRootEntityClass() {
        return BinderOrder.class;
    }

    @Override
    public String getRootEntityName() {
        return "domain.entity.binderOrder";
    }

    private Integer binderId;
    private Date orderDate;
    private Date dueDate;
    private Date returnedDate;
    private String formLetterNo;
    private String subject;
    private String content;
    private String mailStatus;
    private String printStatus;
    private String status;
    private String entryId;
    private Date entryDate;

    public Integer getBinderId() {
        return binderId;
    }

    public void setBinderId(Integer binderId) {
        this.binderId = binderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getReturnedDate() {
        return returnedDate;
    }

    public void setReturnedDate(Date returnedDate) {
        this.returnedDate = returnedDate;
    }

    public String getFormLetterNo() {
        return formLetterNo;
    }

    public void setFormLetterNo(String formLetterNo) {
        this.formLetterNo = formLetterNo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMailStatus() {
        return mailStatus;
    }

    public void setMailStatus(String mailStatus) {
        this.mailStatus = mailStatus;
    }

    public String getPrintStatus() {
        return printStatus;
    }

    public void setPrintStatus(String printStatus) {
        this.printStatus = printStatus;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEntryId() {
        return entryId;
    }

    public void setEntryId(String entryId) {
        this.entryId = entryId;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }
}

