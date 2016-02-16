package org.sanelib.ils.core.domain.view.admin;


import org.sanelib.ils.core.domain.view.DomainView;
import org.sanelib.ils.core.domain.view.ViewWithId;

import java.util.Date;

public class BinderOrderView implements DomainView, ViewWithId {

    private Integer libraryId;
    private Integer id;
    private Integer binderId;
    private Date orderDate;
    private Date dueDate;
    private Date returnedDate;
    private String formLetterNo;
    private String subject;
    private String content;
    private boolean mailStatus;
    private boolean printStatus;
    private String status;
    private String entryId;
    private Date entryDate;

    public Integer getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(Integer libraryId) {
        this.libraryId = libraryId;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public boolean isMailStatus() { return mailStatus;  }

    public void setMailStatus(boolean mailStatus) {  this.mailStatus = mailStatus;  }

    public boolean isPrintStatus() {  return printStatus;   }

    public void setPrintStatus(boolean printStatus) {   this.printStatus = printStatus; }

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

    @Override
    public String toString() {
        return "BinderOrderView{" +
                "libraryId=" + libraryId +
                ", id=" + id +
                ", binderId=" + binderId +
                ", orderDate=" + orderDate +
                ", dueDate=" + dueDate +
                ", returnedDate=" + returnedDate +
                ", formLetterNo='" + formLetterNo + '\'' +
                ", subject='" + subject + '\'' +
                ", content='" + content + '\'' +
                ", mailStatus='" + mailStatus + '\'' +
                ", printStatus='" + printStatus + '\'' +
                ", status='" + status + '\'' +
                ", entryId='" + entryId + '\'' +
                ", entryDate=" + entryDate +
                '}';
    }
}
