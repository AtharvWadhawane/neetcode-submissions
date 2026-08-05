class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //build graph and indegree[]
        List<List<Integer>>graph = new ArrayList<>();

        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }
        int[]indegree = new int[numCourses];

        for(int[] course : prerequisites){
            graph.get(course[1]).add(course[0]);
            indegree[course[0]]++;
        }

        //Initialize queue with 0 indegree courses(independent)
        Queue<Integer>q = new LinkedList<>();

        for(int i=0;i<numCourses;i++){
            if(indegree[i] == 0) q.offer(i);
        }

        //Process the Queue 
        int count = 0;
        while(!q.isEmpty()){
            int course = q.poll();
            count++;
            for(int nbc : graph.get(course)){
                indegree[nbc]--;
                if(indegree[nbc] == 0)
                    q.offer(nbc);
            }
        }
        return count == numCourses;
    }
}
