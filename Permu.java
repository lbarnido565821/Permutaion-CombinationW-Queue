package que;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Permu {

	static Scanner input = new Scanner(System.in);

    // Queue implementation
    static Queue<String> queue = new LinkedList<>();

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== PERMUTATION AND COMBINATION =====");
            System.out.println("[1] Add Elements to Queue");
            System.out.println("[2] Display Queue");
            System.out.println("[3] Generate Permutations");
            System.out.println("[4] Generate Combinations");
            System.out.println("[5] Exit");
            System.out.print("Enter choice: ");

            choice = input.nextInt();

            switch (choice) {

                case 1:
                    addElements();
                    break;

                case 2:
                    displayQueue();
                    break;

                case 3:
                    generatePermutations();
                    break;

                case 4:
                    generateCombinations();
                    break;

                case 5:
                    System.out.println("Program terminated.");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);
    }

 // TODO 1: Accept elements and add them to the Queue

 	static void addElements() {
 		System.out.print("How many elements do you want to add?: ");
 		int number = input.nextInt();
 		for (int i = 0; i < number; i++) {
 			System.out.print("Enter element " + (i + 1) + ": ");
 			String element = input.next();
 			queue.add(element);
 		}
 		System.out.println("Elements successfully added!");
 	}
 // TODO 2: Display all elements in the Queue
 	static void displayQueue() {
 		if (queue.isEmpty()) {
 			System.out.println("Queue is empty!");
 		} else {
 			System.out.println("Queue: " + queue);
 			System.out.println("Front Element: " + queue.peek());
 		}
 	}

 // TODO 3: Generate all possible permutations

 	static void generatePermutations() {
 		if (queue.isEmpty()) {
 			System.out.println("Queue is empty!");
 			return;
 
 		}
 
 
 		List<String> elements = new ArrayList<>(queue);
 			System.out.print("Enter number of elements to arrange: ");
 			int r = input.nextInt();
 			if (r <= 0 || r > elements.size()) {
 				System.out.println("Invalid number of elements!");
 				return;
 			}

 
 			System.out.println("\nPermutations:");
 			boolean[] used = new boolean[elements.size()];
 			int[] count = {0};
 			permutationHelper(elements, "", used, r, count);
 				System.out.println("\nTotal Permutations: " + count[0]);
 	}

 	static void permutationHelper(List<String> elements, String result, boolean[] used, int r, int[] count) {
 		if (!result.isEmpty() && result.trim().split(" ").length == r) {
 			System.out.println(result.replace(" ", ""));
 			count[0]++;
 			return;

 		}

 		for (int i = 0; i < elements.size(); i++) {
 			if (!used[i]) {
 				used[i] = true;

 				permutationHelper(elements, result + elements.get(i) + " ", used, r, count);
 				used[i] = false;

 			}

 		}

 	}

 // TODO 4: Generate all possible combinations

 	static void generateCombinations() {
 		if (queue.isEmpty()) {
 			System.out.println("Queue is empty!");
 			return;

 		}

 

 	List<String> elements = new ArrayList<>(queue);
 		System.out.print("Enter number of elements: ");
 		int r = input.nextInt();
 		if (r <= 0 || r > elements.size()) {
 			System.out.println("Invalid number of elements!");
 			return;
 
 
 }
 System.out.println("\nCombinations:");
 int[] count = {0};
 combinationHelper(elements, "", 0, r, count);

 

 	System.out.println("\nTotal Combinations: " + count[0]);
 }
 	static void combinationHelper(List<String> elements, String result, int start, int r, int[] count) {
 		if (!result.isEmpty() && result.trim().split(" ").length == r) {
 			System.out.println(result.replace(" ", ""));
 			count[0]++;
 			return;

 		}
 		for (int i = start; i < elements.size(); i++) {
 			combinationHelper(elements, result + elements.get(i) + " ", i + 1, r, count);

 		}

 	}
}