/**
 * 
 */
package com.cradle.sat;

/**
 * 
 * @author Modupe Theko Lekena
 * @Descrition Node variable class to create a structure to associate Var to a parent Boolean
 *             variable
 */
public class VariableNode {
  private Var value;
  private Boolean parent;

  public VariableNode(Boolean p, Var c) {
    value = c;
    parent = p;
  }

  public Boolean getParent() {
    return parent;
  }

  public Boolean value() {
    return value.value();
  }

  public boolean isNegated() {
    return value.getClass() == NegativeVariable.class;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("[");
    if (isNegated()) {
      builder.append("-");
    } else {
      builder.append("+");
    }
    builder.append(parent);
    builder.append("= |");
    builder.append(value);
    builder.append("|");
    builder.append("]");
    return builder.toString();
  }


}
