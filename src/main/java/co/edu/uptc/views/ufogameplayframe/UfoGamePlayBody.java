package co.edu.uptc.views.ufogameplayframe;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import co.edu.uptc.pojos.Ufo;
import co.edu.uptc.utilities.ImagePanel;
import co.edu.uptc.utilities.PropertiesService;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UfoGamePlayBody extends JPanel {
    private UfoGamePlayView ufoGamePlayView;
    private PropertiesService propertiesService;
    private JPanel playBodyPanel;
    private List<Ufo> ufos;
    private String ufoImage;

    public UfoGamePlayBody(UfoGamePlayView ufoGamePlayView) {
        propertiesService = new PropertiesService();
        this.ufoGamePlayView = ufoGamePlayView;
        this.ufos = ufoGamePlayView.getUfoGameView().getPresenter().getUfos();
        ufoImage = ufoGamePlayView.getUfoGameView().getUfoGameBody().getSelectedUfoImage();
        this.setLayout(null);
        this.initPlayPanel();
    }

    private void initPlayPanel() {
        playBodyPanel = new ImagePanel(propertiesService.getKeyValue("PlayBackground"), 0.85f) {
            @Override

            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon ufoIcon = new ImageIcon(ufoImage);
                Image ufoImage = ufoIcon.getImage();
                for (Ufo ufo : ufos) {
                    g.drawImage(ufoImage, ufo.getPosition().x, ufo.getPosition().y, 75, 54, this);
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
