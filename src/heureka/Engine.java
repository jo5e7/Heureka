/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heureka;

import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author jdmaestre
 */
abstract public class Engine {
    
    private ArrayList<Memento> mementos = new ArrayList<>();
    private ArrayList<Memento> frontier = new ArrayList<>();
    public DB db;
    //private DB db = new DB();

    
    abstract public void performSearch(Point start, Point end);
    abstract public void add2Frontier(Memento memento);
    abstract public void expandrontier();

    public Engine(DB db) {
        this.db = db;
    }
        
    // Heuristic value
    private double h(Point current, Point goal){
        
        return Math.hypot(current.getX()-goal.getY(), current.getY()-goal.getY());
    }

    //Path cost
    private double g(Point current, Point next){
        
        return Math.hypot(current.getX()-next.getY(), current.getY()-next.getY());
    }

}
