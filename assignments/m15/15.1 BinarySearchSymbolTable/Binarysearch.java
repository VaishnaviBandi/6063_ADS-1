import java.util.Arrays;
public class Binarysearch<Key extends Comparable<Key>, Value> {
	private Key[] keys;
    private Value[] vals;
    private int size = 0;
    Binarysearch() {
    	keys = (Key[]) new Comparable[20];
        vals = (Value[]) new Object[20];
    }
    /**
     * Time complexity is O(log(N))
     */
    public void put(Key key, Value value) {
    	if(size == keys.length) {
    		resize();
    	}
    	if(key == null) {
    		System.out.println("key is null");
    		return;
    	}
    	if(value == null) {
    		delete(key);
    		return;
    	}
    	int i = rank(key);
    	if(i < size && keys[i].compareTo(key) == 0) {
    		vals[i] = value;
    		return;
    	}
    	for(int j = size; j > i;j--) {
    		keys[j] = keys[j - 1];
    		vals[j] = vals[j - 1];
    	}
    	keys[i] = key;
    	vals[i] = value;
    	size++;

    }
    /**
     * @brief [brief description]
     * @details [long description]
     * Time complexity is O(log(N))
     * @param key [description]
     * @return [description]
     */
    public int rank(Key key) {
        if (key == null) {
        	System.out.println("Key is null");
        }
        int lo = 0, hi = size - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(keys[mid]);
            if      (cmp < 0) hi = mid - 1;
            else if (cmp > 0) lo = mid + 1;
            else return mid;
        }
        return lo;
    }
    /**
     * @brief [brief description]
     * Time complexity is O(1)
     * @details [long description]
     */
 public int size() {
        return size;
    }
/**
 * @brief [brief description]
 * @details [long description]
 * Time complexity is O(1)
 * @return [description]
 */
 public boolean isEmpty() {
        return size() == 0;
    }
    /**
     * @brief [brief description]
     * @details [long description]
     *  Time complexity is O(N)
     * @return [description]
     */
    public String keys() {
    	String s = "";
    	int j = 0;
    	for(int i = 0; i < size - 1; i++) {
    		if(keys[i] != null) {
    		s += keys[i] + " " + vals[i] + "\n" ;
    	}

    	}
    	s += keys[size - 1] + " " + vals[size - 1];
    	return s;
    }
    /**
     * @brief [brief description]
     * @details [long description]
     *  Time complexity is O(1)
     * @param key [description]
     * @return [description]
     */
 public boolean contains(Key key) {
        return get(key) != null;
    }
    /**
     * @brief [brief description]
     * @details [long description]
     *  Time complexity is O(1)
     * @param key [description]
     * @return [description]
     */
    public Value get(Key key) {
        if (isEmpty()) {
         return null;
     }
        int i = rank(key);
        if (i < size && keys[i].compareTo(key) == 0)  {
        	return vals[i];
        }
        return null;
    }
   	/**
   	 * @brief [brief description]
   	 * @details [long description]
   	 *  Time complexity is O(N)
   	 * @param key [description]
   	 */
    public void delete(Key key) {
        if (key == null) {
        	return;
        }
        if (isEmpty())  {
        	return;
        }
        int i = rank(key);
        if (i == size || keys[i].compareTo(key) != 0) {
            return;
        }
        for (int j = i; j < size - 1; j++)  {
            keys[j] = keys[j+1];
            vals[j] = vals[j+1];
        }

        size--;
        keys[size] = null;  // to avoid loitering
        vals[size] = null;
        return;

    }
    /**
     * @brief [brief description]
     * @details [long description]
     *  Time complexity is O(1)
     */
    public void deleteMin() {
        if(isEmpty())
        {
        System.out.println("Empty");
        return;
        }
        delete(min());
    }
    /**
     * @brief
     *  Time complexity is O(1)
     * @details [long description]
     */
    public void deleteMax() {
		if(isEmpty()) {
			System.out.println("Empty");
			return;
		}
		delete(max());
    }
    /**
     * @brief [brief description]
     * @details [long description]
     *  Time complexity is O(1)
     * @return [description]
     */
    public Key min() {
        return keys[0];
    }
    /**
     * @brief [brief description]
     * @details [long description]
     *  Time complexity is O(1)
     * @return [description]
     */
     public Key max() {
        return keys[size - 1];
    }
    /**
     * @brief [brief description]
     * @details [long description]
     *  Time complexity is O(N)
     */
    public void resize() {
    	keys = Arrays.copyOf(keys, keys.length * 2);
    	vals = Arrays.copyOf(vals, vals.length * 2);
    }
    /**
     * @brief [brief description]
     * @details [long description]
     *  Time complexity is O(1)
     * @param key [description]
     * @return [description]
     */
    public Key floor(Key key) {
        if (key == null) {
        	System.out.println("null");
        }
        int i = rank(key);
        if (i < size && key.compareTo(keys[i]) == 0) {
        	return keys[i];
        }
        if (i == 0) {
        	return null;
        }
        else {
         return keys[i-1];
     }
    }

}