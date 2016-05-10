/**
 * 
 */
package com.cradle.main;

import java.util.Date;
import java.util.Random;

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
    Boolean[] vars = new Boolean[] {new Boolean(true), new Boolean(true), new Boolean(true)};
    int numberOfClauses = 2;
    ThreeSAT _3sat = new ThreeSAT(vars, numberOfClauses);

    System.out.println(_3sat);
    
    OneInThreeSAT oitsat = OneInThreeSAT.toOneInThreeSAT(_3sat);
    System.out.println(oitsat);

  }
}
