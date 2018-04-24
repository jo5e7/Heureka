/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heureka;

import heureka.route_planning.RouteDB;
import heureka.route_planning.Memento;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

/**
 *
 * @author jdmaestre
 */
public class EngineAStar extends Engine{
    
    
    PriorityQueue<Node> frontier; 

    public EngineAStar(RouteDB db, Memento initialNode, Comparator<Node> comparator) {
        super(db, initialNode);
        frontier = new PriorityQueue<>(comparator);
    }

    @Override
    public Node performSearch(Node goal) {
        if (initialNode.equalState(goal)) {
            return initialNode;
        }
        frontier.add(initialNode);
       
        while (!frontier.isEmpty()) {            
            Node frontierNode = frontier.element();
            //System.out.println("Explored point: " + frontierNode.getPos().toString());
            //System.out.println("Point distance: " + frontierNode.f_n);
            
            explored.add(frontierNode);
            Iterator<Node> iterator = frontierNode.expandNode(db).iterator();
            
            while (iterator.hasNext()) {
                Node next = iterator.next();
                if (!explored.contains(next) &&  !frontier.contains(next)) {
                    if (next.equalState(goal)) {
                        return next;
                    }
                    //Calculate g(n), h(n) and f(n)
                    double g_n = frontierNode.calculate_heuristic(next);
                    double h_n = next.calculate_heuristic(goal);
                    double f_n = g_n + h_n;
                    next.set_f_n(f_n);
                    frontier.add(next);
                    
                    
                }
            }
            
            frontier.remove(frontierNode);
            
        }
        
        return null;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}


