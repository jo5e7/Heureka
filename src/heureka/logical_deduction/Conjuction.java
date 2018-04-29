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
public class Conjuction {
   public ArrayList<Disjunction> disjunctions = new ArrayList<>();
   
   public Conjuction(){
       
   }
   
   public Conjuction(ArrayList<Disjunction> disjunctions){
       this.disjunctions = disjunctions;
   }
   
   public void addDisjuction(Disjunction disjunction){
       if (!disjunctions.contains(disjunction)) {
          disjunctions.add(disjunction); 
       }
   }
   
   @Override
    public boolean equals(Object other){
        if (other instanceof Conjuction) {
            if (((Conjuction) other).disjunctions.size() == this.disjunctions.size()) {
                for (Disjunction disjunction : disjunctions) {
                    if (!((Conjuction) other).disjunctions.contains(disjunction)) {
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
   
}
