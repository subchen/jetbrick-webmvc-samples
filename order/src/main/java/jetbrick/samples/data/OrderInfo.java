package jetbrick.samples.data;

import java.util.Date;

public class OrderInfo {
    private Integer id;
    private String serialno;
    private Double price;
    private Date purchaseDate;

    public OrderInfo() {
    }

    public OrderInfo(Integer id, String serialno, Double price, Date purchaseDate) {
        this.id = id;
        this.serialno = serialno;
        this.price = price;
        this.purchaseDate = purchaseDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSerialno() {
        return serialno;
    }

    public void setSerialno(String serialno) {
        this.serialno = serialno;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
}
