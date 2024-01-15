package domaine;
/*
Description: Classe Wrapper pour les objets de type Personnel, cela permet de les catégoriser et de les numéroter,
car les objets de type Personnel ne sont pas modifiables. et nous aurions besoins dun getNO()
 */
public class PersonnelCategorisable implements Categorisable {
    Personnel personnel;
    String categorie;

    int no;

    public PersonnelCategorisable(Personnel personnel, String categorie, int no) {
        this.personnel = personnel;
        this.categorie = categorie;
        this.no = no;
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
        return personnel.toString() + " <" + categorie + ">";
    }
}
