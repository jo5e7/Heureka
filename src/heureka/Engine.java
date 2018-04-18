/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heureka;

import heureka.route_planning.RouteDB;
import heureka.route_planning.Memento;
import java.awt.Point;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author jdmaestre
 */
abstract public class Engine {
    
    public HashSet<Node> explored = new HashSet<>();
    public RouteDB db;
    public Node initialNode;
    //private DB db = new DB();

    
    abstract public Node performSearch(Node goal);

    public Engine(RouteDB db, Memento initialNode) {
        
        this.db = db;
        this.initialNode = initialNode;
        //this.explored.add(initialNode);
    }
}
