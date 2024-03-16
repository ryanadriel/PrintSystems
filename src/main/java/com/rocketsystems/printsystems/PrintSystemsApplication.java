package com.rocketsystems.printsystems;

import com.rocketsystems.printsystems.entities.Product;
import com.rocketsystems.printsystems.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class PrintSystemsApplication implements CommandLineRunner {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("Menu:");
            System.out.println("[1] Adicionar Item");
            System.out.println("[2] Listar itens cadastrados");
            System.out.println("[3] Sair");
            System.out.print("Digite a opção desejada: ");

            int option = Integer.parseInt(scanner.nextLine());

            if (option == 1){
                System.out.println("Nome do item: ");
                String name = scanner.nextLine();

                System.out.println("Preço do item: ");
                String price = scanner.nextLine();

                System.out.println("Fornecedor: ");
                String supplier = scanner.nextLine();

                System.out.println("Quantidade em estoque: ");
                int quantityInStock = Integer.parseInt(scanner.nextLine());

                Product newProduct = new Product();

                newProduct.setName(name);
                newProduct.setPrice(price);
                newProduct.setSupplier(supplier);
                newProduct.setQuantityInStock(quantityInStock);

                productRepository.save(newProduct);

                System.out.println("Produto cadastrado com sucesso!");

            } else if (option == 2){
                for (Product  p : productRepository.findAll()) {
                    System.out.println("Itens cadastrados: ");
                    System.out.println( "Item: " + p.getName() + " || " + "Valor: " +  p.getPrice() + " || " + "Fornecedor: " + p.getSupplier() + " || " + "Estoque: " + p.getQuantityInStock());
                }
            } else if (option == 3){
                System.out.println("Desconectado!");
                break;
            } else {
                System.out.println("Opção inválida!");
            }
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(PrintSystemsApplication.class, args);
    }

}
