package softeer2nd.cal;

public class Calculator {

    StringProcessor processor = new StringProcessor();
    Operator operator = new Operator();

    public String cal(String input) {

        String[] inputs = processor.manipulate(input);
        if (!processor.isRightSentence(inputs)) return "정상적인 식이 아닙니다";

        return operate(inputs);
    }

    private String operate(String[] inputs) {

        int num1 = Integer.parseInt(inputs[0]);
        int num2 = 0;
        String op = "";

        for (int i = 1; i < inputs.length; i++) {
            if(i % 2 == 0) {

                num2 = Integer.parseInt(inputs[i]);

                switch (op) {
                    case "+" -> num1 = operator.add(num1, num2);
                    case "-" -> num1 = operator.min(num1, num2);
                    case "*" -> num1 = operator.mul(num1, num2);
                    case "/" -> num1 = operator.div(num1, num2);
                }
            }

            else op = inputs[i];
        }

        return String.valueOf(num1);
    }
}