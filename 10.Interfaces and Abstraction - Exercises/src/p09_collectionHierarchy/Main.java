package p09_collectionHierarchy;

import p09_collectionHierarchy.classes.AddCollection;
import p09_collectionHierarchy.classes.AddRemoveCollection;
import p09_collectionHierarchy.classes.MyList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        AddCollection addCollection = new AddCollection();
        AddRemoveCollection addRemoveCollection = new AddRemoveCollection();
        MyList myList = new MyList();

        String[] addTokens = reader.readLine().split(" ");
        int numberOfRemoveOperations = Integer.parseInt(reader.readLine());
        reader.close();

        int[] result1 = new int[addTokens.length];
        int[] result2 = new int[addTokens.length];
        int[] result3 = new int[addTokens.length];
        for (int i = 0; i < addTokens.length; i++) {
            result1[i] = addCollection.add(addTokens[i]);
            result2[i] = addRemoveCollection.add(addTokens[i]);
            result3[i] = myList.add(addTokens[i]);
        }

        printArray(result1);
        printArray(result2);
        printArray(result3);

        for (int i = 0; i < numberOfRemoveOperations; i++) {
            System.out.print(addRemoveCollection.remove() + " ");
        }

        System.out.println();

        for (int i = 0; i < numberOfRemoveOperations; i++) {
            System.out.print(myList.remove() + " ");
        }
    }

    private static void printArray(int[] array) {
        System.out.println(Arrays.toString(array).replaceAll("[\\[\\],]", ""));
    }
}
