import java.util.*;
import java.io.*;

public class 좋은수 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 수의 개수

        // N개의 수를 입력받아 배열 A[N]에 저장
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        // 배열 A 오름차순 정렬
        Arrays.sort(A);

        // 투 포인터 활용
        int count = 0;
        int i;
        int j;
        for(int k=0; k<N; k++) {
            i = 0;
            j = N-1;
            while(i<j) {
                if( i != k && j != k) {
                    if(A[i]+A[j] < A[k]) {
                        i++;
                    } else if (A[i]+A[j] > A[k]) {
                        j--;
                    } else {
                        i++;
                        j--;
                        count++;
                        break;
                    }
                } else if (i == k) {
                    i++;
                } else if (j == k) {
                    j--;
                }
            }
        }
        
        // 결과 출력
        System.out.println(count);
        br.close();
    }
}