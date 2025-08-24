public class stringDemonstration {
    public static void main(String[] args) {
        String str1 = "Java Programming";  // String literal
        String str2 = new String("Java Programming");  // String object
        String []str3 = {"Java", "Programming"};  // String array

        //Comparing using '=='
        System.out.println("Comparing str1 and str2 using '==': " + (str1 == str2)); //False -> bcz they are different objects and compared based on reference
        //Comparing using 'equals()'
        System.out.println("Comparing str1 and str2 using 'equals()': " + (str1.equals(str2))); //True -> bcz they have the same content and compared based on value

        //Printing str3
        for (String str : str3) { //We can use for iteration to print each element in the array also
            System.out.println("String from array: " + str);
        }

        //Using escape sequences
        System.out.println("Programming Quote:\n\t\"Code is Poetry\" - Unknown\n\tPath: C:\\Java\\Projects");
    }
}
