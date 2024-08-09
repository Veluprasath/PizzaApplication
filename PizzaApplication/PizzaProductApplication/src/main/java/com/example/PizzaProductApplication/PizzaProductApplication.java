package com.example.PizzaProductApplication;

import com.example.PizzaProductApplication.filter.JwtFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
public class PizzaProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(PizzaProductApplication.class, args);
	}
//	@Bean
//	public FilterRegistrationBean beanFilter() {
//		FilterRegistrationBean frb = new FilterRegistrationBean();
//		frb.setFilter(new JwtFilter());
//		frb.addUrlPatterns("/pizza-product-app/addUser","/pizza-product-app/updatePizza","/pizza-product-app/deletePizza/{pizzaId}");
//		return frb;
//
//	}

//	@Bean
//	public FilterRegistrationBean filterRegistrationBean () {
//		final CorsConfiguration config = new CorsConfiguration();
//		config.setAllowCredentials(true);
//		config.addAllowedOrigin("http://localhost:4200");
//		config.addAllowedMethod("*");
//		config.addAllowedHeader("*");
//		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//		source.registerCorsConfiguration("/**", config);
//		FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
//		bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
//		return bean;
//	}

}
