package softeer2nd.cal;

public class StringProcessor {

    public String[] manipulate(String input) {

        return input.split(" ");
    }

    public boolean isRightSentence(String[] input) {

        if(input.length % 2 == 0) return false;

        for(int i = 0; i <input.length; i++) {

            if(i % 2 == 0 && !isNumber(input[i])) return false;
            if(i % 2 == 1 && !isOperator(input[i])) return false;
        }

        return true;
    }

    private boolean isNumber(String input) {
        try {
            Integer.parseInt(input);

            return true;
        } catch(NumberFormatException e) {
            return false;
        }
    }

    private boolean isOperator(String input) {

        if(input.length() > 1) return false;

        int operator = input.charAt(input.length() - 1);

        return operator == 42 || operator == 43 || operator == 45 || operator == 47;
    }
}
