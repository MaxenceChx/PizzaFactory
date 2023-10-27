package fabrique;

import fabrique.pizza.Pizza;
import fabrique.pizza.PizzaPesto;

public class FabriquePizzaPesto extends FabriquePizza {
    public Pizza fabriquer() {
        return new PizzaPesto();
    }
}
