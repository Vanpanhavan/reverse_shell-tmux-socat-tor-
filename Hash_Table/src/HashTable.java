public abstract class HashTable <T>{
    public UnorderedArray<T> arr;
    public HashTable(int size){
        arr = new UnorderedArray<T>(size);
    }
    abstract void insert(String key, T value);
    abstract void search(String key);
    abstract void delete(String key);
    @Override
    public String toString() {

        Node<T>[] array = arr.getArr();
        StringBuilder sb = new StringBuilder();

        int indexWidth = 8;
        int keyWidth = 12;
        int valueWidth = 12;

        // Header
        sb.append(String.format(
                "%-" + indexWidth + "s %-" + keyWidth + "s %-" + valueWidth + "s\n",
                "Index", "Key", "Value"
        ));

        sb.append("-".repeat(indexWidth + keyWidth + valueWidth + 2));
        sb.append("\n");

        for (int i = 0; i < array.length; i++) {

            String key;
            String value;

            if (array[i] == null) {
                key = "null";
                value = "null";
            }
            else if ("DELETED".equals(array[i].key)) {
                key = "DELETED";
                value = "null";
            }
            else {
                key = array[i].key;
                value = String.valueOf(array[i].value);
            }

            sb.append(String.format(
                    "%-" + indexWidth + "d %-" + keyWidth + "s %-" + valueWidth + "s\n",
                    i, key, value
            ));
        }

        return sb.toString();
    }
    public int hashFunction(String key){
        return Math.abs(key.hashCode()) % arr.getLength();
    }
}
