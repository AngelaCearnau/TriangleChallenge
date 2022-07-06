package polygon;

public class Equilateral extends Triangle{

    protected Equilateral(Double a, Double b, Double c) {
        super(a, b, c);
    }

    @Override
    public TriangleType getType() {
        return TriangleType.EQUILATERAL;
    }

    final static boolean isValidEquilateral(Double a, Double b, Double c){
        return (Double.compare(a,b) == 0 && Double.compare(b,c) == 0) ;
    }

}
