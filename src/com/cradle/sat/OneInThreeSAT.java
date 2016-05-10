/**
 * 
 */
package com.cradle.sat;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Modupe Theko Lekena
 *
 */
public class OneInThreeSAT {

  private ArrayList<Clause> clauses;
  private ArrayList<Boolean> variables;

  private OneInThreeSAT() {
    clauses = new ArrayList<Clause>();
    variables = new ArrayList<Boolean>();
  }

  public void add(Clause c) {
    if (c.length() != 3) {
      System.out.println("Add 3SAT Clause failed. Clause does not have 3 Variables");
      return;
    }
    VariableNode[] vs = c.getVariables();
    for (VariableNode vn : vs){
      if (!variables.contains(vn.getParent())){
        variables.add(vn.getParent());
      }
    }
    clauses.add(c);
  }

  public static OneInThreeSAT toOneInThreeSAT(ThreeSAT tsat) {
    OneInThreeSAT _1in3 = new OneInThreeSAT();
    for (Clause c : tsat.getClauses()) {
      // First variable in three sat
      VariableNode candidate = c.getVariables()[0];
      Variable v1 = new Variable(candidate.getParent());
      Variable aVar = new Variable(new Boolean(true));
      Variable bVar = new Variable(new Boolean(true));
      Variable cVar = new Variable(new Boolean(true));
      Variable dVar = new Variable(new Boolean(true));
      if (candidate.isNegated()) {
        VariableNode l1 = v1.getPositive();
        VariableNode a = aVar.getPositive();
        VariableNode b = bVar.getPositive();
        _1in3.add(new Clause(new VariableNode[] {l1, a, b}));
      } else {
        VariableNode l1 = v1.getNegative();
        VariableNode a = aVar.getPositive();
        VariableNode b = bVar.getPositive();
        _1in3.add(new Clause(new VariableNode[] {l1, a, b}));
      }
      
      // Second variable in three sat
      candidate = c.getVariables()[1];
      Variable v2 = new Variable(candidate.getParent());
      VariableNode l2 = candidate.isNegated() ? v2.getNegative() : v2.getPositive();
      _1in3.add(new Clause(
          new VariableNode[] {bVar.getPositive(),l2,cVar.getPositive()}));

      // Last variable in three sat
      candidate = c.getVariables()[2];
      Variable v3 = new Variable(candidate.getParent());
      if (candidate.isNegated()) {
        VariableNode l3 = v3.getPositive();
        VariableNode cv = cVar.getPositive();
        VariableNode d = dVar.getPositive();
        _1in3.add(new Clause(new VariableNode[] {cv,d , l3}));
      } else {
        VariableNode l3 = v3.getNegative();
        VariableNode cv = cVar.getPositive();
        VariableNode d = dVar.getPositive();
        _1in3.add(new Clause(new VariableNode[] {cv, d, l3}));
      }
    }

    return _1in3;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("OneInThreeSAT");
    builder.append(System.lineSeparator());
    builder.append("[");
    builder.append(clauses);
    builder.append("]");
    return builder.toString();
  }

/*  public void putIfAbsentWithChildren(Var v) {
    variables.putIfAbsent(v, new ChildrenVariables(v));
  }*/

  /*public void putIfAbsent(Var v) {
    variables.put(v, null);
  }*/
  
 /* public PositiveVariable getPositiveInstance(Var v){
    return (PositiveVariable) variables.get(v).getPositiveInstance();
  }
  
  public NegativeVariable getNegativeInstance(Var v){
    return (NegativeVariable) variables.get(v).getNegativeInstance();
  }
  
  public boolean existAsParent(Var v){
    return variables.containsKey(v);
  }*/
  /*
  
  *//**
   * @author Modupe Theko Lekena
   * This is an inner data structure for the 1 in 3 sat instance produced from a 3 sat instance
   *//*
  private class ChildrenVariables {
   private Var positiveInstance;
   private Var negativeInstance;

    public ChildrenVariables(Var parentToBe) {
      positiveInstance = new PositiveVariable(parentToBe.value());
      negativeInstance = new NegativeVariable(parentToBe.value());

    }

    *//**
     * @return the positiveInstance
     *//*
    public Var getPositiveInstance() {
      return positiveInstance;
    }

    *//**
     * @return the negativeInstance
     *//*
    public Var getNegativeInstance() {
      return negativeInstance;
    }

    *//**
     * @param positiveInstance the positiveInstance to set
     *//*
    public void setPositiveInstance(Var positiveInstance) {
      this.positiveInstance = positiveInstance;
    }

    *//**
     * @param negativeInstance the negativeInstance to set
     *//*
    public void setNegativeInstance(Var negativeInstance) {
      this.negativeInstance = negativeInstance;
    }
    
    
  }*/


}
