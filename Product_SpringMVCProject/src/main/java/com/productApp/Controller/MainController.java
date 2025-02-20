package com.productApp.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import com.productApp.Model.Product;
import com.productApp.Service.ProductService;

@Controller
public class MainController 
{
	@Autowired
	private ProductService productService;
	
	@RequestMapping("/")
	public String indexHandler(Model model)
	{
		List<Product> allProduts = productService.getAllProduts();
		model.addAttribute("allProducts", allProduts);
		return "index";
	}
	
	@RequestMapping("/addProductForm")
	private String addProduct()
	{
		return "addProductForm";
	}
	
	@RequestMapping(value = "/saveProduct", method = RequestMethod.POST)
	public RedirectView saveProduct(@ModelAttribute Product product,HttpServletRequest request)
	{
		RedirectView redirectView = new RedirectView();
		productService.saveProduct(product);
		redirectView.setUrl(request.getContextPath()+"/");
		return redirectView;
	}
	
	@RequestMapping("/deleteProduct/{pid}")
	public RedirectView deleteProduct(@PathVariable("pid") int pid,HttpServletRequest request)
	{
		productService.deleteProduct(pid);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath()+"/");
		return redirectView;
	}
	
	@RequestMapping("/updateProduct/{pid}")
	public String updateProduct(@PathVariable("pid") int pid,Model model)
	{
		Product productById = productService.getProductById(pid);

		model.addAttribute("productById",productById);
		return "updateForm";
	}
	
}
