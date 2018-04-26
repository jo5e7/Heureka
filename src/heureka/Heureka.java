/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heureka;

import heureka.logical_deduction.Atom;
import heureka.logical_deduction.Conjuction;
import heureka.logical_deduction.Disjunction;
import heureka.route_planning.RouteSearcher;
import heureka.route_planning.RouteDB;
import java.awt.Point;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 *
 * @author jdmaestre
 */
public class Heureka {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UI().setVisible(true);
            }
        });
        
        
        Atom not_p = new Atom("The house is green", "p", false);
        Atom not_q = new Atom("Green is not a color", "q", false);
        Atom r = new Atom("Whiskey is tasty", "r", true);
        
        Atom q = new Atom("Green is not a color", "q", true);
        Atom p = new Atom("The house is gree", "p", true);
        
        Atom not_r = new Atom("Whiskey is tasty", "r", false);
        
        
        Disjunction d1 = new Disjunction();
        d1.addAtom(not_p);
        d1.addAtom(not_q);
        d1.addAtom(r);
        
        Disjunction d2 = new Disjunction();
        d2.addAtom(q);
        d2.addAtom(r);
        
        Disjunction d3 = new Disjunction();
        d3.addAtom(p);
        d3.addAtom(r);

        Disjunction fact = new Disjunction();
        fact.addAtom(not_r);
        
        Conjuction kb = new Conjuction();
        kb.addDisjuction(d1);
        kb.addDisjuction(d2);
        kb.addDisjuction(d3);
        kb.addDisjuction(fact);
        
        
        RouteDB db = new RouteDB();
        IntelligentSearcher is;
        is = new RouteSearcher("Calle 84", new Point(10, 70), new Point(55, 55), db);
        //is.setAStar();
        is.StartSearch();
    }
    
}
