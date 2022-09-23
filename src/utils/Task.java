package utils;

import java.util.Date;

public class Task {
    private String title;
    private Date dueDate = new Date();
    private Date createdDate = new Date();
    private Status status = Status.PENDING;
    private String productName;
    private static final long serialVersionUID = 8367141910137788612L;

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) { this.title = title;}
    public String getProductName(){
        return productName;
    }
    public void setProductName(String setProductName) {productName = setProductName;}
    public Date getExpireDate() {
        return dueDate;
    }
    public void setExpireDate(Date dueDate) { this.dueDate = dueDate;}
    public Status getStatus() {
        return status;
    }
    public void setStatus(Status setStatus) {
        this.status = setStatus;
    }
    public Date getCreatedDate() { return createdDate;}
    public void setCreatedDate(Date createdDate) { this.createdDate = createdDate;}

}
