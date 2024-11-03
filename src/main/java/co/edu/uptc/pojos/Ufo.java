package co.edu.uptc.pojos;
import java.awt.Point;
import java.util.Random;

import lombok.Data;

@Data
public class Ufo {
    private Point position; 
    private int speed; 
    private double angle;
    private boolean isMoving; 
    private Random random;

    public Ufo(int speed) {
        this.random = new Random();
        this.position = new Point(getRandomX(), getRandomY());
        this.speed = speed; 
        this.angle = getRandomAngle();
        this.isMoving = true;
    }

    private int getRandomX() {
        return random.nextInt(1150); 
    }

    private int getRandomY() {
        return random.nextInt(636);
    }

    private double getRandomAngle() {
        return random.nextDouble() * 2 * Math.PI; 
    }

    public void move() {
        if (isMoving) {
            int deltaX = (int) (speed * Math.cos(angle));
            int deltaY = (int) (speed * Math.sin(angle));
            position.translate(deltaX, deltaY);
            checkCollision();
        }
    }

    private void checkCollision() {
        if (position.x < 0 || position.x > 1150 || position.y < 0 || position.y > 636) {
            isMoving = false; 
        }
    }
}

