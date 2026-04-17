public class IterativeSolution {
    public static int tri(int n){ //O(n)
        int result = 0;
        if (n < 0){
            throw new IllegalArgumentException("Cannot be negative integer");
        }
        for (int i = 1; i <= n; i++){
            result += i;
        }
        return result;
    }
    public static int fact(int n){ //O(n)
        if (n < 0){
            throw new IllegalArgumentException("Cannot be negative integer");
        }
        int result = 1;
        for (int i = 1; i <= n; i++){
            result = result * i;
        }
        return result;
    }
    public static int fib(int n){ //O(n)
        if (n < 0){
            throw new IllegalArgumentException("Cannot be negative integer");
        }
        else if (n == 0){
            return 0;
        }
        else if (n == 1){
            return 1;
        }
        int current = 1;
        int privious = 0;
        int result = 0;
        for (int i = 1; i < n; i++){
            result = current + privious;
            privious = current;
            current = result;
        }
        return result;
    }
    public static String reverseStr(String str){ //O(n)
        if (str.isEmpty()){
            return "";
        }
        else{
            StringBuilder sb = new StringBuilder();
            for (int i = str.length()-1; i >= 0; i--){
                sb.append(str.charAt(i));
            }
            return sb.toString();
        }
    }
    public static boolean hasChar(String str, char c){ //O(n)
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) == c){
                return true;
            }
        }
        return false;
    }
    public static int gcd(int x1, int x2){ //O(log n)
        if (x1 < 0 || x2 < 0 ) {
            throw new IllegalArgumentException("Cannot be negative integer");
        }
        if (x1 == 0){
            return x2;
        }
        else if (x2 == 0){
            return x1;
        }
        int r = 0;
        while (true){
            if (x1 > x2){
                r = x1%x2;
                if (r==0){
                    return x2;
                }
                else{
                    x1 = x2;
                    x2 = r;
                }
            }
            else{
                r = x2%x1;
                if (r==0){
                    return x1;
                }
                else{
                    x2 = x1;
                    x1 = r;
                }
            }
        }
    }
    public static int countUniquePaths(int n, int m){ //O(n*m)
        if (n < 0 || m < 0){
            throw new IllegalArgumentException("Cannot be negative integer");
        }
        int[][] dp = new int[n+1][m+1];
        for (int i = 0; i <= n; i++){
            dp[i][0] = 1;
        }
        for (int i = 0; i <= m; i++){
            dp[0][i] = 1;
        }
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= m; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[n][m];
    }
}
