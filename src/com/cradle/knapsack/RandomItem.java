/**
 * 
 */
package com.cradle.knapsack;

import java.util.Date;
import java.util.Random;

/**
 * @author Modupe Theko Lekena
 *
 */
public class RandomItem implements KnapSackItem , Comparable{
  
  private int cost;
  private int value;
  private int alternateValue;
  private double valuePerCost;
  private boolean useAltinate;
  
  public RandomItem(int c, int v){
    cost = c;
    value = v;
    alternateValue = v;
    valuePerCost = ((double)v)/c;
  }
  
  public static RandomItem nextRandomItem(){
    Random rand = new Random(new Date().getTime() + new Random().nextInt());
    return new RandomItem(rand.nextInt(20) + 1, rand.nextInt(20));
  }
  
  /* (non-Javadoc)
   * @see com.cradle.knapsack.KnapSackItem#value()
   */
  @Override
  public int value() {
    if (useAltinate) return alternateValue;
    return value;
  }

  /* (non-Javadoc)
   * @see com.cradle.knapsack.KnapSackItem#cost()
   */
  @Override
  public int cost() {
    return cost;
  }

  /* (non-Javadoc)
   * @see com.cradle.knapsack.KnapSackItem#valuePerCost()
   */
  @Override
  public double valuePerCost() {
    return valuePerCost;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("RandomItem [cost=");
    builder.append(cost);
    builder.append(", value=");
    builder.append(value);
    builder.append(", valuePerCost=");
    builder.append(valuePerCost);
    builder.append("]" + System.lineSeparator());
    return builder.toString();
  }

  @Override
  public int compareTo(Object arg0) {
    if (this.valuePerCost < ((KnapSackItem)arg0).valuePerCost()){
      return 1;
    } else if (this.valuePerCost > ((KnapSackItem)arg0).valuePerCost()){
      return -1;
    }
    return 0;
  }
  @Override 
  public void setAlternateValue(int val){
    alternateValue = val;
  }
  @Override
  public void useAlternateValue(){
    useAltinate = true;
    valuePerCost = ((double)alternateValue)/cost;
  }
  @Override
   public void useOriginalValue(){
     useAltinate = false;
   }

  
  

}
