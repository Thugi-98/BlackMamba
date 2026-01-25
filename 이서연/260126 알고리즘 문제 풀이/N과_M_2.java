import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class N과_M_2 {

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

		if (depth == digit) {

			for (int val : numArr) {
				result.append(val).append(' ');
			}

			result.append('\n');
			return;
		}
 
		for (int i = 0; i < range; i++) {

			if (!visit[i]) {

                // 이전 depth에 저장된 값이 현재 저장할 값보다 크면 건너뛰기
                if (depth != 0 && numArr[depth-1] > i+1) {
                    continue;
                }

				visit[i] = true;
				numArr[depth] = i + 1;

				backtracking(depth + 1);

				visit[i] = false;
			}
		}
	}
}

// numArr = [0, 0]
// visit = [false, false, false, false]

// depth    i     visit[i]   numArr[depth-1] ? i+1               visit[i]              numArr[depth]
//   0      0      false              -                [true,  false, false, false]      [0+1, 0]
//   1      0      true
//   1      1      false            1 < 2              [true,  true,  false, false]      [0+1, 1+1]
//   2  => 출력 : 1 2
//   1      1(기존)                                     [true,  false, false, false]
//   1      2      false            1 < 3              [true,  false, true,  false]      [0+1, 2+1]
//   2  => 출력 : 1 2
//   1      2(기존)                                     [true,  false, false, false]
//   1      3      false            1 < 4              [true,  false, false, true ]      [0+1, 3+1]
//   2  => 출력 : 1 2
//   1      3(기존)                                     [true,  false, false, false]
//   1  => for문 종료
//   0      0(기존)                                     [false, false, false, false]
//   0      1      false              -                [false, true,  false, false]      [1+1, 3+1]
//   1      0      false            2 > 1 => X
//   1      1      true
//   1      2      false            2 < 3              [false, true,  true,  false]      [1+1, 2+1]
//   2  => 출력 : 2 3
//   1      2(기존)                                     [false, true,  false, false]
//   1      3      false            2 < 4              [false, true,  false, true ]      [1+1, 3+1]
//   2  => 출력 : 2 4
//   1      3(기존)                                     [false, true,  false, false]
//   1  => for문 종료
//   0      1(기존)                                     [false, false, false, false]