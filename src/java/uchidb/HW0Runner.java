package uchidb;

import java.util.Arrays;
import java.util.List;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author aelmore
 */
public class HW0Runner {
    private static Containers<Integer, String> c = new SContainers<>();
    
    // This class is a factory for a singleton containers class.
    // https://www.tutorialspoint.com/java/java_using_singleton.htm
    public static Containers<Integer, String> getContainers() {
        return c;
    }

    public static void main(String[] args) {
        
    }
}

class SContainers<T, S> implements Containers<T, S> {
    private Map<S, T> map = null;

    // Create a set that stores the array of Integers
    public Set<T> initSet(T[] tArray) {
        return new HashSet<T>(Arrays.asList(tArray));
    }
    
    // Create a list that stores an the array of Integers
    public List<T> initList(T[] tArray) {
        return Arrays.asList(tArray);
    }
    
    // Create an empty map that will use Strings as keys and Integers as values
    public Map<S, T> initEmptyMap() {
        return new HashMap<S, T>();
    }
    
    // Store the map in a local field variable -- often called a setter 
    public void storeMap(Map<S, T> mapToStoreInClass) {
        map = mapToStoreInClass;
    }
    
    // Add a key value to store map with a boolean indicating whether to overwrite existing value.
    // Return whether the value was set (not necessarily changed).
    public boolean addToMap(S key, T value, boolean overwriteExistingKey) {
        if (map == null) {
            return false;
        }

        if (overwriteExistingKey || !map.containsKey(key)) {
            map.put(key, value);
            return true;
        }
        return false;
    }
    
    // Get a value based on a key
    public T getValueFromMap(S key) {
        if (map == null) {
            return null;
        }

        return map.get(key);
    }
    
    // An overloaded function to get value from map but with a default value
    // if the key is not present
    public T getValueFromMap(S key, T defaultValue) {
        if (map == null) {
            return null;
        }
        
        if (map.containsKey(key)) {
            return map.get(key);
        }
        return defaultValue;
    }
}