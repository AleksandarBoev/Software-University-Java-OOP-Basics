package p06_stackOfStrings;

import java.util.ArrayList;
import java.util.List;

public class StackOfStrings {
    private List<String> data;

    public StackOfStrings() {
        this.data = new ArrayList<>();
    }

    public void push(String element) {
        this.data.add(0, element);
    }

    public String pop() {
        if (!this.isEmpty()) {
            String result = this.data.get(0);
            this.data.remove(0);
            return result;
        } else {
            return null;
        }
    }

    public String peek() {
        return this.data.get(0);
    }

    public boolean isEmpty() {
        return this.data.isEmpty();
    }
}
