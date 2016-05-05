/**
 * 
 */
package com.cradle.sat;

/**
 * @author Modupe Theko Lekena
 *
 */
public interface Var {
  public Boolean value();

  public String toString();

  public void flip();

  public void setTrue();

  public void setFalse();
}
