/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heureka.logical_deduction;

import heureka.DB;
import heureka.Node;
import java.util.ArrayList;

/**
 *
 * @author jdmaestre
 */
public class ResolutionNode implements Node{
    
    public Disjunction mDisjunction = new Disjunction();
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
            return (mDisjunction.equals(other.mDisjunction));
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
        LogicDB ldb = (LogicDB) db;
        ArrayList<Node> nodeList = new ArrayList<>();

        for (int i = 0; i < ldb.getKb().disjunctions.size(); i++) {
            Disjunction newDisjunction = new Disjunction();
            Disjunction d1 = ldb.getKb().disjunctions.get(i);
            Disjunction d2 = mDisjunction;

            for (Atom next1 : d1.atoms) {
                boolean add = true;
                //Auxiliar disjuction to track eliminated atoms 
                Disjunction elim = new Disjunction();
                for (Atom next2 : d2.atoms) {
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

                for (Atom next2 : d2.atoms) {
                    if (!newDisjunction.containsAtom(next2) && !elim.containsSimilar(next2)) {
                        newDisjunction.addAtom(next2);
                    }
                }
            }

            ResolutionNode newNode = new ResolutionNode(this);
            newNode.mDisjunction = newDisjunction;
            nodeList.add(newNode);
            
            System.out.println("Number of disjuntions: "+String.valueOf(ldb.getKb().disjunctions.size()));
        }
        for (Node node : nodeList) {
            ResolutionNode rn = (ResolutionNode)node;
            ldb.getKb().addDisjuction(rn.mDisjunction);
        }
        System.out.println("Here we go again");
        return nodeList;
    }
    
}
