/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heureka;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author jdmaestre
 */
public class EngineBFS extends Engine{

   public EngineBFS(DB db, Memento initialNode) {
        super(db, initialNode);
    }

    @Override
    public void add2Frontier(Memento memento) {
        //this.frontier.addFirst(memento);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Memento> expandFrontier(Memento node) {
        
        ArrayList<Memento> expandedNodes = new ArrayList<>();
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
        explored.add(node);
        return expandedNodes;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Memento performSearch(Point goal) {
        
        if (initialNode.getPos().equals(goal)) {
            return initialNode;
        }
        frontier.add(initialNode);
       
        while (!frontier.isEmpty()) {            
            Memento frontierNode = frontier.getFirst();
            
            explored.add(frontierNode);
            Iterator<Memento> iterator = expandFrontier(frontierNode).iterator();
            
            while (iterator.hasNext()) {
                Memento next = iterator.next();
                if (!explored.contains(next) && !frontier.contains(next)) {
                    if (next.getPos().equals(goal)) {
                        return next;
                    }
                    frontier.add(next);
                }
            }
            
            frontier.remove(frontierNode);
        }
        
        return null;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
}
