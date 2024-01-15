package metier.StrategiePCL;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public interface PCLStrategie extends PropertyChangeListener {
    // meme si cette classe n'est pas obligtoire car chaque strategie peut simplement extends PropertyChangeListener
    // je la fait pour que le code soit plus clair
    void propertyChange(PropertyChangeEvent evt);
}
