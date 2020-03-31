package com.cg.feedback.dto;

import java.util.List;

public class ReportDTO {
    private List<FeedbackDTO> feedbacks;

    public ReportDTO(final List<FeedbackDTO> feedbacks) {
        this.feedbacks = feedbacks;
    }

    @Override
    public String toString() {
        String result = "";
        long[] ques_avg = { 0l, 0l, 0l, 0l, 0l };
        long count = feedbacks.size();
        String[] q_strings = { "Presentation and communication skills of faculty: ",
                "Ability to clarify doubts and explain difficult points: ",
                "Time management in completing the contents: ", "Handout provided(Student Guide): ",
                "Hardware, software and network availability: " };
        feedbacks.stream().forEach((FeedbackDTO f) -> {
            f.getQuestions().addRating(ques_avg);
        });
        for (int i = 0; i < 5; i++) {
            ques_avg[i] /= count;
            q_strings[i] += ques_avg[i] + "\n";
            result += q_strings[i];
        }
        result += "Comments and Suggestions:\n";
        if (count > 0) {
            result += "Suggesstion: " + feedbacks.get(0).getSuggestions();
            result += "\nComment: " + feedbacks.get(0).getComments() + "\n";
        } else if (count > 1) {
            result += "Suggesstion: " + feedbacks.get(1).getSuggestions();
            result += "\nComment: " + feedbacks.get(1).getComments() + "\n";
        } else if (count > 2) {
            result += "Suggesstion: " + feedbacks.get(2).getSuggestions();
            result += "\nComment: " + feedbacks.get(2).getComments() + "\n";
        }
        return result;
    }
}