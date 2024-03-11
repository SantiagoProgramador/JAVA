package figures;

public class Circle extends GeometricFigure{
    // Attributes
    private double radius;
    // Constructors
    public Circle(double radius) {
        this.radius = radius;
    }
    // Methods
    public double calculateArea(){
        return Math.PI * (radius * radius);
    }
    // Setters and getters
    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
    // ToString
    // Redundant since the getter already shows all the information the object contain because its only one.

}
