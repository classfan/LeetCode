package password;

public class PasswordValidator {
    private final int length;

    public PasswordValidator(int length){
        this.length = length;
    }

    public boolean isValid(String input) {
        if(input == null){
            return false;
        }

        //密码长度需要大于5位，且需要包含字母和数字
        return containChar(input) & containNumber(input) && isLengthValid(input);
    }

    private boolean containNumber(String input){
        String REGEX_CONTAINT_NUMBER = ".*[a-zA-Z].*";

        return input.matches(REGEX_CONTAINT_NUMBER);
    }

    private boolean containChar(String input){
        String REGEX_CONTAINT_CHAR = ".*[0-9].*";
        return input.matches(REGEX_CONTAINT_CHAR);
    }

    private boolean isLengthValid(String input){
        return input.length() >= this.length;
    }
}
