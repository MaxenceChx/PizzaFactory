package MVC.controleurs;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import MVC.modele.ModeleCommande;

public class ControlDebutCommande implements EventHandler<ActionEvent> {
    private ModeleCommande model;

    public ControlDebutCommande(ModeleCommande mc) {
        this.model = mc;
    }

    public void handle(ActionEvent e) {
        Button b = (Button)e.getSource();
        if (b.getText().equals(" Ajouter une pizza base creme ")) {
            model.ajouterPizza("Creme");
        }
        if (b.getText().equals(" Ajouter une pizza base tomate ")) {
            model.ajouterPizza("Tomate");
        }
        if (b.getText().equals(" Ajouter une pizza base fromage blanc ")) {
            model.ajouterPizza("FromageBlanc");
        }
        if (b.getText().equals(" Ajouter une pizza base pesto ")) {
            model.ajouterPizza("Pesto");
        }
        if (b.getText().equals(" Supprimer la derniere pizza ")) {
            model.supprimerPizza();
        }
    }
}
