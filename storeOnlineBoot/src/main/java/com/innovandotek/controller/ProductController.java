package com.innovandotek.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import com.innovandotek.model.Category;
import com.innovandotek.model.Product;
import com.innovandotek.repository.CategoryRepository;
import com.innovandotek.repository.ProductRepository;
import com.innovandotek.validator.ProductValidator;

@Controller
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductValidator productValidator;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@RequestMapping(value="/products", method = RequestMethod.GET)
	public String products(Model model){
		List<Product> listProduct = (List<Product>) productRepository.findAll();
		model.addAttribute("products", listProduct);
		return "products";
	}
	
	@RequestMapping(value="/products", method = RequestMethod.POST)
	public String buscarProduct(Model model, @RequestParam String name){
		List<Product> listProduct = (List<Product>) productRepository.findByNameContaining(name);
		model.addAttribute("products", listProduct);
		return "products";
	}
	
	@RequestMapping(value="/product/new", method = RequestMethod.GET)
	public String newProduct(Model model){
		List<Category> listCategory = (List<Category>) categoryRepository.findAll();
		model.addAttribute("categorys", listCategory);
		model.addAttribute("product", new Product());
		return "newProduct";
	}
	
	@RequestMapping(value="/product/new", method = RequestMethod.POST)
	public String saveNewProduct(@Valid @ModelAttribute Product product, 
			BindingResult result, Model model){
		
		List<Category> listCategory = (List<Category>) categoryRepository.findAll();		
		
		try {
			//productValidator.validate(product, result);
			if(result.hasErrors()){
				model.addAttribute("categorys", listCategory);
				return "newProduct";
			}
			productRepository.save(product);
			return "redirect:/products";
			
		} catch (Exception e) {
			model.addAttribute("categorys", listCategory);
			return "newProduct";
		}
		
	}
	
	@RequestMapping(value="/product/delete/{id}", method = RequestMethod.GET)
	public String deleteProduct(@PathVariable Long id){
		productRepository.delete(id);
		return "redirect:/products";
	}
	
	@RequestMapping(value="/product/{id}", method = RequestMethod.GET)
	public String viewProduct(@PathVariable Long id, Model model){
		Product product = productRepository.findOne(id);
		model.addAttribute("product", product);
		model.addAttribute("categorys", categoryRepository.findAll());
		return "viewProduct";
	}
	
	@RequestMapping(value="/product/edit/{id}", method = RequestMethod.GET)
	public String editProduct(@PathVariable Long id, Model model){
		Product product = productRepository.findOne(id);
		model.addAttribute("product", product);
		model.addAttribute("categorys", categoryRepository.findAll());
		return "editProduct";
	}
	
	@RequestMapping(value="/product/edit", method = RequestMethod.POST)
	public String saveEditProduct(@ModelAttribute Product product){
		productRepository.save(product);
		return "redirect:/products";
	}

}
