package edu.brown.cs.student.main;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StarTest {
  @Test
  public void testAccess() {
    Star test = new Star(0, "testStar", 3.3, 2.2, 1.1);
    assertEquals(test.getID(), 0);
    assertEquals(test.getName(), "testStar");
    assertEquals(test.getX(), 3.3, 0.01);
    assertEquals(test.getY(), 2.2, 0.01);
    assertEquals(test.getZ(), 1.1, 0.01);
  }

  public void testSet() {
    Star test = new Star(0, "testStar", 3.3, 2.2, 1.1);
    test.setDistance(12.23);
    assertEquals(test.getDistance(), 12.23, 0.01);
  }
}
