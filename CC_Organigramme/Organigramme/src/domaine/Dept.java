package domaine;

import java.util.Objects;

public class Dept implements Categorisable {
    private int no;
    private String code;
    private String nom;
    private String categorie;

    public Dept(int no, String code, String nom, String categorie) {
        this.no = no;
        this.code = code;
        this.nom = nom;
        this.categorie = categorie;
    }

    public int getNo() {
        return no;
    }

    public Dept(int no) {
        this.no = no;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Dept dept = (Dept) object;
        return no == dept.no;
    }

    @Override
    public int hashCode() {
        return Objects.hash(no);
    }

    @Override
    public String toString() {
        return "Departement "+no+" (" + code + ") " + nom + " <" + categorie + ">";
    }

    @Override
    public String getCategorie() {
        return categorie;
    }
}