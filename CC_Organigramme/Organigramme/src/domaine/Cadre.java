package domaine;

// ====================  NE PAS MODIFIER CETTE CLASSE  ====================

public class Cadre extends Personnel {
    private String titre;

    public Cadre(int no, String nom, String prenom, String titre) {
        super(no, nom, prenom);
        this.titre = titre;
    }

    @Override
    public String toString() { return super.toString() + " (" + titre + ")"; }
}