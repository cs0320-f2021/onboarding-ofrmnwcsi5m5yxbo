package edu.brown.cs.student.main;

public class Star {
  private int id;
  private String name;
  private double xValue;
  private double yValue;
  private double zValue;
  private double distance = Double.MAX_VALUE;
  public Star(int id, String name, double xValue, double yValue, double zValue) {
    this.id = id;
    this.name = name;
    this.xValue = xValue;
    this.yValue = yValue;
    this.zValue = zValue;
  }
  public int getID() {
    return id;
  }
  public String getName() {
    return name;
  }
  public double getX() {
    return xValue;
  }
  public double getY() {
    return yValue;
  }
  public double getZ() {
    return zValue;
  }
  public double getDistance() {
    return distance;
  }
  public void setDistance(double distance) {
    this.distance = distance;
  }
}
