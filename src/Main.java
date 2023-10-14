import java.util.ArrayList;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
//        int[] arr = {2, 7, 5, 6, 7, 1, 6, 2, 1, 7};
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the ArrayList: ");
        int size = scanner.nextInt();

        // Create an ArrayList of integers with the specified size
        ArrayList<Integer> arr = new ArrayList<>(size);

        // Prompt the user to enter elements
        System.out.println("Enter the elements of the ArrayList:");
        //adding the elements to array
        for (int i = 0; i < size; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            int element = scanner.nextInt();
            arr.add(element);
        }

        int[] counts = new int[100]; // Assuming elements are between 0 and 100
        int mostFrequent = arr.get(0);
        int maxFrequency = 0;

        for (int i = 0; i < arr.size(); i++) {
            int num = arr.get(i);
            counts[num]++;
            if (counts[num] > maxFrequency || (counts[num] == maxFrequency && num < mostFrequent)) {
                mostFrequent = num;
                maxFrequency = counts[num];
            }
        }
//        displaying the output
        System.out.println("The ArrayList you entered:");
        System.out.println(arr);
        System.out.println("The most frequent number in the table is:");
        System.out.println(mostFrequent + " (" + maxFrequency + " x)");
    }
}