/**
 * 
 */
package com.cradle.sat;

import java.util.ArrayList;

/**
 * @author Modupe Theko Lekena
 *
 */
public class OneInThreeSAT {

  private ArrayList<Clause> clauses;

  private OneInThreeSAT() {
    clauses = new ArrayList<Clause>();
  }

  public void add(Clause c) {
    if (c.length() != 3) {
      System.out.println("Add 3SAT Clause failed. Clause does not have 3 Variables");
      return;
    }

    clauses.add(c);
  }

  public static OneInThreeSAT toOneInThreeSAT(ThreeSAT tsat) {
    OneInThreeSAT _1in3 = new OneInThreeSAT();
    for (Clause c : tsat.getClauses()) {
      if (c.getVariables()[0].getClass() == PositiveVariable.class) {
        _1in3.add(new Clause(
            new Var[] {new NegativeVariable(), new PositiveVariable(), new PositiveVariable()}));
      } else {
        _1in3.add(new Clause(
            new Var[] {new PositiveVariable(), new PositiveVariable(), new PositiveVariable()}));
      }

      _1in3.add(new Clause(
          new Var[] {new PositiveVariable(), new PositiveVariable(), new PositiveVariable()}));

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

  /* (non-Javadoc)
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

  
}
