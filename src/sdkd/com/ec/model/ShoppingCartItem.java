package sdkd.com.ec.model;

/**
 * Created by Administrator on 2016/7/9.
 */
public class ShoppingCartItem {
    private EbProduct product;
    private long quantity;
    private double cost;
    public EbProduct getProduct() {
        return product;
    }

    public void setProduct(EbProduct product) {
        this.product = product;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }


    public ShoppingCartItem(EbProduct product,long quantity,double cost){
        this.cost=cost;
        this.product=product;
        this.quantity=quantity;
    }










}
