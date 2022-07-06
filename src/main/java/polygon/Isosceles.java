package polygon;

public class Isosceles extends Triangle{

    protected Isosceles(double a, double b, double c) {
        super(a, b, c);
    }

    @Override
    public TriangleType getType() {
        return TriangleType.ISOSCELES;
    }

    final static boolean isValidIsosceles(double a, double b, double c){

        return (Double.compare(a,b) == 0 || Double.compare(b,c) == 0 || Double.compare(a,c) == 0) ;
    }
}
