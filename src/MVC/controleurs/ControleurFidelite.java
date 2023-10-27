package MVC.controleurs;

import fidelite.ClientAbonnement;
import fidelite.ClientCarte;
import fidelite.ClientNouveau;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import MVC.modele.ModeleCommande;

public class ControleurFidelite implements EventHandler<ActionEvent> {
    private ModeleCommande model;

    public ControleurFidelite(ModeleCommande mc) {
        this.model = mc;
    }

    public void handle(ActionEvent e) {
        ComboBox<String> cb = (ComboBox<String>)e.getSource();
        switch (cb.getValue()) {
            case "Nouveau client":
                this.model.setFidelite(new ClientNouveau());
                break;
            case "Client adhérent":
                this.model.setFidelite(new ClientAbonnement());
                break;
            case "Client avec carte":
                this.model.setFidelite(new ClientCarte());
                break;
        }
    }
}
