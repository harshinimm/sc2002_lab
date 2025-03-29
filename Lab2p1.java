import java.util.Scanner;
import java.util.Random;

public class Lab2p1 {
    public static void main(String[] args) {
        int choice;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("\nPerform the following methods:");
            System.out.println("1: Multiplication test");
            System.out.println("2: Quotient using division by subtraction");
            System.out.println("3: Remainder using division by subtraction");
            System.out.println("4: Count digits in a number");
            System.out.println("5: Find position of digit in number");
            System.out.println("6: Extract odd digits from a number");
            System.out.println("7: Quit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    mulTest(sc);
                    break;
                case 2:
                    divide(sc);
                    break;
                case 3:
                    modulus(sc);
                    break;
                case 4:
                    countDigits(sc);
                    break;
                case 5:
                    position(sc);
                    break;
                case 6:
                    long result = extractOddDigits(sc);
                    if (result == 0) {
                        System.out.println("No odd digits found.");
                    } else {
                        System.out.println("Extracted odd digits: " + result);
                    }
                    break;
                case 7:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 7);

        sc.close();
    }

    public static void mulTest(Scanner sc) {
        Random random = new Random();

        System.out.print("How many questions do you want? ");
        int sno = sc.nextInt();
        int score = 0;

        for (int i = 0; i < sno; i++) {
            int num1 = random.nextInt(10) + 1;
            int num2 = random.nextInt(10) + 1;

            System.out.print("Enter product of " + num1 + " * " + num2 + ": ");
            int answer = sc.nextInt();

            if (answer == (num1 * num2)) {
                System.out.println("Correct Answer!");
                score++;
            } else {
                System.out.println("Wrong! The correct answer is " + (num1 * num2));
            }
        }

        System.out.println("You got " + score + " out of " + sno + " correct!");
    }

    public static void divide(Scanner sc) {
        System.out.print("Enter dividend: ");
        int m = sc.nextInt();
        System.out.print("Enter divisor: ");
        int n = sc.nextInt();

        if (n == 0) {
            System.out.println("Division by zero is not allowed.");
            return;
        }

        int quotient = 0, originalM = m;
        while (m >= n) {
            m -= n;
            quotient++;
        }

        System.out.println("The quotient of " + originalM + " / " + n + " is " + quotient);
    }

    public static int modulus(Scanner sc) {
        System.out.print("Enter dividend: ");
        int m = sc.nextInt();
        System.out.print("Enter divisor: ");
        int n = sc.nextInt();

        if (n == 0) {
            System.out.println("Division by zero is not allowed.");
            return -1;
        }

        while (m >= n) {
            m -= n;
        }

        System.out.println("The remainder is " + m);
        return m;
    }

    public static int countDigits(Scanner sc) {
        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        if (num < 0) {
            System.out.println("Error!! Negative numbers are not allowed.");
            return -1;
        }

        int digitCount = (num == 0) ? 1 : 0;
        while (num != 0) {
            num /= 10;
            digitCount++;
        }

        System.out.println("The number of digits is: " + digitCount);
        return digitCount;
    }

    public static int position(Scanner sc) {
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        System.out.print("Enter digit to find position: ");
        int digit = sc.nextInt();

        int position = 1, originalNum = num;
        boolean found = false;

        while (num != 0) {
            int lastDigit = num % 10;
            if (lastDigit == digit) {
                System.out.println("Digit " + digit + " found at position " + position);
                found = true;
                break;
            }
            num /= 10;
            position++;
        }

        if (!found) {
            System.out.println("Digit " + digit + " not found in number " + originalNum);
            return -1;
        }

        return position;
    }

    public static long extractOddDigits(Scanner sc) {
        System.out.print("Enter the number you want to extract odd digits from: ");
        long oddNum = sc.nextLong();
        long result = 0, placeValue = 1;

        while (oddNum > 0) {
            long digit = oddNum % 10;
            if (digit % 2 != 0) {
                result = digit * placeValue + result;
                placeValue *= 10;
            }
            oddNum /= 10;
        }

        return result;
    }
}


