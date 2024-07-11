package com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.model.Cart;
import com.service.CartService;

@RestController
@RequestMapping("/carts")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Cart>> getAllCarts() {
        List<Cart> carts = cartService.getAllCarts();
        return new ResponseEntity<>(carts, HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Cart> getCartById(@PathVariable("id") long id) {
        Optional<Cart> cart = cartService.getCartById(id);
        if (cart.isPresent()) {
            return new ResponseEntity<>(cart.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/save/{bookId}")
    public ResponseEntity<Cart> createCart(@PathVariable("bookId") long bookId, @RequestBody Cart cart) {
        Cart createdCart = cartService.createCart(bookId, cart);
        if (createdCart != null) {
            return ResponseEntity.ok(createdCart);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
    @PutMapping("update/{id}")
    public ResponseEntity<Cart> updateCart(@PathVariable("id") long id, @RequestBody Cart cartDetails) {
        Cart updatedCart = cartService.updateCart(id, cartDetails);

        if (updatedCart != null) {
            return ResponseEntity.ok(updatedCart);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteCart(@PathVariable("id") long id) {
        boolean isDeleted = cartService.deleteCart(id);

        if (isDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
