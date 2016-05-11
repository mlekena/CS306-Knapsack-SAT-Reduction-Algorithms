/**
 * 
 */
package com.cradle.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Random;

import com.cradle.knapsack.KnapSack;
import com.cradle.knapsack.RandomItem;
import com.cradle.sat.Clause;
import com.cradle.sat.OneInThreeSAT;
import com.cradle.sat.ThreeSAT;

/**
 * @author Modupe Theko Lekena
 * 
 *
 */
public class Main {

  /**
   * @param args
   */
  public static void main(String[] args) {
    System.out.println("KNAPSACK GOODNESS" + System.lineSeparator());

    ArrayList<Integer> dynamKnap = new ArrayList<Integer>();
    ArrayList<Integer> minCostKnap = new ArrayList<Integer>();
    ArrayList<Integer> greedyKnap = new ArrayList<Integer>();
    ArrayList<Integer> polyKnap = new ArrayList<Integer>();
    
    for (int i = 0; i < 100; i++){
      int length = 30;
      int budget_target = 100;
      int scaling = 2;
      RandomItem[] items = new RandomItem[length];
      for (int noOfItems = 0; noOfItems < length; noOfItems++) {
        items[noOfItems] = RandomItem.nextRandomItem();
      }
      
      if (i == 10){
        System.out.println(Arrays.toString(items));
      }
      
      dynamKnap.add(KnapSack.zeroOne(items, budget_target));
      minCostKnap.add(KnapSack.solveMaxKnapSack(items, budget_target));
      greedyKnap.add(KnapSack.modifiedGreedyKnapsack(items, budget_target));
      polyKnap.add(KnapSack.knapsackApproxScheme(items, budget_target, scaling ));
      
    }
    System.out.println("O(nW) Dynamic Programming Knapsack Solutions");
    System.out.println(dynamKnap);
    dataAnalysis(dynamKnap);
    System.out.println("MinCost Dynamic Programming Knapsack Solutions");
    System.out.println(minCostKnap);
    dataAnalysis(minCostKnap);
    System.out.println("Greedy 2-approximation Knapsack Solutions");
    System.out.println(greedyKnap);
    dataAnalysis(greedyKnap);
    System.out.println("Fully Polynomial Time Approximation KnapSack Solutions");
    System.out.println(polyKnap);
    dataAnalysis(polyKnap);
    
    ArrayList<Double> timeFor3To3In1 = new ArrayList<Double>();
    for (int i = 0; i < 100; i++){
      Boolean[] variables = new Boolean[]{true, false, true, false, true, false, true, false};
      int noOfClauses = 10;
      
      long startTime = System.nanoTime();
      ThreeSAT ts = new ThreeSAT(variables,noOfClauses);
      OneInThreeSAT oitsat = OneInThreeSAT.toOneInThreeSAT(ts);
      long endTime = System.nanoTime();
      
      timeFor3To3In1.add(((endTime - startTime)/1000000.0));
      if (i == 50){
        System.out.println("THREESAT INSTANCE SAMPLE");
        System.out.println(ts);
        System.out.println();
        System.out.println("1 in 3 SAT INSTANCE FROM ABOVE 3 SAT SAMPLE");
        System.out.println(oitsat);
      }
    }
    
    System.out.println("Reporting on 3 SAT to One IN Three SAT");
    dataAnalysisSAT(timeFor3To3In1);
    
   /* int length = 10;
    int budget_target = 20;
    RandomItem[] items = new RandomItem[length];
    for (int i = 0; i < length; i++) {
      items[i] = RandomItem.nextRandomItem();
    }
    System.out.println(Arrays.toString(items));
    System.out.println("ZERO ONE SOLUTION = " + KnapSack.zeroOne(items, budget_target));

    System.out.println("SOLVE MAXIMUM KNAPSACK");
    System.out.println("solution + " + KnapSack.solveMaxKnapSack(items, budget_target));

    int modGreedy = KnapSack.modifiedGreedyKnapsack(items, budget_target);
    System.out.println("GREEDY SOLUTION = " + modGreedy);

    System.out.println("Knapsack Approximation Scheme");
    System.out.println("Solution = " + KnapSack.knapsackApproxScheme(items, budget_target, 2));
    System.out.println();
    
    System.out.println("SAT INSTANCE REDUCTIONS" + System.lineSeparator());
    Boolean[] vars = new Boolean[] {new Boolean(true), new Boolean(true), new Boolean(true)};
    int numberOfClauses = 2;
    ThreeSAT _3sat = new ThreeSAT(vars, numberOfClauses);

    System.out.println(_3sat);

    OneInThreeSAT oitsat = OneInThreeSAT.toOneInThreeSAT(_3sat);
    System.out.println(oitsat);
*/
  }
  
  private static void dataAnalysis(ArrayList<Integer> dataPoints){
    Collections.sort(dataPoints);
    System.out.println("MIN = " + dataPoints.get(0));
    System.out.println("Max = " + dataPoints.get(dataPoints.size()-1));
    System.out.println("Median = " + dataPoints.get(dataPoints.size()/2));
    int sum = 0;
    for (int i = 0; i < dataPoints.size(); i++){
      sum += dataPoints.get(i);
    }
    System.out.println("Average = " + (sum/dataPoints.size()));
    System.out.println();
  }
  
  private static void dataAnalysisSAT(ArrayList<Double> dataPoints){
    Collections.sort(dataPoints);
    System.out.println(dataPoints);
    System.out.println("MIN = " + dataPoints.get(0));
    System.out.println("Max = " + dataPoints.get(dataPoints.size()-1));
    System.out.println("Median = " + dataPoints.get(dataPoints.size()/2));
    double sum = 0;
    for (int i = 0; i < dataPoints.size(); i++){
      sum += dataPoints.get(i);
    }
    System.out.println("Average = " + (sum/dataPoints.size()));
    System.out.println();
  }
}
