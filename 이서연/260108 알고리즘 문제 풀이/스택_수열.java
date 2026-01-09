import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class 스택_수열 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int range = Integer.parseInt(br.readLine());

        int[] targetArr = new int[range];
        for(int i = 0; i < range; i++) {
            targetArr[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> stack = new Stack<>();

        StringBuilder result = new StringBuilder();

        int num = 1;

        for (int i = 0; i < range; i++) {
            
            int target = targetArr[i];

            if (target >= num) {
                
                // num이 target과 같아질 때까지 push
                while (target >= num) {
                    
                    stack.push(num);
                    result.append("+\n");
                    num++;
                }

                // 같아진 num pop
                stack.pop();
                result.append("-\n");

            } else {

                int poppedNum = stack.pop();
                if (poppedNum > target) {
                    result = new StringBuilder("NO");
                    break;
                }
                result.append("-\n");

            }
        }

        System.out.println(result);
    }
}

// range:  1 2 3 4 5 6 7 8
// target: 4 3 6 8 7 5 2 1

// target: 4
// push 1 2 3 4
// pop 4
// + + + + -
// stack 상태: 1 2 3

// target: 3
// pop 3
// -
// stack 상태: 1 2

// target: 6
// push 5 6
// pop 6
// + + - 
// stack 상태: 1 2 5

// target: 8
// push 7 8
// pop 8
// + + -
// stack 상태: 1 2 5 7

// target: 5
// pop 5
// -
// stack 상태: 1 2

// target: 2
// pop 2
// -
// stack 상태: 1

// target: 1
// pop 1
// -
// stack 상태: -



// range:  1 2 3 4 5
// target: 1 2 5 3 4

// target: 1
// push 1
// pop 1
// + -
// stach 상태: -

// target: 2
// push 2
// pop 2
// + -
// stach 상태: -

// target: 5
// push 3 4 5
// pop 5
// + + + -
// stach 상태: 3 4

// target: 3
// stach 상태: 3 4
// 3을 꺼내려면 4부터 꺼내야됨
// pop 시도하면 4 -> pop한 결과 > target