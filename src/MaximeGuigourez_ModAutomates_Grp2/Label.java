package TD1_Implementation;

import java.util.Objects;

/**
 * Class servant à la liaison des Stats -> Les transitions que l'on vérifie !
 * @author maxim
 */

public class Label  {

    private String name; // Nom de l'action

    public Label(String nom){

        this.name = nom;
    }


    // Getteurs et Setteurs

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // ToString de la class

    @Override
    public String toString() {
        return "Label{" +
                "name='" + name + '\'' +
                '}';
    }

    // Equals de Label

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Label label = (Label) o;
        return Objects.equals(name, label.name);
    }


    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
