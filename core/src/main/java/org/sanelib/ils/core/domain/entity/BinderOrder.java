package org.sanelib.ils.core.domain.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "cir_binder_order")
public class BinderOrder implements DomainEntity{

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private BinderOrderId binderOrderId;

    @Column(name = "binder_id")
    private Integer binderId;

    @Column(name = "order_date")
    private Date orderDate;

    @Column(name = "due_date")
    private Date dueDate;

    @Column(name = "returned_date")
    private Date returnedDate;

    @Column(name = "form_letter_no")
    private String formLetterNo;

    @Column(name = "subject")
    private String subject;

    @Column(name = "content")
    private String content;

    @Column(name = "mail_status")
    private char mailStatus;

    @Column(name = "print_status")
    private char printStatus;

    @Column(name = "status")
    private String status;

    @Column(name = "entry_id")
    private String entryId;

    @Column(name = "entry_date")
    private Date entryDate;

    public BinderOrderId getBinderOrderId() {
        return binderOrderId;
    }

    public void setBinderOrderId(BinderOrderId binderOrderId) {
        this.binderOrderId = binderOrderId;
    }

    public void setBinderOrderId(int id, int libraryId){
        if(this.binderOrderId == null){
            this.binderOrderId = new BinderOrderId(libraryId, id);
        } else {
            this.binderOrderId.setId(id);
            this.binderOrderId.setLibraryId(libraryId);
        }
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

    public boolean isMailStatus() {
        return mailStatus == 'Y';
    }

    public void setMailStatus(boolean mailStatus) {
        this.mailStatus = mailStatus ? 'Y' : 'N';
    }

    public boolean isPrintStatus() {
        return printStatus == 'Y';
    }

    public void setPrintStatus(boolean printStatus) {
        this.printStatus = printStatus ? 'Y' : 'N';
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BinderOrder binderOrder = (BinderOrder) o;

        return binderOrderId.equals(binderOrder.binderOrderId);

    }

    @Override
    public int hashCode() {
        return binderOrderId.hashCode();
    }

    @PrePersist
    public void prePersist() {
        if(!isMailStatus()){
            setMailStatus(false);
        }

        if(!isPrintStatus()){
            setPrintStatus(false);
        }

        entryDate = new Date();
    }
}
