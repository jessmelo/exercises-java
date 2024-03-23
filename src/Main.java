import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static int ex1() throws FileNotFoundException {
        int count = 0;
        try {
            File file = new File("src/ex1.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextInt()) {
                if (scanner.nextInt() >= 9999) {
                    count++;
                }
            }
        } catch (Exception e) {
            System.out.println("Not found! " + e.getMessage());
        }
        return count;
    }

    public static void ex2() throws FileNotFoundException {
        try {
            File file = new File("src/ex2.txt");
            Scanner scanner = new Scanner(file);
            scanner.nextLine();
            scanner.nextLine();
            System.out.println(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("Iiih... falhou! " + e.getMessage() + " - " + e.getClass().getName());
        }
    }

    public static String ex3() {
        String year = "";
        try {
            File file = new File("src/ex3.txt");
            Scanner scanner = new Scanner(file);

            // headers
            scanner.next();
            scanner.next();

            year = scanner.next();
            long previousPop = convertToDouble(scanner.next());
            long increase = 0;

            while (scanner.hasNextLine() && scanner.hasNext()) {
                String currentYear = scanner.next();
                long currentPop = convertToDouble(scanner.next());
                long currentIncrease = currentPop - previousPop;

                if (currentIncrease > increase) {
                    year = currentYear;
                    increase = currentIncrease;
                }

                previousPop = currentPop;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage() + " - " + e.getClass().getName());
        }
        return year;
    }

    public static int ex4() {
        int result = 0;
        try {
            File file = new File("src/ex4.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                int aux = scanner.nextInt();
                if (aux == 0) break;
                if (aux % 2 == 0) {
                    result++;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage() + " - " + e.getClass().getName());
        }
        return result;
    }

    public static int ex5() {
        int result = 0;
        try (Scanner scanner = new Scanner(new File("src/ex5.txt"))) {
            if (scanner.hasNextInt()) { // to avoid NoSuchElementException
                int number = scanner.nextInt();
                System.out.println(number * 100);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage() + " - " + e.getClass().getName());
        }
        return result;
    }

    public static long convertToDouble(String number) {
        return Long.parseLong(number.replace(",", ""));
    }

    public static void main(String[] args) throws FileNotFoundException {
        // Counts all numbers greater or equal to 9999
        System.out.println("Ex. 1: " + ex1());
        // Verifies what is printed if we try to access a non existing line
        System.out.println("Ex. 2:");
        ex2();
        // Returns the year which had the biggest increase in population compared to the previous
        System.out.println("Ex. 3: " + ex3());
        // Returns the count of all even numbers before 0 appears
        System.out.println("Ex. 4: " + ex4());
        // What exception is thrown when I use nextInt() on an empty file?
        System.out.println("Ex. 5: " + ex5());
    }
}