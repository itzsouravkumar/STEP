import java.util.Scanner;

class RocketLaunchFor {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Input value: ");
        int counter = input.nextInt();
        
        for (int i = counter; i >= 1; i--) {
            System.out.println(i);
        }
        
        input.close();
    }
}