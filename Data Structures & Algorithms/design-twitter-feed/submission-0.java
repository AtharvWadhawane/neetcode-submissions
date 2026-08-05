
class Tweet{
    int tweetId,time;

    Tweet(int tId, int t){
        tweetId = tId;
        time = t;
    }
}
class Twitter {
    
    //key -> userId , value -> list of users tweet [[tweetId,time],...]
    Map<Integer , List<Tweet>> postTweets;

    //key -> followerId , value -> set of followee
    Map<Integer,Set<Integer>>relationship;

    int time; //for recent tweet retrieval

    

    public Twitter() {
        postTweets = new HashMap<>();
        relationship = new HashMap<>();
        time = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        time++;
        postTweets.putIfAbsent(userId,new ArrayList<>());
        postTweets.get(userId).add(new Tweet(tweetId,time));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> maxHeap = new PriorityQueue<>(
        (a, b) -> b.time - a.time
    );

    Set<Integer> users = new HashSet<>();
    users.add(userId);

    if (relationship.containsKey(userId)) {
        users.addAll(relationship.get(userId));
    }

    for (int user : users) {
        List<Tweet> userTweets = postTweets.get(user);

        if (userTweets != null) {
            for (Tweet t : userTweets) {
                maxHeap.offer(t);
            }
        }
    }

    List<Integer> result = new ArrayList<>();

    while (!maxHeap.isEmpty() && result.size() < 10) {
        result.add(maxHeap.poll().tweetId);
    }

    return result;
        
    }
    
    public void follow(int followerId, int followeeId) {

      if(followerId == followeeId) return; //saftey

      relationship.putIfAbsent(followerId,new HashSet<>());
      relationship.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        
        if(!relationship.containsKey(followerId)) return; //does not follow anyone

        relationship.get(followerId).remove(followeeId);
    }
}
