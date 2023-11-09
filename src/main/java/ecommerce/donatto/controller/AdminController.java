package ecommerce.donatto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ecommerce.donatto.model.Product;
import ecommerce.donatto.service.IOrderService;
import ecommerce.donatto.service.IUserService;
import ecommerce.donatto.service.ProductService;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private ProductService productService;

    @Autowired
    private IUserService userService;

    @Autowired
    private IOrderService orderService;

    @GetMapping("")
    public String home(Model model){

        List<Product> products=productService.findAll();
        model.addAttribute("products", products);

        return "administrador/home";
    }

    @GetMapping("/users")
    public String users(Model model) {
        model.addAttribute("users", userService.findAll());
        return "administrador/usuarios";
    }

    @GetMapping("orders")
    public String orders(Model model) {
        model.addAttribute("ordenes", orderService.findAll());
        return "administrador/orders";
    }

}
