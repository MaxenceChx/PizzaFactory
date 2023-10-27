package fabrique.pizza;

import principal.MyImage;

public class PizzaTomate implements Pizza {
    private double prix = 5;
    private String nomIm = "file:img/fond_tomate.png";
    private String description = "Pizza base tomate";

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