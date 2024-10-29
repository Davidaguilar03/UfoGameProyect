package co.edu.uptc.views.ufogamemainframe;


import javax.swing.JFrame;

import co.edu.uptc.interfaces.*;
import co.edu.uptc.interfaces.UfoGameInterface.Presenter;
import lombok.Getter;

@Getter
public class UfoGameView extends JFrame implements UfoGameInterface.View {
    private UfoGameInterface.Presenter presenter;

    public UfoGameView(){
        this.initFrame();
    }

    @Override
    public void begin() {
        this.setVisible(true);
    }

    private void initFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("UfoGame");
        this.setLayout(null);
        this.setSize(500,500);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    

}
