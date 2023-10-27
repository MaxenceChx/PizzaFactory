package fabrique.pizza.ingredients;

import fabrique.pizza.Pizza;

public class PizzaFromage extends IngredientPizza {
    public PizzaFromage(Pizza p) {
        super(p, 0.75, "Fromage", "file:img/ing_fromage.png");
    }
}
