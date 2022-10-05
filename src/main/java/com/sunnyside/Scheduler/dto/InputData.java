package com.sunnyside.Scheduler.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InputData {
    private String sex;
    private int day;
    private int month;
    private int year;
    private String county;

}