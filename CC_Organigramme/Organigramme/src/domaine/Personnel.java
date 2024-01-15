package domaine;

// ====================  NE PAS MODIFIER CETTE CLASSE  ====================

import java.util.Objects;

public class Personnel {
    private int no;
    private String nom;
    private String prenom;

    public Personnel(int no, String nom, String prenom) {
        this.no = no;
        this.nom = nom;
        this.prenom = prenom;
    }

    public Personnel(int no) {
        this.no = no;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Personnel personne = (Personnel) object;
        return no == personne.no;
    }

    @Override
    public int hashCode() {
        return Objects.hash(no);
    }

    @Override
    public String toString() { return prenom + " " + nom; }
}