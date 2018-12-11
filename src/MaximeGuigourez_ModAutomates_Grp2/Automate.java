package TD1_Implementation;

import java.util.LinkedList;

/**
 *  Class permetant la création d'un automate -> Le support
 */

public class Automate {

    private LinkedList<State> theStats;
    private LinkedList<Label> alphabet;
    private State InitState;
    // delta
    private LinkedList finalState;
    private State UndefinedState;


    /**
     * Constructeur de l'automate
     * Listes: Etats , Labels, Etats Finaux, UN état Initial, Un état UndefinedState
     *
     * UndefinedState est renvoyer lorsque le parcours est mauvais
     */

    public Automate() {

        this.theStats = new LinkedList<State>();
        this.alphabet = new LinkedList<Label>();
        this.InitState = null;
        this.finalState = new LinkedList<State>();
        this.UndefinedState = new State(this,"Undefined State",null);
    }

    public Automate(LinkedList<State> theStats, LinkedList<Label> alphabet, State state, LinkedList finalState) {

        this.theStats = theStats;
        this.alphabet = alphabet;
        this.InitState = state;
        this.finalState = finalState;
        this.UndefinedState = new State(this,"Undefined State",null);
    }


    /**
     *  Va ajouter l'état a la LinkedList des Etats
     * @param s ,l'etat a ajouter
     *
     */

    public void addState(State s){
        this.theStats.add(s);
    }

    /**
     * Methode permettant d'ajouter des labels a l'automate
     * @param l , Le label a ajouté
     */

    public void addLabel(Label l){
        this.alphabet.add(l);
    }

    /**
     * Méthode permettant d'ajouter des états finaux à l'automate
     * @param e, l'Etat à ajouter
     */
    public void addFinalState(State e){
        this.finalState.add(e);
    }


    /**
     * Méthode permettant d'ajouter des états initiaux à l'automate
     * @param e , l'état à ajouter
     */
    public void addInitState(State e){

        this.InitState = e;
    }


    /**
     * Fonction servant à retourner l'Etat indefini
     * @return Etat Indefini de l'automate
     */
    public State getUndefinedState() {
        return UndefinedState;
    }

    /**
     * Fonction servant à retourner l'Etat Initial
     * @return Etat initial de l'automate
     */
    public State getInitState(){
        return this.InitState;
    }

    /**
     * Fonction servant à retourner les Etats Finaux
     * @return Liste D'Etat Finaux de l'automate
     */
    public LinkedList getFinalState(){
        return this.finalState;
    }



}
