package co.edu.uptc.presenters;

import java.awt.Image;
import java.util.List;

import co.edu.uptc.interfaces.*;
import co.edu.uptc.interfaces.UfoGameInterface.Model;
import co.edu.uptc.interfaces.UfoGameInterface.View;
import co.edu.uptc.models.Ufo;
import lombok.Data;

@Data
public class UfoGamePresenter implements UfoGameInterface.Presenter {
    private UfoGameInterface.Model model;
    private UfoGameInterface.View view;

    @Override
    public void addUfo() {
        model.addUfo();
    }

    @Override
    public void moveAll() {
        model.moveAll();
    }

    @Override
    public List<Ufo> getUfos() {
        return model.getUfos();
    }

    @Override
    public void setUfoImage(Image newImage) {
        model.setUfoImage(newImage);
    }

    @Override
    public void setView(View view) {
        this.view = view;
    }

    @Override
    public void setModel(Model model) {
        this.model = model;
    }



}
