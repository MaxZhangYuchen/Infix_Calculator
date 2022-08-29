
## 字符串拆分
```private ArrayList<String> splitExp(String exp)```

#### 设一个flag标记前一个有效字符（去除空格）的类型：
1. flag == 0 ```Double```
2. flag == 1 ```+ - * / ^ %```
3. flag == 2 ```( )```

#### 循环遍历拆分
分四种情况
1. 第一个元素为负数（或带有正数符号的正数）
2. 负数（或带有正数符号的正数）在表达式中间
3. 纯数
4. 运算符（除正负数符号）


## 中缀表达式转后缀表达式（逆波兰式）
将运算符优先级记录在hashmap中

1. 入栈字符token为运算符
   1. 将要入栈的运算符token（非左右括号）与operator栈顶运算符进行比较
      1. token优先级大于栈顶，直接放入operator栈中
      2. token优先级小于栈顶
         1. 将栈顶的运算符，放入postfix
         2. pop掉栈顶元素
         3. 再次判断token优先级是否小于栈顶
         4. 循环知道全部符合条件的运算符放入postfix中
         5. 将要curr运算符放到运算符栈栈顶
   2. 当遇到左括号，直接放入运算符栈
   3. 当遇到右括号，遍历到左括号，中间内容全部入栈

2. 入栈字符token为数字，直接进入postfix中


## 后缀表达式计算
从postfix中取出元素放入cal栈中
1. 当postfix中取出的元素为数字时，直接放入cal栈中
2. 当postfix中取出的元素为运算符时
   1. 计算cal栈中栈顶两个元素的计算值
   ```private Double operation(Double left, Double right, String token)```
   2. 将计算结果存入cal栈中


## 项目运行

Main -> main()