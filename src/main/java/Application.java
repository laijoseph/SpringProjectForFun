
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import controllers.WordHolderController;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import service.WordDictionaryService;

@SpringBootApplication
@ComponentScan(basePackageClasses = {WordHolderController.class, WordDictionaryService.class})
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public OpenAPI openAPI() {
		return new OpenAPI()
				.info(new Info().title("SpringDoc example").description("SpringDoc application").version("v0.0.1"));
	}
//	@Bean
//	public SecurityWebFilterChain filterChain(ServerHttpSecurity http) {
//		http.csrf(csrf -> csrf.disable()).authorizeExchange(exchanges -> exchanges.anyExchange().permitAll());
//		return http.build();
//	}
}
