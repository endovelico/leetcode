package solutions.p171;

import java.util.HashMap;

// Initial Reasoning
// This is a base conversion problem from base-26 alphabet to base-10 decimal system.
//AB would be equals to (1 * 26^1) + (2 * 26^0) = 28

// Complexity
//Time: O(n) where n is the length of the string
//
//Space: O(1) (just using a few variables)

/*
* Great question! Let's break it down:

---

## 🧠 Why `c - 'A' + 1`?

Characters in Java (and most languages like C/C++, Python, etc.) are essentially **integers** under the hood — each has a **Unicode (or ASCII)** value.

So:

```java
'A' == 65
'B' == 66
...
'Z' == 90
```

Now, in the **Excel column system**:

- `'A'` should map to `1`
- `'B'` to `2`
- ...
- `'Z'` to `26`

But `'A'` has an actual value of `65`. To convert it to `1`, we subtract `'A'`:

```java
'A' - 'A' + 1 = 0 + 1 = 1
'B' - 'A' + 1 = 1 + 1 = 2
...
'Z' - 'A' + 1 = 25 + 1 = 26
```

So:
👉 `c - 'A' + 1` gives the **1-based index** of the character in the alphabet.

---

### 📌 Short version:
`'C' - 'A' + 1 = 3` → "C is the 3rd letter of the alphabet"

---

Let me know if you want a version that shows how this works step-by-step with an example string like `"AB"`.
* */
public class Solution {

    public int titleToNumber(String columnTitle) {

        int result = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            char column_letter = columnTitle.charAt(i);
            result = result * 26 + (column_letter - 'A' + 1);
        }
        return result;

    }
}
