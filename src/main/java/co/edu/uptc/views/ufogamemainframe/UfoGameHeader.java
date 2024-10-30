package co.edu.uptc.views.ufogamemainframe;

import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

import co.edu.uptc.views.GlobalView;
import lombok.Getter;

@Getter
public class UfoGameHeader extends JPanel{
    private UfoGameView ufoGameView;
    
    public UfoGameHeader(UfoGameView ufoGameView){
        this.ufoGameView = new UfoGameView();
        this.initPanel();
    }

    private void initPanel(){
        this.setBackground(GlobalView.HEADER_MENU_BACKGROUND);
        this.setForeground(GlobalView.HEADER_MENU_FOREGROUND);
        this.setPreferredSize(new Dimension(0,100));
        this.setBorder(BorderFactory.createMatteBorder(0,0,1,0, GlobalView.BORDER_COLOR));
        this.setLayout(null);
    }
}
