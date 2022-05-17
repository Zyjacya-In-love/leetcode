import t1864.Solution;
import t707.MyLinkedList;

import java.util.Arrays;
import java.util.List;

class Main {
    public static void main(String[] args) {
        t707.MyLinkedList linkedList = new t707.MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
        linkedList.get(1);            //返回2
        linkedList.deleteAtIndex(1);  //现在链表是1-> 3
        linkedList.get(1);            //返回3

        // Create a new Solution instance
        t35.Solution solution = new t35.Solution();
//        SwordPointing2OfferⅡ sp2o = new SwordPointing2OfferⅡ();
        // Create a test case
//        String testCase = "/home/";
//        String s = "**|**|****";
//        String s = "***|**|*****|**||**|*";
        int[][] queries = {{2, 5}, {9, 9}};
//        int[][] queries = {{1,17},{4,5},{14,17},{5,11},{15,16}};
//        int[] nums = {0,0,0};
//        int target = 1;
        // Get the answer
//        String answer = solution.simplifyPath(testCase);
//        int[] answer = solution.platesBetweenCandles(s, queries);
//        int answer = solution.translateNum(506);
        int[] nums = {1,3,5,6,7,7};
        String[] words = {"m", "mo", "moc", "moch", "mocha", "l", "la", "lat", "latt", "latte", "c", "ca", "cat"};
//        int answer = solution.countMaxOrSubsets(nums);
//        String answer = solution.longestWord(words);
        String s = "100";
//        Boolean answer = solution.isNumber(s);
        int num = 13;
        int target = 7;
//        int answer = solution.searchInsert(nums, target);
////        int answer = solution.threeSumClosest(nums, target);
//        String beginWord = "leet", endWord = "code";
//        List<String> wordList = new ArrayList<>(Arrays.asList("lest","leet","lose","code","lode","robe","lost"));
//        int answer = sp2o.ladderLength(beginWord, endWord, wordList);
        // Print the answer
//        System.out.println("answer : " + Arrays.toString(answer));
//        System.out.println(answer);
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(array[0]);

//        String t = "1,2,2,3,";
//        String[] split = t.split(",");
//        System.out.println(Arrays.toString(split));

    }
//    static Object[] array = new Object[700000000];
}
