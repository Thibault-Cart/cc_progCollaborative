package domaine;

// ====================  NE PAS MODIFIER CETTE CLASSE  ====================

public class Employe extends Personnel {
    private String statut;

    public Employe(int no, String nom, String prenom, String statut) {
        super(no, nom, prenom);
        this.statut = statut;
    }

    @Override
    public String toString() { return super.toString() + " (" + statut + ")"; }
}