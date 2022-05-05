package genspark.john_manuel;

/**
 * Objective:
 * Reverse a given int without using the built-in stringbuilder function
 *
 */

public class ReverseAnInt
{
    public static void main( String[] args )
    {
        System.out.println(reversedNum(1234));
    }

    public static int reversedNum(int num){
        int reversedNumber = 0;
        int remainder;

        while(num>0){
            remainder = num % 10;
            reversedNumber = (reversedNumber * 10) + remainder;
            num = num/10;
        }
        return reversedNumber;
    }
}
