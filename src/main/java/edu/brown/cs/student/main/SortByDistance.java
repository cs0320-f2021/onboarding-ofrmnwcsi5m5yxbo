package edu.brown.cs.student.main;

import java.util.Comparator;

public class SortByDistance implements Comparator<Star> {
  static final double THRESH = 0.5;

  /*
  @param: a: first star to be compared
  @param b: second star to be compared
  @return: -1 if the result of a.getDistance() is less than the result of b.getDistance(); 1 if
  the result is greater, and randomly 1 or -1 if the result is the same.
   */
  public int compare(Star a, Star b) {
    if (a.getDistance() < b.getDistance()) {
      return -1;
    } else if (a.getDistance() > b.getDistance()) {
      return 1;
    } else {
      double rand = Math.random();
      if (rand >= THRESH) {
        return 1;
      } else {
        return -1;
      }
    }
  }
}
