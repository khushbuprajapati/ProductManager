package net.codejava;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {

	@Autowired
	private ProductService service; 
	
	/*
	 * @RequestMapping("/") public String viewHomePage(Model model) { List<Product>
	 * listProducts = service.listAll(); model.addAttribute("listProducts",
	 * listProducts);
	 * 
	 * return "index"; }
	 */
	
	@RequestMapping("/product")
	public String viewProductPage(Model model) {
		List<Product> listProducts = service.listAll();
		model.addAttribute("listProducts", listProducts);
		
		return "product";
	}
	
	@RequestMapping("/home")
	public String viewIndexPage(Model model) {
		/*
		 * List<Product> listProducts = service.listAll();
		 * model.addAttribute("listProducts", listProducts);
		 */
		return "index";
	}
	
	@RequestMapping("/new")
	public String showNewProductPage(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
		
		return "new_product";
	}
	

	@RequestMapping("/about")
	public String showAboutPage(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
		
		return "about";
	}
	
	@RequestMapping("/contact")
	public String showContactPage(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
		
		return "contact";
	}
	
	@RequestMapping("/portfolio")
	public String showPortfolioPage(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
		
		return "portfolio";
	}
	
	@RequestMapping("/portfolio-details")
	public String showPortfolioDetailsPage(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
		
		return "portfolio-details";
	}
	
	@RequestMapping("/resume")
	public String showResumePage(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
		
		return "resume";
	}
	
	@RequestMapping("/services")
	public String showServicePage(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
		
		return "services";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("product") Product product) {
		service.save(product);
		
		return "redirect:/";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditProductPage(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("edit_product");
		Product product = service.get(id);
		mav.addObject("product", product);
		
		return mav;
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteProduct(@PathVariable(name = "id") int id) {
		service.delete(id);
		return "redirect:/";		
	}
}
