/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heureka;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javafx.geometry.Pos;

/**
 *
 * @author jdmaestre
 */
public class Street {
    
    String name;
    Map<Point, ArrayList<Point>> blocks = new HashMap<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Point> getBlock(Point startBlock) {
        return blocks.get(startBlock);
    }

    public void setBlock(Point start, Point end) {
        if (blocks.containsKey(start)) {
            this.blocks.get(start).add(end);
        }else{
            ArrayList<Point> endPoints = new ArrayList<>();
            endPoints.add(end);
            this.blocks.put(start, endPoints);
        }
        
    }
    
    
}
