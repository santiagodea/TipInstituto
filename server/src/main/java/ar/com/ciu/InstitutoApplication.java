package ar.com.ciu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SpringBootApplication
public class InstitutoApplication {
	
	@RequestMapping("/")
    @ResponseBody
    String home() {
      return "ESTE ES EL SERVER DEL INSTITUTO!";
    }

	public static void main(String[] args) {
		SpringApplication.run(InstitutoApplication.class, args);
	}

}
