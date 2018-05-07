/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heureka.logical_deduction;


/**
 *
 * @author jdmaestre
 */
public class Atom {
    
    private String fact = "";
    private String representation = "";
    private boolean value = false;

    public Atom(String fact, String representation, boolean negated) {
        this.fact = fact;
        this.representation = representation;
        this.value = negated;
    }

    public String getRepresentation() {
        return representation;
    }
    
    @Override
    public boolean equals(Object obj){
        if (obj instanceof Atom) {
            Atom other = (Atom)obj;
            return other.getRepresentation().equals(this.getRepresentation()) && other.getValue() == this.getValue();
        }
        return super.equals(obj);
    }
    
    //Same representations
    public boolean similar(Atom other){
        return other.getRepresentation().equals(this.getRepresentation());
    }
    
    public boolean isOposite(Atom other){
        return other.getRepresentation().equals(this.getRepresentation()) && other.getValue() != this.getValue();
    }
    
    public boolean getValue(){
        return value;
    }
    
}
