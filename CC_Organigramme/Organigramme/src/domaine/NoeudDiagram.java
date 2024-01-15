package domaine;

public class NoeudDiagram implements Categorisable {
    String categorie;
    Categorisable elem;

    public NoeudDiagram(String categorie, Categorisable elem) {
        this.categorie = categorie;
        this.elem = elem;
    }

    @Override
    public String toString() {
        return elem.toString();
    }

    @Override
    public String getCategorie() {
        return categorie;
    }

    @Override
    public int getNo() {
        return elem.getNo();
    }
}
