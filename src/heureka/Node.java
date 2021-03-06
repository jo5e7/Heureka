/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heureka;

import heureka.route_planning.RouteNode;
import java.util.ArrayList;

/**
 *
 * @author jdmaestre
 */
public interface Node {

    public Node getParent();

    public void setParent(Node parent);
    
    public boolean equalState(Node node);
    
    public double calculate_g_n(Node node);
    
    public double calculate_h_n(Node node);
    
    public void set_f_n(double f_n);
    
    public double get_f_n();
    
    public ArrayList<Node> expandNode(DB db);
    
}
