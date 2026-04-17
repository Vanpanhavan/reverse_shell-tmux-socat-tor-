public class Main {
    public static void main(String[] args) {

        System.out.println("===== TRI =====");
        System.out.println("Recursive tri(5): " + RecursiveSolution.tri(5));
        System.out.println("Iterative tri(5): " + IterativeSolution.tri(5));

        System.out.println("\n===== FACTORIAL =====");
        System.out.println("Recursive fact(5): " + RecursiveSolution.fact(5));
        System.out.println("Iterative fact(5): " + IterativeSolution.fact(5));

        System.out.println("\n===== FIBONACCI =====");
        System.out.println("Recursive fib(7): " + RecursiveSolution.fib(7));
        System.out.println("Iterative fib(7): " + IterativeSolution.fib(7));

        System.out.println("\n===== REVERSE STRING =====");
        String str = "hello";
        System.out.println("Recursive reverse: " + RecursiveSolution.reverseStr(str));
        System.out.println("Iterative reverse: " + IterativeSolution.reverseStr(str));

        System.out.println("\n===== HAS CHAR =====");
        System.out.println("Recursive hasChar('hello','e'): "
                + RecursiveSolution.hasChar("hello", 'e'));

        System.out.println("Iterative hasChar('hello','e'): "
                + IterativeSolution.hasChar("hello", 'e'));

        System.out.println("\n===== GCD =====");
        System.out.println("Recursive gcd(48,18): "
                + RecursiveSolution.gcd(48, 18));

        System.out.println("Iterative gcd(48,18): "
                + IterativeSolution.gcd(48, 18));

        System.out.println("\n===== UNIQUE PATHS =====");
        System.out.println("Recursive countUniquePaths(3,3): "
                + RecursiveSolution.countUniquePaths(20,12));

        System.out.println("Iterative countUniquePaths(3,3): "
                + IterativeSolution.countUniquePaths(20,12));

        System.out.println("\n===== EDGE CASE TEST =====");

        System.out.println("tri(0): " + RecursiveSolution.tri(0));
        System.out.println("fact(0): " + RecursiveSolution.fact(0));
        System.out.println("fib(0): " + RecursiveSolution.fib(0));
        System.out.println("gcd(10,5): " + RecursiveSolution.gcd(10,5));

    }
}