package entities.nations;

import abstract_classes.BaseNation;
import contracts.Nation;

public class FireNation extends BaseNation {
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        return "Fire Nation" + System.lineSeparator() + super.toString();
    }
}
