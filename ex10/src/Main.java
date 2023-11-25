import java.util.Scanner;

class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}

class Circle {
    private double radius;
    private Point center;

    public Circle(double radius, Point center) {
        this.radius = radius;
        this.center = center;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public double surface() {
        return Math.PI * Math.pow(radius, 2);
    }

    public boolean isInternal(double x, double y) {
        double distance = Math.sqrt(Math.pow(x - center.getX(), 2) + Math.pow(y - center.getY(), 2));
        return distance <= radius;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create an array of Circle objects
        Circle[] circles = new Circle[3];

        // Instantiate Circle objects and set their attributes
        for (int i = 0; i < circles.length; i++) {
            System.out.println("Enter radius for Circle " + (i + 1) + ": ");
            double radius = scanner.nextDouble();

            System.out.println("Enter x-coordinate for the center of Circle " + (i + 1) + ": ");
            double x = scanner.nextDouble();

            System.out.println("Enter y-coordinate for the center of Circle " + (i + 1) + ": ");
            double y = scanner.nextDouble();

            circles[i] = new Circle(radius, new Point(x, y));
        }

        // Test surface and isInternal methods
        for (int i = 0; i < circles.length; i++) {
            System.out.println("Surface of Circle " + (i + 1) + ": " + circles[i].surface());

            System.out.println("Enter x-coordinate for a point: ");
            double testX = scanner.nextDouble();

            System.out.println("Enter y-coordinate for a point: ");
            double testY = scanner.nextDouble();

            if (circles[i].isInternal(testX, testY)) {
                System.out.println("(" + testX + ", " + testY + ") is inside Circle " + (i + 1));
            } else {
                System.out.println("(" + testX + ", " + testY + ") is outside Circle " + (i + 1));
            }
        }
    }
}
