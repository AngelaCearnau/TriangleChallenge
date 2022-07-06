# TriangleChallenge

determine the type of triangle (equilateral, isosceles or scalene) based on input values.

Solution:
- built with gradle 
- doesn't have a main class for taking input, only tests 

## TriangleFactory class with static factory method 
Validates input and decides on the type of triangle, and returns a triangle.

## Triangle abstract class 
contains:
- an enum for triangle types
- abstract method getType, which is implemented in classes Scalene, Equilateral and Isosceles   
- method to validate the triangle. This method is based on more general validation methods implemented in the class Polygon for any type of polygon

## Polygon class
- private constructor, static public method, with variable-length arguments, to create any polygon with any number of sides
- methods for validating any polygon:
1. valid input data, sides > 0
2. "the bigger side rule" - a polygon is valid if the bigger side is smaller then the sum of the rest of the sides. 
Triangle is a polygon, therfore this rule is sufficient to decide if the triangle is valid or not.
This class can be used for other polygons (rectagles, pentagons etc) as well


# Tests:
1. for testing the class that decides on the type of triangle: 
- validate expected type of triangle or expected exceptions
- methods use Parameterized-Test JUnit feature to execute a single test method multiple times 

2. for testing the results of the Polygon class responsible with validation of the triangle or any other polygon

