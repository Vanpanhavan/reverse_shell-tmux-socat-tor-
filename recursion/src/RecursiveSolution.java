public class RecursiveSolution {
    public static int tri(int n){ //O(n)
        if (n < 0){
            throw new IllegalArgumentException("Cannot be negative integer");
        }
        else if (n == 0){
            return 0;
        }
        else if (n == 1){
            return 1;
        }
        else{
            return n + tri(n-1);
        }
    }
    public static int fact(int n){ //O(n)
        if (n < 0){
            throw new IllegalArgumentException("Cannot be negative integer");
        }
        else if (n == 0){
            return 1;
        }
        else if (n == 1){
            return 1;
        }
        else{
            return n*fact(n-1);
        }

    }
    public static int fib(int n){ //O(2^n)
        if (n < 0){
            throw new IllegalArgumentException("Cannot be negative integer");
        }
        else if (n == 0){
            return 0;
        }
        else if (n == 1){
            return 1;
        }
        else{
            return fib(n-1) + fib(n-2);
        }
    }
    public static String reverseStr(String str){ //O(n²)
        if (str.isEmpty()){
            return "";
        }
        else if (str.length() == 1){
            return str.charAt(0)+"";
        }
        return (str.charAt(str.length() -1)+"").concat(reverseStr(str.substring(0, str.length()-1)));
    }
    public static boolean hasChar(String str, char c){ //O(n²)
        if (str.isEmpty()){
            return false;
        }
        else if (str.charAt(str.length()-1) == c){
            return true;
        }
        else{
            return hasChar(str.substring(0,str.length()-1), c);
        }
    }
    public static int gcd(int x1, int x2){ //O(log n)
        int r = 0;
        if (x1 < 0 || x2 < 0 ){
            throw new IllegalArgumentException("Cannot be negative integer");
        }
        if (x1 == 0){
            return x2;
        }
        else if (x2 == 0){
            return x1;
        }
        if (x1 > x2){
            r = x1%x2;
            if (r == 0){
                return x2;
            }
            else{
                return gcd(x2, r);
            }
        }
        else{
            r = x2%x1;
            if (r == 0){
                return x1;
            }
            else{
                return gcd(x1, r);
            }
        }
    }
    public static int countUniquePaths(int n, int m){ //O(2^(n+m))
        if (n < 0 || m < 0){
            throw new IllegalArgumentException("Cannot be negative integer");
        }
        if (n == 0) {
            return 1;
        }
        else if (m == 0){
            return 1;
        }
        else{
            return countUniquePaths(n-1, m) + countUniquePaths(n, m-1);
        }
    }
}
