package edu.brown.cs.student.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CsvStore {
  private ArrayList<Star> stars;
  private int numStars = 0;

  /*
  @param filepath: file path to a csv file to load stars from.
  @exception: FileNotFoundException: filepath does not lead to a file.
   */
  public CsvStore(String filepath) throws FileNotFoundException {
    stars = new ArrayList<Star>();
    Scanner sc = new Scanner(new File(filepath));
    sc.useDelimiter("\n");
    while (sc.hasNext()) {
      String tr = sc.next();
      String[] trSplit = tr.split(",");
      if (trSplit[0].equals("StarID")) {
        continue;
      } else {
        int id = Integer.parseInt(trSplit[0]);
        String name = trSplit[1];
        double xValue = Double.parseDouble(trSplit[2]);
        double yValue = Double.parseDouble(trSplit[3]);
        double zValue = Double.parseDouble(trSplit[4]);
        Star toInsert = new Star(id, name, xValue, yValue, zValue);
        stars.add(toInsert);
        numStars++;
      }
    }
  }

  /*
  @return: returns the number of stars currently loaded.
   */
  public int getNumStars() {
    return numStars;
  }

  /*
  @param *1: * value of first location
  @param *2: * value of second location
  @return: straight line distance between two locations.
   */
  public double findDistance(double x1, double x2, double y1, double y2, double z1, double z2) {
    double xdiff = Math.abs(x1 - x2);
    double ydiff = Math.abs(y1 - y2);
    double zdiff = Math.abs(z1 - z2);
    return Math.sqrt((xdiff * xdiff) + (ydiff * ydiff) + (zdiff * zdiff));

  }

  /*
  @param: xValue: x value of position to find from.
  @param: yValue: y value of position to find from.
  @param: zValue: z value of position to find from.
  @param: k: number of neighbors to return
  @return: formatted string of the k closest stars to (xValue, yValue, zValue).
   */
  public String findFromPosition(double xValue, double yValue, double zValue, int k) {
    for (int i = 0; i < stars.size(); i++) {
      Star curStar = stars.get(i);
      curStar.setDistance(findDistance(xValue, curStar.getX(), yValue, curStar.getY(), zValue,
          curStar.getZ()));
    }
    Collections.sort(stars, new SortByDistance());
    String ret = "";
    for (int i = 0; i < k && i < stars.size(); i++) {
      ret += stars.get(i).getID() + "\n";
    }
    return ret;
  }

  /*
  @param: name: name of star to find closest neighbors to.
  @param: k: number of nearest neighbors to find.
  @return: formatted string of the k closest stars to the star with name name.
   */
  public String findFromName(String name, int k) {
    if (k + 1 > this.numStars) {
      return "";
    }
    Star startStar = new Star(-1, "", 0, 0, 0);
    for (Star s : stars) {
      if (s.getName().equals(name)) {
        startStar = s;
        break;
      }
    }
    if (startStar.getID() == -1) {
      return "ERROR: name not found\n";
    }
    String unCut = findFromPosition(startStar.getX(), startStar.getY(), startStar.getZ(), k + 1);
    return unCut.substring(unCut.indexOf('\n') + 1);
  }
}
