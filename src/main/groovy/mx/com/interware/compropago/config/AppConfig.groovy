package mx.com.interware.compropago.config
  
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.EnableWebMvc
  
@Configuration 
@ComponentScan("mx.com.interware")
@EnableAutoConfiguration
@SpringBootApplication
class AppConfig {
	   public static void main(final String[] args) {
	        SpringApplication.run(AppConfig.class, args)
	   }
}  
