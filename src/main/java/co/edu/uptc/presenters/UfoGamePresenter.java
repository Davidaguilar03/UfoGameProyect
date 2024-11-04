package co.edu.uptc.presenters;

import java.util.List;

import co.edu.uptc.interfaces.*;
import co.edu.uptc.interfaces.UfoGameInterface.Model;
import co.edu.uptc.interfaces.UfoGameInterface.View;
import co.edu.uptc.pojos.Ufo;
import lombok.Data;

@Data
public class UfoGamePresenter implements UfoGameInterface.Presenter {
    private UfoGameInterface.Model model;
    private UfoGameInterface.View view;

    @Override
    public void setView(View view) {
        this.view = view;
    }

    @Override
    public void setModel(Model model) {
        this.model = model;
    }

    @Override
    public List<Ufo> getUfos() {
        return model.getUfos();
    }

    @Override
    public void startGame() {
        model.startGame();
    }

    @Override
    public void updateUFOs() {
        view.updateUFOs();
    }

    @Override
    public void setSpawnRate(int spawnRate) {
        model.setSpawnRate(spawnRate);
    }

    @Override
    public void setSpeed(int speed) {
        model.setSpeed(speed);
    }

    @Override
    public void setNumberofUfos(int numberofUfos) {
        model.setNumberofUfos(numberofUfos);
    }

}
