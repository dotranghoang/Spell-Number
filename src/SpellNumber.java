import java.util.Scanner;

public class SpellNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please insert a number (Length max up to 9 number): ");

        try {
            int number = scanner.nextInt();
            if (number == 0) {
                System.out.println("Zero");
            } else {
                System.out.println(numberToWord(number));
            }
        } catch (Exception e) {
            System.out.println("Please enter a number(Length max up to 9 number)");
        }
        scanner.close();
    }

    private static  String numberToWord(int number) {
        String word = "";
        String teenArray[] = {"zezo","one","two","three", "four", "five", "six",
                "seven", "eight", "nine", "ten", "eleven", "twelve",
                "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
                "eighteen", "nineteen"};
        String tenArray[] = {"zero", "ten", "twenty", "thirty", "forty", "fifty",
                "sixty", "seventy", "eighty", "ninety"};

        if(number == 0) {
            return "zero";
        }

        if (number < 0) {
            String numberStr = "" + number;
            numberStr = numberStr.substring(1);
            return "minus " + numberToWord(Integer.parseInt(numberStr));
        }

        if((number / 1000000) > 0) {
            word += numberToWord(number / 1000000) + " Milion ";
            number %= 1000000;
        }

        if((number / 1000) > 0) {
            word += numberToWord(number / 1000) + " thousand ";
            number %= 1000;
        }

        if ((number / 100 ) > 0) {
            word += numberToWord(number / 100) + " hundred ";
            number %= 100;
        }

        if (number > 0) {

            if(number < 20) {
                word += teenArray[number];
            } else {
                word += tenArray[number/10];
                if ((number % 10) > 0) {
                    word += teenArray[number % 10];
                }
            }
        }
        return word;
    }
}
