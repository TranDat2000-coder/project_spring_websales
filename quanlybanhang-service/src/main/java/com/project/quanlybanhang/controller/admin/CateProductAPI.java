package com.project.quanlybanhang.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.quanlybanhang.model.CateProductModel;
import com.project.quanlybanhang.service.ICateProductService;

@Controller
@RequestMapping("/admin")
//@RestController
public class CateProductAPI {

	@Autowired
	private ICateProductService productCateService;
	
	@GetMapping("/list-category-product")
	public String listCategory(Model model) {		
		model.addAttribute("listCategory", productCateService.findAll());

		return "/admin/category_product/list_category";
	}
	
	@GetMapping("/category-product")
	public String category(Model model) {
		CateProductModel cateProductDTO = new CateProductModel();
		
		model.addAttribute("addCategory", cateProductDTO);
		return "admin/category_product/insert_category";
	}
	
	@PostMapping("/category-product")
	public String addCategory(Model model, @ModelAttribute CateProductModel cateProductDTO) {
		
		productCateService.addCategory(cateProductDTO);
		return "redirect:/admin/list-category-product?success";
	}
}
