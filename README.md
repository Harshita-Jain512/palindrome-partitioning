
# Palindrome Partitioning (LeetCode 131)

## Dry Run for `s = "aabb"`

```
s = "aabb"
indices = 0 1 2 3
chars   = a a b b
```

---

## Initial Call

```
func(index = 0, path = [])
```

---

## Level 1 → index = 0

```
for (i = 0; i < 4; i++)
```

### i = 0

```
substring = s[0..0] = "a"
isPalindrome → true
```

```
path.add("a") → path = ["a"]
func(index = 1, path = ["a"])
```

---

## Level 2 → index = 1

```
for (i = 1; i < 4; i++)
```

### i = 1

```
substring = s[1..1] = "a"
isPalindrome → true
```

```
path.add("a") → path = ["a","a"]
func(index = 2, path = ["a","a"])
```

---

## Level 3 → index = 2

```
for (i = 2; i < 4; i++)
```

### i = 2

```
substring = s[2..2] = "b"
isPalindrome → true
```

```
path.add("b") → path = ["a","a","b"]
func(index = 3, path = ["a","a","b"])
```

---

## Level 4 → index = 3

```
for (i = 3; i < 4; i++)
```

### i = 3

```
substring = s[3..3] = "b"
isPalindrome → true
```

```
path.add("b") → path = ["a","a","b","b"]
func(index = 4, path = ["a","a","b","b"])
```

---

## Base Case → index = 4

```
index == s.length() → 4 == 4
res.add(["a","a","b","b"])
return
```

---

## Back to Level 4 (index = 3)

```
path.remove() → removes last "b"
path = ["a","a","b"]
```

```
for loop ends (i finished)
return
```

---

## Back to Level 3 (index = 2)

```
path.remove() → removes "b"
path = ["a","a"]
```

### Next loop iteration

### i = 3

```
substring = s[2..3] = "bb"
isPalindrome → true
```

```
path.add("bb") → path = ["a","a","bb"]
func(index = 4, path = ["a","a","bb"])
```

---

## Base Case → index = 4

```
res.add(["a","a","bb"])
return
```

---

## Back to Level 3 (index = 2)

```
path.remove() → removes "bb"
path = ["a","a"]
```

```
for loop ends
return
```

---

## Back to Level 2 (index = 1)

```
path.remove() → removes "a"
path = ["a"]
```

### Next loop iterations

### i = 2

```
substring = "ab"
isPalindrome → false (skip)
```

### i = 3

```
substring = "abb"
isPalindrome → false (skip)
```

```
for loop ends
return
```

---

## Back to Level 1 (index = 0)

```
path.remove() → removes "a"
path = []
```

### Next loop iterations

### i = 1

```
substring = "aa"
isPalindrome → true
```

```
path.add("aa") → path = ["aa"]
func(index = 2, path = ["aa"])
```

---

## Level 2 (new branch) → index = 2

```
for (i = 2; i < 4; i++)
```

### i = 2

```
substring = "b"
```

```
path.add("b") → ["aa","b"]
func(index = 3)
```

### i = 3

```
substring = "b"
```

```
path.add("b") → ["aa","b","b"]
func(index = 4)
```

```
res.add(["aa","b","b"])
```

Backtrack step-by-step:

```
remove "b" → ["aa","b"]
remove "b" → ["aa"]
```

---

### i = 3 (at index = 2)

```
substring = "bb"
```

```
path.add("bb") → ["aa","bb"]
func(index = 4)
```

```
res.add(["aa","bb"])
```

```
remove "bb" → ["aa"]
return
```

---

## Back to Level 1

```
path.remove() → []
```

### i = 2 → "aab" ❌

### i = 3 → "aabb" ❌

```
for loop ends
```

---

## ✅ Final Result

```
res = [
  ["a","a","b","b"],
  ["a","a","bb"],
  ["aa","b","b"],
  ["aa","bb"]
]
