package hello.core.Entity;

public class Order {
    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getDiscountPirce() {
        return discountPirce;
    }

    public void setDiscountPirce(int discountPirce) {
        this.discountPirce = discountPirce;
    }

    public Order(Long memberId, String itemName, int itemPrice, int discountPirce) {
        this.memberId = memberId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.discountPirce = discountPirce;
    }

    private Long memberId;
    private String itemName;
    private int itemPrice;
    private int discountPirce;


    public int CalculationDiscountPirce() {
        return this.itemPrice - this.discountPirce;
    }

    @Override
    public String toString() {
        return "Order{" +
                "memberId=" + memberId +
                ", itemName='" + itemName + '\'' +
                ", itemPrice=" + itemPrice +
                ", discountPirce=" + discountPirce +
                '}';
    }
}
