package fabrique;

import fabrique.pizza.Pizza;
import fabrique.pizza.PizzaTomate;

public class FabriquePizzaTomate extends FabriquePizza {
    public Pizza fabriquer() {
        return new PizzaTomate();
    }
}
