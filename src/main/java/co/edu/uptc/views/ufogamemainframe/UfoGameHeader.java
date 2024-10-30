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
        this.setPreferredSize(new Dimension(0,100));
        this.setBorder(BorderFactory.createMatteBorder(0,0,1,0, GlobalView.BORDER_COLOR));
        this.setLayout(null);
    }

    private void createSettingsBtn(){
        RoundedButton geograficalAnalysisBtn = new RoundedButton("<html><div style='text-align: center;'>Opciones</html>", 20);
        geograficalAnalysisBtn.setBounds(10, 10, 100, 80);
        geograficalAnalysisBtn.setBackground(GlobalView.BTN_BACKGROUND);
        geograficalAnalysisBtn.setForeground(GlobalView.BTN_TEXT_BACKGROUND);
        geograficalAnalysisBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
               
            }
        });
        this.add(geograficalAnalysisBtn);
    }
    private void createExitBtn(){
        RoundedButton vehicleAnalysisBtn = new RoundedButton("<html><div style='text-align: center;'>Salir</html>", 20);
        vehicleAnalysisBtn.setBounds(200, 10, 100, 80);
        vehicleAnalysisBtn.setBackground(GlobalView.BTN_BACKGROUND);
        vehicleAnalysisBtn.setForeground(GlobalView.BTN_TEXT_BACKGROUND);
        vehicleAnalysisBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                
            }
        });
        this.add(vehicleAnalysisBtn);
    }
}
