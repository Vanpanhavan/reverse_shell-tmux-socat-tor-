public class BasicCalculator {
    private int total = 0;
    public int getTotal(){
        return total;
    }

    public void add(int x){
        total = total + x;
    }

    public void minus(int x){
        total = total - x;
    }
    public void multiply(int x){
        total = total * x;
    }
    public void divide(int x){
        try {
            total = total / x;
        }
            catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero");
        }
    }

    public void modulo(int x) {
        try {
            total = total % x;
        }
        catch (ArithmeticException e) {
            System.out.println("Cannot modulo by zero");
        }
    }

    public void reset(){
        total = 0;
    }
}
