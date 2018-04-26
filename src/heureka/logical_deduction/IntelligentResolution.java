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
import heureka.route_planning.Memento;
import heureka.route_planning.RouteDB;

/**
 *
 * @author jdmaestre
 */
public class IntelligentResolution implements IntelligentSearcher{
    
    Engine engine;
    LogicDB kb = new LogicDB();
    ResolutionNode initialState = new ResolutionNode(null);
    ResolutionNode goalState = new ResolutionNode(null);
    
    public IntelligentResolution(LogicDB kb, Disjunction initialState){
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
            while (fn != null) {                
                fn.mDisjunction.print();
                fn = (ResolutionNode)fn.parent;
            }
           
        }else{
            System.out.println("The fact can not be infered from the Knowledge base");
        }
    }
    
    
}
