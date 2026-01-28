import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class N과_M_3 {

    private static int range, digit;
    private static int[] numArr;
    private static StringBuilder result = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        range = Integer.parseInt(st.nextToken());
        digit = Integer.parseInt(st.nextToken());

        numArr = new int[digit];

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

            numArr[depth] = i + 1;

            // 재귀 호출
            backtracking(depth + 1);
		}
	}
}