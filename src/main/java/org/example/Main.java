package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
class Node { // Define elements oflinked list
    int value; // Stores integers
    Node nextNode; // Pointer to the next list node

    // Constructor to initialize the new node
    Node(int value) {
        this.value = value; // Store data
        this.nextNode = null; // Set the next pointer to null
    }
}

class LinkedList { // Manage linked list operations
    Node headNode; // Beginning of the list

    void insertEnd(int value) { // Insert a new node
        Node newNode = new Node(value); // Create a new node
        if (headNode == null) {
            headNode = newNode; // If the list is empty, make the head the new node
        } else {
            Node lastNode = headNode; // Start from the head
            while (lastNode.nextNode != null) {
                lastNode = lastNode.nextNode; // Traverse to the last node
            }
            lastNode.nextNode = newNode; // Insert a new node towards the end
        }
    }

    int calculateSum() { // Calculate the sum of the nodes values in the list
        int sum = 0;
        Node currentNode = headNode;
        while (currentNode != null) {
            sum += currentNode.value; // Add the value of each node
            currentNode = currentNode.nextNode; // Next node
        }
        return sum; // Return sum
    }
}

public class Main { // Check if given number is prime

    static boolean isPrime(int n) {
        if (n <= 1) return false; // If a number is less than 2, it's not prime
        for (int i = 2; i <= Math.sqrt(n); i++) { // Check if the number is divisible by any number other than 1 and itself
            if (n % i == 0) return false;
        }
        return true; // It's a prime number
    }

    static boolean containsDigitThree(int n) { // Check if the number contains the digit '3'
        return String.valueOf(n).contains("3"); // Convert to string to check for '3'
    }

    public static void main(String[] args) {
        int limit = 100; // Limit
        LinkedList primaryPrimesList = new LinkedList(); // List to store prime numbers
        LinkedList primesWithThreeList = new LinkedList(); // List to store prime numbers including 3

        for (int i = 2; i <= limit; i++) { // Populate the list with prime numbers
            if (isPrime(i)) { // If the number is prime, add it
                primaryPrimesList.insertEnd(i);
                if (containsDigitThree(i)) { // If the number contains '3', add it to the other list
                    primesWithThreeList.insertEnd(i);
                }
            }
        }

        int sumPrimesWithThree = primesWithThreeList.calculateSum(); // Calculate the sum of numbers in the second list
        System.out.println("Sum of prime numbers containing digit '3' between 0 and " + limit + ": " + sumPrimesWithThree);
    }
}
