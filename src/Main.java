import java.awt.*;
import java.util.Scanner;


// Main class that contains the program's entry point
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Create an array to hold multiple triangles
        System.out.print("Enter the number of triangles  ");
        int numTriangles = scanner.nextInt();
        Triangle[] triangles = new Triangle[numTriangles];

        for (int i = 0; i < numTriangles; i++) {
            // Create Point objects for each vertex
            System.out.println("Enter the coordinates for Triangle " + (i + 1));
            Point p1 = createPoint(scanner);
            Point p2 = createPoint(scanner);
            Point p3 = createPoint(scanner);
            triangles[i] = new Triangle(p1, p2, p3);
            // Create a Triangle object with the specified vertices
            double perimeter = triangles[i].calculatePerimeter();
            // Calculate and display the perimeter of the triangle
            System.out.println("Perimeter of Triangle " + (i + 1) + ": " + perimeter);
            // Check if the triangle is isosceles and display the result
            if (triangles[i].isIsosceles()) {
                System.out.println("Triangle " + (i + 1) + " is isosceles");
            } else {
                System.out.println("Triangle " + (i + 1) + " is not isosceles");
            }
        }
        System.out.println("Enter the coordinates of a point to check if it's inside a triangle:");
        // Create a Point object for the point to be checked
        Point pointToCheck = createPoint(scanner);
        // Additional functionality: Check if a point is inside a triangle
        for (int i = 0; i < numTriangles; i++) {
            if (triangles[i].isPointInside(pointToCheck)) {
                System.out.println("The point is inside Triangle " + (i + 1));

            } else {
                System.out.println("The point is not inside Triangle " + (i + 1));

            }
        }
    }
    private static Point createPoint(Scanner scanner) {
        System.out.print("Construction of a new point Please enter x :");
        double x = scanner.nextDouble();
        System.out.print("Enter y coordinate: ");
        double y = scanner.nextDouble();
        return new Point(x, y);
    }
}
class Point {
    // Define a class to represent a 2D point
    private double point_x;
    private double point_y;

    // Constructor to initialize the point with given coordinates
    public Point(double point_x, double point_y) {
        this.point_x = point_x;
        this.point_y = point_y;
    }

    public double getX() {
        return point_x;
    }

    public double getY() {
        return point_y;
    }

    public double distanceTo(Point other) {
        double dx = point_x - other.getX();
        double dy = point_y - other.getY();
        return Math.sqrt(dx * dx + dy * dy);
    }
}
class Triangle {
    // Define a class to represent a triangle using three points
    private Point[] vertices;
    // Constructor to initialize the triangle with three vertices
    public Triangle(Point p1, Point p2, Point p3) {
        vertices = new Point[]{p1, p2, p3};
    }


    // Method to calculate the perimeter of the triangle by summing the lengths of its sides
    public double calculatePerimeter() {
        double perimeter = 0;
        for (int i = 0; i < 3; i++) {
            perimeter += vertices[i].distanceTo(vertices[(i + 1) % 3]);
        }
        return perimeter;
    }
    // Method to check if the triangle is isosceles by comparing side lengths
    public boolean isIsosceles() {
        double side1 = vertices[0].distanceTo(vertices[1]);
        double side2 = vertices[1].distanceTo(vertices[2]);
        double side3 = vertices[2].distanceTo(vertices[0]);
        return side1 == side2 || side2 == side3 || side3 == side1;
    }
    // Method to check if a point is inside the triangle
    public boolean isPointInside(Point point) {
        double area = 0.5 * Math.abs(
                vertices[0].getX() * (vertices[1].getY() - vertices[2].getY()) +
                        vertices[1].getX() * (vertices[2].getY() - vertices[0].getY()) +
                        vertices[2].getX() * (vertices[0].getY() - vertices[1].getY())
        );
        double area1 = 0.5 * Math.abs(
                point.getX() * (vertices[1].getY() - vertices[2].getY()) +
                        vertices[1].getX() * (vertices[2].getY() - point.getY()) +
                        vertices[2].getX() * (point.getY() - vertices[1].getY())
        );
        double area2 = 0.5 * Math.abs(
                vertices[0].getX() * (point.getY() - vertices[2].getY()) +
                        point.getX() * (vertices[2].getY() - vertices[0].getY()) +
                        vertices[2].getX() * (vertices[0].getY() - point.getY())
        );
        double area3 = 0.5 * Math.abs(
                vertices[0].getX() * (vertices[1].getY() - point.getY()) +
                        vertices[1].getX() * (point.getY() - vertices[0].getY()) +
                        point.getX() * (vertices[0].getY() - vertices[1].getY())
        );
        double triangleArea = area1 + area2 + area3;
        return area == triangleArea;
    }
}