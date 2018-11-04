package com.ni3bobade.sounds;

public class Sounds {
    private int soundImageResourceId;
    private String soundName;
    private int audioResourceId;

    public Sounds(int soundImageResourceId, String soundName, int audioResourceId) {
        this.soundImageResourceId = soundImageResourceId;
        this.soundName = soundName;
        this.audioResourceId = audioResourceId;
    }

    public int getSoundImageResourceId() {
        return soundImageResourceId;
    }

    public String getSoundName() {
        return soundName;
    }

    public int getAudioResourceId() {
        return audioResourceId;
    }
}
