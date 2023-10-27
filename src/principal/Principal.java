package principal;

import MVC.modele.ModeleCommande;
import MVC.vues.*;
import MVC.controleurs.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class Principal extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        ModeleCommande mc = new ModeleCommande();

        Observateur vueValidation = new VueValidation();
        mc.enregistrerObservateur(vueValidation);

        String [] ingredients={"Fromage", "Champignons", "Chorizo", "Oeuf", "Oignons", "Olives noires", "Olives vertes", "Roquette", "Retirer ingredient"};
        String[] fidelite = {"Nouveau client", "Client avec carte", "Client adhérent"};
        Button[] bIngr;
        BorderPane bp= new BorderPane();
        bp.setPadding(new Insets(10));


        // Panneau situe au nord de l'IG contenant les 2 boutons
        // permettant le choix de la base des pizzas et le niveau de fidelite du client
        HBox pnord = new HBox(20);
        pnord.setPadding(new Insets(10));
        pnord.setAlignment(Pos.CENTER);

        ComboBox<String> choixFidelite = new ComboBox<String>( );
        for (String s: fidelite ) {
            choixFidelite.getItems().add(s);
        }
        choixFidelite.setValue("Nouveau client");
        choixFidelite.setPrefWidth(200);

        ControleurFidelite cf = new ControleurFidelite(mc);
        choixFidelite.setOnAction(cf);

        ControlDebutCommande cdc = new ControlDebutCommande(mc);

        Button addPizzaCreme = new Button(" Ajouter une pizza base creme ");
        addPizzaCreme.setOnAction(cdc);
        addPizzaCreme.wrapTextProperty().setValue(true);
        addPizzaCreme.setTextAlignment(TextAlignment.CENTER);
        Button addPizzaTomate = new Button(" Ajouter une pizza base tomate ");
        addPizzaTomate.setOnAction(cdc);
        addPizzaTomate.wrapTextProperty().setValue(true);
        addPizzaTomate.setTextAlignment(TextAlignment.CENTER);
        Button addPizzaFromageBlanc = new Button(" Ajouter une pizza base fromage blanc ");
        addPizzaFromageBlanc.setOnAction(cdc);
        addPizzaFromageBlanc.wrapTextProperty().setValue(true);
        addPizzaFromageBlanc.setTextAlignment(TextAlignment.CENTER);
        Button addPizzaPesto = new Button(" Ajouter une pizza base pesto ");
        addPizzaPesto.setOnAction(cdc);
        addPizzaPesto.wrapTextProperty().setValue(true);
        addPizzaPesto.setTextAlignment(TextAlignment.CENTER);
        Button supprPizza= new Button(" Supprimer la derniere pizza ");
        supprPizza.setOnAction(cdc);
        supprPizza.wrapTextProperty().setValue(true);
        supprPizza.setTextAlignment(TextAlignment.CENTER);
        pnord.getChildren().addAll(choixFidelite, addPizzaCreme, addPizzaTomate, addPizzaFromageBlanc, addPizzaPesto, supprPizza);
        bp.setTop(pnord); //place pnord en haut de l'IG


        // Panneau au centre de l'IG contenant la vision du choix des pizzas
        // ainsi que les boutons pour ajouter des ingredients
        BorderPane pcentral= new BorderPane();
        pcentral.setMaxHeight(300);

        //--> Le panneau avec la vision des images des pizzas
        VueCommIm visionComm = new VueCommIm();
        mc.enregistrerObservateur(visionComm);
        pcentral.setCenter(visionComm);
        ControlPizzaCour cpc = new ControlPizzaCour(mc);
        visionComm.setOnMouseClicked(cpc);
        //--> Le panneau contenant les boutons des ingredrients
        GridPane pingr= new GridPane();
        pingr.setAlignment(Pos.CENTER);
        pingr.setHgap(10);
        bIngr= new Button[9];
        ControlIngredient ci = new ControlIngredient(mc);
        for(int i=0;i<ingredients.length;i++){
            bIngr[i]=new Button(ingredients[i]);
            bIngr[i].setMinSize(90,40);
            bIngr[i].setOnAction(ci);
            pingr.add(bIngr[i],i,0);
        }
        // pingr.setPreferredSize(new Dimension(935,50));
        pcentral.setBottom(pingr);
        bp.setCenter(pcentral); //place pcentral au centre de l'IG

        // Panneau au sud de l'IG dans lequel se trouve l'affichage
        // du contenu de la commande et son prix
        BorderPane psud= new BorderPane();
        psud.setMinHeight(300);

        VueCommText commtxt= new VueCommText();
        mc.enregistrerObservateur(commtxt);
        commtxt.setFont(new Font("Times", 14));
        //  commtxt.setPreferredSize(new Dimension(935,200));
        psud.setCenter(commtxt);
        //Mettre un panneau VBox
        VBox vb= new VBox();
        vb.setAlignment(Pos.CENTER);
        VuePrix txtBas = new VuePrix();
        mc.enregistrerObservateur(txtBas);
        txtBas.setFont(new Font("Times", 16));
        txtBas.setTextAlignment(TextAlignment.CENTER);

        Button valider= new Button(" Valider la commande ");
        ControleurValidation cv = new ControleurValidation(mc);
        valider.setOnAction(cv);
        vb.getChildren().addAll(txtBas,valider);
        psud.setBottom(vb);
        bp.setBottom(psud);


        Scene scene = new Scene(bp,935,670);
        stage.setTitle("Commande de pizzas");
        stage.setScene(scene);
        stage.show();
    }
}