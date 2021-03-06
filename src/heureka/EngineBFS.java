/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heureka;


import java.util.ArrayDeque;
import java.util.Iterator;

/**
 *
 * @author jdmaestre
 */
public class EngineBFS extends Engine{

   public ArrayDeque<Node> frontier = new ArrayDeque<>();
    
   public EngineBFS(DB db, Node initialNode) {
        super(db, initialNode);
    }
   
    @Override
    public Node performSearch(Node goal) {
        
        if (initialNode.equalState(goal)) {
            return initialNode;
        }
        frontier.add(initialNode);
       
        while (!frontier.isEmpty()) {            
            Node frontierNode = frontier.getFirst();
            
            explored.add(frontierNode);
            Iterator<Node> iterator = frontierNode.expandNode(db).iterator();
            
            while (iterator.hasNext()) {
                Node next = iterator.next();
                if (!explored.contains(next) && !frontier.contains(next)) {
                    if (next.equalState(goal)) {
                        return next;
                    }
                    frontier.addLast(next);
                }
            }
            
            frontier.remove(frontierNode);
        }
        
        return null;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
}
