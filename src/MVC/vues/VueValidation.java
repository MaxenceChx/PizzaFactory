package MVC.vues;

import MVC.modele.ModeleCommande;
import MVC.modele.Sujet;
import fabrique.pizza.Pizza;

public class VueValidation implements Observateur {
    public VueValidation() {
        super();
    }

    public void actualiser(Sujet s) {
        ModeleCommande mc = (ModeleCommande)s;
        if (mc.getCommandeValidee()) {
            System.out.println("Commande n°" + mc.getNumCommande() + " validée");
            for (int i=1; i<=mc.getNbPizza(); i++) {
                Pizza p = mc.getListePizza().get(i-1);
                System.out.println("• Pizza " + i + " : " + String.format("%.2f",p.cout()) + " euros");
                System.out.println("   " + p.getDescription());
            }
            System.out.println("Prix total de la commande : " + mc.getPrixCommande() + " euros");
        }
    }
}
