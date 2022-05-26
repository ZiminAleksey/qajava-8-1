package ru.radioTest.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.radio.domain.Radio;

public class RadioTest {

    @Test
    void findMax () {
        Radio rad = new Radio();
        rad.setCurrentStation(5);

        int actual = rad.getCurrentStation();
        int expected = 5;

        Assertions.assertEquals(expected, actual);
    }

}
