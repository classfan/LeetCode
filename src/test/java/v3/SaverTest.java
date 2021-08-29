package v3;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class SaverTest {

    @Test
    void should_save_1_when_1_day() {
        Saver saver=new Saver(1);
        assertEquals(saver.amount(),1);
    }

    @Test
    void should_save_3_when_2_day() {
        Saver saver=new Saver(2);
        assertEquals(saver.amount(),3);
    }

    @Test
    void should_save_28_when_7_day() {
        Saver saver=new Saver(7);
        assertEquals(saver.amount(),28);
    }

    @Test
    void should_save_30_when_8_day() {
        Saver saver=new Saver(8);
        assertEquals(saver.amount(),30);
    }

    @Test
    void should_save_96_when_20_day() {
        Saver saver=new Saver(20);
        assertEquals(saver.amount(),96);
    }

    @Test
    void should_return_1_when_1_day(){
        Saver saver = new Saver(1);
        assertEquals(1, saver.weekDayOfTheDay(1));
    }

    @Test
    void should_return_5_when_5_day(){
        Saver saver = new Saver(1);
        assertEquals(5, saver.weekDayOfTheDay(5));
    }

    @Test
    void should_return_7_when_7_day(){
        Saver saver = new Saver(1);
        assertEquals(7, saver.weekDayOfTheDay(7));
    }

    @Test
    void should_return_1_when_8_day(){
        Saver saver = new Saver(1);
        assertEquals(1, saver.weekDayOfTheDay(8));
    }

    @Test
    void should_return_6_when_13_day(){
        Saver saver = new Saver(1);
        assertEquals(6, saver.weekDayOfTheDay(13));
    }

    @Test
    void should_return_7_when_14_day(){
        Saver saver = new Saver(1);
        assertEquals(7, saver.weekDayOfTheDay(14));
    }

    @Test
    void should_return_week_1_when_1_day(){
        Saver saver = new Saver(1);
        assertEquals(1, saver.weekOfTheDay(1));
    }

    @Test
    void should_return_week_1_when_5_day(){
        Saver saver = new Saver(1);
        assertEquals(1, saver.weekOfTheDay(5));
    }

    @Test
    void should_return_week_1_when_7_day(){
        Saver saver = new Saver(1);
        assertEquals(1, saver.weekOfTheDay(7));
    }

    @Test
    void should_return_week_2_when_8_day(){
        Saver saver = new Saver(1);
        assertEquals(2, saver.weekOfTheDay(8));
    }

    @Test
    void should_return_week_2_when_13_day(){
        Saver saver = new Saver(1);
        assertEquals(2, saver.weekOfTheDay(13));
    }

    @Test
    void should_return_week_2_when_14_day(){
        Saver saver = new Saver(1);
        assertEquals(2, saver.weekOfTheDay(14));
    }

    @Test
    void should_return_first_week_1_when_28_day(){
        Saver saver = new Saver(1);
        assertEquals(28, saver.getMoneyFirstWeek());
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

}