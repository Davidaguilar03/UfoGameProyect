package co.edu.uptc.models;

import lombok.Data;

@Data
public class SpawnRunner implements Runnable {
    private UfoGameModel ufoGameModel;
    private int createdUfos;

    public SpawnRunner(UfoGameModel ufoGameModel) {
        this.ufoGameModel = ufoGameModel;
        createdUfos = 0;
    }

    @Override
    public void run() {
        while (createdUfos < ufoGameModel.getNumberofUfos()) {
            ufoGameModel.addUfo(ufoGameModel.getSpeed()); 
            createdUfos++;
            ufoGameModel.getPresenter().updateUFOs(); 
            try {
                Thread.sleep(ufoGameModel.getSpawnRate()); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}