package edu.brown.cs.student.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CsvStore {
  private ArrayList<Star> stars;
  private int numStars = 0;
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
        Star toInsert = new Star(id, "\"" + name + "\"", xValue, yValue, zValue);
        stars.add(toInsert);
        numStars++;
      }
    }
  }

  public int getNumStars() {
    return numStars;
  }
  public double findDistance(double x1, double x2, double y1, double y2, double z1, double z2) {
    double xdiff = Math.abs(x1 - x2);
    double ydiff = Math.abs(y1 - y2);
    double zdiff = Math.abs(z1 - z2);
    return Math.sqrt((xdiff * xdiff) + (ydiff * ydiff) + (zdiff * zdiff));

  }
  public String findFromPosition(double xValue, double yValue, double zValue, int k) {
    for (int i = 0; i < stars.size(); i++) {
      Star curStar = stars.get(i);
      curStar.setDistance(findDistance(xValue, curStar.getX(), yValue, curStar.getY(), zValue,
          curStar.getZ()));
    }
    Collections.sort(stars, new SortByDistance());
    String ret = "";
    for (int i = 0; i < k; i++) {
      ret += stars.get(i).getID() + "\n";
    }
    return ret;
  }
  public String findFromName(String name, int k) {
    if (k + 1 > this.numStars) {
      return "";
    }
    Star startStar = null;
    for (int i = 0; i < stars.size(); i++) {
      Star curStar = stars.get(i);
      if (curStar.getName().equals(name)) {
        startStar = curStar;
      }
    }
    String unCut = findFromPosition(startStar.getX(), startStar.getY(), startStar.getZ(), k + 1);
    return unCut.substring(unCut.indexOf('\n') + 1);
  }
}
