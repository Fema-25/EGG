package practica.eggNews;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"practica.eggNews.repositorios"})
public class EggNewsApplication {

	public static void main(String[] args) {
		SpringApplication.run(EggNewsApplication.class, args);
	}

}
