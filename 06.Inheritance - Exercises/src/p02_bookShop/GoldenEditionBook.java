package p02_bookShop;

public class GoldenEditionBook extends Book {
    public GoldenEditionBook(String author, String title, double price) {
         super(author, title, price);
    }

    protected void setPrice(double price) {
        price = price + ((price * 30) / 100);
        super.setPrice(price);
    }


}
