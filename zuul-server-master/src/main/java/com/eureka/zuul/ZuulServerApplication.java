package com.eureka.zuul;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient 	// It acts as a eureka client
@EnableZuulProxy		// Enable Zuul
public class ZuulServerApplication {
	public static void main(String[] args) {
		SpringApplication.run(ZuulServerApplication.class, args);
	}

	@Bean
	public ZuulFilter postFilter(){
		return new ZuulFilter() {
			@Override
			public String filterType() {
				return "pre";
			}

			@Override
			public int filterOrder() {
				return 1;
			}

			@Override
			public boolean shouldFilter() {
				return true;
			}

			@Override
			public Object run() throws ZuulException {
				return null;
			}
		};
	}
}