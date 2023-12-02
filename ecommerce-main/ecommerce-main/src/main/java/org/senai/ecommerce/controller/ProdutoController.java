package org.senai.ecommerce.controller;

import org.senai.ecommerce.entities.Produto;
import org.senai.ecommerce.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    private final ProdutoService produtoService;

    @Autowired
    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping
    public List<Produto> getAllProducts() {
        return produtoService.getProdutos(); // Use getProdutos() instead of getAllProdutos()
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Long id) {
        return new ResponseEntity<>(produtoService.getProdutoPorCodigo(id), HttpStatus.OK); // Use getProdutoPorCodigo() instead of getProdutoById()
    }

    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody Produto produto) {
        produtoService.criarProduto(produto); // Use criarProduto() instead of createProduto()
        return new ResponseEntity<>("Produto Criado", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable Long id, @RequestBody Produto produtoDetails) {
        produtoService.atualizarProduto(id, produtoDetails); // Use atualizarProduto() instead of updateProduto()
        return new ResponseEntity<>("Produto Atualizado", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        produtoService.excluirProduto(id); // Use excluirProduto() instead of deleteProduto()
        return new ResponseEntity<>("Produto Deletado", HttpStatus.OK);
    }
}
