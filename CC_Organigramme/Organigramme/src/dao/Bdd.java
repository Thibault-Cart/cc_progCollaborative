package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.Map.entry;

public class Bdd {
    private static final Map<String, String> bdd = Map.ofEntries(entry("D1", "DEPT;1;DG;Direction Générale;AA"), entry("D10", "DEPT;10;ADM;Département Administration et RH;AA"), entry("D11", "DEPT;11;RH;Service du Personnel;AA"), entry("D12", "DEPT;12;CPT;Comptabilité;BB"), entry("D20", "DEPT;20;DTEC;Département Technique;DD"), entry("D21", "DEPT;21;INF;Service informatique;CC"), entry("D22", "DEPT;22;INFRA;Service infrastructure;DD"), entry("D23", "DEPT;23;EXPL;Service exploitation;DD"), entry("D30", "DEPT;30;MKT;Département Marketing;BB"), entry("D40", "DEPT;40;PROD;Département Production;DD"), entry("D211", "DEPT;211;PRJA;Projet A;CC"), entry("D212", "DEPT;212;PRJB;Projet B;CC"), entry("C100", "CADR;100;Yerly;Yves;Directeur Général;AA"), entry("E101", "EMPL;101;Zanini;Zoé;Assistante de direction;BB"), entry("C102", "CADR;102;Albrecht;Alan;DRH;AA"), entry("E103", "EMPL;103;Babst;Béa;Comptable;BB"), entry("E104", "EMPL;104;Carrel;Caro;Assistante comptable;BB"), entry("C105", "CADR;105;Dayer;Dana;Directrice informatique;CC"), entry("E106", "EMPL;106;Egli;Eric;DBA;CC"), entry("E107", "EMPL;107;Favre;Fred;Assistant informatique;CC"), entry("C108", "CADR;108;Gibs;Gian;Responsable réseau;DD"), entry("E109", "EMPL;109;Hinni;Helen;Technicienne;DD"), entry("E110", "EMPL;110;Iselin;Ida;Ingénieure système;DD"), entry("E111", "EMPL;111;Joly;Joe;Stagiaire;DD"), entry("C112", "CADR;112;Kapp;Kev;Responsable communication;BB"), entry("C113", "CADR;113;Loup;Léa;Responsable production;DD"), entry("C120", "CADR;120;Arial;Alba;Responsable projet;DD"), entry("E121", "EMPL;121;Bonvin;Benois;Analyste;CC"), entry("E122", "EMPL;122;Chollet;Carl;DBA;CC"), entry("E123", "EMPL;123;Dubois;Dan;Développeur;CC"), entry("E124", "EMPL;124;Emery;Emily;Développeuse;CC"), entry("E125", "EMPL;125;Favre;Flavie;Développeuse;CC"), entry("E126", "EMPL;126;Giroud;Guy;Testeur;DD"), entry("C127", "CADR;127;Hasler;Hans;Responsable projet;CC"), entry("E128", "EMPL;128;Iseli;Iris;Développeuse;CC"), entry("E129", "EMPL;129;Jaunin;Jane;DBA;CC"), entry("E130", "EMPL;130;Keller;Karl;Développeur;CC"), entry("E131", "EMPL;131;Lachat;Léa;Développeuse;CC"));
    private static final String structure = "D1;D10;D1;D20;D1;D30;D1;D40;D1;C100;D1;E101;C100;D11;D10;D12;D10;D21;D20;D22;D20;D23;D20;D211;D21;D212;D21;C102;D11;E103;D12;E104;D12;C105;D21;E106;D21;E107;C105;C108;D22;E109;D22;E110;D23;E111;D23;C112;D30;C113;D40;C120;D211;E121;C120;E122;D211;E123;C120;E124;C120;E125;C120;E126;C120;C127;D212;E128;C127;E129;D212;E130;C127;E131;C127";

    public static String[] read(String key) {
        return bdd.get(key).split(";");
    }

    public static List<String[]> getToutesLesDonneesDeLEntreprise() {
        List<String[]> lst = new ArrayList<>();
        for (String key : structure.split(";")) {
            lst.add(read(key));
        }
        return lst;
    }
}