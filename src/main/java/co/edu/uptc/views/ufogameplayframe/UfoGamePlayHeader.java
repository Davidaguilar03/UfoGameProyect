package co.edu.uptc.views.ufogameplayframe;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import co.edu.uptc.utilities.RoundedButton;
import co.edu.uptc.views.GlobalView;
import lombok.Getter;

@Getter
public class UfoGamePlayHeader extends JPanel{
    private UfoGamePlayView ufoGamePlayView;
    
    public UfoGamePlayHeader(UfoGamePlayView ufoGamePlayView){
        this.ufoGamePlayView=ufoGamePlayView;
        this.initPanel();
        this.createSettingsBtn();
        this.createExitBtn();
    }

    private void initPanel(){
        this.setBackground(GlobalView.BODY_PLAY_BACKGROUND);
        this.setForeground(GlobalView.BODY_PLAY_FOREGROUND);
        this.setPreferredSize(new Dimension(0,70));
        this.setBorder(BorderFactory.createMatteBorder(0,0,1,0, GlobalView.BORDER_COLOR));
        this.setLayout(null);
    }

    private void createSettingsBtn(){
        RoundedButton settingsBtn = new RoundedButton("<html><div style='text-align: center;'>Menu</html>", 20);
        settingsBtn.setBounds(10, 10, 80, 50);
        settingsBtn.setBackground(GlobalView.BTN_BACKGROUND);
        settingsBtn.setForeground(GlobalView.BTN_TEXT_BACKGROUND);
        settingsBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
               
            }
        });
        this.add(settingsBtn);
    }

    private void createExitBtn(){
        RoundedButton exitBtn = new RoundedButton("<html><div style='text-align: center;'>X</html>", 20);
        exitBtn.setBounds(940, 10, 50, 50);
        exitBtn.setBackground(GlobalView.BTN_BACKGROUND);
        exitBtn.setForeground(GlobalView.BTN_TEXT_BACKGROUND);
        exitBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });
        this.add(exitBtn);
    }

}
