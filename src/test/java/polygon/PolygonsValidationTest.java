package polygon;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PolygonsValidationTest {

    @Test
    public void testValidPolygonTriangle(){
        Polygon polygon = Polygon.of(10, 10, 10);
        Assertions.assertTrue(polygon.hasValidInputs());
        Assertions.assertTrue(polygon.isValidBasicRule());
    }

    @Test
    public void testValidPolygonRectangle(){
        Polygon polygon = Polygon.of(10, 10, 10, 29);
        Assertions.assertTrue(polygon.hasValidInputs());
        Assertions.assertTrue(polygon.isValidBasicRule());
    }

    @Test
    public void testValidPolygonPentagon(){
        Polygon polygon = Polygon.of(10.15556, 20.35878, 50.55554, 29.4544444115, 22.3677874554);
        Assertions.assertTrue(polygon.hasValidInputs());
        Assertions.assertTrue(polygon.isValidBasicRule());
    }

    @Test
    public void testInvalidPolygonTriangle(){
        Polygon polygon = Polygon.of(10, 40, 10);
        Assertions.assertTrue(polygon.hasValidInputs());
        Assertions.assertFalse(polygon.isValidBasicRule());

    }

    @Test
    public void testInvalidPolygonRectangle(){
        Polygon polygon = Polygon.of(10.23, 100, 10, 29);
        Assertions.assertTrue(polygon.hasValidInputs());
        Assertions.assertFalse(polygon.isValidBasicRule());
    }

    @Test
    public void testInvalidPolygonPentagon(){
        Polygon polygon = Polygon.of(10, 20, 50, 99, 15);
        Assertions.assertTrue(polygon.hasValidInputs());
        Assertions.assertFalse(polygon.isValidBasicRule());
    }

    @Test
    public void testInvalidInputPolygonTriangle(){
        Polygon polygon = Polygon.of(-10, 40, 10);
        Assertions.assertFalse(polygon.hasValidInputs());
    }

    @Test
    public void testInvalidInputPolygonRectangle(){
        Polygon polygon = Polygon.of(10, 0, 10, 29);
        Assertions.assertFalse(polygon.hasValidInputs());
    }

    @Test
    public void testInvalidInputPolygonPentagon(){
        Polygon polygon = Polygon.of(10, 20, 50, 0, 0);
        Assertions.assertFalse(polygon.hasValidInputs());
    }


}
