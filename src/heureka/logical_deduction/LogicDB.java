/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heureka.logical_deduction;

import heureka.DB;

/**
 *
 * @author jdmaestre
 */
public class LogicDB implements DB{
    
    private Conjuction kb = new Conjuction();
    
    public LogicDB(){
    }
    
    public LogicDB(Conjuction kb){
        this.kb = kb;
    }

    public Conjuction getKb() {
        return kb;
    }

    public void setKb(Conjuction kb) {
        this.kb = kb;
    }
    
    
}
