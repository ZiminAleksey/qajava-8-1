package ru.radio.domain;

public class Radio {
    private int currentStation;
    private int currentVolume;
    private int amountStation = 10;
    private int maxVolume = 100;
    public Radio(int amountStation) {
        this.amountStation = amountStation;
    }
    public Radio() {

    }

    public void setCurrentStation(int currentStation) {
        if (currentStation < 0) {
            return;
        }
        if (currentStation > amountStation - 1) {
            return;
        }
        this.currentStation = currentStation;
    }

    public int getCurrentStation() {
        return currentStation;
    }

    public void setCurrentVolume(int currentVolume) {
        if (currentVolume < 0) {
            return;
        }
        if (currentVolume > maxVolume) {
            return;
        }
        this.currentVolume = currentVolume;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void setNext() {
        if (currentStation == amountStation - 1) {
            currentStation = 0;
        }
        else {
            currentStation++;
        }
    }

    public int getNext() {
        return currentStation;
    }

    public void setPrev() {
        if (currentStation == 0) {
            currentStation = amountStation - 1;
        }
        else {
            currentStation--;
        }
    }

    public int getPrev() {
        return currentStation;
    }

    public void setVolumePlus() {
        if (currentVolume == maxVolume) {
            return;
        }
        currentVolume++;
    }

    public int getVolumePlus() {
        return currentVolume;
    }

    public void setVolumeMinus() {
        if (currentVolume == 0) {
            return;
        }
        currentVolume--;
    }

    public int getVolumeMinus() {
        return currentVolume;
    }
}
