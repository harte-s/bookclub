package com.codingdojo.bookclub.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.bookclub.models.Book;
import com.codingdojo.bookclub.models.LoginUser;
import com.codingdojo.bookclub.models.User;
import com.codingdojo.bookclub.services.BookService;
import com.codingdojo.bookclub.services.UserService;

@Controller
public class HomeController {
	
	private UserService userServ;
	private BookService bookServ;
	
	public HomeController(UserService userServ, BookService bookServ) {
		this.userServ = userServ;
		this.bookServ = bookServ;
	}

	//login and registration page
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
		return "index.jsp";
	}
		
	//registration action
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model, HttpSession session) {
		
		userServ.register(newUser, result);
		if (result.hasErrors()) {
			model.addAttribute("newLogin", new LoginUser());
			return "index.jsp";
		}
		
		session.setAttribute("user_id", newUser.getId());
		return "redirect:/dashboard";
	}
	
	//login action
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model, HttpSession session) {
		
		User user = userServ.login(newLogin, result);
		if (result.hasErrors()) {
			model.addAttribute("newUser", new User());
			return "index.jsp";
		}
		
		session.setAttribute("user_id", user.getId());
		return "redirect:/dashboard";
	}
	
	
	//dashboard - view all
	@RequestMapping("/dashboard")
	public String dashboard(Model model, HttpSession session) {
		if (session.getAttribute("user_id") == null) {
			return "redirect:/";
		} else {
		model.addAttribute("user", userServ.oneUser((Long) session.getAttribute("user_id")));
		model.addAttribute("allBooks", bookServ.allBooks());
		return "dashboard.jsp";	
		}

	}
	
	
	//new entry render jsp
	@RequestMapping("/newbook")
	public String newBook(@ModelAttribute("book")Book book, Model model, HttpSession session) {
		if (session.getAttribute("user_id") == null) {
			return "redirect:/";
		} else {
			model.addAttribute("user", (Long)session.getAttribute("user_id"));
			return "newentry.jsp";
		}
	}
	
	
	//new entry action
	@PostMapping("/process")
	public String processNewBook(@Valid @ModelAttribute("book") Book book, BindingResult result) {
		if (result.hasErrors()) {
			return "newentry.jsp";
		} else {
			bookServ.create(book);
			return "redirect:/dashboard";
		}
	}
	
	
	//view single entry render jsp
	@RequestMapping("/book/{id}")
	public String viewBook(@PathVariable("id") Long id, Model model, HttpSession session) {
		if (session.getAttribute("user_id") == null) {
			return "redirect:/";
		} else {
			User user = userServ.oneUser((Long) session.getAttribute("user_id"));
			model.addAttribute("user", user);
			model.addAttribute("book", bookServ.oneBook(id));
			return "singleentrydetail.jsp";
		}
	}
	
	
	//edit entry render jsp
	@RequestMapping("/edit/{id}")
	public String editBook(@PathVariable("id")Long id, @ModelAttribute("book") Book book, Model model, HttpSession session) {
		if (session.getAttribute("user_id") == null) {
			return "redirect:/";
		} else {
			Book oneBook = bookServ.oneBook(id);
			model.addAttribute("book", oneBook);
			return "edit.jsp";
		}
	}
	
	//edit entry action
	@RequestMapping(value="/processupdate/{id}", method=RequestMethod.PUT)
	public String processUpdate(@PathVariable("id")Long id, @Valid @ModelAttribute("book") Book book, BindingResult result, HttpSession session) {
		if (result.hasErrors()) {
			return "edit.jsp";
		} else {
			bookServ.update(book);
			return "redirect:/dashboard";
		}
	}
	
	//delete entry
	@RequestMapping("/delete/{id}")
	public String destroyBook(@PathVariable("id")Long id) {
		bookServ.destroy(id);
		return "redirect:/dashboard";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	
}
