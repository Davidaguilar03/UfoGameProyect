package co.edu.uptc.views.ufogamemainframe;
import javax.swing.JPanel;

import lombok.Getter;

@Getter
public class UfoGameBody extends JPanel{
    private UfoGameView ufoGameView;

    public UfoGameBody(UfoGameView ufoGameView){
        this.ufoGameView = ufoGameView;
    }


}
