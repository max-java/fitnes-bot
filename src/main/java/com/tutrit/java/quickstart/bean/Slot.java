package com.tutrit.java.quickstart.bean;

import java.time.LocalDateTime;
import java.util.Objects;

public class Slot {
    private LocalDateTime dateTime;
    private long duration;

    public Slot(LocalDateTime dateTime, long duration) {
        this.dateTime = dateTime;
        this.duration = duration;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Slot slot = (Slot) o;
        return duration == slot.duration && Objects.equals(dateTime, slot.dateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateTime, duration);
    }

    @Override
    public String toString() {
        return "Slot{" +
                "dateTime=" + dateTime +
                ", duration=" + duration +
                '}';
    }
}
