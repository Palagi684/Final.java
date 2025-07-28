
// Import the Scanner class to allow user input from the keyboard
import java.util.Scanner;

// Defines the main class of the program
public class Main {

    // This is the main method or the starting point of the program
    public static void main(String[] args) {

        // Create a fixed size list (array) to store up to 5 tasks
        String[] tasks = new String[5];

        // This keeps track of how many tasks have been added so far
        int taskCount = 0;

        // Flags to keep the program running in a loop until the user chooses to exit
        boolean running = true;

        // Displays a welcome message when the program starts
        System.out.println("Welcome to your To-Do List Organizer!");

        // Use resources to safely open the Scanner and automatically close it later
        try (Scanner scanner = new Scanner(System.in)) {

            // Starts the main program loop
            while (running) {

                // Show the menu of choices to the user
                System.out.println("\nChoose a task option:");
                System.out.println("1. Add a new task");
                System.out.println("2. View all tasks");
                System.out.println("3. Mark a task as completed");
                System.out.println("4. Exit");
                System.out.println("Your choice: ");

                // Read the user's menu selection (1–4)
                int choice = scanner.nextInt();
                scanner.nextLine(); // Clear leftover newline from input

                // Use switch-case to perform different actions based on the user's choice
                switch (choice) {

                    // Option 1: Add a new task
                    case 1:
                        // Check to see if there is still room to add more tasks
                        if (taskCount < tasks.length) {
                            // Ask the user to type their task description
                            System.out.print("Enter your task: ");
                            String task = scanner.nextLine();

                            // Save the task in the array and increase the count
                            tasks[taskCount] = task;
                            taskCount++;

                            // Confirm the task was added
                            System.out.println("Task added!");
                        } else {
                            // If the list is full, let the user know
                            System.out.println("Task list is full!");
                        }
                        break;

                    // Option 2: View all current tasks
                    case 2:
                        System.out.println("\nYour Tasks:");

                        // If no tasks have been added yet
                        if (taskCount == 0) {
                            System.out.println("No tasks yet.");
                        } else {
                            // Loop through each task and displays it with a number
                            for (int i = 0; i < taskCount; i++) {
                                System.out.println((i + 1) + ". " + tasks[i]);
                            }
                        }
                        break;

                    // Option 3: Marks a task as completed
                    case 3:
                        // Ask which task number the user wants to mark as done
                        System.out.print("Enter the task number to mark as done: ");
                        int taskNumber = scanner.nextInt();
                        scanner.nextLine(); // Clears leftover newline

                        // Check if the number is valid based on how many tasks are stored
                        if (taskNumber > 0 && taskNumber <= taskCount) {
                            // Add done to the task text to show it's completed
                            tasks[taskNumber - 1] += " (done)";
                            System.out.println("Task marked as complete!");
                        } else {
                            // If the number is out of range, give a warning
                            System.out.println("Not a valid task number.");
                        }
                        break;

                    // Option 4: Exit the program
                    case 4:
                        running = false; // Set the loop to stop
                        System.out.println("Goodbye!");
                        break;

                    // If the user entered a number outside the expected range
                    default:
                        System.out.println("Choose a task option between 1-4. Try again!");
                        break;
                }
            }
        }
    }
}
