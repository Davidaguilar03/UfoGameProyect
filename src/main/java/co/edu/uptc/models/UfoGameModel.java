package co.edu.uptc.models;
import java.util.ArrayList;
import java.util.List;

import co.edu.uptc.interfaces.UfoGameInterface;
import co.edu.uptc.interfaces.UfoGameInterface.Presenter;
import co.edu.uptc.pojos.Ufo;
import lombok.Data;

@Data
public class UfoGameModel implements UfoGameInterface.Model {
    private UfoGameInterface.Presenter presenter;
    private List<Ufo> Ufos;

    public UfoGameModel() {
        this.Ufos = new ArrayList<>();
    }

    @Override
    public void addUfo(int speed){
        Ufo newUfo = new Ufo(speed);
        Ufos.add(newUfo);
    }

    @Override
    public void startGame() {
        UfoRunner ufoRunner = new UfoRunner(this);
        Thread thread = new Thread(ufoRunner);
        thread.start();
    }
    
    @Override
    public List<Ufo> getUfos() {
        return Ufos;
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter=presenter;
    }

    public void moveAll() {
        for (Ufo Ufo : Ufos) {
            Ufo.move();
        }
    }
}
