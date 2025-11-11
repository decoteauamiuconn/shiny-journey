package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.Greeting;
import com.example.demo.model.MyString;
import com.example.demo.model.GetQuestion;
import com.example.demo.model.Count;
//import com.example.demo.model.MyString;
//import com.example.demo.model.questions.QuestionTrueFalse;
import com.example.demo.model.questions.*;



@Controller 
public class HomeController { 

	@GetMapping("/") 
	public String home() { 
		return "home";  // for home.html 
	} 

	@GetMapping("/greeting")
		public String greetingForm(Model model) {
			Count count = new Count();
			count.count = count.count + 1;
			model.addAttribute("greeting", new Greeting());
			model.addAttribute("count", count);
			
			return "greeting";
	}

	@PostMapping("/greeting")
	public String greetingSubmit(@ModelAttribute Greeting greeting, @ModelAttribute Count count, Model model) {
		model.addAttribute("greeting", greeting);
		model.addAttribute("count", count);
		return "result";
  	}

    @GetMapping("/quiz")
    public String showQuiz(Model model) {
        AllQuestions allQuestions = new AllQuestions();
        List<QuestionTrueFalse> questions = allQuestions.getAllQuestions();
        model.addAttribute("questions", questions);
        return "question";
    }

    @PostMapping("/submit-quiz")
    @ResponseBody
    public Map<String, Object> submitQuiz(@RequestParam Map<String, String> params) {
        AllQuestions allQuestions = new AllQuestions();
        List<QuestionTrueFalse> questions = allQuestions.getAllQuestions();
        
        List<Map<String, Object>> results = new ArrayList<>();
        
        for (int i = 0; i < questions.size(); i++) {
            String answerStr = params.get("answer" + i);
            Boolean userAnswer = answerStr != null ? Boolean.parseBoolean(answerStr) : null;
            QuestionTrueFalse question = questions.get(i);
            
            Map<String, Object> result = new HashMap<>();
            result.put("correct", userAnswer != null && userAnswer.equals(question.getAnswer()));
            result.put("correctAnswer", question.getAnswer());
            results.add(result);
        }
        
        Map<String, Object> response = new HashMap<>();
        response.put("results", results);
        return response;
    }

  
}