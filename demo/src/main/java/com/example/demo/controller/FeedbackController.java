package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Feedback;
import com.example.demo.service.FeedbackService;

@RestController
@RequestMapping("/feedback")		
@CrossOrigin(origins = "http://localhost:5174")
public class FeedbackController {

    @Autowired
    private FeedbackService service;

    @PostMapping
    public Feedback createFeedback(@RequestBody Feedback feedback) {
        return service.createFeedback(feedback);
    }

    @GetMapping
    public List<Feedback> getAllFeedbacks() {
        return service.getAllFeedbacks();
    }

    @PutMapping("/{id}/helpful")
    public Feedback markFeedbackAsHelpful(@PathVariable String id) {
        return service.markFeedbackAsHelpful(id).orElseThrow(() -> new RuntimeException("Feedback not found"));
    }
}
