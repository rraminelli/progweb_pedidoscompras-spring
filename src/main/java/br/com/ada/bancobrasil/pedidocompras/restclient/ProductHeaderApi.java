package br.com.ada.bancobrasil.pedidocompras.restclient;

import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;

public class ProductHeaderApi {

    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            requestTemplate.header("Autorization", "token");
            requestTemplate.header("param", "param1");
        };
    }

}
