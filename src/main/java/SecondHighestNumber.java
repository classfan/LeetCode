import java.util.Arrays;
import java.util.LinkedHashSet;

class Solution {
    public static void main(String[] args) {
        Solution number = new Solution();
        String testStr5 = "a1b2c3d4e5f6g7h8i9j0k1l1eere22abcdefghijklmnopqqioruqorutypqrqrqalkdjfkajghahznmnvzbmb";

        System.out.println("Second Highest one is: " + number.secondHighest(testStr5));
    }

    public int secondHighest(String param) {
        int defaulSecondHighest = -1;

        if (param == null || param.length() == 0) {
            return defaulSecondHighest;
        }

        //Solution 1 - 排除法 + 排序法
        //Step 1 - 去除非数字的字符
        //Step 2 - 对于数字进行char排序，且去除重复
        //Step 3 - 判断是否有>=2，如果是，则返回第二大的数字


        String usableParam = removeNonNumberChar(param);
        String filteredParam = removeRepeatedChar(usableParam);

        int[] resultNumbers = new int[filteredParam.length()];

        for (int index = 0; index < filteredParam.length(); index++) {
            char eachPosition = filteredParam.charAt(index);

            if (isNumber(eachPosition)) {
                int current = Integer.valueOf(String.valueOf(eachPosition));
                if(current !=0){
                    resultNumbers[index] = current;
                }
            }

            //System.out.println("Each Position: " + eachPosition);
        }

        Arrays.sort(resultNumbers);

        if (resultNumbers.length < 2) {
            return defaulSecondHighest;
        }

        return resultNumbers[resultNumbers.length - 2];

        //Solution 2 - 根据ASCII编码的值进行排序，进行范围过滤

    }

    private boolean isNumber(char input) {
        String exString = String.valueOf(input);
        return exString.matches("[0-9]+");
    }

    private String removeNonNumberChar(String input){
        return input.replaceAll( "[^\\d]", "" );
    }

    private String removeRepeatedChar(String s) {
        //Create LinkedHashSet of type character
        LinkedHashSet<Character> set = new LinkedHashSet<>();
        //Add each character of the string into LinkedHashSet
        for(int i=0;i<s.length();i++) {
            set.add(s.charAt(i));
        }

        // print the string after removing duplicate characters
        StringBuffer sb = new StringBuffer();
        for(Character ch : set) {
            //System.out.print(ch);
            sb.append(ch);
        }
        return sb.toString();
    }
}
