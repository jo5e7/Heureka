/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heureka;

/**
 *
 * @author jdmaestre
 */
public class IntelligentSearcher {
    
    Engine engine;
    DB db;

    public void setDb(DB db) {
        this.db = db;
    }
    
    public IntelligentSearcher() {
        engine = new EngineBFS(db);
    }
    
    public void setBFS(){
        engine = new EngineBFS(db);
    }
    
    public void setAStar(){
        engine = new EngineAStar(db);
    }
    
    public void setRBFS(){
        engine = new EngineRBFS(db);
    }
}
