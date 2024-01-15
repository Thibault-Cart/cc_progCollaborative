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
                PersonnelCategorisable cadreCategorisable = new PersonnelCategorisable(cadre, champs[5], Integer.parseInt(champs[1]));

                result = cadreCategorisable;
                break;
            case "DEPT":
                Dept dept = new Dept(Integer.parseInt(champs[1]), champs[2], champs[3], champs[4]);
                result = dept;
                break;
            case "EMPL":
                Employe employe = new Employe(Integer.parseInt(champs[1]), champs[2], champs[3], champs[4]);
                PersonnelCategorisable employeCategorisable = new PersonnelCategorisable(employe, champs[5], Integer.parseInt(champs[1]));
                result = employeCategorisable;
                break;
            default:
                System.out.println("Type inconnu");
        }
        return result;
    }
}
