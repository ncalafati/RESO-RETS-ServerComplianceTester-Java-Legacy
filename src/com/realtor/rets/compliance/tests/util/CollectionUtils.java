package com.realtor.rets.compliance.tests.util;

import java.util.*;

/**
 * utility for formatting hashmap keys
 * 
 * @author pobrien
 */
public class CollectionUtils {

    private CollectionUtils() {

    }

    /**
     * 
     * @param map
     *            HashMap from a RETS transaction
     * 
     * @return keyMap with keys in lowercase
     */

    public static Map<String, Object> copyLowerCaseMap(Map<?, ?> map) {
        if (map==null){
            return null;
        }
        HashMap<String, Object> keyMap = new HashMap<String, Object>();
        Iterator<?> keys = map.keySet().iterator();
        while (keys.hasNext()) {
            String key = (String) keys.next();
            Object value = map.get(key);
            if (key != null) {
                key = key.toLowerCase();
            }
            keyMap.put(key, value);
        }
        return keyMap;
    }

    public static boolean hasValue(Map<?, ?> map, String key, String val) {
        if (map==null){
            return false;
        }
        Collection<?> col = (Collection<?>) map.get(key);
        if (col==null){
            return false;
        }
        Iterator<?> itr = col.iterator();
        while (itr.hasNext()) {
            String str = (String) itr.next();
            if (str.equalsIgnoreCase(val)) {
                return true;
            }
            if (str.toLowerCase().startsWith(val)) {
                return true;
            }
        }
        return false;
    }

    public static int keyCount(Map<?, ?> map, String key) {
        if (map==null){
            return 0;
        }
        Collection<?> col = (Collection<?>) map.get(key);
        if (col==null){
            return 0;
        }
        return col.size();

    }
    
    public static List getListFromIterator(Iterator thisIterator) {
        List listOfStuff = new ArrayList();
        while (thisIterator.hasNext()) {
            listOfStuff.add(thisIterator.next());
        }
        
        return listOfStuff;
    }

}
