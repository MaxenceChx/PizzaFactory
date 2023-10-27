package MVC.vues;

import MVC.modele.Sujet;

public interface Observateur {
    public void actualiser(Sujet s);
}
