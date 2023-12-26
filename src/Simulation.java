public class Simulation {
  Simulation(double theta0, double omega0) {
    double theta, thetaMid, omega, omegaMid, alpha, alphaMid, t, dt, tmax;
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
      theta += omegaMid * dt;
      omega += alphaMid * dt;
      t += dt;
      plot.addPoint(t, theta);
    }
  }
}
