package My_Solution;

import java.util.HashMap;
import java.util.Map;

public class RC_Car {
    private String carModel;
    private String headPosition;
    private int currentPositionAtX;
    private int currentPositionAtY;
    private int lastPositionAtX;
    private int lastPositionAtY;

    private Map<String, String> cardinalDirections = new HashMap<>() {

        {
            put("N", "360");
            put("S", "180");
            put("E", "90");
            put("W", "270");

            put("360", "N");
            put("0", "N");
            put("180", "S");
            put("90", "E");
            put("270", "W");
        }
    };


    /**
     * Constructs and initializes a car object. The moment that the car object is created, its current and
     * last position is considered to be the same
     *
     * @param carModel           Model of the car; default value is given as per requirement
     * @param headPosition       current head position of the car
     * @param currentPositionAtX Based on the 2D map, the current position of the car at X-axis
     * @param currentPositionAtY Based on the 2D map, the current position of the car at Y-axis
     */
    public RC_Car(String carModel, String headPosition, int currentPositionAtX,
                  int currentPositionAtY) {

        this.carModel = "Monster_Truck";   //Default value
        this.headPosition = headPosition;
        this.currentPositionAtX = currentPositionAtX;
        this.currentPositionAtY = currentPositionAtY;
        this.lastPositionAtX = currentPositionAtX;
        this.lastPositionAtY = currentPositionAtY;
    }


    //Getters and Setters

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getHeadPosition() {
        return headPosition;
    }

    public void setHeadPosition(String headPosition) {
        this.headPosition = headPosition;
    }

    public int getCurrentPositionAtX() {
        return currentPositionAtX;
    }

    public void setCurrentPositionAtX(int currentPositionAtX) {
        this.currentPositionAtX = currentPositionAtX;
    }

    public int getCurrentPositionAtY() {
        return currentPositionAtY;
    }

    public void setCurrentPositionAtY(int currentPositionAtY) {
        this.currentPositionAtY = currentPositionAtY;
    }

    public int getLastPositionAtX() {
        return lastPositionAtX;
    }

    public void setLastPositionAtX(int lastPositionAtX) {
        this.lastPositionAtX = lastPositionAtX;
    }

    public int getLastPositionAtY() {
        return lastPositionAtY;
    }

    public void setLastPositionAtY(int lastPositionAtY) {
        this.lastPositionAtY = lastPositionAtY;
    }

    public String getDegreesFromCardinalDirections(String key) {
        return this.cardinalDirections.get(key);
    }

    public Map<String, String> getCardinalDirections() {
        return cardinalDirections;
    }
}
