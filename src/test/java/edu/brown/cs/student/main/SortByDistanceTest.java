package edu.brown.cs.student.main;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SortByDistanceTest {
  @Test
  public void testCompare() {
    SortByDistance sbd = new SortByDistance();
    Star a = new Star(0, "a", 0, 2, 1);
    Star b = new Star(1, "b", 3, 2, 1);
    a.setDistance(3.3);
    b.setDistance(2.1);
    int res = sbd.compare(a, b);
    assertEquals(res, 1);
  }
}
