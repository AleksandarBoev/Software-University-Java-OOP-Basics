import classes.Organism;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Organism> nameOrganism = new LinkedHashMap<>();
        //organism has a list of clusters --> different battlefields?

        reader.close();
    }
}
