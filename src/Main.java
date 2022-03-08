
class Main {
    public static void main(String[] args) {
        // Create a new Solution instance
        t71.Solution solution = new t71.Solution();
//        SwordPointing2OfferⅡ sp2o = new SwordPointing2OfferⅡ();
        // Create a test case
        String testCase = "/home/";
//        int[] nums = {0,0,0};
//        int target = 1;
        // Get the answer
        String answer = solution.simplifyPath(testCase);
////        int answer = solution.threeSumClosest(nums, target);
//        String beginWord = "leet", endWord = "code";
//        List<String> wordList = new ArrayList<>(Arrays.asList("lest","leet","lose","code","lode","robe","lost"));
//        int answer = sp2o.ladderLength(beginWord, endWord, wordList);
        // Print the answer
        System.out.println("answer : " + answer);

    }
}
