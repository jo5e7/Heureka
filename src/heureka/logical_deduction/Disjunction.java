/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heureka.logical_deduction;

import java.util.ArrayList;

/**
 *
 * @author jdmaestre
 */
public class Disjunction {
    
    ArrayList<Atom> atoms = new ArrayList<>();

    public Disjunction(ArrayList<Atom> atoms) {
        this.atoms = atoms;
    }
    
    public void AddAtom(Atom atom){
        this.atoms.add(atom);
    }
}
