package domaine;

public class PersonnelCategorisable implements Categorisable {
    Personnel personnel;
    String categorie;

    public PersonnelCategorisable(Personnel personnel, String categorie) {
        this.personnel = personnel;
        this.categorie = categorie;
    }

    @Override
    public boolean equals(Object obj) {
        return personnel.equals(obj);
    }

    @Override
    public String getCategorie() {
        return categorie;
    }

    @Override
    public int getNo() {
        return personnel.getNo();
    }
}
