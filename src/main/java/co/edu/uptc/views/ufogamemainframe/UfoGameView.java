package co.edu.uptc.views.ufogamemainframe;


import javax.swing.JFrame;

import co.edu.uptc.interfaces.*;
import co.edu.uptc.interfaces.UfoGameInterface.Presenter;
import java.awt.CardLayout;
import java.awt.LayoutManager;
import java.awt.BorderLayout;

import lombok.Getter;

@Getter
public class UfoGameView extends JFrame implements UfoGameInterface.View {
    private UfoGameInterface.Presenter presenter;
    private UfoGameHeader ufoGameHeader;
    private UfoGameBody ufoGameBody;
    private CardLayout bodyCardLayout; 

    public UfoGameView(){
        this.initFrame();
        this.createUfoGameHeader();
        this.createUfoGameBody();
    }

    @Override
    public void begin() {
        this.setVisible(true);
    }

    private void initFrame(){
        this.setUndecorated(true);
        this.setLayout((LayoutManager) new BorderLayout());
        this.setSize(500,500);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }

    private void createUfoGameHeader(){
        ufoGameHeader = new UfoGameHeader(this);
        this.add(ufoGameHeader,BorderLayout.NORTH);
    }

    private void createUfoGameBody(){
        ufoGameBody = new UfoGameBody(this);
        this.add(ufoGameBody);
    }


    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    

}
