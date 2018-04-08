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
    private String street = "";
    private Memento parent;
    private boolean isInitialNode = false;

    public Memento(Memento parent){
        this.parent = parent;
    }

    public String getStreet() {
        return street;
    }

    public Point getPos() {
        return pos;
    }

    public void setPos(Point pos) {
        this.pos = pos;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Memento getParent() {
        return parent;
    }

    public void setParent(Memento parent) {
        this.parent = parent;
    }
    
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
    
    public void setIsInitialNode(boolean isInitialNode) {
        this.isInitialNode = isInitialNode;
    }
    
    public boolean isInitialNode() {
        return isInitialNode;
    }
}
