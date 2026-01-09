import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

class 절댓값_힙 {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int operations = Integer.parseInt(br.readLine());

        // 우선순위가 낮은 숫자부터 출력
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            
            @Override
            public int compare(Integer o1, Integer o2) {
            // 반환값	의미	     정렬 결과
            // 음수     o1 < o2	    o1이 앞
            // 0	   o1 == o2    순서 유지
            // 양수 	o1 > o2 	o1이 뒤

                int abs1 = Math.abs(o1);
                int abs2 = Math.abs(o2);

                if (abs1 != abs2) {
                    // 절댓값이 작은 수가 우선
                    return abs1 - abs2;
    
                } else {
                    // 절댓값이 같으면 원래 값 비교
                    return o1 - o2;
                    // 원래 값도 같으면 FIFO
                }
            }
        });

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < operations; i++) {
            
            int num = Integer.parseInt(br.readLine());

            // 0 입력 시
            if (num == 0) {
                if (!queue.isEmpty()) {

                    // queue의 첫 번째 값 출력
                    result.append(queue.poll()).append("\n");

                } else {

                    // queue가 비어있으면 0 출력
                    result.append(0).append("\n");
                }
            } else {

                // 그 외 숫자 입력시 queue에 추가
                queue.add(num);
            }
        }

        System.out.println(result);
    }
}

// 입력     힙                        출력
// 1       1
// -1      1, -1
// 0       1                         -1
// 0                                 1
// 0                                 0
// 1       1
// 1       1, 1
// -1      1, 1, -1
// -1      1, 1, -1, -1
// 2       1, 1, -1, -1, 2
// -2      1, 1, -1, -1, 2, -2
// 0       1, 1, -1, -1, 2           -1
// 0       1, 1, -1, 2               -1
// 0       1, 1, 2                   1
// 0       1, 2                      1
// 0       2                         -2
// 0                                 2
// 0                                 0