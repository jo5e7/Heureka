/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heureka.logical_deduction;

import heureka.DB;
import heureka.Engine;
import heureka.EngineAStar;
import heureka.EngineBFS;
import heureka.EngineDFS;
import heureka.IntelligentSearcher;
import heureka.Node;
import heureka.route_planning.RouteNode;
import heureka.route_planning.RouteDB;
import java.util.Comparator;

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
    
    Comparator<Node> resolutionNComparator = new Comparator<Node>() {
        @Override
        public int compare(Node o1, Node o2) {
            
            ResolutionNode obj1 = new ResolutionNode(null);
            ResolutionNode obj2 = new ResolutionNode(null);
            
            if (o1 instanceof ResolutionNode) {
            obj1 = (ResolutionNode)o1;
            }
            
            if (o2 instanceof ResolutionNode) {
            obj2 = (ResolutionNode)o2;
            }
            
            if (obj1.f_n < obj2.f_n) {
                return -1;
            }else{
                if (obj1.f_n == obj2.f_n) {
                    return 0;
                }else{
                    return 1;
                }
            }
            }
            
    };

    @Override
    public void setDb(DB db) {
        
    }

    @Override
    public void StartSearch() {
        ResolutionNode fn = (ResolutionNode)engine.performSearch(goalState);
        FindFinalPath(fn);
        System.out.println("_______________________________");
        System.out.println("_______________________________");
        System.out.println("");
    }

    @Override
    public void setBFS() {
        engine = new EngineBFS(kb, initialState);
    }

    @Override
    public void setAStar() {
        engine = new EngineAStar(kb, initialState,resolutionNComparator);
    }

    @Override
    public void setDFS() {
        engine = new EngineDFS(kb, initialState);
    }

    /*
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
    */
    
    
    @Override
    public void FindFinalPath(Node finalNode) {
        if (finalNode instanceof ResolutionNode) {
           ResolutionNode fn = (ResolutionNode)finalNode;
           //Print solution
            if (fn.getParent() != null) {
                FindFinalPath(fn.getParent());
            }
            
           fn.mDisjunction.print();
           
        }else{
            System.out.println("The fact can not be inferred from the Knowledge base");
        }
        
    }
    
}
