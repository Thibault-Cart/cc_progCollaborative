package domaine;

public class PersonnelCategorisable implements Categorisable {
    Personnel personnel;
    String categorie;

    int no;
    public PersonnelCategorisable(Personnel personnel, String categorie,int no) {
        this.personnel = personnel;
        this.categorie = categorie;
        this.no=no;
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
        return this.no;
    }

    @Override
    public String toString() {
        return personnel.toString()+" <"+categorie+">";
    }
}
