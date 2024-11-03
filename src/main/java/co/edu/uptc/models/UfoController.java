package co.edu.uptc.models;

import co.edu.uptc.pojos.Ufo;

import java.awt.Point;
import java.util.Random;

public class UfoController {
    private Random random;

    public UfoController() {
        this.random = new Random();
    }

    public Ufo createUfo(int speed) {
        Point randomPosition = new Point(getRandomX(), getRandomY());
        double randomAngle = getRandomAngle();
        return new Ufo(speed, randomPosition, randomAngle);
    }

    private int getRandomX() {
        return random.nextInt(1125); 
    }

    private int getRandomY() {
        return random.nextInt(632);
    }

    private double getRandomAngle() {
        return random.nextDouble() * 2 * Math.PI; 
    }

    public void moveUfo(Ufo ufo) {
        if (ufo.isMoving()) {
            int deltaX = (int) (ufo.getSpeed() * Math.cos(ufo.getAngle()));
            int deltaY = (int) (ufo.getSpeed() * Math.sin(ufo.getAngle()));
            ufo.getPosition().translate(deltaX, deltaY);
            checkCollision(ufo);
        }
    }

    private void checkCollision(Ufo ufo) {
        if (ufo.getPosition().x < 0 || ufo.getPosition().x > 1125 || ufo.getPosition().y < 0 || ufo.getPosition().y > 632) {
            ufo.setMoving(false); 
        }
    }
}

