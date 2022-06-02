package ru.radioTest.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import ru.radio.domain.Radio;

public class RadioTest {

    @Test
    void firstTest() {
        Radio rad = new Radio(30);
        rad.setCurrentStation(29);
        rad.setCurrentVolume(100);
        rad.setNext();
        rad.setPrev();
        rad.setVolumePlus();
        rad.setVolumeMinus();
        Radio rad1 = new Radio();
        rad1.setCurrentStation(9);
        rad1.setCurrentVolume(1);

        Assertions.assertEquals(29 + 99, rad.getCurrentStation() + rad.getCurrentVolume());
        Assertions.assertEquals(9 + 1, rad1.getCurrentStation() + rad1.getCurrentVolume());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/StationVolume.csv")

    public void VolumeStation(int currentStation, int currentVolume, int expected) {
        Radio rad = new Radio(25);
        rad.setCurrentStation(currentStation);
        rad.setCurrentVolume(currentVolume);

        Assertions.assertEquals(expected, rad.getCurrentStation() + rad.getCurrentVolume());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/IncreaseVolumeStation.csv")

    public void IncreaseVolumeStation(int currentStation, int currentVolume, int expected) {
        Radio rad = new Radio(33);
        rad.setCurrentStation(currentStation);
        rad.setCurrentVolume(currentVolume);
        rad.setNext();
        rad.setVolumePlus();

        Assertions.assertEquals(expected, rad.getCurrentStation() + rad.getCurrentVolume());

    }

    @ParameterizedTest
    @CsvFileSource(resources = "/DecreaseVolumeStation.csv")

    public void DecreaseVolumeStation(int currentStation, int currentVolume, int expected) {
        Radio rad = new Radio(54);
        rad.setCurrentStation(currentStation);
        rad.setCurrentVolume(currentVolume);
        rad.setPrev();
        rad.setVolumeMinus();

        Assertions.assertEquals(expected, rad.getCurrentStation() + rad.getCurrentVolume());

    }
}
