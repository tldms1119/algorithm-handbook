## 🧭 Two Pointers Pattern

### 📌 When to Use
- Sorted array (정렬된 배열)
- Finding pairs (두 수의 합 / 쌍 찾기 문제)
- Reducing O(n²) brute force to O(n) (O(n²) 완전탐색을 O(n)으로 줄일 수 있을 때)

### 🧠 Core Idea
Use two indices moving toward each other. (양 끝에서 포인터 두 개를 사용해 탐색 범위를 줄인다.)

- Left pointer → start
- Right pointer → end
- Adjust based on comparison (조건에 따라 이동)

### ⏱ Typical Complexity
- Time: O(n)
- Space: O(1)
