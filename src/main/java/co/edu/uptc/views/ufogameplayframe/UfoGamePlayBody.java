package co.edu.uptc.views.ufogameplayframe;
import java.awt.Graphics;
import javax.swing.JPanel;

import co.edu.uptc.pojos.Ufo;
import co.edu.uptc.utilities.ImagePanel;
import co.edu.uptc.utilities.PropertiesService;
import co.edu.uptc.views.GlobalView;

import java.util.ArrayList;
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
        this.ufos= new ArrayList<>();
        this.setLayout(null);
        this.initPlayPanel();
        timer = new Timer(50, e -> updateUFOs());
        timer.start();
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

    public void addUFO(Ufo ufo) {
        ufos.add(ufo);
        playBodyPanel.repaint();
    }

    private void updateUFOs() {
        for (Ufo ufo : ufos) {
            ufo.move();
        }
        playBodyPanel.repaint(); 
    }

    public void removeUFO(int index) {
        if (index >= 0 && index < ufos.size()) {
            ufos.remove(index);
            playBodyPanel.repaint();
        }
    }
}


