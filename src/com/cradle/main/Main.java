/**
 * 
 */
package com.cradle.main;

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
    ThreeSAT _3sat = new ThreeSAT();
    _3sat.add(Clause.posNegPosFactory());
    _3sat.add(Clause.negPosNegFactory());
    _3sat.add(Clause.posNegPosFactory());
    _3sat.add(Clause.negPosNegFactory());
    OneInThreeSAT.toOneInThreeSAT(_3sat);
  }

}
