public class StringReverser {
    public static String reverse(String input) {
        char[] arr = new char[input.length()];

        // insert char to stack
        for (int i = 0; i < input.length(); i++) {
            arr[i] = input.charAt(i);
        }

        // pop char from stack
        StringBuilder sb = new StringBuilder();
        for (int i = input.length() - 1; i >= 0; i--) {
            sb.append(arr[i]);
            arr[i] = ' ';
        }
        return sb.toString();
    }
}
