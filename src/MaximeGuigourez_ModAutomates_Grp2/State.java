package TD1_Implementation;

import java.util.HashMap;
import java.util.Objects;

/**
 * Class permettant la création d'Etat
 */

public class State {

    private Automate auto;
    private String name;
    private HashMap<Label,State> outTransitions;


    /**
     *
     * @param aut Nous avons un automate en paramètre afin d'obtenir son état indéfini en cas d'erreur
     *            Coût élevé de l'opération pour avoir l'automate pour chaque Etat mais peu impactanr dans notre cas
     *            Point d'Améliorations Futur de l'organisation du programme.
     *
     * @param nom Le nom de l'automate
     * @param out Les transitions vers les autres états
     */
    public State(Automate aut,String nom,HashMap<Label,State> out){

        this.auto = aut;
        this.name = nom;
        this.outTransitions = out;
    }

    /**
     * @param: Label
     * Fonction qui retourne le prochain état de l'automate
     */

    public State nextState(Label n){
        if(this.outTransitions.containsKey(n)){
            return this.outTransitions.get(n);
        }
        else{
            return this.auto.getUndefinedState();
        }
}

    /**
     * Fonction qui permet d'ajouter une transition
     * @param t Label utilisé
     * @param out Etat suivant
     */
    public void addTransition(Label t, State out){

        this.outTransitions.put(t,out);
    }

    /**
     * Fonction equals d'Etats afin de savoir si l'Etat en question est égal à l'objet en parametre
     * @param o L'objet testé par rapport a cet Etat
     * @return Bool Vrai ou Faux
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        State state = (State) o;
        return Objects.equals(name, state.name) &&
                Objects.equals(outTransitions, state.outTransitions);
    }


}
