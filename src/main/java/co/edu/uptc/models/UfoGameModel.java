package co.edu.uptc.models;
import java.awt.Image;
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
    private Image UfoImage;
    private int spawnRate;

    public UfoGameModel() {
        this.Ufos = new ArrayList<>();
    }

    public void addUfos(int number, int speed) {
        for (int i = 0; i < number; i++) {
            addUfo(speed);
        }
    }

    @Override
    public void addUfo(int speed){
        Ufo newUfo = new Ufo(speed);
        Ufos.add(newUfo);
    }

    public void startGame() {
        UfoRunner ufoRunner = new UfoRunner(this);
        Thread thread = new Thread(ufoRunner);
        thread.start();
    }

    public void setUfoImage(Image UfoImage) {
        this.UfoImage = UfoImage;
    }

    public void setSpawnRate(int spawnRate) {
        this.spawnRate = spawnRate;
    }

    public void moveAll() {
        for (Ufo Ufo : Ufos) {
            Ufo.move();
        }
    }

    public void setPresenter(Presenter presenter) {
        this.presenter=presenter;
    }

    @Override
    public List<Ufo> getUfos() {
        return Ufos;
    }

}
