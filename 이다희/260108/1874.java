import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Integer> stack = new Stack<>();

        int N = Integer.parseInt(br.readLine());

        int count = 1;

        for (int i = 0; i < N; i++) {

            int seq = Integer.parseInt(br.readLine());

            for (int j = count; j <= seq; j++) {
                stack.push(count);
                count++;
                sb.append("+\n");
            }

            if (stack.peek() == seq) {
                stack.pop();
                sb.append("-\n");
            } else {
                System.out.println("NO");
                return;
            }
        }

        System.out.println(sb.toString());
    }
}