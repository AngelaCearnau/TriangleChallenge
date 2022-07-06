package polygon;

public class TriangleFactory {

    public static Triangle createTriangle(double a, double b, double c){

        if (!Triangle.isValidTriangle(a,b,c)){
            throw new IllegalArgumentException("Not a valid triangle");
        }

        Triangle triangle;

        if (Equilateral.isValidEquilateral(a, b, c)) {
            triangle = new Equilateral(a, b, c);
        } else if (Isosceles.isValidIsosceles(a, b, c)) {
            triangle = new Isosceles(a, b, c);
        } else {
            triangle = new Scalene(a, b, c);
        }

        return triangle;
    }
}
