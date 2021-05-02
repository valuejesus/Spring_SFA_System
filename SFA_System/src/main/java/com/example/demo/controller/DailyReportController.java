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

import com.example.demo.domain.Dailyreport;
import com.example.demo.service.DailyReportService;

@Controller
@RequestMapping("/ClientList/dailyreport")
public class DailyReportController {

	@Autowired
	private DailyReportService dailyreportservice;

	@GetMapping
	public String index(Model model) {
		model.addAttribute("dailyreport", dailyreportservice.findAll());
		return "dailyreport";
	}

	@GetMapping("{id}")
	public String show(@PathVariable Long id, Model model) {
		model.addAttribute("Dailyreport", dailyreportservice.findOne(id));
		return "dailyreport_show";
	}

	@GetMapping("dailyreport_new")
	public String newItem(@ModelAttribute("Dailyreport") Dailyreport dailyreport, Model model) {
		return "dailyreport_new";
	}

	@GetMapping("{id}/dailyreport_edit")
	public String edit(@PathVariable Long id, @ModelAttribute("Dailyreport") Dailyreport dailyreport, Model model) {
		model.addAttribute("Dailyreport", dailyreportservice.findOne(id));
		return "dailyreport_edit";
	}

	@PostMapping
	public String create(@ModelAttribute("Dailyreport") @Validated Dailyreport dailyreport, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "dailyreport_new";
		} else {
			dailyreportservice.save(dailyreport);
			return "redirect:/ClientList/dailyreport";
		}
	}

	@PutMapping("{id}")//Productlistを追加？
	public String update(@PathVariable Long id, @ModelAttribute("Dailyreport") @Validated Dailyreport dailyreport, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("Dailyreport", dailyreport);
			return "dailyreport_edit";
		} else {
			dailyreport.setId(id);
			dailyreportservice.update(dailyreport);
			return "redirect:/ClientList/dailyreport";
		}
	}

	@DeleteMapping("{id}")
	public String delete(@PathVariable Long id) {
		dailyreportservice.delete(id);
		return "redirect:/ClientList/dailyreport";
	}
}
