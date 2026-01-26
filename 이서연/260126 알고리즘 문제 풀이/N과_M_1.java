import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class N과_M_1 {

    private static int range, digit;
    private static int[] numArr;
    private static boolean[] visit;
    private static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        range = Integer.parseInt(st.nextToken());
        digit = Integer.parseInt(st.nextToken());

        numArr = new int[digit];
        visit = new boolean[range];
        
        backtracking(0);

        System.out.print(result);
    }

    private static void backtracking(int depth) {

		// 배열 출력
		if (depth == digit) {

			for (int val : numArr) {
				result.append(val).append(' ');
			}
			result.append('\n');
			return;
		}
 
		for (int i = 0; i < range; i++) {

			if (!visit[i]) {

				// visit 변환 및 배열에 해당 값 추가
				visit[i] = true;
				numArr[depth] = i + 1;

				// 재귀 호출
				backtracking(depth + 1);

				// visit 원래대로 되돌려놓기
				visit[i] = false;
			}
		}
	}
}

// numArr = [0, 0, 0, 0]
// visit = [false, false, false, false]

// depth    i       visit[i]              visit[i]                 numArr[depth]
//   0      0        false      [true,  false, false, false]     [0+1, 0, 0, 0]
//   1      0        true
//   1      1        false      [true,  true,  false, false]     [0+1, 1+1, 0, 0]
//   2      0        true
//   2      1        true
//   2      2        false      [true,  true,  true,  false]     [0+1, 1+1, 2+1, 0]
//   3      0        true
//   3      1        true
//   3      2        true
//   3      3        false      [true,  true,  true,  true ]     [0+1, 1+1, 2+1, 3+1]
//   4  => 출력 : 1 2 3 4
//   3      3(기존)              [true,  true,  true,  false]
//   3  => for문 종료
//   2      2(기존)              [true,  true,  false, false]
//   2      3        false      [true,  true,  false, true ]     [0+1, 1+1, 3+1, 3+1]
//   3      0        true
//   3      1        true
//   3      2        false      [true,  true,  true,  true ]     [0+1, 1+1, 3+1, 2+1]
//   4  => 출력 : 1 2 4 3
//   3      2(기존)              [true,  true,  false, true ]
//   3      3        true
//   3  => for문 종료
//   2      3(기존)              [true,  true,  false, false]
//   2  => for문 종료
//   1      1(기존)              [true,  false, false, false]
//   1      2        false      [true,  false, true,  false]     [0+1, 2+1, 3+1, 2+1]
//   2      0        true
//   2      1        false      [true,  true,  true,  false]     [0+1, 2+1, 1+1, 2+1]
//   3      0        true
//   3      1        true
//   3      2        true
//   3      3        false      [true,  true,  true,  true ]     [0+1, 2+1, 1+1, 3+1]
//   4  => 출력 : 1 3 2 4
//   3      3(기존)              [true,  true,  true,  false]
//   3  => for문 종료
//   2      1(기존)              [true,  false, true,  false]
//   2      2        true
//   2      3        false      [true,  false, true,  true ]     [0+1, 2+1, 3+1, 3+1]
//   3      0        true
//   3      1        false      [true,  true,  true,  true ]     [0+1, 2+1, 3+1, 1+1]
//   4  => 출력 : 1 3 4 2