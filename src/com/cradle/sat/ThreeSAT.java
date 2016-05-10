/**
 * 
 */
package com.cradle.sat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

/**
 * @author Modupe Theko Lekena
 *
 */
public class ThreeSAT {
  private ArrayList<Boolean> variables;
  private ArrayList<Clause> clauses;
  private Random rand;
  public ThreeSAT() {
    clauses = new ArrayList<Clause>();
    variables = new ArrayList<Boolean>();
    rand = new Random(new Date().getTime());
  }

  public ThreeSAT(Boolean[] vars, int noOfClauses) {
    this();
    int i = -1; // used for the random calls

    for (int index = 0; index < noOfClauses; index++) {
      // Randomly select a boolean object to use as a variable in the clause
      i = rand.nextInt(vars.length);
      Variable a = new Variable(vars[i]);
      i = rand.nextInt(vars.length);
      Variable b = new Variable(vars[i]);
      i = rand.nextInt(vars.length);
      Variable c = new Variable(vars[i]);
      
      // Test to see if the boolean object has been selected before and is in the set. If not add it
      if (!variables.contains(a.getParent())) { // if the variable is not in the set of variable
                                                // parents
        variables.add(a.getParent());
      }
      if (!variables.contains(b.getParent())) { // if the variable is not in the set of variable
                                                // parents
        variables.add(b.getParent());
      }
      if (!variables.contains(c.getParent())) { // if the variable is not in the set of variable
                                                // parents
        variables.add(c.getParent());
      }
      // Randomly pick a positive or negative representation of the boolean object
      VariableNode first = rand.nextInt() % 2 == 0 ? a.getPositive() : a.getNegative();
      VariableNode second = rand.nextInt() % 2 == 0 ? b.getPositive() : b.getNegative();
      VariableNode third = rand.nextInt() % 2 == 0 ? b.getPositive() : b.getNegative();
      
      // Create the clause and add it to the set of cluases
      clauses.add(new Clause(new VariableNode[] {first, second, third}));
    }

  }

  public void add(Clause c) {
    if (c.length() != 3) {
      System.out.println("Add 3SAT Clause failed. Clause does not have 3 Variables");
      return;
    }

    for (VariableNode v : c.getVariables()) {
      if (!variables.contains(v.getParent())) { // if it doesnt contain this variable in its variable set...
                                    // well add it
        System.out.println("Adding a new parent in the add in ThreeSAT (NOT IN CONSTRUCTOR!!)");
        variables.add(v.getParent());
      }
    }

    clauses.add(c);
  }

  public ArrayList<Clause> getClauses() {
    return clauses;
  }

  public ArrayList<Boolean> getVariables() {
    return variables;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("Three SAT Instance");
    builder.append(System.lineSeparator());
    builder.append(Arrays.toString(clauses.toArray()));
//    for (int index = 0; index < clauses.size(); index++ ){
//      builder.append("<");
//      Clause c = clauses.get(index);
//      builder.append()
//    }
    return builder.toString();
  }
  
  

}
