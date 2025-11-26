import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P4_2 {
    public interface Operation {
        int apply(int a, int b) throws Exception;
    }

    public static class UnknownOperationException extends Exception {
        public UnknownOperationException(String name) {
            super("Unknown operation: " + name);
        }
    }

    public static class Calculator {
        private final Map<String, Operation> ops = new HashMap<>();

        public Calculator() {
            ops.put("add", (a, b) -> a + b);
            ops.put("sub", (a, b) -> a - b);
            ops.put("mul", (a, b) -> a * b);
            ops.put("div", (a, b) -> {
                if (b == 0) throw new Exception("Cannot divide by zero");
                return a / b;
            });
        }

        public int execute(String opName, int a, int b) throws Exception {
            if (!ops.containsKey(opName)) throw new UnknownOperationException(opName);
            return ops.get(opName).apply(a, b);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator c = new Calculator();
        int success = 0;
        int fail = 0;

        while (true) {
            String op = sc.next();
            if (op.equals("exit")) break;
            int a = sc.nextInt();
            int b = sc.nextInt();

            try {
                int result = c.execute(op, a, b);
                System.out.println("result = " + result);
                success++;
            } catch (Exception e) {
                System.out.println("error = " + e.getMessage());
                fail++;
            }
        }

        System.out.println("success = " + success);
        System.out.println("fail = " + fail);
    }
}
