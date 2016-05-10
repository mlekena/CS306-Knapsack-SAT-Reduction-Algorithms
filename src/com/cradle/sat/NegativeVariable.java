/**
 * 
 */
package com.cradle.sat;

/**
 * @author Modupe Theko Lekena
 *
 */
public class NegativeVariable implements Var {
  private Boolean variable;

  public NegativeVariable(Boolean b) {
    variable = b;
  }

  public NegativeVariable() {
    this(false);
  }

  @Override
  public Boolean value() {
    return !variable;
  }

  @Override
  public String toString() {
    return "-var:{" + value() + "} ";
  }

  @Override
  public void flip() {
    if (variable) {
      setFalse();
    } else {
      setTrue();
    }
  }

  @Override
  public void setTrue() {
    variable = true;    
  }

  @Override
  public void setFalse() {
    variable = false;
  }

}

