package genspark.john_manuel;

/**
 * Objective:
 * check to see if then given integer is divisible by 3 and if it is then you will need to return fizz,
 * if it's divisible by 5 then return buzz,
 * and lastly if it's divisible by 3 and 5 return fizz buzz bazz.
 *
 */

public class FizzBuzzBazz
{
    public static void main( String[] args )
    {
        System.out.println(numCheck(9));
        System.out.println(numCheck(10));
        System.out.println(numCheck(15));
        System.out.println(numCheck(4));
    }

    public static String numCheck(int num){

        if((num%3) == 0 && (num%5) != 0){
            return "fizz";
        }
        else if((num%5) == 0 && (num%3) != 0){
            return "buzz";
        }
        else if((num%3) == 0){
            return "fizz buzz bazz";
        }

        return "none";
    }
}
