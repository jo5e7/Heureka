/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heureka;


import java.awt.Point;

/**
 *
 * @author jdmaestre
 */
public class RouteSearcher implements IntelligentSearcher{
    
    private Engine engine;
    DB db;
    Memento initialState = new Memento(null);
    Memento goalState = new Memento(null);
    
    public RouteSearcher(String street, Point initialPosition, Point goalPosition, DB db) {
        initialState.setPos(initialPosition);
        initialState.setStreet(street);
        
        goalState.setPos(goalPosition);
        
        this.db = db;
        
        setBFS();
    }
    
    @Override
    public void StartSearch() {
        Memento fn = engine.performSearch(goalState);
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
        engine = new EngineAStar(db, initialState);
    }

    @Override
    public void setBFS() {
        engine = new EngineBFS(db, initialState);
    }
    
    //Find path
    @Override
    public void FindFinalPath(Node goal){
        if (goal instanceof Memento) {
            Memento other = (Memento)goal;
            
            while (true) {            
            System.out.println(other.getStreet() + " " + other.getXPoint() + "  " + other.getYPoint());
            System.out.println("");
            other = other.getParent();
            if (other == null) {
                break;
            }
        }
        }
    }
}
