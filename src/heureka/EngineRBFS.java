/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heureka;

import heureka.route_planning.RouteDB;
import heureka.route_planning.RouteNode;
import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author jdmaestre
 */

public class EngineRBFS extends Engine{

    public EngineRBFS(RouteDB db, RouteNode initialNode) {
        super(db, initialNode);
    }

    @Override
    public RouteNode performSearch(Node goal) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



    
}
