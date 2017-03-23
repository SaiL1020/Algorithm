import java.util.*;
/**
 * Created by sail on 9/18/16.
 * Code one more line :)
 */
public class Leet355 {
    Map<Integer, Set<Integer>> userToFollowee;
    Map<Integer, Stack<Integer>> userToTweet;
    Map<Integer, Long> tweetToTime;
    long time;
    class TweetIdAndTime implements Comparable<TweetIdAndTime> {
        int tweetId;
        long time;
        TweetIdAndTime(int id, long tm) {
            tweetId = id;
            time = tm;
        }
        @Override
        public int compareTo(TweetIdAndTime x) {
            return (int)(x.time - this.time);
        }
    }
    /** Initialize your data structure here. */
    public Leet355() {
        userToFollowee = new HashMap<>();
        userToTweet = new HashMap<>();
        tweetToTime = new HashMap<>();
        time = 0;
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        Stack<Integer> sta = userToTweet.getOrDefault(userId, new Stack<>());
        sta.add(tweetId);
        userToTweet.put(userId, sta);
        tweetToTime.put(tweetId, ++time);
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<TweetIdAndTime> tot = new LinkedList<>();
        Stack<Integer> sta = new Stack<>();
        int curTweetId = 0, curSize;
        if (userToTweet.get(userId) != null) {
            sta.addAll(userToTweet.get(userId));
            curSize = Math.min(10, sta.size());
            while (curSize-- > 0) {
                curTweetId = sta.pop();
                tot.add(new TweetIdAndTime(curTweetId, tweetToTime.get(curTweetId)));
            }
        }
        Set<Integer> set = userToFollowee.get(userId);
        if (set != null) {
            for (int followeeId : set) {
                if (userToTweet.get(followeeId) == null) continue;
                sta = new Stack<>();
                sta.addAll(userToTweet.get(followeeId));
                curSize = Math.min(10, sta.size());
                while (curSize-- > 0) {
                    curTweetId = sta.pop();
                    tot.add(new TweetIdAndTime(curTweetId, tweetToTime.get(curTweetId)));
                }
            }
        }

        List<Integer> ans = new LinkedList<>();
        if (tot.size() == 0) return ans;
        Collections.sort(tot);
        curSize = Math.min(10, tot.size());
        for (int i = 0; i < curSize; i++) {
            ans.add(tot.get(i).tweetId);
        }
        return ans;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return ;
        Set<Integer> set = userToFollowee.get(followerId);
        if (set == null) set = new HashSet<>();
        set.add(followeeId);
        userToFollowee.put(followerId, set);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) return ;
        Set<Integer> set = userToFollowee.get(followerId);
        if (set != null) set.remove(followeeId);
        userToFollowee.put(followerId, set);
    }

    public static void main(String[] args) {
        Leet355 obj = new Leet355();
        obj.postTweet(1,5);
        List<Integer> param_1 = obj.getNewsFeed(1);
        print(param_1);
        obj.follow(1,2);
        obj.postTweet(2,6);
        obj.postTweet(2,3);
        obj.postTweet(2,9);
        param_1 = obj.getNewsFeed(1);
        print(param_1);
        obj.unfollow(1,2);
        param_1 = obj.getNewsFeed(1);
        print(param_1);
    }

    public static void print(List<Integer> feed) {
        for (int k : feed) {
            System.out.print(k + " ");
        }
        System.out.println();
    }
}

/*
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
