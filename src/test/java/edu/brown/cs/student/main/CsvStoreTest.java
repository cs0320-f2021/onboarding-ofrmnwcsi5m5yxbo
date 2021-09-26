package edu.brown.cs.student.main;

import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.assertEquals;

public class CsvStoreTest {
  @Test
  public void testConstructor() throws FileNotFoundException {
    CsvStore csv = new CsvStore("data/stars/ten-star.csv");
    assertEquals(csv.getNumStars(), 10, 0.01);
  }
  @Test
  public void testFindDistance() throws FileNotFoundException {
    CsvStore csv = new CsvStore("data/stars/ten-star.csv");
    double res = csv.findDistance(0.0, 1.0, 0.0, 1.0, 0.0, 1.0);
    assertEquals(res, 1.732, 0.01);
    res = csv.findDistance(0.0, 0.0, 0.0, 0.0, 0.0, 0.0);
    assertEquals(res, 0, 0.01);
    res = csv.findDistance(0.0, 0.0, 0.0, 10.0, 0.0, 0.0);
    assertEquals(res, 10.0, 0.01);
    res = csv.findDistance(0.0, 10.0, 0.0, 10.0, 0.0, 0.0);
    assertEquals(res, 14.142, 0.01);
    res = csv.findDistance(5.0, 2.0, 3.0, 8.0, 9.0, 1.0);
    assertEquals(res, 9.899, 0.01);
  }
  @Test
  public void testFindFromPosition() throws FileNotFoundException {
    CsvStore csv = new CsvStore("data/stars/ten-star.csv");
    String res = csv.findFromPosition(0, 0, 0, 1);
    assertEquals(res, "0\n");
    res = csv.findFromPosition(10.0, 10.0, 10.0, 1);
    assertEquals(res, "3759\n");
    res = csv.findFromPosition(0, 0, 0, 3);
    assertEquals(res, "0\n70667\n71454\n");
  }
  @Test
  public void testFindFromName() throws FileNotFoundException {
    CsvStore csv = new CsvStore("data/stars/ten-star.csv");
    String res = csv.findFromName("Sol", 1);
    assertEquals(res, "70667\n");
    res = csv.findFromName("Proxima Centauri", 3);
    assertEquals(res, "71454\n71457\n0\n");
    res = csv.findFromName("Barnard's Star", 1);
    assertEquals(res, "0\n");
  }

}
