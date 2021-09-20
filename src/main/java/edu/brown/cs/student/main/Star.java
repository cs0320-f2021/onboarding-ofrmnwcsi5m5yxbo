package edu.brown.cs.student.main;

public class Star {
  private int id;
  private String name;
  private double xValue;
  private double yValue;
  private double zValue;
  private double distance = Double.MAX_VALUE;
  /*
  @param: id: id of the star
  @param: name: name of the star.
  @param: xValue: x value of the location of the star
  @param: yValue: y value of the location of the star
  @param: zValue: z value of the location of the star
   */
  public Star(int id, String name, double xValue, double yValue, double zValue) {
    this.id = id;
    this.name = name;
    this.xValue = xValue;
    this.yValue = yValue;
    this.zValue = zValue;
  }

  /*
  @return: id of this star.
   */
  public int getID() {
    return id;
  }
  /*
  @return: name of this star.
   */
  public String getName() {
    return name;
  }
  /*
  @return: x value of the location of this star.
   */
  public double getX() {
    return xValue;
  }
  /*
  @return y value of the location of this star.
   */
  public double getY() {
    return yValue;
  }
  /*
  @return z value of the location of this star.
   */
  public double getZ() {
    return zValue;
  }
  /*
  @return distance from this star to a target star.
   */
  public double getDistance() {
    return distance;
  }
  /*
  @param distance: distance from this star to a target star.
   */
  public void setDistance(double distance) {
    this.distance = distance;
  }
}
