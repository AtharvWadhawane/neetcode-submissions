 /* Only HashMap approach 

set function : 
check if key is there if yes update the value 
if not there then make key and put values 

get function : 
If the key does not exist → return "" (case 1)

If the key exists and the exact timestamp exists → return its value (case 2)

If the key exists but the timestamp does not exist →
return the value with the largest timestamp ≤ given timestamp (case 3)

If no such timestamp exists → return "" (case 4)
*/

class TimeMap {
    
    // key -> (timestamp -> value)
    Map<String,HashMap<Integer,String>> map ;

    public TimeMap() {
        map = new HashMap<>();    
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key,new HashMap<>());
        map.get(key).put(timestamp,value);
    }
    
    public String get(String key, int timestamp) {

        if(!map.containsKey(key)) return ""; //case  1

        // case 2 & 3
        Map<Integer,String>timeMap = map.get(key);
        int maxtime = -1;
        String result = "";  //case 4 if not found return empty string 

        for(int t : timeMap.keySet()){

            if(t<=timestamp && t > maxtime){
                maxtime = t;
                result = timeMap.get(t);
            }
        }
        return result;        
    }
}
