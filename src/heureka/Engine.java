/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heureka;

import java.util.ArrayList;

/**
 *
 * @author jdmaestre
 */
abstract public class Engine {
    
    public ArrayList<Node> explored = new ArrayList<>();
    public DB db;
    public Node initialNode;
    //private DB db = new DB();

    
    abstract public Node performSearch(Node goal);

    public Engine(DB db, Node initialNode) {
        
        this.db = db;
        this.initialNode = initialNode;
        //this.explored.add(initialNode);
    }
}
