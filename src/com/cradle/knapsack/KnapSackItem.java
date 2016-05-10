/**
 * 
 */
package com.cradle.knapsack;

/**
 * @author Modupe Theko Lekena
 *
 */
public interface KnapSackItem {
  public int value();

  public int cost();

  public double valuePerCost();
  
  public void setAlternateValue(int value);
  
  public void useAlternateValue();
  
  public void useOriginalValue();
}
