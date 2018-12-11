package TD1_Implementation;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class main {

    /**
     * Fonction de Création de l'automate sans un fichier csv (Fonctionnelle)     *
     * @return Automate auto
     */

    public static Automate crea_automate(){

        //Automate principal
        Automate auto = new Automate();


          // Creation des Labels
            Label lab1 = new Label(":");
            Label lab2 = new Label(";");
            Label lab3 = new Label("-");
            Label lab4 = new Label(")");
            Label lab5 = new Label("(");
            Label lab6 = new Label("=");

            //Creation des Etats

            State E0 = new State(auto,"E0",new HashMap<Label, State>());
            State E1 = new State(auto,"E1",new HashMap<Label, State>());
            State E2 = new State(auto,"E2",new HashMap<Label, State>());
            State E3 = new State(auto,"E3",new HashMap<Label, State>());
            State E4 = new State(auto,"E4",new HashMap<Label, State>());


            //Création des Transitions

            E0.addTransition(lab1,E1);
            E0.addTransition(lab2,E2);
            E1.addTransition(lab3,E3);
            E1.addTransition(lab6,E3);
            E2.addTransition(lab3,E3);
            E3.addTransition(lab5,E4);
            E3.addTransition(lab4,E4);

            auto.addState(E0);
            auto.addState(E1);
            auto.addState(E2);
            auto.addState(E3);
            auto.addState(E4);

            auto.addInitState(E0);
            auto.addFinalState(E4);


    return auto;
    }


    /**
     * Fonction de Création de l'automate avec un fichier csv (Non Fonctionnelle pour le moment)
     * Note ! Toujours etat initial en premier dans le fichier et etat final en dernier ( 1 de chaque pour le moment)
     * En cours de développement
     *
     * @return Automate auto2
     *
     */


   public static Automate fichier(){

        Automate auto2 = new Automate();
        String fileName = "automatsmiley.csv";

        Scanner sc = new Scanner(fileName);

       LinkedList<State> liste_etats = new LinkedList<State>();
       LinkedList<Label> liste_label = new LinkedList<Label>();

        while(sc.hasNextLine()){

            sc.useDelimiter(" ");


            String n = sc.next();

            State etat1 = new State(auto2, n, new HashMap<Label, State>());
            System.out.println(n);

            if (!liste_etats.contains(etat1)){
                liste_etats.add(etat1);
            }
            /* --------------------------------------------------------*/

            String l = sc.next();
            Label lab = new Label(l);
            System.out.println(l);

            if(!liste_label.contains(lab)){
                liste_label.add(lab);
            }


            /* --------------------------------------------------------*/

            String der = sc.next();
            State etat2 = new State(auto2, der, new HashMap<Label, State>());
            System.out.println(der);

            if(!liste_etats.contains(etat2)){
                liste_etats.add(etat2);
            }

            etat1.addTransition(lab,etat2);
        }

        for (int i = 0; i <= liste_etats.size();i++){

            auto2.addState(liste_etats.get(i));
        }


       auto2.addInitState(liste_etats.getFirst());
       auto2.addFinalState(liste_etats.getLast());

        return auto2;

    }

    /**
     * Main de l'automate sans fichier -> fontionne
     */

    public void main_auto(){
        Automate principal = crea_automate();


        String smiley = ":-)";
        State currentState = principal.getInitState();
        State  finalState = (State) principal.getFinalState().getFirst();

        int i = 0;

        while ((currentState != finalState) && (currentState != principal.getUndefinedState())) {

            try {
                char e = smiley.charAt(i);
                currentState = currentState.nextState(new Label("" + e));
                i++;
            }catch (StringIndexOutOfBoundsException s){
                System.out.println("Undefined State, Le smiley n'a pas la taille requis");
                break;
            }
        }
        if(currentState == principal.getUndefinedState()){
            System.out.println("Undefined State, L'un des caractères n'est pas correct !");
        }

        if(principal.getFinalState().contains(currentState)){

            System.out.println("Smiley Reconnu !");
        }

    }


    /**
     * Fonction main qui appelera soit l'automate sans lecture d'un fichier ou avec
     * @param args
     */

    public static void main(String[] args){


        Automate principal = crea_automate();

        Scanner sc = new Scanner(System.in);
        System.out.println("Entrez un smiley dans l'automate : ");
         String smiley = sc.nextLine();

        State currentState = principal.getInitState();
        State  finalState = (State) principal.getFinalState().getFirst();

        int i = 0;

        while ((currentState != finalState) && (currentState != principal.getUndefinedState())) {

            try {
                char e = smiley.charAt(i);
                currentState = currentState.nextState(new Label("" + e));
                i++;
            }catch (StringIndexOutOfBoundsException s){
                System.out.println("Undefined State, Le smiley n'a pas la taille requis");
                break;
            }
        }
        if(currentState == principal.getUndefinedState()){
            System.out.println("Undefined State, Le Smiley n'est pas reconnu ! L'un des caractères n'est pas correct !");
        }

        if(principal.getFinalState().contains(currentState)){

            System.out.println("Smiley Reconnu !");
        }



    }
}
