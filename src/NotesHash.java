public class NotesHash implements IDictionary {

    private static final int NUM_BINS = 101;
    private Node[][] table;

    public NotesHash() {
        this.table = new Node[NUM_BINS][2];
    }

    // Determines whether the dictionary is empty.
    @Override
    public boolean isEmpty() {
        for (int j = 0; j < NUM_BINS; j++) {
            for (int i = 0; i < table[j].length; i++) {
                if (this.table[j][i] != null)
                    return false;
            }
        }
        return true;
    }

    // Adds the provided (key,value) pair to the dictionary.
    // If the key is already associated with a value, the
    // old key, value pair are replaced.
    @Override
    public void add(String key, String value) {
        int bucketIndex = Math.abs(key.hashCode() % NUM_BINS);
        boolean hit = false;
        int length = this.table[bucketIndex].length;
        Node newNode = new Node(key, value);

        // if bin is empty-- add the given pair or if keys are identical -- replace with
        // given pair
        for (int i = 0; i < length; i++) {
            if (this.table[bucketIndex][i] == null || this.table[bucketIndex][i].getKey().equals(key)) {
                this.table[bucketIndex][i] = newNode;
                hit = true;
                break;
            }
        }
        // else if keys are unique and the bins are occupied -- create new array
        // doubling the size
        // copying all the original content + new to the array
        if (!hit) {
            Node[] bucket = new Node[length * 2];
            for (int i = 0; i <= length; i++) {
                if (i == length) {
                    bucket[i] = newNode;
                } else {
                    bucket[i] = this.table[bucketIndex][i];
                }
            }
            this.table[bucketIndex] = bucket;
        }
    }

    // Removes the (key, value) pair specified by the given
    // key from the dictionary. Throws an exception if the
    // (key, value) pair is not contained in the dictionary.
    @Override
    public void remove(String key) throws DictionaryException {
        int bucketIndex = Math.abs(key.hashCode() % (NUM_BINS));
        int length = this.table[bucketIndex].length;
        int emptyBuckets = 0;
        int nodeIndex = -1;
        // checks if it contains the key and stores the location of it
        for (int i = 0; i < length; i++) {
            if (this.table[bucketIndex][i] != null && this.table[bucketIndex][i].getKey().equals(key)) {
                nodeIndex = i;
            }
            if (this.table[bucketIndex][i] == null) { // counts how many are empty
                emptyBuckets++;
            }
        }
        // if it doesn't contain the key-- throw exception
        if (nodeIndex == -1)
            throw new DictionaryException("The pair is not contained in the dictionary!");

        this.table[bucketIndex][nodeIndex] = null;// removes the pair from the saved location
        emptyBuckets++; // now there is a new empty bucket

        if (length > 1 && emptyBuckets >= (length / 2)) { // if empty buckets are greater than or equal to
            Node[] bucket = new Node[length / 2]; // half of the length.-- bucket is resized
            int oldIndex = 0;
            int newIndex = 0;
            while (oldIndex < length) {
                if (this.table[bucketIndex][oldIndex] != null) {
                    bucket[newIndex] = this.table[bucketIndex][oldIndex];
                    newIndex++;
                }
                oldIndex++;
            }
            this.table[bucketIndex] = bucket;
        }
    }

    // Returns the value associated with the given key
    // from the dictionary. Does not modify the dictionary.
    // Throws an exception if the (key, value) pair is not
    // contained in the dictionary.
    @Override
    public String getValue(String key) throws DictionaryException {
        int bucketIndex = Math.abs(key.hashCode() % (NUM_BINS));
        int length = this.table[bucketIndex].length;
        boolean contains = false;
        String value = null;
        for (int i = 0; i < length; i++) {
            if (this.table[bucketIndex][i].getKey().equals(key)) {
                contains = true;
                value = this.table[bucketIndex][i].getValue();
            }
        }
        if (!contains && value == null)
            throw new DictionaryException("The pair is not contained in the dictionary!");
        return value;
    }

    // Removes all (key, value) pairs in the dictionary.
    @Override
    public void clearDictionary() {
        this.table = new Node[NUM_BINS][2];
    }

    // public void printHash(){
    // for(int j = 0; j < NUM_BINS;j++){
    // for(int i = 0; i < table[j].length;i++){
    // if (table[j][i] != null && table != null){
    // System.out.println("bin " + j + ", " + i);
    // System.out.println("key: " + table[j][i].getKey() +" value: " +
    // table[j][i].getValue());
    // }
    // else{
    // System.out.println("bin " + j + ", " + i);
    // System.out.println("null");
    // }
    // }
    // }
    // }
}
