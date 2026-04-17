public class DelimiterChecker {
    public static boolean check(String input){
        char[] arr = new char[input.length()];
        int lastElement = -1;

        for (int i = 0; i < input.length(); i++) {
            // insert open delimiter to stack
            if (input.charAt(i) == '(' || input.charAt(i) == '[' || input.charAt(i) == '{') {
                arr[lastElement + 1] = input.charAt(i);
                lastElement++;
            }
            else{
                // pop delimiter from stack
                if(input.charAt(i) == ')'){
                    if(lastElement == -1 || arr[lastElement] != '(')
                        return false;
                    lastElement--;
                }
                else if(input.charAt(i) == ']'){
                    if(lastElement == -1 || arr[lastElement] != '[')
                        return false;
                    lastElement--;
                }
                else if(input.charAt(i) == '}'){
                    if(lastElement == -1 || arr[lastElement] != '{')
                        return false;
                    lastElement--;
                }
                else
                    continue;
            }
        }
        if (lastElement != -1){
            return false;
        }
        return true;
    }
}
