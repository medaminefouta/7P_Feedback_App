package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.model.Feedback;

@Service
public class FeedbackService {

	private final List<Feedback> feedbacks = new ArrayList<>();

    public Feedback createFeedback(Feedback feedback) {
    	feedbacks.add(feedback);
        return feedback;
    }

    public List<Feedback> getAllFeedbacks() {
        return feedbacks;
    }

    public Optional<Feedback> markFeedbackAsHelpful(String id) {
        return feedbacks.stream().filter(f -> f.getId().equals(id)).findFirst().map(feedback -> {
            feedback.increaseHelpfulCount();
            return feedback;
        });
    }
}
