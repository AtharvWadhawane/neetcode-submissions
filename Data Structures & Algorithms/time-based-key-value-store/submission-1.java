class TimeMap {
    // key , [timestamp,value]

    Map<String,List<Pair>> map;

    class Pair{
        int time;
        String value;

        Pair(int time, String value){
            this.time = time;
            this.value = value;
        }
    }

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key,new ArrayList<>());
        map.get(key).add(new Pair(timestamp,value));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";

        List<Pair> list = map.get(key); // access the values of given key

        int l = 0, r = list.size()-1;
        String result ="";

        while(l<=r){
            int mid = l+(r-l)/2;

            if(list.get(mid).time <= timestamp){
                result = list.get(mid).value;
                l = mid+1; // find higher 
            }else{
                r = mid-1;
            }
        }
        return result;
    }
}