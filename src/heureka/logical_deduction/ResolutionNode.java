/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heureka.logical_deduction;

import heureka.DB;
import heureka.Node;
import heureka.route_planning.Memento;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author jdmaestre
 */
public class ResolutionNode implements Node{
    
    public Conjuction kb = new Conjuction();
    public Node parent;
    
    public ResolutionNode(ResolutionNode parent){
        this.parent = parent;
    }

    @Override
    public Node getParent() {
        return this.parent;
    }

    @Override
    public void setParent(Node parent) {
        this.parent = parent;
    }

    @Override
    public boolean equalState(Node node) {
        if (node instanceof ResolutionNode) {
            ResolutionNode other = (ResolutionNode)node;
            return (kb.equals(other.kb));
        }
        return super.equals(node);
    }

    @Override
    public double calculate_heuristic(Node node) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void set_f_n(double f_n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Node> expandNode(DB db) {
        ArrayList<Node> nodeList = new ArrayList<>();
        
        for (int i = 0; i < this.kb.disjunctions.size(); i++) {
            Disjunction newDisjunction = new Disjunction();
            for (int j = i+1; j < this.kb.disjunctions.size(); j++) {
                Disjunction d1 = this.kb.disjunctions.get(i);
                Disjunction d2 = this.kb.disjunctions.get(j);
                
                for (Iterator iterator = d1.atoms.iterator(); iterator.hasNext();) {
                    Atom next1 = (Atom) iterator.next();
                    boolean add = true;
                    Disjunction elim = new Disjunction();
                    for (Iterator iterator1 = d2.atoms.iterator(); iterator1.hasNext();) {
                        Atom next2 = (Atom) iterator1.next();
                        // Represetation is the same p,q,r
                        if (next1.similar(next2) && next1.getValue() != next2.getValue()) {
                            // Negation or not negation is the same (-p ^ -p)  or (p ^p)
                                add = false;
                                elim.addAtom(next1);
                        }
                    }
                    if (add) {
                        newDisjunction.addAtom(next1);
                    }
                    
                    for (Iterator iterator1 = d2.atoms.iterator(); iterator1.hasNext();) {
                        Atom next2 = (Atom)iterator1.next();
                        if (!newDisjunction.containsAtom(next2) && !elim.containsSimilar(next2)) {
                            newDisjunction.addAtom(next2);
                        }
                    }
                }
                
                ResolutionNode newNode = new ResolutionNode(this);
                Conjuction newConjuction = new Conjuction(this.kb.disjunctions);
                newConjuction.addDisjuction(newDisjunction);
                newNode.kb = newConjuction;
                nodeList.add(newNode);
            }
        }
        
        
        return nodeList;
    }
    
}
