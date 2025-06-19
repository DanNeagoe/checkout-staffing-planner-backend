package com.staffplanner.checkout.dto;
import java.util.List;

public class ScheduleRequest {
    private String date;
    private String shift;
    private List<Long> employeeIds;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public List<Long> getEmployeeIds() {
        return employeeIds;
    }

    public void setEmployeeIds(List<Long> employeeIds) {
        this.employeeIds = employeeIds;
    }

    @Override
    public String toString() {
        return "ScheduleRequest{" +
                "date='" + date + '\'' +
                ", shift='" + shift + '\'' +
                ", employeeIds=" + employeeIds +
                '}';
    }
}

