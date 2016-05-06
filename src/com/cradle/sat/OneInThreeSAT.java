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
  private HashMap<Var, ChildrenVariables> variables;

  private OneInThreeSAT() {
    clauses = new ArrayList<Clause>();
    variables = new HashMap<Var, ChildrenVariables>();
  }

  public void add(Clause c) {
    if (c.length() != 3) {
      System.out.println("Add 3SAT Clause failed. Clause does not have 3 Variables");
      return;
    }
    Var[] v = c.getVariables();
    variables.add(v[0]);
    variables.add(v[1]);
    variables.add(v[2]);
    clauses.add(c);
  }

  public static OneInThreeSAT toOneInThreeSAT(ThreeSAT tsat) {
    OneInThreeSAT _1in3 = new OneInThreeSAT();
    for (Clause c : tsat.getClauses()) {
      // First variable in three sat
      Var candidate = c.getVariables()[0];
      _1in3.putIfAbsentWithChildren(candidate);
      if (candidate.getClass() == PositiveVariable.class) {
        Var a = _1in3.;
        Var b = new PositiveVariable();
        Var d = new PositiveVariable();
        _1in3.add(new Clause(new Var[] {a, b, d}));
      } else {
        Var a = new PositiveVariable();
        Var b = new PositiveVariable();
        Var d = new PositiveVariable();
        _1in3.add(new Clause(new Var[] {a, b, d}));
      }
      
      // Second variable in three sat
      _1in3.add(new Clause(
          new Var[] {new PositiveVariable(), new PositiveVariable(), new PositiveVariable()}));

      // Last variable in three sat
      if (c.getVariables()[2].getClass() == PositiveVariable.class) {
        _1in3.add(new Clause(
            new Var[] {new NegativeVariable(), new PositiveVariable(), new PositiveVariable()}));
      } else {
        _1in3.add(new Clause(
            new Var[] {new PositiveVariable(), new PositiveVariable(), new PositiveVariable()}));
      }
    }

    System.out.println(_1in3);
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
    builder.append("OneInThreeSAT [clauses=");
    builder.append(clauses);
    builder.append("]");
    return builder.toString();
  }

  public void putIfAbsentWithChildren(Var v) {
    variables.putIfAbsent(v, new ChildrenVariables(v));
  }

  public void putIfAbsent(Var v) {
    variables.put(v, null);
  }
  
  public PositiveVariable getPositiveInstance(Var v){
    return (PositiveVariable) variables.get(v).getPositiveInstance();
  }
  
  public NegativeVariable getNegativeInstance(Var v){
    return (NegativeVariable) variables.get(v).getNegativeInstance();
  }
  
  public boolean existAsParent(Var v){
    return variables.containsKey(v);
  }
  
  
  /**
   * @author Modupe Theko Lekena
   * This is an inner data structure for the 1 in 3 sat instance produced from a 3 sat instance
   */
  private class ChildrenVariables {
   private Var positiveInstance;
   private Var negativeInstance;

    public ChildrenVariables(Var parentToBe) {
      positiveInstance = new PositiveVariable(parentToBe.value());
      negativeInstance = new NegativeVariable(parentToBe.value());

    }

    /**
     * @return the positiveInstance
     */
    public Var getPositiveInstance() {
      return positiveInstance;
    }

    /**
     * @return the negativeInstance
     */
    public Var getNegativeInstance() {
      return negativeInstance;
    }

    /**
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
    }*/
    
    
  }


}
