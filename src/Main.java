import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Input expression: ");
//        String exp = scanner.next();
        ArrayList<String> test = new ArrayList<String>(){
            {
                add("4.7+3.0*5.5");
                add("4.7 + 3.0 * -5.5");
                add("4.7+-3.0*5.5");
                add("1+(2*-3)+-4");
                add("(1+2)*3*(4/2)");
                add("(1+2)*(3*4)/+2");
                add("1^(2*3)-1");
                add("(2+3)^2");
                add("(2+3)^-2");
                add("8%3");
                add("(2+3)%2");
            }
        };
        ArrayList<String> ans = new ArrayList<String>(){
            {
                add("21.2");
                add("-11.8");
                add("-11.8");
                add("-9.0");
                add("18.0");
                add("18.0");
                add("0.0");
                add("25.0");
                add("0.04");
                add("2.0");
                add("1.0");

            }
        };

        Calculator calculator = new Calculator();
        for(int i = 0; i < ans.size(); ++i){
            System.out.println(test.get(i) + " = " + calculator.evalExp(test.get(i)) + "  correct answer : " + ans.get(i));
        }
    }
}
