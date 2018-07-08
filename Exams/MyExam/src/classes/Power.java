package classes;

import constants.Constants;
import interfaces.SuperPower;

public class Power implements SuperPower {
    //•	name – a string
    //	- The power name should start and finish with '@' and consist only
    // of alphabetical characters not less than 5 characters along with '@'. The name can have "_".
    //	- If not, throw an IllegalArgumentException with the message “Super power name not in the correct format!”.
    //•	powerPoints - a possitive floating point number;
    //	- If not, throw an IllegalArgumentException with the message “Power points should be a possitive number!”.
    private String name;
    private double powerPoints;

    public Power(String name, double powerPoints) {
        this.setName(name);
        this.setPowerPoints(powerPoints);
    }

    public void setName(String name) {
        if (name.matches("@[A-z_]{3,}@")) {
            this.name = name;
        } else {
            throw new IllegalArgumentException(Constants.INVALID_SUPERPOWER_NAME_MESSAGE);
        }
    }

    public void setPowerPoints(double powerPoints) {
        if (powerPoints >= 0) {
            this.powerPoints = powerPoints;
        } else {
            throw new IllegalArgumentException(Constants.INVALID_POWER_POINTS_MESSAGE);
        }
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getPowerPoints() {//Returns the powerPoints + Power name length divided by 2
        return this.powerPoints + this.name.length() / 2;
    }
}
