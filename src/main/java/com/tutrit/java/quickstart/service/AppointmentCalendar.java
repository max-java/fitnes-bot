package com.tutrit.java.quickstart.service;

import com.tutrit.java.quickstart.bean.Slot;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AppointmentCalendar {
    private static final Map<LocalDateTime, Slot> appointmentCalendarList = new HashMap();

    public void addSlot(Slot slot) {
        appointmentCalendarList.put(slot.getDateTime(), slot);
    }

    public Map<LocalDateTime, Slot> findAll() {
        return appointmentCalendarList;
    }

    public Slot findByDateTime(LocalDateTime dateTime) {
        return appointmentCalendarList.get(dateTime);
    }

    public boolean isPresent(LocalDateTime dateTime) {
        return appointmentCalendarList.containsKey(dateTime);
    }

    public void removeAllSlots() {
        appointmentCalendarList.clear();
    }
}
