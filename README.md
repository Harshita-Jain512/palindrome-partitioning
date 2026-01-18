# sudoko solver
Initial Board (partial view)
Row\Col 0 1 2 3 4 5 6 7 8

0       5 3 . . 7 . . . .
1       6 . . 1 9 5 . . .
2       . 9 8 . . . . 6 .


. → empty cell

Initial Call
solve(board)

Level 1 → First empty cell found
i = 0, j = 2
board[0][2] == '.'

Try digits for board[0][2]
for (c = '1' to '9')

c = '1'
isValid(board, 0, 2, '1')


Checks:

Row 0 → no '1'

Col 2 → no '1'

3×3 box → no '1'

isValid → true

board[0][2] = '1'


Board now:

5 3 1 . 7 . . . .

solve(board)   ← recursive call

Level 2 → Next empty cell
i = 0, j = 3
board[0][3] == '.'

Try digits for board[0][3]
c = '1'
Row already has '1' → invalid
(skip)

c = '2'
isValid → true

board[0][3] = '2'


Board:

5 3 1 2 7 . . . .

solve(board)

Level 3 → Next empty cell
i = 0, j = 5
board[0][5] == '.'

Try digits for board[0][5]
c = '1' ❌ (row conflict)
c = '2' ❌ (row conflict)
c = '3' ❌
c = '4' ✅
board[0][5] = '4'


Board:

5 3 1 2 7 4 . . .

solve(board)

Level 4 → Next empty cell
i = 0, j = 6
board[0][6] == '.'

Try digits for board[0][6]
c = '1' ❌
c = '2' ❌
c = '3' ❌
c = '4' ❌
c = '5' ❌
c = '6' ❌
c = '7' ❌
c = '8' ❌
c = '9' ❌
No valid digit found

❌ DEAD END REACHED
return false

🔙 Backtrack to Level 3 (cell 0,5)

We come back here:

if (solve(board) == true)
    return true;
else
    board[i][j] = '.';

board[0][5] = '.'


Board restored:

5 3 1 2 7 . . . .

Level 3 → Try next digit
c = '5' ❌
c = '6' ❌
c = '7' ❌
c = '8' ✅ // iski iteration 4 ke baad puri nhi hui so... now starting with 5
board[0][5] = '8'

solve(board)

Level 4 → board[0][6] again
Try digits
c = '4' ✅
board[0][6] = '4'

solve(board)

Level 5 → Next empty cell
i = 0, j = 7


Try digits…

Eventually:

board[0][7] = '9'

solve(board)

Level 6 → Next empty cell
i = 0, j = 8

board[0][8] = '6'

✔ Row 0 COMPLETED
5 3 1 2 7 8 4 9 6

Move to Row 1
i = 1, j = 1
board[1][1] == '.'


Repeat SAME PROCESS:

Try digits

Place

Recurse

Fail → Backtrack

Succeed → Continue

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
