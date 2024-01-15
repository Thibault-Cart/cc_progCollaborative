package metier;

import domaine.Categorisable;

import java.util.ArrayList;

public class Organigramme {
    private Noeud racine;

    public Organigramme(Categorisable racine) {
        this.racine = new Noeud(racine, null);
    }

    public Organigramme() {
    }

    public Noeud getRacine() {
        return racine;
    }

    public void setRacine(Categorisable racine) {
        this.racine = new Noeud(racine, null);
    }


    public void ajouterNoeud(Categorisable fils, Categorisable pere) {

        Noeud p = racine.chercher(new Noeud(pere));
        Noeud enfant = new Noeud(fils, p);
        if (p != null) {
            p.addFils(enfant);
        }
    }

    public String getNoeud(int key) {
        return racine.chercher(new Noeud(key)).toString();
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
        }else {
            System.out.println("Noeud introuvable");
        }
    }


    static class Noeud {
        Categorisable contenu;
        private ArrayList<Noeud> fils;
        private Noeud pere;
        private int cle;

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

        public void parcoursPrefixe() {
            System.out.print(contenu + " ");
            for (Noeud f : fils) {
                f.parcoursPrefixe();
            }
        }

        public void parcoursPostfixe() {
            for (Noeud f : fils) {
                f.parcoursPostfixe();
            }
            System.out.print(contenu + " ");
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
            for (Noeud f : fils) {
                System.out.println("-->Deplacement de  " + f.contenu);
                f.pere = this.pere;
                f.pere.fils.remove(this);
            }
        }


    }

}