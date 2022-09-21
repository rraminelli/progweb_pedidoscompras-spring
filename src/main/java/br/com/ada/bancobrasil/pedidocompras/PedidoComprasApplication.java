package br.com.ada.bancobrasil.pedidocompras;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PedidoComprasApplication {

	public static void main(String[] args) {
		SpringApplication.run(PedidoComprasApplication.class, args);
	}

}
