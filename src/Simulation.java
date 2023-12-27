import java.text.DecimalFormat;

public class Simulation {
  private double t1 = -1; // Negative values are invalid
  private double t2 = -1;
  Simulation(double theta0, double omega0) {
    double theta, thetaMid, thetaPrev, omega, omegaMid, alpha, alphaMid, t, dt, tmax;
    t = 0;
    dt = 0.01;
    tmax = 100;
    Plot plot = new Plot("Theta in function of t", 0, 100, 1, -0.5, 0.5, 0.1);
    plot.setPointSize(1);
    theta = theta0;
    omega = omega0;
    while (t < tmax) {
      alpha = -Math.sin(theta);
      thetaMid = theta + omega * 0.5 * dt;
      omegaMid = omega + alpha * 0.5 * dt;
      alphaMid = -Math.sin(thetaMid);
      thetaPrev = theta;
      theta += omegaMid * dt;
      omega += alphaMid * dt;
      t += dt;
      this.recordTimeAtZeroTheta(theta, thetaPrev, t, omega);
      plot.addPoint(t, theta);
    }
    this.showPeriod();
  }

  private void recordTimeAtZeroTheta(double thetaPrev, double theta, double t, double omega) {
    if (this.t1 > 0 && this.t2 > 0) return;
    double timeToRecord = -1;
    if (theta == 0) timeToRecord = t;
    if ((theta > 0 && thetaPrev < 0) || (theta < 0 && thetaPrev > 0))
      timeToRecord = this.correctTime(t, theta, omega);
    if (timeToRecord < 0) return;
    if (this.t1 < 0) {
      this.t1 = timeToRecord;
      return;
    }
    if (this.t2 < 0) this.t2 = timeToRecord;
  }

  private double correctTime(double t, double theta, double omega) {
    return t - theta / omega;
  }

  private void showPeriod() {
    double T = 2 * (this.t2 -this.t1);
    DecimalFormat threeDecimals = new DecimalFormat("0.000");
    System.out.println("Period = " + threeDecimals.format(T));
  }
}
