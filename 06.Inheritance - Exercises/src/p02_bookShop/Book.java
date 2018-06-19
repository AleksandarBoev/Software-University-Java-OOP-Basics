package p02_bookShop;

public class Book {
    private static final String INVALID_AUTHOR_NAME_MESSAGE = "Author not valid!";
    private static final String INVALID_TITLE_MESSAGE = "Title not valid!";
    private static final String INVALID_PRICE_MESSAGE = "Price not valid!";

    private String author;
    private String title;
    private double price;

    public Book(String author, String title, double price) {
        setAuthor(author);
        setTitle(title);
        setPrice(price);
    }

    public String getAuthor() {
        return author;
    }

    private void setAuthor(String author) {
        String[] twoNames = author.split(" ");
        if (twoNames.length == 2 && Character.isDigit(twoNames[1].charAt(0))) {
            throw new IllegalArgumentException(INVALID_AUTHOR_NAME_MESSAGE);
        }

        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    private void setTitle(String title) {
        if (title.length() < 3) {
            throw new IllegalArgumentException(INVALID_TITLE_MESSAGE);
        }

        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    protected void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException(INVALID_PRICE_MESSAGE);
        }

        this.price = price;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Type: ").append(this.getClass().getSimpleName())
                .append(System.lineSeparator())
                .append("Title: ").append(this.getTitle())
                .append(System.lineSeparator())
                .append("Author: ").append(this.getAuthor())
                .append(System.lineSeparator())
                .append("Price: ").append(this.getPrice())
                .append(System.lineSeparator());
        return sb.toString();

    }
}
