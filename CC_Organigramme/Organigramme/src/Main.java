import metier.GestionOrganigramme;
import metier.Organigramme;
import metier.StrategiePCL.PCLStrategieAffichageConsole;
public class Main {
    public static void main(String[] args) {
        // au lancement de l'application, choisir la strategie de creation des objets, dans notre cas FactoryEmployeDept
        GestionOrganigramme.setFactoryOrganigram(new domaine.factory.FactoryEmployeDept());

        // au lancement de l'application, choisir la strategie de Listener a utiliser, dans notre cas affichage dans la console
        Organigramme.setStrategieListener(new PCLStrategieAffichageConsole());

        new metier.GestionOrganigramme();
    }
}