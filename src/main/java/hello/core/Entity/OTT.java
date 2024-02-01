package hello.core.Entity;

public class OTT {
    private Long memberId;
    private String subject;
    private int Price;
    private String Kind;
    private int DiscountPirce;

    public OTT(Long memberId, String subject, int price, String kind, int discountPirce) {
        this.memberId = memberId;
        this.subject = subject;
        this.Price = price;
        this.Kind = kind;
        this.DiscountPirce = discountPirce;
    }

    public Long getMemberId() {
        return this.memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public int getDiscountPirce() {
        return this.DiscountPirce;
    }

    public void setDiscountPirce(int discountPirce) {
        this.DiscountPirce = discountPirce;
    }

    public String getSubject() {
        return this.subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getPrice() {
        return this.Price;
    }

    public void setPrice(int price) {
        this.Price = price;
    }

    public String getKind() {
        return this.Kind;
    }

    public void setKind(String kind) {
        this.Kind = kind;
    }

    public int OTTpriceResult() {
        return this.Price - this.DiscountPirce;
    }

    public String toString() {
        return "OTT{memberId=" + this.memberId + ", subject='" + this.subject + "', Price=" + this.Price + ", Kind='" + this.Kind + "', DiscountPirce=" + this.DiscountPirce + "}";
    }
}