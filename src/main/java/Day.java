public class Day {
    private final int dayNumber;
    private final int daysOfWeek = 7;

    public Day(int dayNumber){
        this.dayNumber = dayNumber;
    }

    /**
     * 计算当前录入天数的累计金额
     *
     * @return
     */
    public int amount(){
        return week() + weekDay() - 1;
    }

    /**
     * 计算当前录入天数是第几周
     *
     * @return
     */
    public int week(){
        return ((dayNumber - 1) / daysOfWeek) + 1;
    }

    /**
     * 计算当前录入天数是一周的第几天
     *
     * @return
     */
    public int weekDay(){
        return ((dayNumber - 1) % daysOfWeek) + 1;
    }
}
