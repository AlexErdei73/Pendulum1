public class Pendulum1 {
    public static void main(String[] args) {
        double angleInDegree = 1;
        try {
            angleInDegree = Double.parseDouble(args[0]);
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
            System.out.println("Missing command line parameter");
            System.out.println("Default angle = " + angleInDegree + " degrees");
        }
        new Simulation(angleInDegree / 180 * Math.PI, 0);
    }
}
