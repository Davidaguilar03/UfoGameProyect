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

    public UfoGameModel() {
        this.Ufos = new ArrayList<>();
    }

    @Override
    public void moveAll() {
        for (Ufo Ufo : Ufos) {
            Ufo.move();
        }
    }

    @Override
    public void setUfoImage(Image UfoImage) {
        this.UfoImage = UfoImage;
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter=presenter;
    }

    @Override
    public void addUfo() {
        Ufo newUfo = new Ufo(1);
        Ufos.add(newUfo);
    }

    @Override
    public List<Ufo> getUfos() {
        return Ufos;
    }

}
