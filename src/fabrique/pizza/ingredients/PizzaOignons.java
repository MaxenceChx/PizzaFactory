package fabrique.pizza.ingredients;

import fabrique.pizza.Pizza;

public class PizzaOignons extends IngredientPizza {
    public PizzaOignons(Pizza p) {
        super(p, 0.4, "Oignons", "file:img/ing_oignons.png");
    }
}
