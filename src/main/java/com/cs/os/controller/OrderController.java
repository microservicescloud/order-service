package com.cs.os.controller;

import com.cs.os.OrderServiceProxy;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class OrderController {
	private OrderServiceProxy orderServiceProxy;

	@RequestMapping("/{order}")
	public String getOrder(@PathVariable("order") String order) {
		return String.format("%s - feign call : %s", order, orderServiceProxy.getProduct(order));
	}

	@RequestMapping("/")
	public String test() {
		return "test";
	}

}