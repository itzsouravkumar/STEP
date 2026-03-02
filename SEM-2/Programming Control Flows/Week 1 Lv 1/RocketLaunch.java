import java.util.Scanner;

class RocketLaunch {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
		
		System.out.print("Input value: ");
        int counter = input.nextInt();
        
        while (counter >= 1) {
            System.out.println(counter);
            counter--;
        }
		
		input.close();
    }
}