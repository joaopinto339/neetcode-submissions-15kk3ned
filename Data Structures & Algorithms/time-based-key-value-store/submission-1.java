class TimeMap {
    private static class Pair<K, V> {
        private final K key;
        private final V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    Map<String, List<Pair<Integer, String>>> keyStore;

    public TimeMap() {
        keyStore = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        Pair<Integer,String> pair = new Pair<>(timestamp, value);
        keyStore.computeIfAbsent(key, k -> new ArrayList<>()).add(pair);
    }
    
    public String get(String key, int timestamp) {
        List<Pair<Integer, String>> values = keyStore.getOrDefault(key, new ArrayList<>());
        int l = 0, r = values.size() - 1;
        String res = "";

        while(l <= r){
            int m = (l + r) / 2;
            if(values.get(m).getKey() <= timestamp){
                res = values.get(m).getValue();
                l = m + 1;
            }
            else{
                r = m - 1;
            }
        }
        return res;
    }
}
