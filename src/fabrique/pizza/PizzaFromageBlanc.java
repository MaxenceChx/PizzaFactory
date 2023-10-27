package fabrique.pizza;

import principal.MyImage;

public class PizzaFromageBlanc implements Pizza {
    private double prix = 6;
    private String nomIm = "file:img/fond_fromage_blanc.png";
    private String description = "Pizza base fromage blanc";

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