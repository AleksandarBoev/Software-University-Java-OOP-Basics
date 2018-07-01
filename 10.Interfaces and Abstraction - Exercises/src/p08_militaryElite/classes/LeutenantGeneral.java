package p08_militaryElite.classes;

import p08_militaryElite.interfaces.ILeutenantGeneral;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class LeutenantGeneral extends Private implements ILeutenantGeneral {
    Set<Private> privates;

    public LeutenantGeneral(String id, String firstName, String secondName, double salary, Set<Private> privates) {
        super(id, firstName, secondName, salary);
        this.privates = privates;
    }

    @Override
    public Set<Private> getPrivates() {
        return Collections.unmodifiableSet(this.privates);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append(System.lineSeparator());
        sb.append("Privates:");
        if (this.privates.isEmpty()) {
            return sb.toString();
        } else {
            sb.append(System.lineSeparator());
        }

        this.privates.stream()
                .sorted((p1, p2) -> {
                    return p2.getId().compareTo(p1.getId());
                }).forEach(p -> {
                    sb.append("  ").append(p.toString()).append("\n");
        });

        sb.delete(sb.length() - 1, sb.length()); // deleting the last new line

        return sb.toString();
    }
}
