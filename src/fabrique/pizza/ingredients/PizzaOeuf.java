package fabrique.pizza.ingredients;

import fabrique.pizza.Pizza;

public class PizzaOeuf extends IngredientPizza {
    public PizzaOeuf(Pizza p) {
        super(p, 0.7, "Oeuf", "file:img/ing_oeuf.png");
    }
}
