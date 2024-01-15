package metier;

import dao.Bdd;
import domaine.Categorisable;
import domaine.factory.FactoryEmployeDept;
import domaine.factory.FactoryOrganigram;

import java.util.Arrays;
import java.util.List;

public class GestionOrganigramme {

    private Organigramme organigramme=new Organigramme();  // TODO: Cette variable devra contenir TOUTES les données

    //par default on utilise la factory FactoryEmployeDept
    private static FactoryOrganigram factoryOrganigram = new FactoryEmployeDept();

    //mais on peut changer la factory utilisée
    public static void setFactoryOrganigram(FactoryOrganigram factoryOrganigram) {
        GestionOrganigramme.factoryOrganigram = factoryOrganigram;
    }

    public GestionOrganigramme() {      // test des traitements : vous pouvez en ôter/modifier/rajouter
        remplirOrganigramme();
        System.out.println("Il y en a " + nombreDeCetteCategorie("CC") + " de la catégorie <CC>");
        afficherPositionHierarchique("E123");
        supprimerUnNoeud("E126");
        supprimerUnNoeud("D12");
        supprimerUnNoeud("C112");
    }

    private void remplirOrganigramme() {
        // TODO: cette méthode doit remplir la variable 'organigramme' avec TOUTES les données
        List<String[]> data = Bdd.getToutesLesDonneesDeLEntreprise();
        // Le code ci-dessous est là uniquement pour vous montrer le contenu ! Vous pouvez tout supprimer/remplacer !
        System.out.println("Sommet de l'organigramme : " + Arrays.toString(data.get(0)));
        Categorisable sommet = factoryOrganigram.createCategorisable(data.get(0));
        for (int i = 1; i < data.size(); i += 2) {
            Categorisable noeud = factoryOrganigram.createCategorisable(data.get(i ));
            organigramme.ajouterNoeud(noeud);
            System.out.println("Nouveau poste: " + Arrays.toString(data.get(i)) + " est le fils de " + Arrays.toString(data.get(i + 1)));
        }
    }

    private int nombreDeCetteCategorie(String categorie) {
        // TODO: cette méthode doit retourner le nombre de postes de la catégorie spécifiée
        return -1;
    }

    private void afficherPositionHierarchique(String key) {
        // TODO: cette méthode doit afficher tous les supérieurs de 'key'
        String[] x = Bdd.read(key);
        System.out.println("Position hiérarchique de " + Arrays.toString(x) + " :");
    }

    private void supprimerUnNoeud(String key) {
        // TODO: cette méthode doit supprimer le poste 'key', et rattacher ses fils éventuels à son père
    }
}