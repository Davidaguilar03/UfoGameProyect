package co.edu.uptc.views.ufogameplayframe;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import co.edu.uptc.pojos.Ufo;
import co.edu.uptc.utilities.ImagePanel;
import co.edu.uptc.utilities.PropertiesService;
import co.edu.uptc.views.GlobalView;
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
    private boolean showTrajectory;
    private Ufo selectedUfo;
    private ArrayList<Point> trajectoryPoints = new ArrayList<>();

    public UfoGamePlayBody(UfoGamePlayView ufoGamePlayView) {
        this.propertiesService = new PropertiesService();
        this.ufoGamePlayView = ufoGamePlayView;
        this.ufos = ufoGamePlayView.getUfoGameView().getPresenter().getUfos();
        this.ufoImage = ufoGamePlayView.getUfoGameView().getUfoGameBody().getSelectedUfoImage();
        this.showTrajectory = ufoGamePlayView.getUfoGameView().getUfoGameBody().isShowTrajectory();
        this.setLayout(null);
        this.initPlayPanel();
        
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                selectUfo(e.getPoint());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (selectedUfo != null) {
                    selectedUfo.setTrajectory(new ArrayList<>(trajectoryPoints));
                    trajectoryPoints.clear();
                    selectedUfo = null;
                    repaint();
                }
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (selectedUfo != null) {
                    trajectoryPoints.add(e.getPoint());
                    repaint();
                }
            }
        });
    }

    private void initPlayPanel() {
        playBodyPanel = new ImagePanel(propertiesService.getKeyValue("PlayBackground"), 0.85f) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawUfos(g);
                if (showTrajectory) {
                    drawTrajectory(g); 
                }
            }
        };
        
        playBodyPanel.setBounds(0, 0, 1200, 686);
        playBodyPanel.setLayout(null);
        this.add(playBodyPanel);
    }

    private void drawUfos(Graphics g) {
        ImageIcon ufoIcon = new ImageIcon(ufoImage);
        Image ufoImage = ufoIcon.getImage();
        for (Ufo ufo : ufos) {
            g.drawImage(ufoImage, ufo.getPosition().x, ufo.getPosition().y, 75, 54, this);
        }
    }

    private void drawTrajectory(Graphics g) {
        if (!trajectoryPoints.isEmpty()) {
            Graphics2D g2d = (Graphics2D) g; 
            g2d.setColor(GlobalView.HEADER_MENU_BACKGROUND); 
            g2d.setStroke(new BasicStroke(3)); 
            for (int i = 0; i < trajectoryPoints.size() - 1; i++) {
                Point start = trajectoryPoints.get(i);
                Point end = trajectoryPoints.get(i + 1);
                g2d.drawLine(start.x, start.y, end.x, end.y);
            }
        }
    }
    

    private void selectUfo(Point point) {
        for (Ufo ufo : ufos) {
            if (ufo.getBounds().contains(point)) { 
                selectedUfo = ufo;
                trajectoryPoints.clear();
                break;
            }
        }
    }

    public void updateUFOs() {
        playBodyPanel.repaint();
    }
}
