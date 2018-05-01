/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heureka;

import heureka.route_planning.RouteDB;
import java.awt.Point;

/**
 *
 * @author jdmaestre
 */
public interface IntelligentSearcher {
    
    public void setDb(DB db);
    
    public void StartSearch();
   
    
    public  void setBFS();
    
    public void setAStar();
    
    public void setDFS();
    
    public void FindFinalPath(Node finalNode);
}
