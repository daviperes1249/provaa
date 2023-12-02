package org.senai.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.senai.ecommerce.entities.Produto;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    List<Produto> findByNome(String nome);

    List<Produto> findByPrecoGreaterThan(double preco);


}
