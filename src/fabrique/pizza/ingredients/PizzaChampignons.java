package fabrique.pizza.ingredients;

import fabrique.pizza.Pizza;

public class PizzaChampignons extends IngredientPizza {
    public PizzaChampignons(Pizza p) {
        super(p, 0.5, "Champignons", "file:img/ing_champignons.png");
    }
}
