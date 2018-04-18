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

/**
 *
 * @author jdmaestre
 */
abstract public class Engine {
    
    public HashSet<Memento> explored = new HashSet<>();
    public DB db;
    public Memento initialNode;
    //private DB db = new DB();

    
    abstract public Memento performSearch(Node goal);
    abstract public void add2Frontier(Memento memento);
    abstract public ArrayList<Memento> expandFrontier(Memento node);

    public Engine(DB db, Memento initialNode) {
        
        this.db = db;
        this.initialNode = initialNode;
        add2Frontier(initialNode);
        //this.explored.add(initialNode);
    }
}
