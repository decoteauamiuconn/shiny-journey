package com.example.demo;

import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.PostMapping;

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

	@GetMapping({"/get_question", "/get-question"})
	public String questionForm(Model model) {
		Count count = new Count();
		count.count = count.count + 1;
		MyString myString = new MyString();
		GetQuestion getQuestion = new GetQuestion();
		myString.setMyString(getQuestion.nextQuestion(0).getQuestion());
		model.addAttribute("myString", myString );
		model.addAttribute("count", count);
		
		return "question";
	}

	@PostMapping({"/get_question", "/get-question"})
	public String questionFormPOST(String answer, Model model) {
		System.out.println("The answer is " + answer);
		
		GetQuestion getQuestion = new GetQuestion();
		QuestionTrueFalse qtf = getQuestion.nextQuestion(0);
		model.addAttribute("QuestionTrueFalse", qtf);

		Count count = new Count();
		count.count = count.count + 1;
		model.addAttribute("count", count);
		MyString myString = new MyString();
		myString.setMyString(getQuestion.nextQuestion(0).getQuestion());
		model.addAttribute("myString", myString );

		// Compare Boolean values correctly (avoid reference equality)
		Boolean answerBool = Boolean.valueOf(answer);
		if (answerBool.equals(qtf.getAnswer())) {
			System.out.println("Correct!");
		} else {
			System.out.println("Wrong!");
		}
		//model.addAttribute("myString", myString );
		
		
		return "question";
	}

  
}