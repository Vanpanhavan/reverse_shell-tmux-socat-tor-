public class SeperateChaining <T> extends HashTable<T> {
    public SeperateChaining(int size) {
        super(size);
    }
    public void insert(String key, T value) {
        int index = super.hashFunction(key);
        Node<T>[] array = super.arr.getArr();
        if (array[index] == null) {
            super.arr.insert(index, key, value);
        }
        else{
            Node<T> current = array[index];
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node<T>();
            current.next.key = key;
            current.next.value = value;
        }
    }
    public void delete(String key){
        int index = super.hashFunction(key);
        Node<T>[] array = super.arr.getArr();
        if (array[index] == null) {
            System.out.println("Not Found");
        }
        else{
            Node<T> current = array[index];
            Node<T> prev = null;

            while(current != null && !(current.key.equals(key))){
                prev = current;
                current = current.next;
            }

            if (current == null){
                System.out.println("Not Found");
            }
            else if (prev == null){
                array[index] = current.next;
            }
            else{
                prev.next = current.next;
            }
        }
    }
    public void search(String key){
        int index = super.hashFunction(key);
        Node<T>[] array = super.arr.getArr();
        if (array[index] == null) {
            System.out.println("Not Found");
        }
        else{
            Node<T> current = array[index];

            while(current != null && !(current.key.equals(key))){
                current = current.next;
            }

            if (current == null){
                System.out.println("Not Found");
            }
            else{
                System.out.println("key " + key + " Found");
            }
        }
    }
    @Override
    public String toString() {

        Node<T>[] array = super.arr.getArr();
        StringBuilder sb = new StringBuilder();

        int indexWidth = 6;
        int dataWidth = 30;

        // Header
        sb.append(String.format(
                "%-" + indexWidth + "s %-" + dataWidth + "s\n",
                "Index", "Chain"
        ));

        sb.append("-".repeat(indexWidth + dataWidth));
        sb.append("\n");

        for (int i = 0; i < array.length; i++) {

            sb.append(String.format("%-" + indexWidth + "d ", i));

            Node<T> current = array[i];

            if (current == null) {
                sb.append("null");
            }
            else {
                while (current != null) {
                    sb.append("(" + current.key + ", " + current.value + ")");

                    if (current.next != null)
                        sb.append(" -> ");

                    current = current.next;
                }
            }

            sb.append("\n");
        }

        return sb.toString();
    }
}
