package com.demo.springDockerDemo.repository;

import com.demo.springDockerDemo.models.Product;
import org.springframework.data.couchbase.core.query.N1qlPrimaryIndexed;
import org.springframework.data.couchbase.core.query.ViewIndexed;
import org.springframework.data.couchbase.repository.ReactiveCouchbaseRepository;
import org.springframework.stereotype.Repository;

@Repository
@N1qlPrimaryIndexed
@ViewIndexed(designDoc = "product", viewName = "all")
public interface SpringDockerRepo extends ReactiveCouchbaseRepository<Product,Integer> {

}
