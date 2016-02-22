package org.sanelib.ils.api.dto.binderOrder;

import org.sanelib.ils.api.dto.DtoWithId;
import org.sanelib.ils.api.dto.DtoWithLibraryId;

public class BinderOrderDto implements DtoWithId, DtoWithLibraryId {

    private String libraryId;
    private String id;
    private String binderId;
    private String orderDate;
    private String dueDate;
    private String returnedDate;
    private String formLetterNo;
    private String subject;
    private String content;
    private boolean mailStatus;
    private boolean printStatus;
    private String status;

    @Override
    public String getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(String libraryId) {
        this.libraryId = libraryId;
    }

    @Override
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBinderId() {
        return binderId;
    }

    public void setBinderId(String binderId) {
        this.binderId = binderId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getReturnedDate() {
        return returnedDate;
    }

    public void setReturnedDate(String returnedDate) {
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

    public boolean isMailStatus() {  return mailStatus;  }

    public void setMailStatus(boolean mailStatus) { this.mailStatus = mailStatus;  }

    public boolean isPrintStatus() {  return printStatus;  }

    public void setPrintStatus(boolean printStatus) { this.printStatus = printStatus;  }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
