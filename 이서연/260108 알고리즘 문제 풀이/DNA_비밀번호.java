import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class DNA_비밀번호 {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 전체 문자열의 길이와 부분 문자열의 길이
        StringTokenizer st1 = new StringTokenizer(br.readLine());

        int totalLen = Integer.parseInt(st1.nextToken());
        int subLen = Integer.parseInt(st1.nextToken());
        
        // 임의의 DNA 문자열
        String totalString = br.readLine();

        // {‘A’, ‘C’, ‘G’, ‘T’} 의 최소 개수
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        
        int[] leastNumArr = new int[4];
        for (int i = 0; i <= 3; i++) {
            leastNumArr[i] = Integer.parseInt(st2.nextToken());
        }

        int result = 0;

        // 첫 번째 경우
        String password = totalString.substring(0, subLen);

        int[] countArr = new int[4];

        // 부분 문자열을 순회하며 A, C, G, T 개수 카운트
        for (char c : password.toCharArray()) {
            countArr[findIndex(c)]++;
        }

        // 첫 번째 문자열의 패스워드 사용 가능 여부 확인
        if (checkLeastNum(leastNumArr, countArr)) {
            result++;
        }

        // 부분문자열 한 칸씩 이동
        for (int i = 1; i <= totalLen - subLen; i++) {
            
            // 지나간 문자열의 count 제거
            char removedChar = totalString.charAt(i-1);
            countArr[findIndex(removedChar)]--;

            // 새로운 문자열의 count 추가
            char newChar = totalString.charAt(i+subLen-1);
            countArr[findIndex(newChar)]++;

            // 패스워드 사용 가능 여부 확인
            if (checkLeastNum(leastNumArr, countArr)) {
                result++;
            }
        }

        System.out.println(result);
    }

    // 
    private static boolean checkLeastNum(int[] leastNumArr, int[] countArr) {

        return leastNumArr[0] <= countArr[0]
                && leastNumArr[1] <= countArr[1]
                && leastNumArr[2] <= countArr[2]
                && leastNumArr[3] <= countArr[3];
    }

    private static int findIndex(char c) {
        
        switch (c) {
            case 'A':
                return 0;

            case 'C':
                return 1;
            
            case 'G':
                return 2;

            case 'T':
                return 3;
        }

        return -1;
    }
}