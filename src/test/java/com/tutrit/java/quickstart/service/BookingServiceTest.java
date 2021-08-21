package com.tutrit.java.quickstart.service;

import static org.junit.Assert.*;

import com.tutrit.java.quickstart.bean.Slot;
import com.tutrit.java.quickstart.mock.SlotMockProvider;
import java.time.LocalDateTime;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class BookingServiceTest {


    private ScheduleCalendar scheduleCalendarMock;
    private AppointmentCalendar appointmentCalendarSpy;
    private BookingService bookingService;


    @Before
    public void setUp() {
        scheduleCalendarMock = Mockito.mock(ScheduleCalendar.class);
        appointmentCalendarSpy = Mockito.spy(AppointmentCalendar.class);
        bookingService = new BookingService(appointmentCalendarSpy, scheduleCalendarMock);
    }

    @Test
    public void findAllAvailableSlots() {
        appointmentCalendarSpy.addSlot(new Slot(LocalDateTime.parse("2021-01-01T19:30"), 30));
        Mockito.when(scheduleCalendarMock.findAll()).thenReturn(SlotMockProvider.makeSlotsMock());
        List<Slot> actual = bookingService.findAllAvailableSlots();
        Assert.assertEquals(getExpectedWhenFindAllAvailableSlots(), actual);

    }

    private List<Slot> getExpectedWhenFindAllAvailableSlots() {
        return List.of(
                new Slot(LocalDateTime.parse("2021-01-01T19:00"), 30),
                new Slot(LocalDateTime.parse("2021-01-01T20:00"), 30),
                new Slot(LocalDateTime.parse("2021-01-01T20:30"), 30),
                new Slot(LocalDateTime.parse("2021-01-01T21:00"), 30)
        );
    }
}