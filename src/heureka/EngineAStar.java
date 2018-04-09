/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heureka;

import java.awt.Point;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.PriorityQueue;

/**
 *
 * @author jdmaestre
 */
public class EngineAStar extends Engine{
    
    Comparator<Memento> mementoHComparator = new Comparator<Memento>() {
        @Override
        public int compare(Memento o1, Memento o2) {
            if (o1.f_n < o2.f_n) {
                return -1;
            }else{
                if (o1.f_n == o2.f_n) {
                    return 0;
                }else{
                    return 1;
                }
            }
        }
    };
    PriorityQueue<Memento> frontier = new PriorityQueue<>(mementoHComparator);

    public EngineAStar(DB db, Memento initialNode) {
        super(db, initialNode);
    }

    @Override
    public Memento performSearch(Point goal) {
        if (initialNode.getPos().equals(goal)) {
            return initialNode;
        }
        frontier.add(initialNode);
       
        while (!frontier.isEmpty()) {            
            Memento frontierNode = frontier.element();
            System.out.println("Explored point: " + frontierNode.getPos().toString());
            System.out.println("Point distance: " + frontierNode.f_n);
            
            explored.add(frontierNode);
            Iterator<Memento> iterator = expandFrontier(frontierNode).iterator();
            
            while (iterator.hasNext()) {
                Memento next = iterator.next();
                if (!explored.contains(next) &&  !frontier.contains(next)) {
                    if (next.getPos().equals(goal)) {
                        
                        return next;
                    }
                    double g_n = g(frontierNode.getPos(), next.getPos());
                    double h_n = h(next.getPos(), goal);
                    double f_n = g_n + h_n;
                    next.f_n = f_n;
                    frontier.add(next);
                    
                    
                }
            }
            
            frontier.remove(frontierNode);
            
        }
        
        return null;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void add2Frontier(Memento memento) {
        
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
        //explored.add(node);
        return expandedNodes;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    

    
}


