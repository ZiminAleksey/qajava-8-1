package ru.radioTest.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import ru.radio.domain.Radio;

public class RadioTest {

    @Test
    void firstTest() {
        Radio rad = new Radio();
        rad.setCurrentStation(5);
        rad.setCurrentVolume(7);
        rad.setNext();
        rad.setPrev();
        rad.setVolumePlus();
        rad.setVolumeMinus();

        int actual = rad.getCurrentStation() + rad.getCurrentVolume();
        int expected = 5 + 7;

        Assertions.assertEquals(expected, actual);
    }

    void borderTest() {
        Radio rad = new Radio();

    }


    @ParameterizedTest
    @CsvFileSource(resources = "/StationVolume.csv")

    public void VolumeStation(int currentStation, int currentVolume, int expected) {
        Radio rad = new Radio();
        rad.setCurrentStation(currentStation);
        rad.setCurrentVolume(currentVolume);

        int actual = rad.getCurrentStation() + rad.getCurrentVolume();
        Assertions.assertEquals(expected, actual);

    }

    @ParameterizedTest
    @CsvFileSource(resources = "/IncreaseVolumeStation.csv")

    public void IncreaseVolumeStation(int currentStation, int currentVolume, int expected) {
        Radio rad = new Radio();
        rad.setCurrentStation(currentStation);
        rad.setCurrentVolume(currentVolume);
        rad.setNext();
        rad.setVolumePlus();

        int actual = rad.getCurrentStation() + rad.getCurrentVolume();
        Assertions.assertEquals(expected, actual);

    }

    @ParameterizedTest
    @CsvFileSource(resources = "/DecreaseVolumeStation.csv")

    public void DecreaseVolumeStation(int currentStation, int currentVolume, int expected) {
        Radio rad = new Radio();
        rad.setCurrentStation(currentStation);
        rad.setCurrentVolume(currentVolume);
        rad.setPrev();
        rad.setVolumeMinus();

        int actual = rad.getCurrentStation() + rad.getCurrentVolume();
        Assertions.assertEquals(expected, actual);

    }
}
