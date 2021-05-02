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

import com.example.demo.domain.Productlist;
import com.example.demo.service.ProductListService;

@Controller
@RequestMapping("/ClientList/productlist")
public class ProductListController {

	@Autowired
	private ProductListService productListService;

	@GetMapping
	public String index(Model model) {
		model.addAttribute("productlist", productListService.findAll());
		return "productlist";
	}

	@GetMapping("{id}")
	public String show(@PathVariable Long id, Model model) {
		model.addAttribute("Productlist", productListService.findOne(id));
		return "product_show";
	}

	@GetMapping("product_new")
	public String newItem(@ModelAttribute("Productlist") Productlist productlist, Model model) {
		return "product_new";
	}

	@GetMapping("{id}/productlist_edit")
	public String edit(@PathVariable Long id, @ModelAttribute("Productlist") Productlist productlist, Model model) {
		model.addAttribute("Productlist", productListService.findOne(id));
		return "product_edit";
	}

	@PostMapping
	public String create(@ModelAttribute("Productlist") @Validated Productlist productlist, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "product_new";
		} else {
			productListService.save(productlist);
			return "redirect:/ClientList/productlist";
		}
	}

	@PutMapping("{id}")//Productlistを追加？
	public String update(@PathVariable Long id, @ModelAttribute("Productlist") @Validated Productlist productlist, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("Productlist", productlist);
			return "product_edit";
		} else {
			productlist.setId(id);
			productListService.update(productlist);
			return "redirect:/ClientList/productlist";
		}
	}

	@DeleteMapping("{id}")
	public String delete(@PathVariable Long id) {
		productListService.delete(id);
		return "redirect:/ClientList/productlist";
	}
}
