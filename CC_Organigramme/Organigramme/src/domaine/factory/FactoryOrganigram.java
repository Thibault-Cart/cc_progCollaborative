package domaine.factory;

import domaine.Categorisable;

public interface FactoryOrganigram {
    public Categorisable createCategorisable(String... champs);
}
