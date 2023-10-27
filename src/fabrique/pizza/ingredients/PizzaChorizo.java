package fabrique.pizza.ingredients;

import fabrique.pizza.Pizza;

public class PizzaChorizo extends IngredientPizza {
    public PizzaChorizo(Pizza p) {
        super(p, 0.5, "Chorizo", "file:img/ing_chorizo.png");
    }
}
