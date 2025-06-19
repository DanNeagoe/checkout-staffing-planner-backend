package com.staffplanner.checkout.controller;

import com.staffplanner.checkout.model.Wish;
import com.staffplanner.checkout.repository.WishRepository;
import com.staffplanner.checkout.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wishes")
@CrossOrigin(origins = "*")
public class WishController {

    private final WishRepository wishRepository;
    private final EmployeeRepository employeeRepository;

    @Autowired
    public WishController(WishRepository wishRepository, EmployeeRepository employeeRepository) {
        this.wishRepository = wishRepository;
        this.employeeRepository = employeeRepository;
    }

    // POST /api/wishes
    @PostMapping
    public Wish createWish(@RequestBody Wish wish) {
        return wishRepository.save(wish);
    }

    // GET /api/wishes
    @GetMapping
    public List<Wish> getAllWishes() {
        return wishRepository.findAll();
    }
}
