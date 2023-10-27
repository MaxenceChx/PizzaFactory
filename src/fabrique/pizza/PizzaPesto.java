package fabrique.pizza;

import principal.MyImage;

public class PizzaPesto implements Pizza {
    private double prix = 8;
    private String nomIm = "file:img/fond_pesto.png";
    private String description = "Pizza base pesto";

    public MyImage getPizzaIm() {
        return new MyImage(this.nomIm, null);
    }

    public double cout() {
        return prix;
    }

    public String getDescription() {
        return description;
    }
}