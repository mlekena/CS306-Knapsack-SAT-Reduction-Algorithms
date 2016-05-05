/**
 * 
 */
package com.cradle.knapsack;

/**
 * @author Modupe Theko Lekena
 *
 */
public interface KnapSackItem {
  public <T extends Number> T value();

  public <T extends Number> T cost();

  public <T extends Number> T valuePerCost();
}
