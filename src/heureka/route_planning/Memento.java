/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heureka.route_planning;

import heureka.DB;
import heureka.Node;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author jdmaestre
 */
public class Memento implements Node{
    
    private Point pos = new Point();
    private String street = "";
    private Node parent;
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

    public Node getParent() {
        return parent;
    }

    @Override
    public void setParent(Node parent) {
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

    @Override
    public void set_f_n(double f_n) {
        this.f_n = f_n;
    }

    @Override
    public ArrayList<Node> expandNode(DB database) {
        Memento node = this;
        RouteDB db = (RouteDB)database;
        ArrayList<Node> expandedNodes = new ArrayList<>();
        //Search in every street
        for (int i = 0; i < db.streets.size(); i++) {
            //If the street has a block that begins at the start point then
            //the end of that block is added to the frontier
            if (db.streets.get(i).blocks.containsKey(node.getPos())) {
                
                //Creates a new node for every endPoint
                for (int j = 0; j < db.streets.get(i).blocks.get(node.getPos()).size(); j++) {
                    Memento newNode = new Memento(node);
                    newNode.setStreet(db.streets.get(i).name);
                    newNode.setPos(db.streets.get(i).blocks.get(node.getPos()).get(j));
                    expandedNodes.add(newNode); 
                }
            }   
        }
        //explored.add(node);
        return expandedNodes;
    }

    

    
}
