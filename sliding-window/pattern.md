## Sliding Window Pattern

### 📌 When to Use
- Find longest/shortest **subarray or substring** satisfying specific condition
- Problems where window expands until invalid then contracts until valid again

### 🧠 Core Template
```java
int left = 0;
for(int right = 0; right < n; right++){
  // include element at right into window
  while(/* window is invalid on specific condition */){
    // remove element at left from window (contract window)
    left++;
  }
  // update answer
}
```
