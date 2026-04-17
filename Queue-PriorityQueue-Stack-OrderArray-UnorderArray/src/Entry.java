/**
 * Entry represents a key-value pair stored inside
 * OrderedArray and UnorderedArray.
 *
 * The anchor (key) is used for searching and ordering,
 * while the value stores the associated data.
 */
class Entry <V, K>{
    V value;
    K anchor;
    public Entry(V value, K anchor){
        this.value = value;
        this.anchor = anchor;
    }
}
