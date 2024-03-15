package com.rocketsystems.printsystems;

import com.rocketsystems.printsystems.entities.Product;
import com.rocketsystems.printsystems.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PrintSystemsApplication implements CommandLineRunner {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Selecione um Opção:");
        System.out.println("1. Adicionar Item");
        System.out.println("2. Listar itens cadastrados");
        System.out.println("3. Sair");
    }

    public static void main(String[] args) {
        SpringApplication.run(PrintSystemsApplication.class, args);
    }

}
