// 백준 1874
// 스택 수열 문제
import java.io.*;
import java.util.*;

public class 스택으로수열 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        int n = Integer.parseInt(br.readLine());
        int curr = 1;
        for (int i = 0; i < n; i++) {
            int target = Integer.parseInt(br.readLine());
            while (curr <= target) {
                stack.push(curr++);
                sb.append("+\n");
            }
            if (stack.peek() == target) {
                stack.pop();
                sb.append("-\n");
            } else {
                System.out.print("NO\n");
                return;
            }
        }
        System.out.print(sb.toString());
    }
}
