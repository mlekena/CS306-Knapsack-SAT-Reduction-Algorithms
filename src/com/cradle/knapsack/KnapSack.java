/**
 * 
 */
package com.cradle.knapsack;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Modupe Theko Lekena
 *
 */
public class KnapSack {

  public KnapSack() {};

  public static int zeroOne(KnapSackItem[] items, int cap) {
    int[][] solution = new int[items.length + 1][cap + 1];

    for (int itemIndex = items.length - 1; itemIndex > 0; itemIndex--) {
      for (int currentCapacity = 1; currentCapacity <= cap; currentCapacity++) {
        if (items[itemIndex].cost() > currentCapacity) {
          solution[itemIndex][currentCapacity] = solution[itemIndex + 1][currentCapacity];
        } else {
          solution[itemIndex][currentCapacity] =
              Math.max((solution[itemIndex + 1][currentCapacity - items[itemIndex].cost()]
                  + items[itemIndex].value()), solution[itemIndex + 1][currentCapacity]);
        }
      }
    } // end of double loop

    return solution[1][cap];
  }

  public static int solveMaxKnapSack(KnapSackItem[] items, int budget) {
    KnapSackItem largest = items[0];
    for (int x = 1; x < items.length; x++) {
      if (items[x].value() > largest.value()) {
        largest = items[x];
      }
    } // end of finding largest
    int maxN = items.length * largest.value();
    int[][] minCost = new int[items.length][maxN];
    boolean[][] take = new boolean[items.length][maxN];

    for (int z = 0; z <= items[0].value(); z++) {
      minCost[0][z] = items[0].cost();
      take[0][z] = true;
    }

    for (int z = items[0].value() + 1; z < maxN; z++) {
      minCost[0][z] = Integer.MAX_VALUE - maxN * 3;
      take[0][z] = false;
    }

    for (int i = 1; i < items.length; i++) {
      for (int t = 0; t < maxN; t++) {
        int nextT = Math.max(0, t - items[i].value());
        if (minCost[i - 1][t] <= items[i].cost() + minCost[i - 1][nextT]) {
          minCost[i][t] = minCost[i - 1][t];
          take[i][t] = false;
        } else {
          minCost[i][t] = items[i].cost() + minCost[i - 1][nextT];
          take[i][t] = true;
        }
      }
    }
    return constructMaxKnapsackSolution(items, budget, minCost, take);
  }

  private static int constructMaxKnapsackSolution(KnapSackItem[] items, int budget, int[][] minCost,
      boolean[][] take) {
    int largestIndex = 0;
    for (int x = 1; x < items.length; x++) {
      if (items[x].value() > items[largestIndex].value()) {
        largestIndex = x;
      }
    } // end of finding largest

    int optimalValue = items.length * items[largestIndex].value();
    while (optimalValue > 0 && minCost[items.length - 1][optimalValue - 1] > budget) {
      optimalValue--;
    }

    ArrayList<KnapSackItem> solution = new ArrayList<KnapSackItem>();
    int i = items.length - 1;
    int t = optimalValue;
    while (i > 0 && t > 0) {
      if (take[i][t] == true) {
        solution.add(items[i]);
        t -= items[i].value();
      }
      i -= 1;
    }
    // System.out.println("ITEMS SELECTED BY SolveMAX");
    // System.out.println(solution);
    return optimalValue;
  }

  public static int modifiedGreedyKnapsack(KnapSackItem[] items, int budget) {
    ArrayList<KnapSackItem> selected = new ArrayList<KnapSackItem>();
    Arrays.sort(items);
//    System.out.println(Arrays.toString(items));
    double leftOver = (double) budget;
    for (KnapSackItem item : items) {
      if (item.cost() <= leftOver) {
        selected.add(item);
        leftOver -= item.cost();
      }
    }
//    System.out.println(selected);
    KnapSackItem maxItem = items[0];
    int sum = 0;
    for (int i = 0; i < selected.size(); i++) {
      sum += selected.get(i).value();
    }
    if (maxItem.value() > sum) {
      return maxItem.value();
    }
    return sum;
  }

  public static int knapsackApproxScheme(KnapSackItem[] items, int targetValue, double scaling) {
    KnapSackItem largest = items[0];
    for (int x = 1; x < items.length; x++) {
      if (items[x].value() > largest.value()) {
        largest = items[x];
      }
    }
    scaling = scaling * ((double)largest.value()/items.length);
    for (KnapSackItem item : items) {
      item.setAlternateValue((int)Math.floor((item.value()/ scaling)));
      item.useAlternateValue();
    }
    return solveMaxKnapSack(items, targetValue);// targetValue);
  }

  /*
   * class SolveMaxResults { public int[][] minCost; public boolean[][] take;
   * 
   * public SolveMaxResults(int[][] mc, boolean[][] t) { minCost = mc; take = t; } }
   */
}
