/**
 * 
 */
package com.cradle.sat;

import java.util.Arrays;

/**
 * @author Modupe Theko Lekena
 *
 */
public class Clause {
  private Var[] variables;

  public Clause(Var[] v) {
    variables = v;
  }

  public static Clause negPosNegFactory() {
    return new Clause(
        new Var[] {new NegativeVariable(), new PositiveVariable(), new NegativeVariable()});
  }

  public static Clause posNegPosFactory() {
    return new Clause(
        new Var[] {new PositiveVariable(), new NegativeVariable(), new PositiveVariable()});
  }

  public boolean satisfied() {
    return variables[0].value() && variables[1].value() && variables[2].value();
  }

  public void flip(int index) {
    variables[index].flip();
  }

  public void setTrue(int index) {
    variables[index].setTrue();
  }

  public void setFalse(int index) {
    variables[index].setFalse();
  }
  
  public int length(){
    return variables.length;
  }
  
  public Var[] getVariables(){
    return variables;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("Clause [variables=");
    builder.append(Arrays.toString(variables));
    builder.append("]" + System.lineSeparator());
    return builder.toString();
  }
  
  
}
