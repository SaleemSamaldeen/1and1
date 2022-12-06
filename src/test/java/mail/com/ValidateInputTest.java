package mail.com;

import utils.StringHelper;

import java.util.Scanner;

public class ValidateInputTest {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter text: ");
        String value = scanner.nextLine();
        StringHelper helper = new StringHelper();
        System.out.println(helper.reverseText(value));
    }
}
