public class Simulation {
  Simulation(double theta0, double omega0) {
    double theta, omega, alpha, t, dt, tmax;
    t = 0;
    dt = 0.01;
    tmax = 100;
    Plot plot = new Plot("Theta in function of t", 0, 100, 1, -0.5, 0.5, 0.1);
    plot.setPointSize(1);
    theta = theta0;
    omega = omega0;
    while (t < tmax) {
      alpha = -Math.sin(theta);
      theta += omega * dt;
      omega += alpha * dt;
      t += dt;
      plot.addPoint(t, theta);
    }
  }
}
