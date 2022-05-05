package genspark.john_manuel;

/**
 * Objective:
 * Reverse a given String without using the built-in stringbuilder function
 *
 */
public class ReverseAString
{
    public static void main( String[] args )
    {
        System.out.println(reversedString("my test string"));
    }

    public static String reversedString( String input ){
        char[] lettersInString = input.toCharArray();
        int first, last = 0;

        last = lettersInString.length - 1;

        for(first = 0; first < last; first++, last--){
            char temp = lettersInString[first];

            lettersInString[first] = lettersInString[last];
            lettersInString[last] = temp;
        }

        return String.valueOf(lettersInString);
    }
}
