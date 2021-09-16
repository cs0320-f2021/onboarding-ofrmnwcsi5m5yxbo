package edu.brown.cs.student.main;

import java.util.Comparator;

public class SortByDistance implements Comparator<Star> {
  static final double PNT = 0.5;
  public int compare(Star a, Star b) {
    if (a.getDistance() < b.getDistance()) {
      return -1;
    } else if (a.getDistance() > b.getDistance()) {
      return 1;
    } else {
      double rand = Math.random();
      if (rand >= PNT) {
        return 1;
      } else {
        return -1;
      }
    }
  }
}
