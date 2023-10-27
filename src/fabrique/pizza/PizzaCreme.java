package fabrique.pizza;

import principal.MyImage;

public class PizzaCreme implements Pizza {
    private double prix = 6;
    private String nomIm = "file:img/fond_creme.png";
    private String description = "Pizza base crème";

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
