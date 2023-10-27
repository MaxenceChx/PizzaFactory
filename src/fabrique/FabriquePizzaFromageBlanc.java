package fabrique;


import fabrique.pizza.Pizza;
import fabrique.pizza.PizzaFromageBlanc;

public class FabriquePizzaFromageBlanc extends FabriquePizza {
    public Pizza fabriquer() {
        return new PizzaFromageBlanc();
    }
}
