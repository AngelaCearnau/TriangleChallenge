package polygon;

public class Scalene extends Triangle{

    protected Scalene(double a, double b, double c) {
        super(a, b, c);
    }

    @Override
    public TriangleType getType() {
        return TriangleType.SCALENE;
    }
}
