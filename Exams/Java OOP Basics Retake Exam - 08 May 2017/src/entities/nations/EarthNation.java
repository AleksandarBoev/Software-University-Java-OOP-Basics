package entities.nations;

import abstract_classes.BaseNation;
import contracts.Nation;

public class EarthNation extends BaseNation {
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        return "Earth Nation" + System.lineSeparator() + super.toString();
    }
}
