package metier;

import dao.Bdd;
import domaine.Categorisable;
import domaine.factory.FactoryEmployeDept;
import domaine.factory.FactoryOrganigram;

import java.util.Arrays;
import java.util.List;

public class GestionOrganigramme {

    private Organigramme organigramme = new Organigramme();  // TODO: Cette variable devra contenir TOUTES les données

    //par default on utilise la factory FactoryEmployeDept
    private static FactoryOrganigram factoryOrganigram = new FactoryEmployeDept();

    //mais on peut changer la factory utilisée
    public static void setFactoryOrganigram(FactoryOrganigram factoryOrganigram) {
        GestionOrganigramme.factoryOrganigram = factoryOrganigram;
    }

    public GestionOrganigramme() {      // test des traitements : vous pouvez en ôter/modifier/rajouter
        remplirOrganigramme();
        System.out.println("Il y en a " + nombreDeCetteCategorie("CC") + " de la catégorie <CC>");
        afficherPositionHierarchique(123);
        supprimerUnNoeud(126);
        supprimerUnNoeud(12);
        supprimerUnNoeud(112);
    }

    private void remplirOrganigramme() {
        // TODO: cette méthode doit remplir la variable 'organigramme' avec TOUTES les données
        List<String[]> data = Bdd.getToutesLesDonneesDeLEntreprise();
        // Le code ci-dessous est là uniquement pour vous montrer le contenu ! Vous pouvez tout supprimer/remplacer !
        System.out.println("Sommet de l'organigramme : " + Arrays.toString(data.get(0)));
        Categorisable sommet = factoryOrganigram.createCategorisable(data.get(0));
        organigramme.setRacine(sommet);
        for (int i = 1; i < data.size(); i += 2) {
            Categorisable fils = factoryOrganigram.createCategorisable(data.get(i));
            Categorisable pere = factoryOrganigram.createCategorisable(data.get(i + 1));
            organigramme.ajouterNoeud(fils, pere);
        }
    }

    private int nombreDeCetteCategorie(String categorie) {
        // TODO: cette méthode doit retourner le nombre de postes de la catégorie spécifiée
        return organigramme.nombreDeCetteCategorie(categorie);
    }

    private void afficherPositionHierarchique(int key) {

        System.out.println("\nPosition hiérarchique du Noeud " + organigramme.getNoeud(key));
        organigramme.afficherPositionHierarchique(key);
    }

    private void supprimerUnNoeud(int key) {
        // TODO: cette méthode doit supprimer le poste 'key', et rattacher ses fils éventuels à son père
        System.out.println("Suppression du Noeud " + organigramme.getNoeud(key));
        organigramme.supprimerUnNoeud(key);
    }
}