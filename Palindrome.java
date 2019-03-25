import java.util.*;

public class Palindrome {

    public static void main(String args[]) throws EmptyStringException {
        Scanner in = new Scanner(System.in);
        palindrome(in.nextLine());

    }

    public static Boolean palindrome(String original) throws EmptyStringException {
        String  reverse = ""; // Objects of String class
        Scanner in = new Scanner(System.in);
        if(original=="")throw new EmptyStringException();

        int length = original.length();

        for ( int i = length - 1; i >= 0; i-- )
            reverse = reverse + original.charAt(i);
        if (original.equals(reverse))
            return true;
        else
            return false;
    }
}
