package MVC.modele;

import MVC.vues.Observateur;

public interface Sujet {
    public void enregistrerObservateur(Observateur o);
    public void supprimerObservateur(Observateur o);
    public void notifierObservateur();
}
