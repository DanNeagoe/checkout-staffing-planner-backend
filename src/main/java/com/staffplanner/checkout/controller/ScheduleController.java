package com.staffplanner.checkout.controller;

import com.staffplanner.checkout.dto.ScheduleRequest;
import com.staffplanner.checkout.model.Employee;
import com.staffplanner.checkout.model.Schedule;
import com.staffplanner.checkout.repository.EmployeeRepository;
import com.staffplanner.checkout.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/schedules")
@CrossOrigin(origins = "*")
public class ScheduleController {

    private final ScheduleRepository scheduleRepository;
    private final EmployeeRepository employeeRepository;

    @Autowired
    public ScheduleController(ScheduleRepository scheduleRepository, EmployeeRepository employeeRepository) {
        this.scheduleRepository = scheduleRepository;
        this.employeeRepository = employeeRepository;
    }

    // POST /api/schedules
    @PostMapping
    public ResponseEntity<?> createSchedule(@RequestBody ScheduleRequest request) {
        System.out.println("Received schedule request: " + request);

        List<Employee> employees = employeeRepository.findAllById(request.getEmployeeIds());

        if (employees.size() != request.getEmployeeIds().size()) {
            return ResponseEntity.badRequest().body("Some employees not found.");
        }

        if (employees.size() > 2) {
            return ResponseEntity.badRequest().body("Only 2 employees allowed per shift.");
        }

        Schedule schedule = new Schedule();
        schedule.setDate(LocalDate.parse(request.getDate()));
        schedule.setShift(Schedule.Shift.valueOf(request.getShift()));
        schedule.setEmployees(employees);

        Schedule saved = scheduleRepository.save(schedule);
        return ResponseEntity.ok(saved);
    }

    @GetMapping
    public List<Schedule> getByDate(@RequestParam("date") String date) {
        return scheduleRepository.findByDate(LocalDate.parse(date));
    }
}