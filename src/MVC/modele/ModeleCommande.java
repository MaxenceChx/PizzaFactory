package MVC.modele;

import MVC.vues.*;
import fabrique.*;
import fabrique.pizza.*;
import fidelite.*;
import fabrique.pizza.ingredients.*;

import java.util.ArrayList;
import java.util.List;

public class ModeleCommande implements Sujet {
    private int nbPizza;
    private int numPizzaCourante;
    private double prixCommande;
    private List<Pizza> listePizza;
    private StrategyFidelite taux;
    private List<Observateur> observateurs;
    private int numCommande;
    private boolean commandeValidee;

    public ModeleCommande() {
        this.nbPizza = 0;
        this.numPizzaCourante = 0;
        this.prixCommande = 0f;
        this.listePizza = new ArrayList<Pizza>();
        this.taux = new ClientNouveau();
        this.observateurs = new ArrayList<Observateur>();
        this.numCommande = 0;
        this.commandeValidee = false;
    }

    public void ajouterPizza(String s) {
        if (nbPizza < 4) {
            FabriquePizza fp = null;
            switch (s) {
                case "Tomate" -> fp = new FabriquePizzaTomate();
                case "Creme" -> fp = new FabriquePizzaCreme();
                case "FromageBlanc" -> fp = new FabriquePizzaFromageBlanc();
                case "Pesto" -> fp = new FabriquePizzaPesto();
            }
            if (fp != null) {
                this.listePizza.add(fp.fabriquer());
                this.nbPizza++;
            }

            this.notifierObservateur();
        }
    }

    public void calculerPrixCommande() {
        double c = 0;
        for (Pizza p : this.listePizza) {
            c += p.cout();
        }
        this.prixCommande = c;
    }

    public void choixIngredient(int i) {
        if (this.numPizzaCourante != 0) {
            Pizza tmp = this.listePizza.get(this.numPizzaCourante - 1);
            switch (i) {
                case 0 -> {
                    if (!(tmp.getDescription().contains("Fromage"))) {
                        tmp = new PizzaFromage(tmp);
                    }
                }
                case 1 -> {
                    if (!(tmp.getDescription().contains("Champignons"))) {
                        tmp = new PizzaChampignons(tmp);
                    }
                }
                case 2 -> {
                    if (!(tmp.getDescription().contains("Chorizo"))) {
                        tmp = new PizzaChorizo(tmp);
                    }
                }
                case 3 -> {
                    if (!(tmp.getDescription().contains("Oeuf"))) {
                        tmp = new PizzaOeuf(tmp);
                    }
                }
                case 4 -> {
                    if (!(tmp.getDescription().contains("Oignons"))) {
                        tmp = new PizzaOignons(tmp);
                    }
                }
                case 5 -> {
                    if (!(tmp.getDescription().contains("Olives noires"))) {
                        tmp = new PizzaOlivesN(tmp);
                    }
                }
                case 6 -> {
                    if (!(tmp.getDescription().contains("Olives vertes"))) {
                        tmp = new PizzaOlivesV(tmp);
                    }
                }
                case 7 -> {
                    if (!(tmp.getDescription().contains("Roquette"))) {
                        tmp = new PizzaRoquette(tmp);
                    }
                }
                case 8 -> {
                    if (!(tmp instanceof PizzaTomate) && !(tmp instanceof PizzaCreme) && !(tmp instanceof PizzaFromageBlanc)) {
                        tmp = ((IngredientPizza)tmp).getPizza();
                    }
                }
            }
            this.listePizza.set(this.numPizzaCourante - 1, tmp);
            this.notifierObservateur();
        }
    }

    public void supprimerPizza() {
        if (this.nbPizza > 0) {
            this.listePizza.remove(this.nbPizza - 1);
            this.nbPizza--;
            this.notifierObservateur();
        }
    }

    public void validerCommande() {
        this.numCommande++;
        this.commandeValidee = true;
        this.notifierObservateur();
    }

    public void reinitialiser() {
        this.listePizza.clear();
        this.nbPizza = 0;
        this.numPizzaCourante = 0;
        this.prixCommande = 0f;
        this.taux = new ClientNouveau();
        this.commandeValidee = false;
        this.notifierObservateur();
    }

    public int getNbPizza() {
        return this.nbPizza;
    }

    public double getPrixCommande() {
        calculerPrixCommande();
        double prixCommande = this.prixCommande * this.taux.getTaux();
        return (double)Math.round(prixCommande * 100) /100;
    }

    public List<Pizza> getListePizza() {
        return this.listePizza;
    }

    public int getNumPizzaCourante() {
        return this.numPizzaCourante;
    }

    public int getNumCommande() {
        return this.numCommande;
    }

    public boolean getCommandeValidee() {
        return this.commandeValidee;
    }

    public void setNumPizzaCourante(int i) {
        if (i > 0 && i <= this.nbPizza && i != this.numPizzaCourante) {
            this.numPizzaCourante = i;
            this.notifierObservateur();
        }
    }

    public void setFidelite(StrategyFidelite sf) {
        this.taux = sf;
        this.notifierObservateur();
    }

    public void enregistrerObservateur(Observateur o) {
        this.observateurs.add(o);
    }

    public void supprimerObservateur(Observateur o) {
        this.observateurs.remove(o);
    }

    public void notifierObservateur() {
        for (Observateur o : this.observateurs) {
            o.actualiser(this);
        }
    }
}
