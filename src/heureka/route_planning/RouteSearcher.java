/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heureka.route_planning;


import heureka.DB;
import heureka.Engine;
import heureka.EngineAStar;
import heureka.EngineBFS;
import heureka.EngineRBFS;
import heureka.IntelligentSearcher;
import heureka.Node;
import java.awt.Point;
import java.util.Comparator;

/**
 *
 * @author jdmaestre
 */
public class RouteSearcher implements IntelligentSearcher{
    
    private Engine engine;
    RouteDB db;
    RouteNode initialState = new RouteNode(null);
    RouteNode goalState = new RouteNode(null);
    
    Comparator<Node> mementoHComparator = new Comparator<Node>() {
        @Override
        public int compare(Node o1, Node o2) {
            
            RouteNode obj1 = new RouteNode(null);
            RouteNode obj2 = new RouteNode(null);
            
            if (o1 instanceof RouteNode) {
            obj1 = (RouteNode)o1;
            }
            
            if (o2 instanceof RouteNode) {
            obj2 = (RouteNode)o2;
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
    
    public RouteSearcher(String street, Point initialPosition, Point goalPosition, RouteDB db) {
        initialState.setPos(initialPosition);
        initialState.setStreet(street);
        
        goalState.setPos(goalPosition);
        
        this.db = db;
        
        setBFS();
    }
    
    @Override
    public void StartSearch() {
        RouteNode fn = (RouteNode)engine.performSearch(goalState);
        FindFinalPath(fn);
    }
    
    @Override
    public void setRBFS(){
        engine = new EngineRBFS(db, initialState);
    }

    @Override
    public void setDb(DB db) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setAStar() {
        engine = new EngineAStar(db, initialState, mementoHComparator);
    }

    @Override
    public void setBFS() {
        engine = new EngineBFS(db, initialState);
    }
    
    //Find path
    @Override
    public void FindFinalPath(Node goal){
        if (goal instanceof RouteNode) {
            RouteNode other = (RouteNode)goal;
            
            while (true) {            
            System.out.println(other.getStreet() + " " + other.getXPoint() + "  " + other.getYPoint());
            System.out.println("");
            other = (RouteNode) other.getParent();
            if (other == null) {
                break;
            }
        }
        }
    }
}
