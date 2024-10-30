package co.edu.uptc.views.ufogamemainframe;
import javax.swing.JPanel;

import co.edu.uptc.utilities.RoundedButton;
import co.edu.uptc.views.GlobalView;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import lombok.Getter;

@Getter
public class UfoGameBody extends JPanel{
    private UfoGameView ufoGameView;
    private JPanel menuPanel;
    private JPanel playPanel;

    public UfoGameBody(UfoGameView ufoGameView,CardLayout cardLayout){
        this.ufoGameView = ufoGameView;
        this.setLayout(cardLayout);
        this.initPlayPanel();
        this.initMenuPanel();
    }

    private void initPlayPanel(){
        playPanel = new JPanel();
        playPanel.setBackground(GlobalView.BODY_PLAY_BACKGROUND);
        playPanel.setForeground(GlobalView.BODY_PLAY_FOREGROUND);
        playPanel.setLayout(null);
        this.add(playPanel,"Play");
        this.createPlayBtn();
    }

    private void initMenuPanel(){
        menuPanel = new JPanel();
        menuPanel.setBackground(GlobalView.BODY_MENU_BACKGROUND);
        menuPanel.setForeground(GlobalView.BODY_MENU_FOREGROUND);
        menuPanel.setLayout(null);
        this.add(menuPanel,"Menu");
    }

    private void createPlayBtn(){
        RoundedButton playBtn = new RoundedButton("<html><div style='text-align: center;'>Play</html>", 20);
        playBtn.setBounds(200, 200, 100, 50);
        playBtn.setBackground(GlobalView.BTN_BACKGROUND);
        playBtn.setForeground(GlobalView.BTN_TEXT_BACKGROUND);
        playBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){

            }
        });
        playPanel.add(playBtn);
    }

}
