package MVC.vues;

import MVC.modele.ModeleCommande;
import MVC.modele.Sujet;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import fabrique.pizza.Pizza;
import principal.*;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

public class VueCommIm extends GridPane implements Observateur {
    public VueCommIm() {
        super();
		this.setPadding(new Insets(15));
		this.setHgap(25);
		this.setAlignment(Pos.CENTER_LEFT);
    }

    public void actualiser(Sujet s) {
        ArrayList<Pizza> listePizza = (ArrayList<Pizza>)((ModeleCommande)s).getListePizza();
        int nbPizza = ((ModeleCommande)s).getNbPizza();
        int numPizzaCourante = ((ModeleCommande)s).getNumPizzaCourante();

        this.getChildren().clear();
        for (int i=0; i<nbPizza; i++) {
            MyImage myIm = listePizza.get(i).getPizzaIm();
            this.add(myIm.getSp(), i, 1);
            if (i+1 == numPizzaCourante) {
                Rectangle rect= new Rectangle(200,200, Color.rgb(255,255,255,0.2));
                rect.setStroke(Color.BLACK);
                myIm.getSp().getChildren().add(rect);
            }
        }
    }
}
