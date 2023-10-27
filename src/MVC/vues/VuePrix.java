package MVC.vues;

import javafx.scene.control.Label;
import MVC.modele.ModeleCommande;
import MVC.vues.Observateur;
import MVC.modele.Sujet;

public class VuePrix extends Label implements Observateur {
    public VuePrix() {
        super("Pas de commande en cours");
    }

    public void actualiser(Sujet s) {
        if (((ModeleCommande)s).getNbPizza() == 0) {
            this.setText("Pas de commande en cours");
            return;
        }
        this.setText("Prix total de votre commande : " + ((ModeleCommande)s).getPrixCommande() + " euros");
    }
}
