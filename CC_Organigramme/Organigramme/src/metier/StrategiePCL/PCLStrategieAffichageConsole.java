package metier.StrategiePCL;

import domaine.Categorisable;

import java.beans.PropertyChangeEvent;

public class PCLStrategieAffichageConsole implements PCLStrategie {
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        Categorisable elementSansFils = (Categorisable) evt.getOldValue();

        System.out.println("le " + elementSansFils + " n'a plus aucun membre");
    }
}
