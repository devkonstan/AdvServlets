package ShopCart;

public class Cart {
    private String product;
    private String type;
    private Integer amount;

    public Cart(String product, String type, Integer amount) {
        this.product = product;
        this.type = type;
        this.amount = amount;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "product='" + product + '\'' +
                ", type='" + type + '\'' +
                ", amount=" + amount +
                '}';
    }
}
