package com.example.demo.model.questions;

import java.util.ArrayList;
import java.util.List;

public class AllQuestions {
    private static List<QuestionTrueFalse> arrayListQuestionsTF = new ArrayList<QuestionTrueFalse>();
    private int totalQuestions = 0;

    public ArrayQuestionsTrueFalse() {
        arrayListQuestionsTF.add(new QuestionTrueFalse("99.9% of calico cats are female", true));
        arrayListQuestionsTF.add(new QuestionTrueFalse("The Andromeda Galaxy is the closest major galaxy to the Milky Way", true));
        arrayListQuestionsTF.add(new QuestionTrueFalse("Sewing machines were invented in 1655", false));
        arrayListQuestionsTF.add(new QuestionTrueFalse("Teeth are the only body part that cannot repair themselves", true));
        arrayListQuestionsTF.add(new QuestionTrueFalse("Our solar system is estimated to have up to 400 billion stars",false));
        totalQuestions = arrayListQuestionsTF.size();
    }

    public QuestionTrueFalse nextQuestion(int i) {
        return arrayListQuestionsTF.get(i % totalQuestions);
    }
    
}