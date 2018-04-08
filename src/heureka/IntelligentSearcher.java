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
public class IntelligentSearcher {
    
    Engine engine;
    DB db;
    Memento initialState = new Memento(null);
    Point goal;

    public IntelligentSearcher(String street, Point initialPosition, Point goalPosition, DB db) {
        initialState.setPos(initialPosition);
        initialState.setStreet(street);
        
        this.db = db;
        this.goal = goalPosition;
        
        setBFS();
    }

    public void setDb(DB db) {
        this.db = db;
    }
    
    public void StartSearch(){
        Memento finalNode = engine.performSearch(goal);
        engine.FindFinalPath(finalNode);
    }
    
    public IntelligentSearcher() {
        engine = new EngineBFS(db, initialState);
    }
    
    public void setBFS(){
        engine = new EngineBFS(db, initialState);
    }
    
    public void setAStar(){
        engine = new EngineAStar(db, initialState);
    }
    
    public void setRBFS(){
        engine = new EngineRBFS(db, initialState);
    }
}
