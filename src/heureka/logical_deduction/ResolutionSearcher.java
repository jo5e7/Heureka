/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heureka.logical_deduction;

import heureka.DB;
import heureka.Engine;
import heureka.EngineBFS;
import heureka.IntelligentSearcher;
import heureka.Node;
import heureka.route_planning.RouteNode;
import heureka.route_planning.RouteDB;

/**
 *
 * @author jdmaestre
 */
public class ResolutionSearcher implements IntelligentSearcher{
    
    Engine engine;
    ResolutionDB kb = new ResolutionDB();
    ResolutionNode initialState = new ResolutionNode(null);
    ResolutionNode goalState = new ResolutionNode(null);
    
    public ResolutionSearcher(ResolutionDB kb, Disjunction initialState){
        this.kb = kb;
        this.initialState.mDisjunction = initialState;
        setBFS();
        //The final state is already created with the empty clause
    }

    @Override
    public void setDb(DB db) {
        
    }

    @Override
    public void StartSearch() {
        ResolutionNode fn = (ResolutionNode)engine.performSearch(goalState);
        FindFinalPath(fn);
    }

    @Override
    public void setBFS() {
        engine = new EngineBFS(kb, initialState);
    }

    @Override
    public void setAStar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setRBFS() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void FindFinalPath(Node finalNode) {
        if (finalNode instanceof ResolutionNode) {
           ResolutionNode fn = (ResolutionNode)finalNode;
           //Print solution
           fn.mDisjunction.print();
           fn.auxDisjunction.print();
           fn = (ResolutionNode)fn.parent;
            while (fn != null) {
                fn.mDisjunction.print();
                fn = (ResolutionNode)fn.parent;
            }
           
        }else{
            System.out.println("The fact can not be infered from the Knowledge base");
        }
        
        System.out.println("_______________________________");
        System.out.println("_______________________________");
        System.out.println("_______________________________");
        System.out.println("_______________________________");
        
        for (Disjunction d : kb.getKb().disjunctions) {
            d.print();
        }
    }
    
    
}
