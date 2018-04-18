/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heureka;

import heureka.route_planning.RouteSearcher;
import heureka.route_planning.RouteDB;
import java.awt.Point;
import java.io.FileNotFoundException;

/**
 *
 * @author jdmaestre
 */
public class Heureka {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UI().setVisible(true);
            }
        });
        RouteDB db = new RouteDB();
        IntelligentSearcher is;
        is = new RouteSearcher("Calle 84", new Point(10, 70), new Point(55, 55), db);
        //is.setAStar();
        is.StartSearch();
    }
    
}
