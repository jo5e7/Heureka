/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heureka.logical_deduction;

import heureka.DB;
import java.util.ArrayList;

/**
 *
 * @author jdmaestre
 */
public class Disjunction implements DB{
    
    ArrayList<Atom> atoms = new ArrayList<>();

    public Disjunction(){
        
    }
    
    public Disjunction(ArrayList<Atom> atoms) {
        this.atoms = atoms;
    }
    
    @Override
    public boolean equals(Object other){
        if (other instanceof Disjunction) {
            if (((Disjunction) other).atoms.size() == this.atoms.size()) {
                for (Atom atom : atoms) {
                    if (!((Disjunction) other).atoms.contains(atom)) {
                        return false;
                    }
                }
                return true;
            }else{
                return false;
            }
        }
        return super.equals(other);
    }
    
    public boolean containsAtom(Atom other){
        return this.atoms.contains(other);
    }
    
    public boolean containsSimilar(Atom other){
        for (int i = 0; i < atoms.size(); i++) {
            if (other.similar(this.atoms.get(i) )) {
                return true;
            }
        }
        return false;
    }
    
    public int clashingClauses(Disjunction other){
        int cc = 0;
        for (Atom atom : atoms) {
            for (Atom atom1 : other.atoms) {
                if (atom.isOposite(atom1)) {
                    cc += 1;
                }
            }
        }
        return cc;
    }
    
    public void addAtom(Atom atom){
        this.atoms.add(atom);
    }
    
    public void print() {
        if (atoms.size() == 0) {
            System.out.print("[]");
        } else {
            for (Atom atom : atoms) {
                if (atom.getValue() == true) {
                    System.out.print(atom.getRepresentation());
                } else {
                    System.out.print("-" + atom.getRepresentation());
                }
            }
        }
        System.out.println("");
    }
    
    
}
