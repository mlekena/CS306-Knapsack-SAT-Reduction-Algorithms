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
  private ArrayList<Var> variables;
  private ArrayList<Clause> clauses;

  public ThreeSAT() {
    clauses = new ArrayList<Clause>();
    variables = new ArrayList<Var>();
  }

  public ThreeSAT(Var[] vars, int noOfClauses) {
    super();
    int i = -1;
    for (int index = 0; index < noOfClauses; index++) {
      Random rand = new Random(new Date().getTime());
      i = rand.nextInt(vars.length);
      Var a = vars[i];
      i = rand.nextInt(vars.length);
      Var b = vars[i];
      i = rand.nextInt(vars.length);
      Var c = vars[i];
      clauses.add(new Clause(new Var[] {a, b, c}));
    }

    variables = new ArrayList<Var>(Arrays.asList(vars));
  }

  public void add(Clause c) {
    if (c.length() != 3) {
      System.out.println("Add 3SAT Clause failed. Clause does not have 3 Variables");
      return;
    }

    for (Var v : c.getVariables()) {
      if (!variables.contains(v)) { // if it doesnt contain this variable in its variable set...
                                    // well add it
        variables.add(v);
      }
    }

    clauses.add(c);
  }

  public ArrayList<Clause> getClauses() {
    return clauses;
  }

  public ArrayList<Var> getVariables() {
    return variables;
  }


}
