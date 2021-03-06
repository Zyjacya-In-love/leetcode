package t71;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 71. 简化路径
 * https://leetcode-cn.com/problems/simplify-path/
 * @author xzq
 * @create 2022-03-08-10:16
 */
//class Solution {
//    public String simplifyPath(String path) {
//        Deque<String> pathQueue = new LinkedList<String>();
//        for(int i = 0; i < path.length(); ) {
//            while(i < path.length() && path.charAt(i) == '/') i++;
//            int post_i = i;
//            while(post_i < path.length() && path.charAt(post_i) != '/') post_i++;
//            String now = path.substring(i, post_i);
////            System.out.println("now : " + now);
//            if(now.equals(".") || now.equals("")) {
//
//            } else if(now.equals("..")) {
//                if(!pathQueue.isEmpty()) {
//                    pathQueue.pollLast();
//                }
//                System.out.println(pathQueue.toString());
//            } else {
//                pathQueue.offerLast(now);
//            }
//            i = post_i;
//        }
//        StringBuilder pwd = new StringBuilder(10);
//        while(!pathQueue.isEmpty()) {
//            pwd.append("/");
//            pwd.append(pathQueue.pollFirst());
//        }
////        System.out.println("pwd : "  +pwd);
//        if(pwd.length() == 0) {
//            pwd.append("/");
//        }
//        return pwd.toString();
//    }
//}

/*
 * @create 2022-05-21-15:17
 */
class Solution {
    public String simplifyPath(String path) {
        String[] splits = path.split("/");
        Deque<String> stack = new LinkedList<>();
        for (String split : splits) {
            if (split.isEmpty() || split.equals(".")) continue;
            if (split.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(split);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append("/");
            sb.append(stack.pollLast());
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }
}
// 通过   3 ms	41 MB