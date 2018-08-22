package entities.nations;

import abstract_classes.BaseNation;
import contracts.Bender;
import contracts.Monument;
import contracts.Nation;

import java.util.List;

public class AirNation extends BaseNation {
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        return "Air Nation" + System.lineSeparator() + super.toString();
    }
}
