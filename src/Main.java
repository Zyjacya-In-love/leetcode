import java.util.Arrays;

/**
 * 错题记录
 * 1. 剑指 Offer 04. 二维数组中的查找 2022.3.10
 * 2. 剑指 Offer 36. 二叉搜索树与双向链表 2022.3.20
 * 3. 剑指 Offer 64. 求1+2+…+n 2022.3.25
 * 4. 剑指 Offer 68 - I. 二叉搜索树的最近公共祖先 2022.3.26
 * 5. 剑指 Offer 65. 不用加减乘除做加法 2022.3.26
 * 6. 剑指 Offer 56 - I. 数组中数字出现的次数 2022.3.27
 * 7. 剑指 Offer 62. 圆圈中最后剩下的数字 2022.3.29
 * 8. 剑指 Offer 20. 表示数值的字符串 2022.3.31
 * 9. 剑指 Offer 67. 把字符串转换成整数 2022.3.31
 * 10. 剑指 Offer 59 - I. 滑动窗口的最大值 2022.4.1
 */

class Main {
    public static void main(String[] args) {
        // Create a new Solution instance
        lcof20.Solution solution = new lcof20.Solution();
//        SwordPointing2OfferⅡ sp2o = new SwordPointing2OfferⅡ();
        // Create a test case
//        String testCase = "/home/";
//        String s = "**|**|****";
//        String s = "***|**|*****|**||**|*";
        int[][] queries = {{2,5}, {9,9}};
//        int[][] queries = {{1,17},{4,5},{14,17},{5,11},{15,16}};
//        int[] nums = {0,0,0};
//        int target = 1;
        // Get the answer
//        String answer = solution.simplifyPath(testCase);
//        int[] answer = solution.platesBetweenCandles(s, queries);
//        int answer = solution.translateNum(506);
        int[] nums = {3,2,1,5};
        String[] words = {"m","mo","moc","moch","mocha","l","la","lat","latt","latte","c","ca","cat"};
//        int answer = solution.countMaxOrSubsets(nums);
//        String answer = solution.longestWord(words);
        String s = "    .1  ";
        Boolean answer = solution.isNumber(s);
////        int answer = solution.threeSumClosest(nums, target);
//        String beginWord = "leet", endWord = "code";
//        List<String> wordList = new ArrayList<>(Arrays.asList("lest","leet","lose","code","lode","robe","lost"));
//        int answer = sp2o.ladderLength(beginWord, endWord, wordList);
        // Print the answer
//        System.out.println("answer : " + Arrays.toString(answer));
        System.out.println(answer);
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(array[0]);

    }
//    static Object[] array = new Object[700000000];
}
