package figures;

public class Square extends GeometricFigure{
    //Attributes
    private double side;
    
    // Constructors
    public Square(double side) {
        this.side = side;
    }

    //Methods
    public double calculateArea(){
        return side * side;
    }
    //Setters and getters

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    //ToString
    // Redundant since the getter already shows all the information the object contain because its only one.
}
