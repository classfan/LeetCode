package v3;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class SaverTest {
    @Test
    void should_return_1_when_1_day(){
        Saver saver = new Saver(1);
        assertEquals(1, saver.weekDayOf(1));
    }

    @Test
    void should_return_5_when_5_day(){
        Saver saver = new Saver(1);
        assertEquals(5, saver.weekDayOf(5));
    }

    @Test
    void should_return_7_when_7_day(){
        Saver saver = new Saver(1);
        assertEquals(7, saver.weekDayOf(7));
    }

    @Test
    void should_return_1_when_8_day(){
        Saver saver = new Saver(1);
        assertEquals(1, saver.weekDayOf(8));
    }

    @Test
    void should_return_6_when_13_day(){
        Saver saver = new Saver(1);
        assertEquals(6, saver.weekDayOf(13));
    }

    @Test
    void should_return_7_when_14_day(){
        Saver saver = new Saver(1);
        assertEquals(7, saver.weekDayOf(14));
    }

    @Test
    void should_return_week_1_when_1_day(){
        Saver saver = new Saver(1);
        assertEquals(1, saver.weekOf(1));
    }

    @Test
    void should_return_week_1_when_5_day(){
        Saver saver = new Saver(1);
        assertEquals(1, saver.weekOf(5));
    }

    @Test
    void should_return_week_1_when_7_day(){
        Saver saver = new Saver(1);
        assertEquals(1, saver.weekOf(7));
    }

    @Test
    void should_return_week_2_when_8_day(){
        Saver saver = new Saver(1);
        assertEquals(2, saver.weekOf(8));
    }

    @Test
    void should_return_week_2_when_13_day(){
        Saver saver = new Saver(1);
        assertEquals(2, saver.weekOf(13));
    }

    @Test
    void should_return_week_2_when_14_day(){
        Saver saver = new Saver(1);
        assertEquals(2, saver.weekOf(14));
    }

    @Test
    void should_return_true_when_7_day(){
        Saver saver = new Saver(1);
        assertEquals(true, saver.isFullWeek(7));
    }

    @Test
    void should_return_false_when_5_day(){
        Saver saver = new Saver(1);
        assertNotEquals(true, saver.isFullWeek(5));
    }

    @Test
    void should_return_true_when_14_day(){
        Saver saver = new Saver(1);
        assertEquals(true, saver.isFullWeek(14));
    }

    @Test
    void should_return_false_when_15_day(){
        Saver saver = new Saver(1);
        assertNotEquals(true, saver.isFullWeek(15));
    }

    @Test
    void should_return_1_when_5_day(){
        Saver saver = new Saver(1);
        assertEquals(1, saver.initialMoneyInTheWeekOf(5));
    }

    @Test
    void should_return_1_when_7_day(){
        Saver saver = new Saver(1);
        assertEquals(1, saver.initialMoneyInTheWeekOf(7));
    }

    @Test
    void should_return_2_when_8_day(){
        Saver saver = new Saver(1);
        assertEquals(2, saver.initialMoneyInTheWeekOf(8));
    }

    @Test
    void should_return_2_when_14_day(){
        Saver saver = new Saver(1);
        assertEquals(2, saver.initialMoneyInTheWeekOf(14));
    }

    @Test
    void should_return_3_when_16_day(){
        Saver saver = new Saver(1);
        assertEquals(3, saver.initialMoneyInTheWeekOf(16));
    }

    // ----------------------- Not Passed Cases -------------------------------------//
    @Test
    void should_return_the_day_money_1_when_1_day(){
        Saver saver = new Saver(1);
        assertEquals(1, saver.moneyOn(1));
    }

    @Test
    void should_return_the_day_money_7_when_7_day(){
        Saver saver = new Saver(1);
        assertEquals(7, saver.moneyOn(7));
    }

    @Test
    void should_return_the_day_money_2_when_8_day(){
        Saver saver = new Saver(1);
        assertEquals(2, saver.moneyOn(8));
    }

    @Test
    void should_return_the_day_money_3_when_9_day(){
        Saver saver = new Saver(1);
        assertEquals(3, saver.moneyOn(9));
    }

    @Test
    void should_return_6_first_week_1(){
        Saver saver = new Saver(1);
        assertEquals(6, saver.moneyForFirstWeek(3));
    }

    @Test
    void should_return_28_first_week_1(){
        Saver saver = new Saver(1);
        assertEquals(28, saver.moneyForFirstWeek(7));
    }

    @Test
    void should_return_first_week_1_when_28_day_as_common(){
        Saver saver = new Saver(1);
        assertEquals(28*1 + 7*0, saver.moneyForFullWeek(1));
    }

    @Test
    void should_return_first_week_2_when_as_common(){
        Saver saver = new Saver(1);
        assertEquals(28*2 + 7*1, saver.moneyForFullWeek(2));
    }

    @Test
    void should_return_first_week_3_when_as_common(){
        Saver saver = new Saver(1);
        assertEquals(28*3 + 7*2 + 7*1, saver.moneyForFullWeek(3));
    }

    @Test
    void should_return_first_week_4_when_as_common(){
        Saver saver = new Saver(1);
        assertEquals(28*4 + 7*3 + 7*2 + 7*1, saver.moneyForFullWeek(4));
    }

    @Test
    void should_return_2_additional(){
        Saver saver = new Saver(1);
        assertEquals(2, saver.moneyForAdditionalDaysOutOfWeek(2, 1));
    }

    @Test
    void should_return_9_additional(){
        Saver saver = new Saver(1);
        assertEquals(9, saver.moneyForAdditionalDaysOutOfWeek(2, 3));
    }

    @Test
    void should_return_neg_1_additional(){
        Saver saver = new Saver(1);
        assertEquals(-1, saver.moneyForAdditionalDaysOutOfWeek(2, 0));
    }

    @Test
    void should_return_36_additional(){
        Saver saver = new Saver(1);
        int days = 8;
        int weeks = saver.weekOf(days);
        int fullWeekMoney = saver.moneyForFullWeek(weeks - 1);
        int additionalDays = saver.weekDayOf(days);

        int additionalDayMoney = saver.moneyForAdditionalDaysOutOfWeek(weeks, additionalDays);

        assertEquals(30, fullWeekMoney + additionalDayMoney);
    }

    @Test
    void should_return_333333_additional(){
        Saver saver = new Saver(1);
        int days = 7;
        int weeks = saver.weekOf(days);
        int fullWeekMoney = saver.moneyForFullWeek(weeks - 1);
        int additionalDays = saver.weekDayOf(days);

        int additionalDayMoney = saver.moneyForAdditionalDaysOutOfWeek(weeks, additionalDays);

        assertEquals(30, fullWeekMoney + additionalDayMoney);
    }
}