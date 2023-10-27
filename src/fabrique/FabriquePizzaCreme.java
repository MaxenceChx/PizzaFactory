package fabrique;

import fabrique.pizza.Pizza;
import fabrique.pizza.PizzaCreme;

public class FabriquePizzaCreme extends FabriquePizza {
    public Pizza fabriquer() {
        return new PizzaCreme();
    }
}
