/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heureka;

import java.awt.Point;

/**
 *
 * @author jdmaestre
 */
public class Memento {
    
    private Point pos = new Point();

    public double getXPoint() {
        return pos.getX();
    }
    
    public double getYPoint() {
        return pos.getY();
    }

    public void setX(int posX) {
        this.pos.x = posX;
    }
    
    public void setY(int posY) {
        this.pos.y = posY;
    }
}
