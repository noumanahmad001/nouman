package hello;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ApiController {

	
	//@Autowired
	@RequestMapping(value="/test")
	public String getAllMenu(){
	//	System.out.println("size is " + ((List<Menu>)menuRepo.findAll()).size());
		 
		return "done";
	}

}
