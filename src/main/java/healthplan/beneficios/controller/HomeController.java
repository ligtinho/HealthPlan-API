package healthplan.beneficios.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;




@Controller
public class HomeController {
	@Autowired
	

	@GetMapping("")
	public String index() {
		return "index";
	}
	
	@GetMapping("/home")
	public String home() {	
		return "home";
	}
	
	@GetMapping("/create")
	public String create() {	
		return "create";
	}
	
	@GetMapping("/update")
	public String update() {	
		return "update";
	}
	
	@GetMapping("/listarbeneficiarios")
	public String listarbeneficiarios() {	
		return "listarbeneficiarios";
	}
	
	@GetMapping("/listardocumentos")
	public String listardocumentos() {	
		return "listardocumentos";
	}
	
	@GetMapping("/sair")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
      
        return "redirect:/?logout";
    }
}
