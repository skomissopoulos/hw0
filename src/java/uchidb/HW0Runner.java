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
    private static Containers<Integer, String> containers = new IntegerStringContainers();
    
    // This class is a factory for a singleton containers class.
    // https://www.tutorialspoint.com/java/java_using_singleton.htm
    public static Containers<Integer, String> getContainers() {
        return containers;
    }

    public static void main(String[] args) {

    }
}

class IntegerStringContainers implements Containers<Integer, String> {
    private Map<String, Integer> map;

    public IntegerStringContainers() {
        map = null;
    }

    // Create a set that stores the array of Integers
    public Set<Integer> initSet(Integer[] tArray) {
        return new HashSet<Integer>(Arrays.asList(tArray));
    }
    
    // Create a list that stores an the array of Integers
    public List<Integer> initList(Integer[] tArray) {
        return Arrays.asList(tArray);
    }
    
    // Create an empty map that will use Strings as keys and Integers as values
    public Map<String, Integer> initEmptyMap() {
        return new HashMap<String, Integer>();
    }
    
    // Store the map in a local field variable -- often called a setter 
    public void storeMap(Map<String, Integer> mapToStoreInClass) {
        map = mapToStoreInClass;
    }
    
    // Add a key value to store map with a boolean indicating whether to overwrite existing value
    public boolean addToMap(String key, Integer value, boolean overwriteExistingKey) {
        if (overwriteExistingKey || !map.containsKey(key)) {
            map.put(key, value);
            return true;
        }
        return false;
    }
    
    // Get a value based on a key
    public Integer getValueFromMap(String key) {
        return map.get(key);
    }
    
    // An overloaded function to get value from map but with a default value
    // if the key is not present
    public Integer getValueFromMap(String key, Integer defaultValue) {
        if (map.containsKey(key)) {
            return map.get(key);
        }
        return defaultValue;
    }
}