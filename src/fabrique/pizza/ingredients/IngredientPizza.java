package fabrique.pizza.ingredients;

import fabrique.pizza.Pizza;
import principal.MyImage;

public abstract class IngredientPizza implements Pizza {
    protected Pizza pizza;
    protected double prix;
    protected String description;
    protected String nomImage;

    protected IngredientPizza(Pizza p, double px, String d, String n) {
        this.pizza = p;
        this.prix = px;
        this.description = d;
        this.nomImage = n;
    }

    public String getDescription() {
        return pizza.getDescription() + " - " + this.description;
    }

    public double cout() {
        return this.prix + pizza.cout();
    }

    public MyImage getPizzaIm() {
        MyImage i = this.pizza.getPizzaIm();
        i.superposer(this.nomImage);
        return i;
    }

    public Pizza getPizza() {
        return pizza;
    }
}
