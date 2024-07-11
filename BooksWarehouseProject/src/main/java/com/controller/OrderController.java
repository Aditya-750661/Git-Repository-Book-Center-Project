package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Order;
import com.model.User;
import com.service.OrderService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;


	@PostMapping("/buy")
	public ResponseEntity<String> buyOrder(@RequestBody Order o) {
		System.out.println(o);
	    try {
	        Order order = orderService.buyOrder(o);
	        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Buy Order Placed");
	    } catch (IllegalArgumentException e) {
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred");
	    }
	}


	@PostMapping("/rentBuy/{buyerId}/{sellerId}/{bookId}")
	public ResponseEntity<String> rentBuyOrder(@PathVariable("buyerId") long buyerId,@PathVariable("sellerId") long sellerId,@PathVariable("bookId") long bookId,@RequestBody Order order) {
	    Order placedOrder = orderService.buyOnRentOrder(buyerId, sellerId, bookId, order);

	    if (placedOrder != null) {
	        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Rent buy order placed successfully");
	    } else {
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Problem occurred while placing rent buy order");
	    }
	}
	
    @DeleteMapping("/delete/{orderId}")
    public ResponseEntity<Void> deleteOrder(@PathVariable long orderId) {
        orderService.deleteOrder(orderId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("get/{orderId}")
    public ResponseEntity<Order> getOrderById(@PathVariable long orderId) {
        Order order = orderService.getOrderById(orderId);
        if (order != null) {
            return new ResponseEntity<>(order, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
