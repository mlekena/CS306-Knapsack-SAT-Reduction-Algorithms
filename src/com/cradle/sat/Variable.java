/**
 * 
 */
package com.cradle.sat;

/**
 * @author Modupe Theko Lekena
 *
 */
public class Variable {
  private Boolean assignment;
  private VariableNode posInst;
  private VariableNode negInst;

  public Variable(Boolean b) {
    assignment = b;
    posInst = new VariableNode(assignment, new PositiveVariable(assignment)); 
    negInst = new VariableNode(assignment, new NegativeVariable(assignment));
  }

  public VariableNode getPositive() {
    return posInst;
  }

  public VariableNode getNegative() {
    return negInst;
  }
  
  public Boolean getParent(){
    return assignment;
  }

}
