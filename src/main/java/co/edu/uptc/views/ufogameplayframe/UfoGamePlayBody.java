package co.edu.uptc.views.ufogameplayframe;

import java.awt.CardLayout;

import javax.swing.JPanel;

import co.edu.uptc.utilities.ImagePanel;
import co.edu.uptc.utilities.PropertiesService;
import co.edu.uptc.views.GlobalView;
import lombok.Getter;
@Getter
public class UfoGamePlayBody extends JPanel{
    private UfoGamePlayView ufoGamePlayView;
    private PropertiesService propertiesService;
    private JPanel playBodyPanel;

    public UfoGamePlayBody(UfoGamePlayView ufoGamePlayView,CardLayout cardLayout){
        propertiesService= new PropertiesService();
        this.ufoGamePlayView=ufoGamePlayView;
        this.setLayout(cardLayout);
        this.initPlayPanel();
    }

    private void initPlayPanel(){
        playBodyPanel = new ImagePanel(propertiesService.getKeyValue("PlayBackground"),0.85f);
        playBodyPanel.setForeground(GlobalView.BODY_MENU_FOREGROUND);
        playBodyPanel.setLayout(null);
        this.add(playBodyPanel,"PlayBody");
    }
}


