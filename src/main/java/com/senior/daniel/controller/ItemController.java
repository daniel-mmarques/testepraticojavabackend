package com.senior.daniel.controller;

import com.senior.daniel.dto.ItemDTO;
import com.senior.daniel.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping
    public ResponseEntity<ItemDTO> create(@RequestBody ItemDTO request) {
        ItemDTO item = itemService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(item);
    }

    @GetMapping("{id}")
    public ResponseEntity<ItemDTO> read(@PathVariable UUID id) {
        ItemDTO itemDTO = itemService.read(id);
        if (itemDTO != null) {
            return ResponseEntity.status(HttpStatus.OK).body(itemDTO);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @PutMapping("{id}")
    public ResponseEntity<ItemDTO> update(@PathVariable UUID id, @RequestBody ItemDTO request) {
        ItemDTO item = itemService.udpate(id, request);
        if (item != null) {
            return ResponseEntity.status(HttpStatus.OK).body(item);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable UUID id) {
        itemService.delete(id);
    }

    @GetMapping
    public ResponseEntity<List<ItemDTO>> list() {
        return ResponseEntity.status(HttpStatus.OK).body(itemService.list());
    }

}
