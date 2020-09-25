package example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// This will allow us to reinitialize this controller to get any new config
// values when the /refresh endpoint is POSTed to.
@RefreshScope
public class AppController {

    @Value("${database.name}")
    private String fooProperty;

    @RequestMapping("/")
    public String hello() {
        return "database name is  [" + fooProperty + "] from config server";
    }
}
