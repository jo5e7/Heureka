/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heureka;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

/**
 *
 * @author jdmaestre
 */
public class EngineAStar extends Engine{
    
    
    PriorityQueue<Node> frontier; 

    public EngineAStar(DB db, Node initialNode, Comparator<Node> comparator) {
        super(db, initialNode);
        frontier = new PriorityQueue<>(comparator);
    }

    @Override
    public Node performSearch(Node goal) {
        
        frontier.add(initialNode);
       
        while (!frontier.isEmpty()) {            
            Node frontierNode = frontier.element();
            //System.out.println("Explored point: " + frontierNode.getPos().toString());
            //System.out.println("Point distance: " + frontierNode.f_n);
            if (frontierNode.equalState(goal)) {
                return frontierNode;
            }
            
            explored.add(frontierNode);
            Iterator<Node> iterator = frontierNode.expandNode(db).iterator();
            
            while (iterator.hasNext()) {
                Node next = iterator.next();
                //Calculate g(n), h(n) and f(n)
                double g_n = frontierNode.calculate_g_n(next);
                double h_n = next.calculate_h_n(goal);
                double f_n = g_n + h_n;
                next.set_f_n(f_n);
                    
                if (!explored.contains(next) &&  !frontier.contains(next)) {
                    frontier.add(next);
                    
                }else{
                    //Checks if the current node is in the frontier
                    if (frontier.contains(next)) {
                        for (Node node : explored) {
                            //Checks if the current node in the frontier has f(n) > than the current node
                            if (node.equals(next) && node.get_f_n() > next.get_f_n()) {
                                frontier.remove(node);
                                frontier.add(next);
                            }
                        }
                    }
                }
            }
            
            frontier.remove(frontierNode);
            
        }
        
        return null;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}


