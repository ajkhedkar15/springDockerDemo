package com.demo.springDockerDemo.handlers;

import com.demo.springDockerDemo.models.Product;
import com.demo.springDockerDemo.repository.SpringDockerRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class SpringDockerHandler {

    private SpringDockerRepo repo;

    @Autowired
    public SpringDockerHandler(SpringDockerRepo repo) {
        this.repo = repo;
    }

    public Mono<ServerResponse> addProduct(ServerRequest request){
        return request.bodyToMono(Product.class).flatMap(product->{
            System.out.println(product);
            return repo.save(product);
        }).then(ServerResponse.ok().build());
    }

    public Mono<ServerResponse> getProducts(ServerRequest request){
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(repo.findAll(), Product.class);
    }
}
