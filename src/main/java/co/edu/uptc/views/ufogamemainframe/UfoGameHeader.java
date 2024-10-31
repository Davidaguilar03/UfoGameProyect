package co.edu.uptc.views.ufogamemainframe;

import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.edu.uptc.utilities.RoundedButton;
import co.edu.uptc.views.GlobalView;
import lombok.Getter;

@Getter
public class UfoGameHeader extends JPanel{
    private UfoGameView ufoGameView;
    
    public UfoGameHeader(UfoGameView ufoGameView){
        this.ufoGameView=ufoGameView;
        this.initPanel();
        this.createExitBtn();
        this.createSettingsBtn();
    }

    private void initPanel(){
        this.setBackground(GlobalView.HEADER_MENU_BACKGROUND);
        this.setForeground(GlobalView.HEADER_MENU_FOREGROUND);
        this.setPreferredSize(new Dimension(0,70));
        this.setBorder(BorderFactory.createMatteBorder(0,0,1,0, GlobalView.BORDER_COLOR));
        this.setLayout(null);
    }

    private void createSettingsBtn(){
        RoundedButton settingsBtn = new RoundedButton("<html><div style='text-align: center;'>Menu</html>", 20);
        settingsBtn.setBounds(10, 10, 80, 50);
        settingsBtn.setBackground(GlobalView.BTN_BACKGROUND);
        settingsBtn.setForeground(GlobalView.BTN_FOREGROUND);
        settingsBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
               ufoGameView.getBodyCardLayout().show(ufoGameView.getUfoGameBody(), "Menu");
            }
        });
        this.add(settingsBtn);
    }

    private void createExitBtn(){
        RoundedButton exitBtn = new RoundedButton("<html><div style='text-align: center;'>X</html>", 20);
        exitBtn.setBounds(440, 10, 50, 50);
        exitBtn.setBackground(GlobalView.BTN_BACKGROUND);
        exitBtn.setForeground(GlobalView.BTN_FOREGROUND);
        exitBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });
        this.add(exitBtn);
    }
}
