package polygon;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TriangleFactoryValidationTest {


    @ParameterizedTest
    @CsvSource({
            "0.4,0.4,0.5",
            "4,5,4",
            "2.65,5,2.65",
            "3,10,10"
    })
    public void testValidIsosceles(double lengthSideA, double lengthSideB, double lengthSideC){
        Triangle triangle = TriangleFactory.createTriangle(lengthSideA,lengthSideB,lengthSideC);
        System.out.println("---Verify " + triangle);
        Assertions.assertEquals(Triangle.TriangleType.ISOSCELES, triangle.getType());
    }

    @ParameterizedTest
    @CsvSource({
            "0.14,0.14,0.14",
            "48,48,48.0",
            "2.67,2.67,2.67",
            "10,10,10"
    })
    public void testValidEquilateral(double lengthSideA, double lengthSideB, double lengthSideC){
        Triangle triangle = TriangleFactory.createTriangle(lengthSideA,lengthSideB,lengthSideC);
        System.out.println("---Verify " + triangle);
        Assertions.assertEquals(Triangle.TriangleType.EQUILATERAL, triangle.getType());
    }

    @ParameterizedTest
    @CsvSource({
            "0.143,0.243,0.141",
            "48,58,68.0",
            "5.67,2.67,3.67",
            "12,15,18",
            "12,15,26"
    })
    public void testValidScalene(double lengthSideA, double lengthSideB, double lengthSideC){
        Triangle triangle = TriangleFactory.createTriangle(lengthSideA,lengthSideB,lengthSideC);
        System.out.println("---Verify " + triangle);
        Assertions.assertEquals(Triangle.TriangleType.SCALENE, triangle.getType());
    }

    @ParameterizedTest
    @CsvSource({
            "-1,1,1",
            "-2,-2,2",
            "3,3,-3",
            "0,5,5",
            "1,0,1",
            "0.00,0.00,0.00"
    })
    public void testInvalidParams(double lengthSideA, double lengthSideB, double lengthSideC){
        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            TriangleFactory.createTriangle(lengthSideA,lengthSideB,lengthSideC);
        });
        Assertions.assertEquals("Provided lengths should contain only positive values", exception.getMessage());

    }

    @ParameterizedTest
    @CsvSource({
            "10.00,2,3",
            "12,15,27",
            "5,3,8",
            "1.00,2.00,3.00"
    })
    public void testInvalidTriangle(double lengthSideA, double lengthSideB, double lengthSideC){
        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            TriangleFactory.createTriangle(lengthSideA,lengthSideB,lengthSideC);
        });
        Assertions.assertEquals("Provided lengths do not form a valid triangle", exception.getMessage());

    }


    @Test
    public void testTriangleBoundaryLimits(){

        Triangle triangle = TriangleFactory.createTriangle(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE);
        System.out.println("---Verify " + triangle);
        Assertions.assertEquals(Triangle.TriangleType.EQUILATERAL, triangle.getType());

    }

    @Test
    public void testTriangleBoundaryLimitsInvalidTriangle(){

        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            TriangleFactory.createTriangle(Double.MAX_VALUE, 200, 100);
        });
        Assertions.assertEquals("Provided lengths do not form a valid triangle", exception.getMessage());
    }

}
