package com.project.quanlybanhang.controller.web;

import com.project.quanlybanhang.entities.ProductsEntity;
import com.project.quanlybanhang.service.ICateProductService;
import com.project.quanlybanhang.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.Optional;

@RestController
@Transactional
@RequestMapping("/TMDT/product")
public class ProductWebAPI {

	@Autowired
	private IProductService productService;
	
	@Autowired
	private ICateProductService productCateService;
	
	@GetMapping("/list_product")
	public String listProduct(Model model) {
		model.addAttribute("listProduct", productService.findAll());
		model.addAttribute("listCategory", productCateService.findAll());
		return "web/product/list_products_web";
	}
	
	@GetMapping("/image/display/{id}")
	public void showImage(@PathVariable("id") Long id, HttpServletResponse response, 
							Optional<ProductsEntity> productEntity) throws ServletException, IOException{
		productEntity = productService.getImageById(id);
		response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
		response.getOutputStream().write(productEntity.get().getImage());
		response.getOutputStream().close();
	}
	
	@GetMapping("/product_detail")
	public String productDetail(Model model, @RequestParam(value = "id", required = false)Long id) {
		model.addAttribute("productDetail", productService.findById(id));
		return "web/product/product_detail";
	}
	
	//Lấy danh sách sản phẩm theo thể loại
	@GetMapping(value = "/list-product-by-category")
	public String listProductWithCategory(Model model, @RequestParam(value = "categoryId", required = false)Long id){
		model.addAttribute("listProduct", productService.findAllProductByCategoryId(id));
		model.addAttribute("listCategory", productCateService.findAll());
		return "web/product/list_products_web";
	}

}
