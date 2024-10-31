package co.edu.uptc.views.ufogamemainframe;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import co.edu.uptc.utilities.ImagePanel;
import co.edu.uptc.utilities.PropertiesService;
import co.edu.uptc.utilities.RoundedButton;
import co.edu.uptc.views.GlobalView;
import co.edu.uptc.views.ufogameplayframe.UfoGamePlayView;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import lombok.Getter;

@Getter
public class UfoGameBody extends JPanel{
    private UfoGameView ufoGameView;
    private PropertiesService propertiesService;
    private JPanel menuPanel;
    private JPanel playPanel;

    public UfoGameBody(UfoGameView ufoGameView,CardLayout cardLayout){
        propertiesService = new PropertiesService();
        this.ufoGameView = ufoGameView;
        this.setLayout(cardLayout);
        this.initPlayPanel();
        this.initMenuPanel();
    }

    private void initPlayPanel(){
    playPanel = new ImagePanel(propertiesService.getKeyValue("GameLogo"),1); 
    playPanel.setForeground(GlobalView.BODY_PLAY_FOREGROUND);
    playPanel.setLayout(null);
    this.add(playPanel, "Play");
    this.createPlayBtn();
    }

    private void initMenuPanel(){
        menuPanel = new ImagePanel(propertiesService.getKeyValue("MenuBackGround"),0.5f);
        menuPanel.setForeground(GlobalView.BODY_MENU_FOREGROUND);
        menuPanel.setLayout(null);
        this.add(menuPanel,"Menu");
    }

    private void createPlayBtn(){
        RoundedButton playBtn = new RoundedButton("<html><div style='text-align: center;'>Play</html>", 20);
        playBtn.setBounds(200, 400, 100, 50);
        playBtn.setBackground(GlobalView.BTN_BACKGROUND);
        playBtn.setForeground(GlobalView.BTN_TEXT_BACKGROUND);
        playBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                createUfoGamePlayView();
                SwingUtilities.getWindowAncestor(playPanel).dispose();
            }
        });
        playPanel.add(playBtn);
    }

    public void createUfoGamePlayView(){
        UfoGamePlayView ufoGamePlayView = new UfoGamePlayView(ufoGameView);
        ufoGamePlayView.begin();
    }

}
