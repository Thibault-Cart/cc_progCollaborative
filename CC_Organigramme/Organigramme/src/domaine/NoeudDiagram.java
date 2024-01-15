package domaine;

public class NoeudDiagram implements Categorisable {
    String categorie;
    Categorisable elem;

    public NoeudDiagram(String categorie, Categorisable elem) {
        this.categorie = categorie;
        this.elem = elem;
    }


    @Override
    public String getCategorie() {
        return null;
    }

    @Override
    public int getNo() {
        return elem.getNo();
    }
}
