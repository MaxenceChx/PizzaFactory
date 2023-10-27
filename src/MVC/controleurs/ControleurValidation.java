package MVC.controleurs;

import MVC.modele.ModeleCommande;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class ControleurValidation implements EventHandler<ActionEvent> {
    private ModeleCommande model;
    public ControleurValidation(ModeleCommande mc) {
        this.model = mc;
    }

    public void handle(ActionEvent e) {
        Button b = (Button)e.getSource();
        if (b.getText().equals(" Valider la commande ")) {
            this.model.validerCommande();
            this.model.reinitialiser();
        }
    }
}
