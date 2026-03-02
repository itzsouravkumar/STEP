import java.util.Scanner;

class AgeOfThree {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the height of Amar: ");
        int amar = input.nextInt();

        System.out.print("Enter the height of Akbar: ");
        int akbar = input.nextInt();

        System.out.print("Enter the height of Anthony: ");
        int anthony = input.nextInt();

        if (amar >= akbar && amar >= anthony) {
            System.out.println("Amar is the tallest.");
        } else if (akbar >= amar && akbar >= anthony) {
            System.out.println("Akbar is the tallest.");
        } else {
            System.out.println("Anthony is the tallest.");
        }

        if (amar <= akbar && amar <= anthony) {
            System.out.println("Amar is the shortest.");
        } else if (akbar <= amar && akbar <= anthony) {
            System.out.println("Akbar is the shortest.");
        } else {
            System.out.println("Anthony is the shortest.");
        }

        input.close();
    }
}
