package co.edu.uptc.models;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import co.edu.uptc.interfaces.UfoGameInterface;
import co.edu.uptc.interfaces.UfoGameInterface.Presenter;
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
            Ufo newUfo = new Ufo(speed);
            Ufos.add(newUfo);
        }
    }

    public void moveAll() {
        for (Ufo Ufo : Ufos) {
            Ufo.move();
        }
    }

    public void startGame() {
        UfoAnimation ufoAnimation = new UfoAnimation(this, spawnRate);
        Thread thread = new Thread(ufoAnimation);
        thread.start();
    }

    public void setUfoImage(Image UfoImage) {
        this.UfoImage = UfoImage;
    }

    public void setSpawnRate(int spawnRate) {
        this.spawnRate = spawnRate;
    }

    public void setPresenter(Presenter presenter) {
        this.presenter=presenter;
    }

    public List<Ufo> getUfos() {
        return Ufos;
    }

}
