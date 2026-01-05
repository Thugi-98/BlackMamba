# 📌 Java 알고리즘에서 BufferedReader를 사용하는 이유

알고리즘 문제를 처음 풀다 보면  
`Scanner` 대신 `BufferedReader`와 `StringTokenizer`를 사용하는 코드가 많이 보인다.  
이는 **입출력 속도 문제** 때문이다.

---

## 1️⃣ Scanner를 잘 안 쓰는 이유

### ❌ Scanner의 단점

```java
Scanner sc = new Scanner(System.in);
int n = sc.nextInt();
```

- 내부적으로 정규식 처리
- 입력 하나하나 검사 → 느림
- 입력 데이터가 많을 경우 시간 초과 발생 가능

## 2️⃣ BufferedReader를 사용하는 이유

### ✅ BufferedReader의 장점
```java
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
```

- 입력을 한 줄 단위로 한 번에 읽음
- 내부 버퍼 사용 → 입력 속도가 매우 빠름
- 알고리즘 문제의 표준 입력 방식

### 📌 요약 비교

|입력 방식|속도|특징|
|-----|---|---|
|Scanner|❌ 느림|사용은 쉬움|
|BufferedReader	|⭕ 빠름|직접 파싱 필요|

## 3️⃣ StringTokenizer는 왜 쓰는가?

BufferedReader는 한 줄을 문자열로만 읽는다.

```java
String line = br.readLine(); // "1 2 3 4 5"
```

- 이 문자열을 숫자로 나누기 위해 토큰 분리가 필요하다.

❌ split() (비추천)
```java
String[] arr = line.split(" ");
```

- 내부적으로 정규식 사용
- 상대적으로 느림

✅ StringTokenizer (추천)
```java
StringTokenizer st = new StringTokenizer(line);
while (st.hasMoreTokens()) {
    int x = Integer.parseInt(st.nextToken());
}
```

- 공백 기준 빠른 분리
- 알고리즘 문제에서 매우 자주 사용

## 알고리즘 기본 입출력 템플릿
```java
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
StringTokenizer st = new StringTokenizer(br.readLine());

int N = Integer.parseInt(st.nextToken());
```