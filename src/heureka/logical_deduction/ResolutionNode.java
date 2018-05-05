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
public class ResolutionNode implements Node {

    public Disjunction mDisjunction = new Disjunction();
    public Disjunction auxDisjunction = new Disjunction();
    public Node parent;
    public double f_n = -1;
    public int g_n = 0;

    public ResolutionNode(ResolutionNode parent) {
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
            ResolutionNode other = (ResolutionNode) node;
            return (mDisjunction.equals(other.mDisjunction));
        }
        return super.equals(node);
    }
    
    @Override
    public boolean equals(Object o) {
        if (o instanceof ResolutionNode) {
            ResolutionNode other = (ResolutionNode) o;
            return (mDisjunction.equals(other.mDisjunction));
        }
        return super.equals(o);
    }

    @Override
    public double calculate_g_n(Node node) {
        return g_n;
    }
    
    @Override
    public double calculate_h_n(Node node) {
        ResolutionNode rn = (ResolutionNode)node;
        return mDisjunction.atoms.size();
    }

    @Override
    public void set_f_n(double f_n) {
        this.f_n = f_n;
    }
    
    @Override
    public double get_f_n() {
        return this.f_n;
    }

    @Override
    public ArrayList<Node> expandNode(DB db) {
        ResolutionDB ldb = (ResolutionDB) db;
        ArrayList<Node> nodeList = new ArrayList<>();

        for (int i = 0; i < ldb.getKb().disjunctions.size(); i++) {
            Disjunction newDisjunction = new Disjunction();
            Disjunction d2 = ldb.getKb().disjunctions.get(i);
            Disjunction d1 = mDisjunction;
            //Auxiliar disjuction to track eliminated atoms 
            Disjunction elim = new Disjunction();

            if (d1.clashingClauses(d2) == 1) {
                for (Atom next1 : d1.atoms) {
                    boolean add = true;

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

                }

                for (Atom next2 : d2.atoms) {
                    if (!newDisjunction.containsAtom(next2) && !elim.containsSimilar(next2)) {
                        newDisjunction.addAtom(next2);
                    }
                }

                ResolutionNode newNode = new ResolutionNode(this);
                newNode.mDisjunction = newDisjunction;
                newNode.auxDisjunction = d2;
                newNode.g_n = this.g_n +1;
                nodeList.add(newNode);
            }

        }
        for (Node node : nodeList) {
            ResolutionNode rn = (ResolutionNode) node;
            ldb.getKb().addDisjuction(rn.mDisjunction);
        }

        /*System.out.println("Father: ");
        this.mDisjunction.print();
        System.out.println("Children: ");
        for (Node node : nodeList) {
                ResolutionNode auxNode = (ResolutionNode)node;
                auxNode.mDisjunction.print();
            }
        System.out.println("__________________");
        System.out.println("Here we go again");*/

        return nodeList;
    }
    
}
