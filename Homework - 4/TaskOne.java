import java.util.Scanner;

public class TaskOne {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Your name is: ");
        String firstName = sc.next();
        int len = firstName.length();

        if(firstName.equals(" ") || firstName.equals("")){
            System.out.print("Error");
        } else if (onlyDigits(firstName, len) == true){
            System.out.print("Digits are not allowed!");
        }else{
            print(firstName);
        }

    }
    public static void print(String name){
        System.out.print("Hello, " + name + "!");
    }

    public static boolean onlyDigits(String str, int n) {
        for (int i = 0; i < n; i++) {

            if (str.charAt(i) >= '0'
                    && str.charAt(i) <= '9') {
                return true;
            }
            else {
                return false;
            }
        }
        return false;
    }

}
