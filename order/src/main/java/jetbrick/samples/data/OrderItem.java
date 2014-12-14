package jetbrick.samples.data;

public class OrderItem {
    private Integer id;
    private Integer orderId;
    private String goods;
    private Double price;

    public OrderItem() {
    }

    public OrderItem(Integer id, Integer orderId, String goods, Double price) {
        this.id = id;
        this.orderId = orderId;
        this.goods = goods;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getGoods() {
        return goods;
    }

    public void setGoods(String goods) {
        this.goods = goods;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
