import java.util.Random;

public class Main {

    public static void main(String[] args) {

        int size = 20;

        System.out.println("===== LINEAR PROBING TEST =====");
        stressTest(new LinearProbing<Integer>(size));

        System.out.println("\n===== QUADRATIC PROBING TEST =====");
        stressTest(new QuadraticProbing<Integer>(size));

        System.out.println("\n===== DOUBLE HASHING TEST =====");
        stressTest(new DoubleHashing<Integer>(size));

        System.out.println("\n===== SEPARATE CHAINING TEST =====");
        stressTest(new SeperateChaining<Integer>(size));
    }

    public static void stressTest(HashTable<Integer> table){

        Random rand = new Random();

        System.out.println("\n--- Inserting 15 elements ---");

        for(int i = 0; i < 15; i++){
            String key = "K" + rand.nextInt(50);
            int value = rand.nextInt(1000);

            try{
                table.insert(key, value);
                System.out.println("Inserted: " + key + " -> " + value);
            }
            catch(Exception e){
                System.out.println("Insert Failed: " + e.getMessage());
            }
        }

        System.out.println("\n--- Table After Insert ---");
        System.out.println(table);


        System.out.println("\n--- Searching 10 random keys ---");

        for(int i = 0; i < 10; i++){
            String key = "K" + rand.nextInt(50);

            try{
                table.search(key);
            }
            catch(Exception e){
                System.out.println("Search: " + key + " Not Found");
            }
        }


        System.out.println("\n--- Deleting 5 random keys ---");

        for(int i = 0; i < 5; i++){
            String key = "K" + rand.nextInt(50);

            try{
                table.delete(key);
                System.out.println("Deleted: " + key);
            }
            catch(Exception e){
                System.out.println("Delete: " + key + " Not Found");
            }
        }

        System.out.println("\n--- Table After Delete ---");
        System.out.println(table);


        System.out.println("\n--- Reinserting 5 elements ---");

        for(int i = 0; i < 5; i++){
            String key = "R" + rand.nextInt(50);
            int value = rand.nextInt(1000);

            try{
                table.insert(key, value);
                System.out.println("Inserted: " + key + " -> " + value);
            }
            catch(Exception e){
                System.out.println("Insert Failed: " + e.getMessage());
            }
        }

        System.out.println("\n--- Final Table ---");
        System.out.println(table);
    }
}