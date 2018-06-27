package io.github.alexbogovich.springjpasandbox;

import com.cosium.spring.data.jpa.entity.graph.repository.support.EntityGraphJpaRepositoryFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(repositoryFactoryBeanClass = EntityGraphJpaRepositoryFactoryBean.class)
public class SpringJpaSandboxApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaSandboxApplication.class, args);
	}
}
