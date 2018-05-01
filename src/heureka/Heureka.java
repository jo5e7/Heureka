/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heureka;

import heureka.logical_deduction.Atom;
import heureka.logical_deduction.Conjuction;
import heureka.logical_deduction.Disjunction;
import heureka.logical_deduction.ResolutionSearcher;
import heureka.logical_deduction.ResolutionDB;
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
        /*java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UI().setVisible(true);
            }
        });
        */
        /*
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
        */
        
        
       Atom p = new Atom("", "p", true);
       Atom not_p = new Atom("", "p", false);
       Atom q = new Atom("", "q", true);
       Atom not_q = new Atom("", "q", false);
       Atom r = new Atom("", "r", true);
       Atom not_r = new Atom("", "r", false);
       Atom t = new Atom("", "t", true);
       Atom not_t = new Atom("", "t", false);
       Atom s = new Atom("", "s", true);
       Atom not_s = new Atom("", "s", false);
       
       Disjunction d1 = new Disjunction();
       d1.addAtom(p);
       
       Disjunction d2 = new Disjunction();
       d2.addAtom(not_p);
       d2.addAtom(q);
       d2.addAtom(r);
       
       Disjunction d3 = new Disjunction();
       d3.addAtom(not_p);
       d3.addAtom(not_q);
       d3.addAtom(not_r);
       
       Disjunction d4 = new Disjunction();
       d4.addAtom(not_p);
       d4.addAtom(s);
       d4.addAtom(t);
       
       Disjunction d5 = new Disjunction();
       d5.addAtom(not_p);
       d5.addAtom(not_s);
       d5.addAtom(not_t);
       
       Disjunction d6 = new Disjunction();
       d6.addAtom(not_s);
       d6.addAtom(q);
       
       Disjunction d7 = new Disjunction();
       d7.addAtom(r);
       d7.addAtom(t);
       
       Disjunction fact = new Disjunction();
       fact.addAtom(not_t);
       fact.addAtom(s);
        
        Conjuction kb = new Conjuction();
        kb.addDisjuction(d1);
        kb.addDisjuction(d2);
        kb.addDisjuction(d3);
        kb.addDisjuction(d4);
        kb.addDisjuction(d5);
        kb.addDisjuction(d6);
        kb.addDisjuction(d7);
        //kb.addDisjuction(fact);
        
        ResolutionDB logicDB = new ResolutionDB(kb);
        ResolutionSearcher ir = new ResolutionSearcher(logicDB, fact);
        ir.setAStar();
        ir.StartSearch();
        
        
        RouteDB db = new RouteDB();
        IntelligentSearcher is;
        Point startPoint = new Point(10, 70);
        Point goalPoint = new Point(55, 55);
        is = new RouteSearcher(startPoint, goalPoint, db);
        is.setAStar();
        is.StartSearch();
        
    }
    
}
