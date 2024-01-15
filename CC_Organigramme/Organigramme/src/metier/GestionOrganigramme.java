package metier;

import dao.Bdd;
import domaine.Categorisable;
import domaine.factory.FactoryEmployeDept;
import domaine.factory.FactoryOrganigram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
        System.out.println("Il y en a " + nombreDeCetteCategorie("CC") + " Noeuds de la catégorie <CC>");
        System.out.println("Il y en a " + nombreDeCetteCategorie("AA") + " Noeuds de la catégorie <AA>");
        afficherPositionHierarchique(123);
        supprimerUnNoeud(126);
        supprimerUnNoeud(12);
        supprimerUnNoeud(112);
        afficherPositionHierarchique(104);
    }

    private void remplirOrganigramme() {
        // TODO: cette méthode doit remplir la variable 'organigramme' avec TOUTES les données
        List<String[]> data = Bdd.getToutesLesDonneesDeLEntreprise();
        // Le code ci-dessous est là uniquement pour vous montrer le contenu ! Vous pouvez tout supprimer/remplacer !
        System.out.println("\nSommet de l'organigramme : " + Arrays.toString(data.get(0)));
        Categorisable sommet = factoryOrganigram.createCategorisable(data.get(0));
        //un defini le sommet de l'organigramme
        organigramme.setRacine(sommet);
        //on ajoute les autres noeuds
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

        String noeud = organigramme.getNoeud(key);
        //permets de verifier si le noeud existe
        if (noeud == null) {
            System.out.println("Noeud no " + key + " introuvable");
            return;
        } else {
            System.out.println("\nPosition hiérarchique du Noeud " + organigramme.getNoeud(key));
            //recupere la liste des noeuds composant la hierarchie du noeud key
            ArrayList affichage = organigramme.afficherPositionHierarchique(key);
            int tabulation = 0;
            String charTab = "\t\t ";

            // inverse affichageChemin
            Collections.reverse(affichage);

            //pour on affiche chaque noeud
            for (int i = 0; i < affichage.size(); i++) {
                //on affiche le noeud avec un nombre de tabulation correspondant a sa position dans la hierarchie
                System.out.println(charTab.repeat(tabulation) + "==>" + affichage.get(i));
                //on incremente le nombre de tabulation
                tabulation++;
            }
        }
    }

    private void supprimerUnNoeud(int key) {
        // TODO: cette méthode doit supprimer le poste 'key', et rattacher ses fils éventuels à son père
        System.out.println("\nSuppression du Noeud " + organigramme.getNoeud(key));
        organigramme.supprimerUnNoeud(key);
    }
}