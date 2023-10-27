package MVC.vues;

import javafx.scene.control.Label;
import fabrique.pizza.Pizza;
import MVC.modele.ModeleCommande;
import MVC.modele.Sujet;

import java.util.ArrayList;

public class VueCommText extends Label implements Observateur {
    public VueCommText() {
        super("Aucune commande en cours");
    }

    public void actualiser(Sujet s) {
        if (((ModeleCommande)s).getNbPizza() == 0) {
            this.setText("Aucune commande en cours");
            return;
        }
        StringBuffer sb = new StringBuffer("Votre Commande :\n");
        ArrayList<Pizza> listePizza = (ArrayList<Pizza>)((ModeleCommande)s).getListePizza();
        for (int i=1; i<=((ModeleCommande)s).getNbPizza(); i++) {
            Pizza p = listePizza.get(i-1);
            sb.append("• Pizza ").append(i).append(" : ").append(String.format("%.2f",p.cout())).append(" euros\n");
            sb.append("   ").append(p.getDescription()).append("\n");
        }
        this.setText(sb.toString());
    }
}
