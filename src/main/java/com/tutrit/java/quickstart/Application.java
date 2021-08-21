package com.tutrit.java.quickstart;

import com.tutrit.java.quickstart.controller.ScheduleCalendarController;
import com.tutrit.java.quickstart.dispatcher.BaseDispatcher;
import com.tutrit.java.quickstart.service.ScheduleCalendar;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Application {
    private static Logger log = LoggerFactory.getLogger("main");

    public static void main(String[] args) {
        log.info("Hello world!");
        new BaseDispatcher(new ScheduleCalendarController(new ScheduleCalendar()))
                .dispatch(args);
    }
}

