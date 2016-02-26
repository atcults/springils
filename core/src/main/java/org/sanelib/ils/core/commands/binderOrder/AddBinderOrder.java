package org.sanelib.ils.core.commands.binderOrder;

import org.sanelib.ils.core.commands.ProcessAuditCommandWithLibraryId;
import org.sanelib.ils.core.domain.entity.BinderOrder;

import java.util.Date;

public class AddBinderOrder extends ProcessAuditCommandWithLibraryId {

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
    private boolean mailStatus;
    private boolean printStatus;
    private String status;

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

    public void setMailStatus(boolean mailStatus) { this.mailStatus = mailStatus; }

    public boolean isPrintStatus() { return printStatus;  }

    public void setPrintStatus(boolean printStatus) { this.printStatus = printStatus;  }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}

