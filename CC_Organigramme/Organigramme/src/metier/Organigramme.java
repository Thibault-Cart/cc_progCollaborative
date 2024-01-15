package metier;

import domaine.Categorisable;
import metier.StrategiePCL.PCLStrategie;
import metier.StrategiePCL.PCLStrategieAffichageConsole;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class Organigramme {
    private Noeud racine;

    // variable static contenant la strategie de l'organigramme, par defaut c'est la strategie PCLStrategieAffichageConsole
    private static PCLStrategie strategieListener = new PCLStrategieAffichageConsole();

    public Organigramme(Categorisable racine) {
        this.racine = new Noeud(racine, null);
    }

    public Organigramme() {
    }

    public static void setStrategieListener(PCLStrategie pclStrategie) {
        strategieListener = pclStrategie;
    }

 
    public void setRacine(Categorisable racine) {
        this.racine = new Noeud(racine, null);
    }


    public void ajouterNoeud(Categorisable fils, Categorisable pere) {

        Noeud p = racine.chercher(new Noeud(pere));
        Noeud enfant = new Noeud(fils, p);
        enfant.addObserver(strategieListener);
        if (p != null) {
            p.addFils(enfant);
        }
    }

    public String getNoeud(int key) {

        Noeud n = racine.chercher(new Noeud(key));
        if (n != null) {
            return n.toString();
        } else {
            return null;
        }
    }

    public static int compteurCategorie = 0;

    public int nombreDeCetteCategorie(String categorie) {
        compteurCategorie = 0;
        racine.compterCategorie(this.racine, categorie);
        return compteurCategorie;
    }

    public void supprimerUnNoeud(int key) {
        Noeud n = racine.chercher(new Noeud(key));
        if (n != null) {
            n.supprimer();
        } else {
            System.out.println("Noeud introuvable");
        }
    }

    private static ArrayList affichageChemin;

    public ArrayList afficherPositionHierarchique(int key) {
        affichageChemin = new ArrayList<>();
        Noeud n = racine.chercher(new Noeud(key));
        if (n != null) {

            n.afficherPositionHierarchique();

            return affichageChemin;

        } else {
            System.out.println("Noeud introuvable");
        }
        return null;
    }


    static class Noeud {
        Categorisable contenu;
        private ArrayList<Noeud> fils;
        private Noeud pere;
        private int cle;

        private PropertyChangeSupport pcs = new PropertyChangeSupport(this);

        public void addObserver(PropertyChangeListener listener) {
            pcs.addPropertyChangeListener("NoeudSansFils", listener);
        }

        public Noeud(Categorisable contenu, Noeud pere) {
            this.contenu = contenu;
            this.fils = new ArrayList<>();
            this.pere = pere;
            this.cle = contenu.getNo();
        }

        public Noeud(Categorisable contenu) {
            this.contenu = contenu;
            this.fils = new ArrayList<>();
            this.cle = contenu.getNo();
        }

        public Noeud(int cle) {
            this.cle = cle;
        }

        public void addFils(Noeud f) {
            fils.add(f);
        }

        public void setPere(Noeud pere) {
            this.pere = pere;
        }


        public Noeud chercher(Noeud x) {
            if (this.equals(x)) return this;
            for (Noeud f : fils) {
                Noeud r = f.chercher(x);
                if (r != null) return r;
            }
            return null;


        }

        public void compterCategorie(Noeud x, String categorie) {
            if (x.contenu.getCategorie().equals(categorie))
                compteurCategorie++;
            for (Noeud f : fils) {
                f.compterCategorie(f, categorie);
            }
        }

        @Override
        public boolean equals(Object obj) {
            return this.cle == ((Noeud) obj).cle;
        }

        @Override
        public String toString() {
            return contenu.toString();
        }

        public void supprimer() {
            //pour chaque fils du noeud a supprimer, on le deplace vers le noeud pere
            for (Noeud f : fils) {
                System.out.println("-->Deplacement de  " + f.contenu);
                f.pere = this.pere;
                f.pere.fils.remove(this);
                f.pere.fils.add(f);
            }
            //supprimer le noeud de la liste des fils du noeud pere
            if (this.pere != null) {
                this.pere.fils.remove(this);
            }
            //si le noeud pere ne possede plus de fils, on declenche l'evenement NoeudSansFils
            if (this.pere.fils.size() == 0) {
                pcs.firePropertyChange("NoeudSansFils", this.pere.contenu, this.pere.pere);
            }
        }

        public void afficherPositionHierarchique() {
            if (pere != null) {
                affichageChemin.add(contenu);
                pere.afficherPositionHierarchique();
            } else {
                affichageChemin.add(contenu);
            }
        }

    }

}