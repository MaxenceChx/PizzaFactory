package fabrique.pizza.ingredients;

import fabrique.pizza.Pizza;

public class PizzaRoquette extends IngredientPizza {
    public PizzaRoquette(Pizza p) {
        super(p, 0.45, "Roquette", "file:img/ing_roquette.png");
    }
}
