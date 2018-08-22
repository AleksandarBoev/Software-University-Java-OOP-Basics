package entities.nations;

import abstract_classes.BaseNation;
import contracts.Nation;

public class WaterNation extends BaseNation {
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        return "Water Nation" + System.lineSeparator() + super.toString();
    }
}
