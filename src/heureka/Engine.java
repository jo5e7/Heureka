/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heureka;

import java.awt.Point;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import javax.swing.text.Position;

/**
 *
 * @author jdmaestre
 */
abstract public class Engine {
    
    public HashSet<Memento> explored = new HashSet<>();
    public ArrayDeque<Memento> frontier = new ArrayDeque<>();
    public DB db;
    public Memento initialNode;
    //private DB db = new DB();

    
    abstract public Memento performSearch(Point goal);
    abstract public void add2Frontier(Memento memento);
    abstract public ArrayList<Memento> expandFrontier(Memento node);

    public Engine(DB db, Memento initialNode) {
        this.db = db;
        this.initialNode = initialNode;
        add2Frontier(initialNode);
        this.explored.add(initialNode);
    }
        
    // Heuristic value
    private double h(Point current, Point goal){
        
        return Math.hypot(current.getX()-goal.getY(), current.getY()-goal.getY());
    }

    //Path cost
    private double g(Point current, Point next){
        
        return Math.hypot(current.getX()-next.getY(), current.getY()-next.getY());
    }
    
    //Find path
    public void FindFinalPath(Memento goal){
        
        while (true) {            
            System.out.println(goal.getStreet() + " " + goal.getXPoint() + "  " + goal.getYPoint());
            System.out.println("");
            goal = goal.getParent();
            if (goal == null) {
                break;
            }
        }
    }

}
