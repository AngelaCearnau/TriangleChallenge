package polygon;

public abstract class Triangle{

    public enum TriangleType{
        EQUILATERAL,
        ISOSCELES,
        SCALENE
    }

    protected final double a;
    protected final double b;
    protected final double c;


    Triangle(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;

    }

    public abstract TriangleType getType();

    @Override
    public String toString() {
        return "Triangle with sides: " + this.a + " | " + this.b + " | " + this.c;
    }


    public static boolean isValidTriangle(double a, double b, double c){

        Polygon polygon = Polygon.of(a, b, c);

        if (polygon.hasValidInputs()){
            if (polygon.isValidBasicRule()){
                return true;
            } else { throw new IllegalArgumentException("Provided lengths do not form a valid triangle"); }
        } else { throw new IllegalArgumentException("Provided lengths should contain only positive values"); }

    }

}
