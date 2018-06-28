package p00_shapesDrawing;

public class Rectangle implements Drawable {
    private int height;
    private int width;

    public Rectangle(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    public void sayHi() {
        System.out.println("Hello");
    }

    @Override
    public void draw() {
        for (int i = 0; i < this.getHeight(); i++) {
            System.out.print("*");
            for (int j = 1; j < this.getWidth() - 1; j++) {
                System.out.print(" ");
                if (i == 0 || i == (this.getHeight() - 1)){
                    System.out.print("*");
                } else { System.out.print(" "); }}
            System.out.print(" ");
            System.out.print("*");
            System.out.println();
        }

    }
}
