package co.edu.uptc.views.ufogamemainframe;
import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import co.edu.uptc.utilities.ImagePanel;
import co.edu.uptc.utilities.PropertiesService;
import co.edu.uptc.utilities.RoundedButton;
import co.edu.uptc.views.GlobalView;
import co.edu.uptc.views.ufogameplayframe.UfoGamePlayView;

import java.awt.CardLayout;
import java.awt.Checkbox;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import lombok.Getter;

@Getter
public class UfoGameBody extends JPanel{
    private UfoGameView ufoGameView;
    private PropertiesService propertiesService;
    private JPanel menuPanel;
    private JPanel playPanel;
    private JTextField txtSpawnRate;
    private JTextField txtUfosAmount;
    private Checkbox trayectoryCheckbox;
    

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
        this.createLblSpawnRate();
        this.createTextFileSpawnRate();
        this.createLblUfosAmount();
        this.createTextFileUfosAmount();
        this.createTrayectoryCheckBox();
        this.createBackBtn();
    }

    private void createPlayBtn(){
        RoundedButton playBtn = new RoundedButton("<html><div style='text-align: center;'>Play</html>", 20);
        playBtn.setBounds(200, 400, 100, 50);
        playBtn.setBackground(GlobalView.BTN_BACKGROUND);
        playBtn.setForeground(GlobalView.BTN_FOREGROUND);
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

    private void createLblSpawnRate(){
        JLabel lblSpawnRate = new JLabel("INGRESE EL RADIO DE APARICION EN MILISEGUNDOS");
        lblSpawnRate.setBounds(30, 20, 500, 25);
        lblSpawnRate.setFont(new Font("Semi_Bold", 1, 17));
        lblSpawnRate.setForeground(GlobalView.BODY_PLAY_BACKGROUND);
        menuPanel.add(lblSpawnRate);
    }

    private void createTextFileSpawnRate() {
        txtSpawnRate = new JTextField("Ingrese el radio de aparicion en milisengundos");
        txtSpawnRate.setBounds(100, 50, 300, 30);
        txtSpawnRate.setForeground(GlobalView.PLACEHOLDER_TEXT_COLOR);
        txtSpawnRate.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txtSpawnRate.getText().equals("Ingrese el radio de aparicion en milisengundos")) {
                    txtSpawnRate.setText("");
                    txtSpawnRate.setForeground(GlobalView.TEXT_COLOR);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (txtSpawnRate.getText().isEmpty()) {
                    txtSpawnRate.setForeground(GlobalView.PLACEHOLDER_TEXT_COLOR);
                    txtSpawnRate.setText("Ingrese el radio de aparicion en milisengundos");
                }
            }
        });
        menuPanel.add(txtSpawnRate);
    }

    private void createLblUfosAmount(){
        JLabel lblUfosAmount = new JLabel("INGRESE LA CANTIDAD DE OVNIS");
        lblUfosAmount.setBounds(100, 100, 500, 25);
        lblUfosAmount.setFont(new Font("Semi_Bold", 1, 17));
        lblUfosAmount.setForeground(GlobalView.BODY_PLAY_BACKGROUND);
        menuPanel.add(lblUfosAmount);
    }

    private void createTextFileUfosAmount() {
        txtUfosAmount = new JTextField("Ingrese la cantidad de ovnis");
        txtUfosAmount.setBounds(100, 130, 300, 30);
        txtUfosAmount.setForeground(GlobalView.PLACEHOLDER_TEXT_COLOR);
        txtUfosAmount.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txtUfosAmount.getText().equals("Ingrese la cantidad de ovnis")) {
                    txtUfosAmount.setText("");
                    txtUfosAmount.setForeground(GlobalView.TEXT_COLOR);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (txtUfosAmount.getText().isEmpty()) {
                    txtUfosAmount.setForeground(GlobalView.PLACEHOLDER_TEXT_COLOR);
                    txtUfosAmount.setText("Ingrese la cantidad de ovnis");
                }
            }
        });
        menuPanel.add(txtUfosAmount);
    }

    private void createTrayectoryCheckBox() {
    JCheckBox trayectoryCheckbox = new JCheckBox("Mostrar la Trayectoria");
    trayectoryCheckbox.setBackground(GlobalView.BODY_PLAY_BACKGROUND);
    trayectoryCheckbox.setForeground(GlobalView.SECUNDARY_BTN_TEXT_BACKGROUND);
    trayectoryCheckbox.setFont(new Font("Arial", Font.BOLD, 14));
    trayectoryCheckbox.setBorder(BorderFactory.createLineBorder(GlobalView.PLACEHOLDER_TEXT_COLOR, 1));
    trayectoryCheckbox.setBounds(100, 180, 300, 30);
    trayectoryCheckbox.setHorizontalAlignment(SwingConstants.LEFT);
    menuPanel.add(trayectoryCheckbox);
    }

    private void createBackBtn(){
        RoundedButton backBtn = new RoundedButton("<html><div style='text-align: center;'>Volver</html>", 20);
        backBtn.setBounds(100, 420, 300, 30);
        backBtn.setBackground(GlobalView.BTN_BACKGROUND);
        backBtn.setForeground(GlobalView.BTN_FOREGROUND);
        backBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                ufoGameView.getBodyCardLayout().show(ufoGameView.getUfoGameBody(), "Play");
            }
        });
        menuPanel.add(backBtn);
    }
}
