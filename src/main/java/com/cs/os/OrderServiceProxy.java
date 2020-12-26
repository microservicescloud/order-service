package com.cs.os;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="product-service")
public interface OrderServiceProxy {
    @GetMapping("/{product}")
    public String getProduct(@PathVariable("product") String product);
}
