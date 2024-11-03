package co.edu.uptc.views.ufogamemainframe;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
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
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.HashMap;
import java.util.Map;

import lombok.Getter;

@Getter
public class UfoGameBody extends JPanel {
    private UfoGameView ufoGameView;
    private PropertiesService propertiesService;
    private JPanel menuPanel;
    private JPanel playPanel;
    private JTextField txtSpawnRate;
    private JTextField txtUfosAmount;
    private JTextField txtUfosSpeed;
    private CardLayout cardLayout;
    private Checkbox trayectoryCheckbox;
    private UfoGamePlayView ufoGamePlayView;
    private int numberofUfos;
    private int speed;
    private String selectedUfoImage;
    private Map<JLabel, String> imageLabelMap = new HashMap<>();

    public UfoGameBody(UfoGameView ufoGameView, CardLayout cardLayout) {
        propertiesService = new PropertiesService();
        this.ufoGameView = ufoGameView;
        this.setLayout(cardLayout);
        this.initPlayPanel();
        this.initMenuPanel();
        selectedUfoImage = propertiesService.getKeyValue("UFO1-OFF");
        numberofUfos=3;
        speed=3;
    }

    private void initPlayPanel() {
        playPanel = new ImagePanel(propertiesService.getKeyValue("GameLogo"), 1);
        playPanel.setForeground(GlobalView.BODY_PLAY_FOREGROUND);
        playPanel.setLayout(null);
        this.add(playPanel, "Play");
        this.createPlayBtn();
    }

    private void initMenuPanel() {
        menuPanel = new ImagePanel(propertiesService.getKeyValue("MenuBackGround"), 0.5f);
        menuPanel.setForeground(GlobalView.BODY_MENU_FOREGROUND);
        menuPanel.setLayout(null);
        this.add(menuPanel, "Menu");
        this.createLblSpawnRate();
        this.createTextFileSpawnRate();
        this.createLblUfosAmount();
        this.createTextFileUfosAmount();
        this.createTrayectoryCheckBox();
        this.createBackBtn();
        this.createLblUfosSpeed();
        this.createTextFileUfosSpeed();
        this.createUfoImageSelector();
    }

    private void createPlayBtn() {
        RoundedButton playBtn = new RoundedButton("<html><div style='text-align: center;'>Jugar</html>", 20);
        playBtn.setBounds(200, 400, 100, 50);
        playBtn.setBackground(GlobalView.BTN_BACKGROUND);
        playBtn.setForeground(GlobalView.BTN_FOREGROUND);
        playBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addUfos();
                createUfoGamePlayView();
                SwingUtilities.getWindowAncestor(playPanel).dispose();
            }
        });
        playPanel.add(playBtn);
    }

    public void createUfoGamePlayView() {
        ufoGamePlayView = new UfoGamePlayView(ufoGameView);
        ufoGamePlayView.begin();
    }

    private void createLblSpawnRate() {
        JLabel lblSpawnRate = new JLabel("INGRESE EL RADIO DE APARICION");
        lblSpawnRate.setBounds(100, 15, 500, 25);
        lblSpawnRate.setFont(new Font("Semi_Bold", 1, 17));
        lblSpawnRate.setForeground(GlobalView.BODY_PLAY_BACKGROUND);
        menuPanel.add(lblSpawnRate);
    }

    private void createTextFileSpawnRate() {
        txtSpawnRate = new JTextField("Ingrese el Radio de Aparicion en Milisengundos");
        txtSpawnRate.setBounds(100, 45, 300, 30);
        txtSpawnRate.setForeground(GlobalView.PLACEHOLDER_TEXT_COLOR);
        txtSpawnRate.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txtSpawnRate.getText().equals("Ingrese el Radio de Aparicion en Milisengundos")) {
                    txtSpawnRate.setText("");
                    txtSpawnRate.setForeground(GlobalView.TEXT_COLOR);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (txtSpawnRate.getText().isEmpty()) {
                    txtSpawnRate.setForeground(GlobalView.PLACEHOLDER_TEXT_COLOR);
                    txtSpawnRate.setText("Ingrese el Radio de Aparicion en Milisengundos");
                }
            }
        });
        menuPanel.add(txtSpawnRate);
    }

    private void createLblUfosAmount() {
        JLabel lblUfosAmount = new JLabel("INGRESE LA CANTIDAD DE OVNIS");
        lblUfosAmount.setBounds(100, 85, 500, 25);
        lblUfosAmount.setFont(new Font("Semi_Bold", 1, 17));
        lblUfosAmount.setForeground(GlobalView.BODY_PLAY_BACKGROUND);
        menuPanel.add(lblUfosAmount);
    }

    private void createTextFileUfosAmount() {
        txtUfosAmount = new JTextField("Ingrese la Cantidad de Ovnis");
        txtUfosAmount.setBounds(100, 115, 300, 30);
        txtUfosAmount.setForeground(GlobalView.PLACEHOLDER_TEXT_COLOR);
        txtUfosAmount.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txtUfosAmount.getText().equals("Ingrese la Cantidad de Ovnis")) {
                    txtUfosAmount.setText("");
                    txtUfosAmount.setForeground(GlobalView.TEXT_COLOR);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (txtUfosAmount.getText().isEmpty()) {
                    txtUfosAmount.setForeground(GlobalView.PLACEHOLDER_TEXT_COLOR);
                    txtUfosAmount.setText("Ingrese la Cantidad de Ovnis");
                }
            }
        });
        menuPanel.add(txtUfosAmount);
    }

    private void createLblUfosSpeed() {
        JLabel lblUfosSpeed = new JLabel("INGRESE LA VELOCIDAD DE OVNIS");
        lblUfosSpeed.setBounds(100, 155, 500, 25);
        lblUfosSpeed.setFont(new Font("Semi_Bold", 1, 17));
        lblUfosSpeed.setForeground(GlobalView.BODY_PLAY_BACKGROUND);
        menuPanel.add(lblUfosSpeed);
    }

    private void createTextFileUfosSpeed() {
        txtUfosSpeed = new JTextField("Ingrese la Velocidad de Ovnis");
        txtUfosSpeed.setBounds(100, 185, 300, 30);
        txtUfosSpeed.setForeground(GlobalView.PLACEHOLDER_TEXT_COLOR);
        txtUfosSpeed.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txtUfosSpeed.getText().equals("Ingrese la Velocidad de Ovnis")) {
                    txtUfosSpeed.setText("");
                    txtUfosSpeed.setForeground(GlobalView.TEXT_COLOR);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (txtUfosSpeed.getText().isEmpty()) {
                    txtUfosSpeed.setForeground(GlobalView.PLACEHOLDER_TEXT_COLOR);
                    txtUfosSpeed.setText("Ingrese la Velocidad de Ovnis");
                }
            }
        });
        menuPanel.add(txtUfosSpeed);
    }

    private void createTrayectoryCheckBox() {
        JCheckBox trayectoryCheckbox = new JCheckBox("Mostrar la Trayectoria");
        trayectoryCheckbox.setBackground(GlobalView.BODY_PLAY_BACKGROUND);
        trayectoryCheckbox.setForeground(GlobalView.SECUNDARY_BTN_TEXT_BACKGROUND);
        trayectoryCheckbox.setFont(new Font("Arial", Font.BOLD, 14));
        trayectoryCheckbox.setBorder(BorderFactory.createLineBorder(GlobalView.PLACEHOLDER_TEXT_COLOR, 1));
        trayectoryCheckbox.setBounds(100, 235, 300, 30);
        trayectoryCheckbox.setHorizontalAlignment(SwingConstants.LEFT);
        menuPanel.add(trayectoryCheckbox);
    }

    private void createUfoImageSelector() {
        JPanel ufoImageSelector = new ImagePanel(propertiesService.getKeyValue("PlayBackground"), 0.7f);
        ufoImageSelector.setForeground(GlobalView.BODY_MENU_FOREGROUND);
        ufoImageSelector.setBounds(100, 275, 300, 110);
        cardLayout = new CardLayout();
        ufoImageSelector.setLayout(cardLayout);
        String[] imagePaths = {
            propertiesService.getKeyValue("UFO1-OFF"),
            propertiesService.getKeyValue("UFO2-OFF"),
            propertiesService.getKeyValue("UFO3-OFF"),
        };
        selectedUfoImage = imagePaths[0]; 
        for (String imagePath : imagePaths) {
            ImageIcon imageIcon = new ImageIcon(imagePath);
            Image scaledImage = imageIcon.getImage().getScaledInstance(125, 90, Image.SCALE_SMOOTH);
            JLabel label = new JLabel(new ImageIcon(scaledImage));
            ufoImageSelector.add(label, imagePath);
            imageLabelMap.put(label, imagePath);
        }
        RoundedButton prevButton = new RoundedButton("Anterior",20);
        prevButton.setBackground(GlobalView.BTN_BACKGROUND);
        prevButton.setForeground(GlobalView.BTN_FOREGROUND);
        RoundedButton nextButton = new RoundedButton("Siguiente",20);
        nextButton.setBackground(GlobalView.BTN_BACKGROUND);
        nextButton.setForeground(GlobalView.BTN_FOREGROUND);
        prevButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.previous(ufoImageSelector);
                updateSelectedImage(ufoImageSelector); 
            }
        });
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.next(ufoImageSelector);
                updateSelectedImage(ufoImageSelector); 
            }
        });
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(prevButton);
        buttonPanel.add(nextButton);
        buttonPanel.setBounds(150, 390, 185, 35);
        buttonPanel.setOpaque(false);
        menuPanel.add(buttonPanel);
        menuPanel.add(ufoImageSelector);
    }

    private void updateSelectedImage(JPanel ufoImageSelector) {
        for (Component component : ufoImageSelector.getComponents()) {
            if (component.isVisible()) {
                selectedUfoImage = imageLabelMap.get(component);
                break;
            }
        }
    }
    
    
    private void createBackBtn() {
        RoundedButton backBtn = new RoundedButton("<html><div style='text-align: center;'>Volver</html>", 20);
        backBtn.setBounds(100, 430, 305, 30);
        backBtn.setBackground(GlobalView.BTN_BACKGROUND);
        backBtn.setForeground(GlobalView.BTN_FOREGROUND);
        backBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ufoGameView.getBodyCardLayout().show(ufoGameView.getUfoGameBody(), "Play");
                saveSettings();
            }
        });
        menuPanel.add(backBtn);
    }

    public void saveSettings() {
        numberofUfos = Integer.parseInt(txtUfosAmount.getText());
        speed = Integer.parseInt(txtUfosSpeed.getText());
        addUfos();
    }

    private void addUfos(){
        for (int i = 0; i < numberofUfos; i++) {
            ufoGameView.getPresenter().addUfo(speed);
        }
    }
}
