package com.example.demo.model;

import java.util.ArrayList;
import com.example.demo.model.questions.QuestionTrueFalse;

public class ArrayQuestionsTrueFalse {
    private ArrayList<QuestionTrueFalse> questionsTF;

    public ArrayQuestionsTrueFalse() {
        questionsTF = new ArrayList<QuestionTrueFalse>();
    }

    public QuestionTrueFalse nextQuestion(int count) {
        if (count < questionsTF.size()) {
            return questionsTF.get(count);
        }
        return null;
    }
}