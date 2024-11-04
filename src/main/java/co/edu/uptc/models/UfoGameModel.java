package co.edu.uptc.models;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import co.edu.uptc.interfaces.UfoGameInterface;
import co.edu.uptc.interfaces.UfoGameInterface.Presenter;
import co.edu.uptc.pojos.Ufo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UfoGameModel implements UfoGameInterface.Model {
    private UfoGameInterface.Presenter presenter;
    private List<Ufo> Ufos;
    private int spawnRate;
    private int speed;
    private int numberofUfos;

    public UfoGameModel() {
        this.Ufos = new CopyOnWriteArrayList<>();
    }

    public synchronized void addUfo(int speed) {
        UfoController ufoController = new UfoController();
        Ufo newUfo = ufoController.createUfo(speed);
        Ufos.add(newUfo);
    }

    @Override
    public void startGame() {
        Thread moveThread = new Thread(new UfoRunner(this));
        moveThread.start();
        Thread spawnThread = new Thread(new SpawnRunner(this));
        spawnThread.start();
    }

    @Override
    public List<Ufo> getUfos() {
        return Ufos;
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void setSpawnRate(int spawnRate) {
        this.spawnRate = spawnRate;
    }

    @Override
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public void setNumberofUfos(int numberofUfos) {
        this.numberofUfos = numberofUfos;
    }
    
    public synchronized void moveAll() {
        Iterator<Ufo> iterator = Ufos.iterator();
        while (iterator.hasNext()) {
            Ufo ufo = iterator.next();
            UfoController ufoController = new UfoController();
            ufoController.moveUfo(ufo);
        }
    }
}
