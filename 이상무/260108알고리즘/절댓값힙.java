
// 백준 11286
// 절댓값 힙
import java.io.*;
import java.util.*;

public class 절댓값힙 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        // 절댓값이 작은 값이 우선
        // 절댓값이 동일하면 원래 값중 더 작은 값이 우선

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                int absA = Math.abs(a);
                int absB = Math.abs(b);
                if (absA != absB)
                    return absA - absB; // 절댓값 작은 순
                return a - b; // 절댓값 같으면 실제 값 작은 순
                // 여기서 -는 빼기 연산자가 아니다.
                // a - b가 음수면 a가 b보다 우선순위가 높다는 뜻이다.
                // 즉, a = -2, b = 2 라면 절댓값이 같아도 -2가 2보다 우선순위가 높다라는 뜻이다.
            }
        });

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) {
                // 0이면 큐에서 절댓값 기준으로 가장 우선인 값 출력,
                // 없으면 0 출력
                if (pq.isEmpty())
                    sb.append(0).append('\n');
                else
                    sb.append(pq.poll()).append('\n');
            } else {
                // 0이 아니면 큐에 삽입
                pq.add(x);
            }
        }

        System.out.print(sb.toString());
    }
}
