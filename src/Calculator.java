import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Stack;

public class Calculator implements InfixCalculator {
    // priority list 优先级表
    HashMap<String, Integer> map = new HashMap<String, Integer>() {
        {
            put("+", 1);
            put("-", 1);
            put("*", 2);
            put("/", 2);
            put("^", 3);
            put("%", 3);
            put("(", 4);
            put(")", 4);
        }
    };

    /**
     * split expression
     * 1. 包含空格
     * 2. 无法拆分负数
     *
     * @param exp
     * @return
     */
    private ArrayList<String> splitExp(String exp) {
        ArrayList<String> arrayList = new ArrayList<>();
        int flag = 0;
        for (int i = 0; i < exp.length(); ) {
            int start = i;
            if((exp.charAt(i) == '-' || exp.charAt(i) == '+') && i == 0){
                ++i;
                while (i < exp.length() && (exp.charAt(i) == '.' || (exp.charAt(i) >= '0' && exp.charAt(i) <= '9')))
                    ++i;
                String ans = exp.substring(start, i);
                arrayList.add(ans);
                flag = 0;
            }
            else if ((exp.charAt(i) == '-' || exp.charAt(i) == '+') && flag == 1 &&
                    (exp.charAt(i + 1) >= '0' && exp.charAt(i + 1) <= '9')) {
                ++i;
                while (i < exp.length() && (exp.charAt(i) == '.' || (exp.charAt(i) >= '0' && exp.charAt(i) <= '9'))) {
                    ++i;
                }
                String ans = exp.substring(start, i);
                arrayList.add(ans);
                flag = 0;
            } else if (exp.charAt(i) >= '0' && exp.charAt(i) <= '9') {
                while (i < exp.length() && (exp.charAt(i) == '.' || (exp.charAt(i) >= '0' && exp.charAt(i) <= '9'))) {
                    ++i;
                }
                String ans = exp.substring(start, i);
                arrayList.add(ans);
                flag = 0;
            } else {
                if (exp.charAt(i) == ' ') {
                    ++i;
                    continue;
                }
                arrayList.add(String.valueOf(exp.charAt(i)));
                if(exp.charAt(i) == '(' || exp.charAt(i) == ')'){
                    flag = 2;
                }
                else{
                    flag = 1;
                }
                ++i;


            }
        }
        return arrayList;
    }

    /**
     * calculate
     *
     * @param left
     * @param right
     * @param token
     * @return
     */
    private Double operation(Double left, Double right, String token) {
        switch (token) {
            case "+":
                return left + right;
            case "-":
                return left - right;
            case "*":
                return left * right;
            case "/":
                if (right == 0) {
                    throw new RuntimeException("error");
                }
                return left / right;
            case "^":
                return Math.pow(left, right);
            case "%":
                return left % right;
            default:
                throw new RuntimeException("error");
        }
    }

    /**
     * calculate the whole expression
     *
     * @param exp
     * @return
     */
    @Override
    public String evalExp(String exp) {
        ArrayList<String> postfix = new ArrayList<String>();       // 后缀表达式
        Stack<String> operator = new Stack<>();     // 符号
        // split Expression
        ArrayList<String> infix = splitExp(exp);


        // infix to postfix 中缀表达式转后缀表达式
        for (String token : infix) {
            if (map.containsKey(token)) {
                if (!operator.isEmpty()) {
                    if (Objects.equals(token, ")")) {
                        while (!operator.isEmpty() && !Objects.equals(operator.peek(), "(")) {
                            postfix.add(operator.peek());
                            operator.pop();
                        }
                        operator.pop();
                    } else {
                        while (!operator.isEmpty() && map.get(token) <= map.get(operator.peek()) && !Objects.equals(operator.peek(), "(")) {
                            postfix.add(operator.peek());
                            operator.pop();
                        }
                        operator.push(token);
                    }
                } else {
                    operator.push(token);
                }
            } else {
                postfix.add(token);
            }
        }
        while (!operator.isEmpty()) {
            postfix.add(operator.peek());
            operator.pop();
        }

        // calculate the result
        Stack<Double> cal = new Stack<>();
        for (String token : postfix) {
            if (map.containsKey(token)) {
                Double right = cal.peek();
                cal.pop();
                Double left = cal.peek();
                cal.pop();
                cal.push(operation(left, right, token));
            } else {
                cal.push(Double.parseDouble(token));
            }

        }

        return String.valueOf(cal.peek());
    }


}
