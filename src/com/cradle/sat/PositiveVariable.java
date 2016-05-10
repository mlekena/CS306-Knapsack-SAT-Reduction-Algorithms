/**
 * 
 */
package com.cradle.sat;

/**
 * @author Modupe Theko Lekena
 *
 */
public class PositiveVariable implements Var {

  /**
   * @see com.cradle.sat.Var#value()
   */
  private Boolean variable;

  public PositiveVariable(Boolean b) {
    variable = b;
  }

  public PositiveVariable() {
    this(false);
  }

  @Override
  public Boolean value() {
    return variable;
  }

  @Override
  public String toString() {
    return "+var:{" + value() + "} ";
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
