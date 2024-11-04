package co.edu.uptc.models;

import co.edu.uptc.pojos.Ufo;

import java.awt.Point;
import java.util.List;
import java.util.Random;

public class UfoController {
    private Random random;
    private UfoGameModel ufoGameModel;

    public UfoController(UfoGameModel ufoGameModel) {
        this.ufoGameModel = ufoGameModel;
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

    public void moveUfo(Ufo ufo, List<Ufo> allUfos) {
        if (ufo.isMoving() && ufo.getTrajectory() != null && !ufo.getTrajectory().isEmpty()) {
            followTrajectory(ufo);
        } else if (ufo.isMoving()) {
            int deltaX = (int) (ufo.getSpeed() * Math.cos(ufo.getLastAngle())); 
            int deltaY = (int) (ufo.getSpeed() * Math.sin(ufo.getLastAngle())); 
            ufo.getPosition().translate(deltaX, deltaY);
            if (checkWallCollision(ufo)) {
                removeUfo(ufo, allUfos);
                return; 
            }
            for (Ufo otherUfo : allUfos) {
                if (ufo != otherUfo && ufo.getBounds().intersects(otherUfo.getBounds())) {
                    removeUfo(ufo, allUfos);
                    removeUfo(otherUfo, allUfos);
                    return; 
                }
            }
        }
    }
    

    private boolean checkWallCollision(Ufo ufo) {
        return ufo.getPosition().x < 0 || ufo.getPosition().x > 1125 || 
               ufo.getPosition().y < 0 || ufo.getPosition().y > 632;
    }
    
    private void removeUfo(Ufo ufo, List<Ufo> allUfos) {
        allUfos.remove(ufo);
        ufoGameModel.getPresenter().incrementCrashedUfoCount();
    }

    private void followTrajectory(Ufo ufo) {
        Point currentPos = ufo.getPosition();
        double speed = Math.max(ufo.getSpeed(), 2); 
        
        if (!ufo.getTrajectory().isEmpty()) {
            Point targetPos = ufo.getNextPoint();
            int deltaX = targetPos.x - currentPos.x;
            int deltaY = targetPos.y - currentPos.y;
            double distance = Math.sqrt(deltaX * deltaX + deltaY * deltaY);
            
            if (distance > 0) {
                double angle = Math.atan2(deltaY, deltaX);
                ufo.updateAngle(angle);
                double increasedSpeed = speed * 1.5; 
                double normalizedSpeed = Math.min(increasedSpeed, distance);
                int moveX = (int) (normalizedSpeed * Math.cos(angle));
                int moveY = (int) (normalizedSpeed * Math.sin(angle));
                currentPos.translate(moveX, moveY);
                
                if (distance <= increasedSpeed) {
                    currentPos.setLocation(targetPos);
                    ufo.removeReachedPoint(); 
                }
            }
        } else {
            double angle = ufo.getLastAngle();
            int moveX = (int) (speed * Math.cos(angle));
            int moveY = (int) (speed * Math.sin(angle));
            currentPos.translate(moveX, moveY);
        }
    }
    
}
