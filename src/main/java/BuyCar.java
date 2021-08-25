import java.util.Arrays;
import java.util.LinkedHashSet;

class BuyCar {
    public static void main(String[] args) {
        BuyCar carMoney = new BuyCar();
        int dayN = 8;
        int week = 3;

//        System.out.println("Day one money for the week: " + week + ", money: " + carMoney.getDayOneMoneyOfWeek(week));

        System.out.println("Total Money for day N is: " + carMoney.totalMoney(dayN));
    }

    public int totalMoney(int dayN) {
        int defaultTotal = 0;
        int daysOfWeek = 7;

        if(dayN == 0){
            return defaultTotal;
        }

        int countOfWeek = (dayN / daysOfWeek) + 1;

        //计算输入的天数和daysOfWeek的关系，再计算增加一元
        int initialMoneyForTheWeek = 0;
        int deltaMoneyForOneMoreDay = 1;
        int deltaMoneyForOneMoreWeek = 1;
        int weeks = 1;


        int totalMoney = 0;

        for(int i=1; i <= countOfWeek; i++){
            initialMoneyForTheWeek += i;
        }

        if(dayN <= 7){
            int currentDayMoney = 0;

            for(int dayCount=1; dayCount<= dayN; dayCount++){
                if(dayCount == 1) {
                    int dayOneMoneyOfTheWeek = getDayOneMoneyOfWeek(weeks);
                    currentDayMoney = dayOneMoneyOfTheWeek;
                }else{
                    currentDayMoney += deltaMoneyForOneMoreDay;
                }

                System.out.println("Day: " + dayCount + ", currentDayMoney: " + currentDayMoney);

                totalMoney += currentDayMoney;
            }

            System.out.println("totalMoney: " + totalMoney);
        }else{
            weeks = (dayN / daysOfWeek) + 1;
            dayN = dayN - 7 * weeks;

            int additionalWeek = --weeks;
            int daysForPassedWeek = additionalWeek * daysOfWeek;

            int dayOneMoneyOfTheWeek = getDayOneMoneyOfWeek(weeks);
            int currentDayMoney = 0;

            for(int dayCount=1; dayCount<= dayN; dayCount++){
                if(dayCount == 1) {
                    currentDayMoney = dayOneMoneyOfTheWeek;
                }else{
                    currentDayMoney += deltaMoneyForOneMoreDay;
                }

                System.out.println("Day: " + dayCount + ", currentDayMoney: " + currentDayMoney);

                totalMoney += currentDayMoney;
            }

            System.out.println("totalMoney: " + totalMoney);
        }

        return totalMoney;
    }

    private int getDayOneMoneyOfWeek(int week){
        if(week == 0){
            return -1;
        }else if(week == 1){
            return 1;
        }

        return week;
    }
}
