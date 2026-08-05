class Pair {
    String str;
    int steps;

    Pair(String str, int steps) {
        this.str = str;
        this.steps = steps;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, Integer> map = new HashMap<>(); // word,int
        int n = wordList.size();

        for (String str : wordList) {
            map.put(str, 1);
        }

        if (!map.containsKey(endWord))
            return 0;

        if (!map.containsKey(beginWord))
            map.put(beginWord, 1);

        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(beginWord, 1));

        map.remove(beginWord);

        while (!q.isEmpty()) {
            Pair p = q.poll();
            String s = p.str;
            int value = p.steps;

            if (s.equals(endWord))
                return value;

            char[] charc = s.toCharArray();
            for (int i = 0; i < charc.length; i++) {
                char og = charc[i];

                for (char c = 'a'; c <= 'z'; c++) {
                    if (c == og)
                        continue; // try 25 combinations not 26
                    charc[i] = c;
                    String s1 = String.valueOf(charc);
                    if (map.containsKey(s1)) {
                        q.offer(new Pair(s1, value + 1));
                        map.remove(s1);
                    }
                }
                charc[i] = og; // to explore other permutaions
            }
        }
        return 0;
    }
}
