import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;
import java.util.Scanner;

public class TaskFour {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("The number: ");
        int num = sc.nextInt();

        String numName = theLastNumber(num);
        System.out.printf("The last digit is %s", numName);
    }

    public static String theLastNumber(int num) {
        int lastDigit = num % 10;
        String nameDigit;
        switch (lastDigit) {
            case 0:
                nameDigit = "Zero";
            case 1:
                nameDigit = "One";
            case 2:
                nameDigit = "Two";
            case 3:
                nameDigit = "Three";
            case 4:
                nameDigit = "Four";
            case 5:
                nameDigit = "Five";
            case 6:
                nameDigit = "Six";
            case 7:
                nameDigit = "Seven";
            case 8:
                nameDigit = "Eight";
            case 9:
                nameDigit = "Nine";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + lastDigit);
        }
        return nameDigit;
    }
}
