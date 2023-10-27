package MVC.controleurs;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import MVC.modele.ModeleCommande;

public class ControlIngredient implements EventHandler<ActionEvent> {
    private String[] ingredients = {"Fromage", "Champignons", "Chorizo", "Oeuf", "Oignons", "Olives noires", "Olives vertes", "Roquette", "Retirer ingredient"};
    private ModeleCommande model;
    public ControlIngredient(ModeleCommande mc) {
        this.model = mc;
    }

    public void handle(ActionEvent e) {
        Button b = (Button)e.getSource();
        int i = 0;
        while (i < ingredients.length) {
            if (b.getText().equals(ingredients[i])) {
                this.model.choixIngredient(i);
                break;
            }
            else {
                i++;
            }
        }
    }
}
