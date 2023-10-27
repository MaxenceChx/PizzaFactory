package MVC.controleurs;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import MVC.modele.ModeleCommande;

public class ControlPizzaCour implements EventHandler<MouseEvent> {
    private ModeleCommande model;

    public ControlPizzaCour(ModeleCommande mc) {
        this.model = mc;
    }

    public void handle(MouseEvent e) {
        this.model.setNumPizzaCourante(1+(int)e.getX()/225);
    }
}
