import java.util.Arrays;

/**
 * 错题记录
 * 1. 剑指 Offer 04. 二维数组中的查找 2022.3.10
 */

class Main {
    public static void main(String[] args) {
        // Create a new Solution instance
        t393.Solution solution = new t393.Solution();
//        SwordPointing2OfferⅡ sp2o = new SwordPointing2OfferⅡ();
        // Create a test case
//        String testCase = "/home/";
//        String s = "**|**|****";
//        String s = "***|**|*****|**||**|*";
//        int[][] queries = {{2,5}, {9,9}};
//        int[] data = {197,130,1};
//        int[] data = {235,140,4};
//        int[] data = {145};
        int[] data = {250,145,145,145,145};
//        int[][] queries = {{1,17},{4,5},{14,17},{5,11},{15,16}};
//        int[] nums = {0,0,0};
//        int target = 1;
        // Get the answer
//        String answer = solution.simplifyPath(testCase);
//        int[] answer = solution.platesBetweenCandles(s, queries);
////        int answer = solution.threeSumClosest(nums, target);
        boolean answer = solution.validUtf8(data);
//        String beginWord = "leet", endWord = "code";
//        List<String> wordList = new ArrayList<>(Arrays.asList("lest","leet","lose","code","lode","robe","lost"));
//        int answer = sp2o.ladderLength(beginWord, endWord, wordList);
        // Print the answer
        System.out.println("answer : " + answer);

//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(array[0]);

    }
//    static Object[] array = new Object[700000000];
}
