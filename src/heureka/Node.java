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
interface Node {

    public Node getParent();

    public void setParent(Memento parent);
    
    public boolean equalState(Node node);
    
    public double calculate_heuristic(Node node);
}
