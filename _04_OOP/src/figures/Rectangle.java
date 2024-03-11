package figures;

public class Rectangle extends GeometricFigure{
    //Attributes
    private double base;
    private double height;

    //Constructors
    public Rectangle( double height, double base){
        this.height = height;
        this.base = base;
    };
    //Methods
    public double calculateArea(){
        return base * height;
    }
    //Setters and getters
    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    // ToString
    @Override
    public String toString() {
        return "rectangle [base=" + base + ", height=" + height + "]";
    }
}