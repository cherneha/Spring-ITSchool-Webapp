package bootstart;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    @RequestMapping("/home")
    public String welcome(){
        return "Welcome to the webapp!";
    }
}
