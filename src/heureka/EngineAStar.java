/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heureka;

import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author jdmaestre
 */
public class EngineAStar extends Engine{

    public EngineAStar(DB db, Memento initialNode) {
        super(db, initialNode);
    }

    @Override
    public Memento performSearch(Point goal) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void add2Frontier(Memento memento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Memento> expandFrontier(Memento node) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
