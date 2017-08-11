import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 */

/**
 * @author songy
 * @date 2017年8月8日 下午2:58:27
 */
@Controller
@EnableAutoConfiguration
public class Application {

	@RequestMapping("/")
	@ResponseBody
	public String greeting() {
		return "Hello World!";
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
