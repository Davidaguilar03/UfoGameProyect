package co.edu.uptc.views.ufogameplayframe;
import java.awt.Graphics;
import javax.swing.JPanel;

import co.edu.uptc.pojos.Ufo;
import co.edu.uptc.utilities.ImagePanel;
import co.edu.uptc.utilities.PropertiesService;
import co.edu.uptc.views.GlobalView;
import java.util.List;
import javax.swing.Timer;

import lombok.Getter;
@Getter
public class UfoGamePlayBody extends JPanel{
    private UfoGamePlayView ufoGamePlayView;
    private PropertiesService propertiesService;
    private JPanel playBodyPanel;
    private List<Ufo> ufos;
    private Timer timer;

    public UfoGamePlayBody(UfoGamePlayView ufoGamePlayView){
        propertiesService= new PropertiesService();
        this.ufoGamePlayView=ufoGamePlayView;
        this.ufos= ufoGamePlayView.getUfoGameView().getPresenter().getUfos();
        this.setLayout(null);
        this.initPlayPanel();
    }

    private void initPlayPanel(){
        playBodyPanel = new ImagePanel(propertiesService.getKeyValue("PlayBackground"), 0.85f) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(GlobalView.HEADER_MENU_BACKGROUND); 
                for (Ufo ufo : ufos) {
                    g.fillOval(ufo.getPosition().x, ufo.getPosition().y, 50, 50); 
                }
            }
        };
        playBodyPanel.setBounds(0, 0, 1200, 686);
        playBodyPanel.setLayout(null);
        this.add(playBodyPanel);
    }

    public void updateUFOs() {
        playBodyPanel.repaint(); 
    }
}


