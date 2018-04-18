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
public class Memento implements Node{
    
    private Point pos = new Point();
    private String street = "";
    private Memento parent;
    public double f_n = -1; 
    private boolean isInitialNode = false;

    public Memento(Memento parent){
        this.parent = parent;
    }
    
    @Override
    public boolean equals(Object obj){
        if (obj instanceof Memento) {
            Memento other = (Memento)obj;
            return (pos.equals(other.pos));
        }
        return super.equals(obj);
    }
    
    @Override
    public boolean equalState(Node node) {
        if (node instanceof Memento) {
            Memento other = (Memento)node;
            return (pos.equals(other.pos));
        }
        return super.equals(node);
    }
    
    @Override
    public double calculate_heuristic(Node node) {
        if (node instanceof Memento) {
            Memento other = (Memento)node;
            return Math.hypot(this.pos.getX()-other.pos.getX(), this.pos.getY()-other.pos.getY());
        }
        return -1;
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
