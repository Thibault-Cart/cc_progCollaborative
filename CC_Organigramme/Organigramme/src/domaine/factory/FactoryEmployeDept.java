package domaine.factory;

import domaine.*;


public class FactoryEmployeDept implements FactoryOrganigram {
    @Override
    public Categorisable createCategorisable(String... champs) {
        Categorisable result = null;

        String type = champs[0];

        switch (type) {
            case "CADR":
                Cadre cadre = new Cadre(Integer.parseInt(champs[1]), champs[2], champs[3], champs[4]);
                PersonnelCategorisable personnelCategorisable = new PersonnelCategorisable(cadre, champs[5]);
                Categorisable categorisable = new NoeudDiagram(champs[5], personnelCategorisable);
                result = categorisable;
                break;
            case "DEPT":
                Dept dept = new Dept(Integer.parseInt(champs[1]), champs[2], champs[3], champs[4]);
                Categorisable categorisable2 = new NoeudDiagram(champs[4], dept);
                result = categorisable2;


                break;
            case "EMPL":
                Employe employe = new Employe(Integer.parseInt(champs[1]), champs[2], champs[3], champs[4]);
                PersonnelCategorisable personnelCategorisable2 = new PersonnelCategorisable(employe, champs[5]);
                Categorisable categorisable3 = new NoeudDiagram(champs[5], personnelCategorisable2);
                result = categorisable3;
                break;
            default:
                System.out.println("Type inconnu");
        }

        return result;
    }
}
