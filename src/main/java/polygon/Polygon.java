package polygon;

import java.util.*;
import java.util.stream.Collectors;

public class Polygon {

    private ArrayList<Double> sides;

    private Polygon() {
    }

    private Polygon(ArrayList<Double> sides) {
        this.sides = sides;
    }

    public static Polygon of(double... sides) {
        if (sides == null || sides.length <= 2) {
            throw new IllegalArgumentException("Polygon with " + sides.length + " sides is invalid");
        }
        ArrayList<Double> sidesList = new ArrayList<>();
        for (double str : sides) {
            sidesList.add(str);
        }
        return new Polygon(sidesList);

    }

    public Double getSide(int index) {
        return sides.get(index);
    }


    /*check the bigger side rule
     smaller sides are greater than the largest side*/
    protected boolean isValidBasicRule(){
        //find the biggest side
        List<Double> sortedList = sides.stream().sorted().collect(Collectors.toList());
        Double maxLength = sortedList.get(sortedList.size()-1);

        Double totalSum = sides.stream()
                .mapToDouble(Double::doubleValue)
                .sum();
        Double sumExceptOneSide = totalSum -maxLength;
        if (sumExceptOneSide.compareTo(maxLength) <= 0) {  //one side is equal to or bigger then the sum of the rest of sides
            return false;
        }
        return true;
    }

    protected boolean hasValidInputs() {

        //check for negative values
        if (sides.stream().anyMatch(i -> i <= 0)) {
            return false;
        }
        return true;
    }


}
