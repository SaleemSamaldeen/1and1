package utils;

public class StringHelper {

    public String reverseText(String value) throws Exception {
        if (value.length() < 30 && value.matches("[a-zA-Z]")) {
            StringBuilder builder = new StringBuilder();
            return builder.append(value).reverse().toString();
        } else throw new Exception(value + " - contains either non ACSII letters or more than 30 characters");
    }

}
