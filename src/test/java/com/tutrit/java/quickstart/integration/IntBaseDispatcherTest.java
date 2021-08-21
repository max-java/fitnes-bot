package com.tutrit.java.quickstart.integration;

import static org.junit.Assert.assertEquals;

import com.tutrit.java.quickstart.bean.Slot;
import com.tutrit.java.quickstart.controller.ScheduleCalendarController;
import com.tutrit.java.quickstart.dispatcher.BaseDispatcher;
import com.tutrit.java.quickstart.mock.SlotMockProvider;
import com.tutrit.java.quickstart.service.ScheduleCalendar;
import java.time.LocalDateTime;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class IntBaseDispatcherTest {

    private BaseDispatcher baseDispatcher;
    private ScheduleCalendarController controllerSpy;
    private ScheduleCalendar scheduleCalendarMock;

    @Before
    public void setUp(){
        scheduleCalendarMock = Mockito.mock(ScheduleCalendar.class);
        controllerSpy = Mockito.spy(new ScheduleCalendarController(scheduleCalendarMock));
        baseDispatcher = new BaseDispatcher(controllerSpy);
    }

    @Test
    public void dispatch() {
        Mockito.when(scheduleCalendarMock.findAll()).thenReturn(SlotMockProvider.makeSlotsMock());
        String[] args = {"/showSlots"};
        List<Slot> actual = baseDispatcher.dispatch(args);
        assertEquals(expectedSlots(), actual);
        Mockito.verify(controllerSpy, Mockito.times(2)).showAllSlots();
    }

    private List<Slot> expectedSlots() {
        return List.of(
                new Slot(LocalDateTime.parse("2021-01-01T19:00"), 30),
                new Slot(LocalDateTime.parse("2021-01-01T19:30"), 30),
                new Slot(LocalDateTime.parse("2021-01-01T20:00"), 30),
                new Slot(LocalDateTime.parse("2021-01-01T20:30"), 30),
                new Slot(LocalDateTime.parse("2021-01-01T21:00"), 30)
        );
    }
}
