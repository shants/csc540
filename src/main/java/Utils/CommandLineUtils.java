package Utils;
import java.util.Scanner;

public class CommandLineUtils {
    public static String ReadInput(){
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        return input;
    }


}
