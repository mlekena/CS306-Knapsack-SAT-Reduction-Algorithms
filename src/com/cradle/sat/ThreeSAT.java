/**
 * 
 */
package com.cradle.sat;

import java.util.ArrayList;

/**
 * @author Modupe Theko Lekena
 *
 */
public class ThreeSAT {
  private ArrayList<Clause> clauses;

  public ThreeSAT() {
    clauses = new ArrayList<Clause>();
  }

  public void add(Clause c) {
    if (c.length() != 3){
      System.out.println("Add 3SAT Clause failed. Clause does not have 3 Variables");
      return;
    }
    
    clauses.add(c);
  }
  
  public ArrayList<Clause> getClauses(){
    return clauses;
  }
  
  
}
