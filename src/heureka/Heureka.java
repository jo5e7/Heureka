/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heureka;

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
        DB db = new DB();
        IntelligentSearcher is;
        is = new IntelligentSearcher("Calle 84", new Point(10, 70), new Point(70, 85), db);
        is.StartSearch();
    }
    
}
