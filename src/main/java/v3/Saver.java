package v3;

public class Saver {
    private final int day;
    private final int daysOfWeek = 7;
    private final int eachDayIncreament = 1;
    private final int eachWeekIncreament = 1;
    private final int initialMoney = 1;

    public Saver(int day) {
        this.day = day;
    }

    public int moneyOn(int theDay){
        //第一周的就跟当天的位置一一匹配，公式是：moneyOnDay = initial + (i-1)*delta
        //第二周的，第二周第一天比第一周第一天多增量元，moneyOnDay = secondWeekInitial + (i-1)*delta
        int week = this.weekOf(theDay);
        int weekDay = this.weekDayOf(theDay);

        return this.initialMoneyInTheWeekOf(theDay) + (weekDay - 1)*this.eachDayIncreament;
    }

    //计算得到某一天属于该周第几天
    public int weekDayOf(int theDay){
        if(theDay%this.daysOfWeek == 0){
            return 7;
        }
        return (int)theDay%this.daysOfWeek;
    }

    //计算得到某一天属于第几周
    public int weekOf(int theDay){
        return (int)Math.ceil((float)theDay/this.daysOfWeek);
    }

    public int initialMoney(){
        return this.initialMoney;
    }

    public int initialMoneyInTheWeekOf(int theDay){
        return this.initialMoney() + (this.weekOf(theDay) - 1) * this.eachWeekIncreament;
    }

    public int initialMoneyOn(int week){
        return this.initialMoney() + (week-1) * this.eachWeekIncreament;
    }

    public boolean isFullWeek(int theDay){
        return theDay%7 == 0;
    }

    public int moneyForFirstWeek(int theDay){
        int totalForFirstWeek =  0;
        int varDay = 0;

        if(theDay == 7) {
            varDay = this.daysOfWeek;
        }else{
            varDay = theDay;
        }

        for (int i = 0; i < varDay; i++) {
            int theDayMoney = this.initialMoney + this.eachDayIncreament * i;
            totalForFirstWeek += theDayMoney;
        }

        return totalForFirstWeek;
    }

    /**
     * 处理整周部分的钱，第一周的不在处理范围内
     *
     * @param weeks
     * @return
     */
    public int moneyForFullWeek(int weeks) {
        int weekTotalIncreament = 0;
        int weekTotalFullMoney = 0;

        //按第一周的来乘以weeks数，再加上每周多出来的那部分increament数
        for(int i=0; i<weeks; i++){
            //每一周都比第一周多(week-1)*(days*dayIncreament)
            int weekSingleIncreament = i * this.daysOfWeek * this.eachDayIncreament;
            weekTotalIncreament += weekSingleIncreament;
        }

        weekTotalFullMoney = weeks * moneyForFirstWeek(this.daysOfWeek);

        return weekTotalFullMoney + weekTotalIncreament;
    }

    /**
     * 处理尾数的天数，7天以上才需用到本方法；7天以内用第一周的方法
     *
     * @param additionalDays
     * @return
     */
    public int moneyForAdditionalDaysOutOfWeek(int week, int additionalDays){
        int weekDay = this.weekDayOf(additionalDays);
        int initialMoneyInWeek = this.initialMoneyOn(week);
        int totalAdditionalMoney = 0;

        //只有一周以上，才需要计算额外的天数；一周以内的在一周的计算中包括了
        if(weekDay<7) {
            for (int i = 0; i < weekDay; i++) {
                int theDayMoney = initialMoneyInWeek + this.eachDayIncreament * i;
                totalAdditionalMoney += theDayMoney;
            }
        }else{
            return -1;
        }

        return totalAdditionalMoney;
    }
}
