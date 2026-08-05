class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        if(numCourses == 1) return new int[]{0};

        int[]result = new int[numCourses];

        List<List<Integer>>graph = new ArrayList<>();

        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }

        int[]indegree = new int[numCourses];

        for(int[]nb : prerequisites){
            graph.get(nb[1]).add(nb[0]);
            indegree[nb[0]]++;
        }

        Queue<Integer>q = new LinkedList<>();

        for(int i=0;i<numCourses;i++){
            if(indegree[i] == 0) q.offer(i);
        }
        int count = 0,i=0;
        while(!q.isEmpty()){
            int course = q.poll();
            count++;
            result[i++] = course;

            for(int nbc : graph.get(course)){
                indegree[nbc]--;
                if(indegree[nbc] == 0) q.offer(nbc);
            }
        }

        return count == numCourses ? result : new int[0];
    }
}