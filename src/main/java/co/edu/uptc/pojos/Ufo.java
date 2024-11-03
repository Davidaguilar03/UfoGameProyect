package co.edu.uptc.pojos;

import java.awt.Point;
import lombok.Data;

@Data
public class Ufo {
    private Point position; 
    private int speed; 
    private double angle;
    private boolean isMoving; 

    public Ufo(int speed, Point position, double angle) {
        this.position = position;
        this.speed = speed; 
        this.angle = angle;
        this.isMoving = true;
    }
}


