package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.Clientlist;
import com.example.demo.service.ClientListService;

@Controller
@RequestMapping("/ClientList")
public class ClientListController {

	@Autowired
	private ClientListService clientlistService;

	@GetMapping
	public String index(Model model) {
		model.addAttribute("ClientList", clientlistService.findAll());
		return "clientlist";
	}

	@GetMapping("{id}")
	public String show(@PathVariable Long id, Model model) {
		model.addAttribute("Clientlist", clientlistService.findOne(id));
		return "client_show";
	}

	@GetMapping("client_new")
	public String newItem(@ModelAttribute("Clientlist") Clientlist clientlist, Model model) {
		return "client_new";
	}

	@GetMapping("{id}/client_edit")
	public String edit(@PathVariable Long id, @ModelAttribute("Clientlist") Clientlist item, Model model) {
		model.addAttribute("Clientlist", clientlistService.findOne(id));
		return "client_edit";
	}

	@PostMapping
	public String create(@ModelAttribute("Clientlist") @Validated Clientlist item, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "client_new";
		} else {
			clientlistService.save(item);
			return "redirect:/ClientList";
		}
	}

	@PutMapping("{id}")
	public String update(@PathVariable Long id, @ModelAttribute("Clientlist") @Validated Clientlist item, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("Clientlist", item);
			return "client_edit";
		} else {
			item.setId(id);
			clientlistService.update(item);
			return "redirect:/ClientList";
		}
	}

	@DeleteMapping("{id}")
	public String delete(@PathVariable Long id) {
		clientlistService.delete(id);
		return "redirect:/ClientList";
	}
}
