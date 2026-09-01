class Solution {
    public int[] asteroidCollision(int[] asteroids) {

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i : asteroids) {
            boolean destroyed = false;
            while (!stack.isEmpty() && i < 0 && stack.peek() > 0) {
                if ((i * -1) > stack.peek()) { //incoming bigger
                    stack.pop();
                    continue;
                } else if ((i * -1) == stack.peek()) {
                    stack.pop();
                }
                destroyed = true;
                break;
            }
            if(destroyed)
                continue;
            stack.push(i);

        }

        int[] ans = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty()) {
            ans[i++] = stack.pollLast();
        }

            //Incase to avoid confusion in pollLast------>
        // int[] ans = new int[stack.size()];
        // for (int i = stack.size() - 1; i >= 0; i--) {
        //     ans[i] = stack.pop(); // preserve left-to-right order
        // }

        return ans;
    }
}