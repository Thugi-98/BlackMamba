import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
                if (Math.abs(a) == Math.abs(b)) {
                    return a - b;
                } else {
                    return Math.abs(a) - Math.abs(b);
                }
            }
        );

        for (int i = 0; i < N; i++) {

            int x = Integer.parseInt(br.readLine());

            if (x == 0) {
                
                if (pq.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(pq.poll());
                }

            } else {
                pq.add(x);
            }
        }
    }
}