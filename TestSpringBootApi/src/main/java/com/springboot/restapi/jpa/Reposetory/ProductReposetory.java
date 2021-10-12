package com.springboot.restapi.jpa.Reposetory;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.springboot.restapi.domain.Products;

@Service
public interface ProductReposetory extends CrudRepository<Products, Integer> {

}
