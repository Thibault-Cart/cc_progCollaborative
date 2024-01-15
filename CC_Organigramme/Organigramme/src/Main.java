import metier.GestionOrganigramme;

public class Main {
    public static void main(String[] args) {
        GestionOrganigramme.setFactoryOrganigram(new domaine.factory.FactoryEmployeDept());


        new metier.GestionOrganigramme();
    }
}