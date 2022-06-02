package ru.radio.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Radio {
    private int currentStation;
    private int currentVolume;
    private int amountStation = 10;
    private int maxVolume = 100;

    public Radio(int amountStation) {
        this.amountStation = amountStation;
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

    public void setCurrentVolume(int currentVolume) {
        if (currentVolume < 0) {
            return;
        }
        if (currentVolume > maxVolume) {
            return;
        }
        this.currentVolume = currentVolume;
    }

    public void setNext() {
        if (currentStation == amountStation - 1) {
            currentStation = 0;
        } else {
            currentStation++;
        }
    }

    public void setPrev() {
        if (currentStation == 0) {
            currentStation = amountStation - 1;
        } else {
            currentStation--;
        }
    }

    public void setVolumePlus() {
        if (currentVolume == maxVolume) {
            return;
        }
        currentVolume++;
    }

    public void setVolumeMinus() {
        if (currentVolume == 0) {
            return;
        }
        currentVolume--;
    }
}
