import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class DayTest {

    @org.junit.Test
    public void should_calculate_day_amount() {
        assertThat(new Day(1).amount(), is(1));
        assertThat(new Day(3).amount(), is(3));
        assertThat(new Day(7).amount(), is(7));
        assertThat(new Day(8).amount(), is(2));
        assertThat(new Day(16).amount(), is(4));
    }

    @Test
    public void should_calculate_total_days_amount(){
        int totalDays = 3;
        int totalAmount = 0;
        int currentDayAmount = 0;

        for(int i=1; i<=totalDays; i++){
            currentDayAmount = new Day(i).amount();
            totalAmount += currentDayAmount;
        }

        assertThat(totalAmount, is(6));
    }

    @org.junit.Test
    public void should_calculate_week() {
    }

    @org.junit.Test
    public void should_calculate_weekDay() {
    }
}