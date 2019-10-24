package main.java.workflow;
import java.util.Scanner;

public class CommandLineUtils {
    public static String ReadOption(){
        Scanner scanner = new Scanner(System.in);

        String input = scanner.next();
        return input;
    }
}
