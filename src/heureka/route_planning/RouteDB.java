/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heureka.route_planning;

import heureka.DB;
import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author jdmaestre
 */
public class RouteDB implements DB{

  
    public ArrayList<Street> streets = new ArrayList<>();
    
    public RouteDB() throws FileNotFoundException {
        Scanner fileIn = new Scanner(new File("/Users/jdmaestre/Documents/DB.txt"));
        
        String name;
        
        
        while (fileIn.hasNextLine()){
            boolean isInDB = false;
            Point startPos = new Point();
            Point endPos = new Point();
            
            //Get information from line in txt
            startPos.x = Integer.valueOf(fileIn.next()) ;
            startPos.y = fileIn.nextInt();
            name = fileIn.next();
            endPos.x = fileIn.nextInt();
            endPos.y = fileIn.nextInt();
                
            //Add information to db
            for (int i = 0; i < streets.size() - 1; i++) {
                if (streets.get(i).name.equals(name)) {
                    streets.get(i).setBlock(startPos, endPos);
                    isInDB = true;
                    break;
                }
            }
            if(!isInDB){
                Street s = new Street();
                s.setName(name);
                s.setBlock(startPos, endPos);
                streets.add(s);
            }   
            
            fileIn.nextLine();
        }
    }
    
    
    
}
