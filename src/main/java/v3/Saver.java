package v3;

public class Saver {
    private final int day;
    private final int daysOfWeek = 7;
    private final int eachDayIncreament = 1;
    private final int eachWeekIncrement = 1;
    private final int initialMoney = 1;

    public Saver(int day) {
        this.day = day;
    }

    public int amount() {
        int total = 0;
        int weekOneTotal = 0;
        int wholeWeekTotal = 0;
        int weekTwoTotal = 0;

        //当前天数是某一周的第几天
        int dayOnWeek = day%7;

        //当前天数是第几周
        int currentWeek = day/7 + 1;
        int dayMoneyOfWeekStart = 0;
        int dayMoneyOnWeekOne = 1;

        for(int i=1; i<=day; i++){
            //第一周计算好
            if(currentWeek == 1) {
                dayMoneyOfWeekStart = dayMoneyOnWeekOne;
                weekOneTotal = weekOneTotal + i;
            }else{
                dayMoneyOfWeekStart = dayMoneyOnWeekOne + i;
                //current
                wholeWeekTotal = weekOneTotal * (currentWeek - 1);
            }
        }

        return total;
    }

    public int getMoneyFirstWeek(){
        int totalForFirstWeek =  0;
        int theDayMoney = this.initialMoney;

        for(int dayPosition=1; dayPosition<=this.daysOfWeek; dayPosition++){
            if(dayPosition > 1) {
                theDayMoney = this.initialMoney + this.eachDayIncreament * (dayPosition-1);
            }
            totalForFirstWeek += theDayMoney;
        }
        return totalForFirstWeek;
    }

    //计算得到某一天属于该周第几天
    public int weekDayOfTheDay(int theDay){
        if(theDay%this.daysOfWeek == 0){
            return 7;
        }
        return (int)theDay%this.daysOfWeek;
    }

    //计算得到某一天属于第几周
    public int weekOfTheDay(int theDay){
        return (int)Math.ceil((float)theDay/this.daysOfWeek);
    }

    public boolean isFullWeek(int theDay){
        return theDay%7 == 0;
    }
}
