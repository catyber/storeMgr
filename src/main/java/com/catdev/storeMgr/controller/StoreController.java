package com.catdev.storeMgr.controller;

import com.catdev.storeMgr.exception.ResourceNotFoundException;
import com.catdev.storeMgr.model.Store;
import com.catdev.storeMgr.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class StoreController {
    @Autowired
    StoreRepository storeRepository;

    @GetMapping("/api/stores/trail")
    public String allAccess() {
        return "Im on the STORE CONTROLLER.";
    }

    @GetMapping("/api/stores")
    public Page<Store> getAllStores(Pageable pageable) {
        return storeRepository.findAll(pageable);
    }
//    public List<Store> getAllStores(){
//            return repository.findAll();
//    }

    @GetMapping("/api/stores/{storeId}")
    public Store getStore(@PathVariable Long storeId) {
        return storeRepository.findById(storeId)
                .orElseThrow(() -> new ResourceNotFoundException("Store " + storeId + " not found."));
    }

    @PostMapping("/api/stores/")
    public Store createStore(@Valid @RequestBody Store newStore) {
        return storeRepository.save(newStore);
    }

    @PutMapping("/api/stores/{storeId}")
    public Store updateStore(@PathVariable Long storeId, @Valid @RequestBody Store newStore){
        return storeRepository.findById(storeId).map(store -> {
            store.setName(newStore.getName());
            return storeRepository.save(store);
        }).orElseThrow(() -> new ResourceNotFoundException("Store " + storeId + " not found."));
    }
//    public ResponseEntity<Store> updateStore(@PathVariable Long id, @RequestBody Store newStore) {
//
//        return repository.findById(id)
//                .map(store -> {
//                    store.setStoreName(newStore.getStoreName());
//                    return new ResponseEntity<Store>(repository.save(store), HttpStatus.OK);
//                })
//                .orElseGet(() -> {
//                    newStore.setId(id);
//                    return new ResponseEntity<Store>(repository.save(newStore), HttpStatus.OK);
//                });
//    }

    @DeleteMapping("/api/stores/{storeId}")
    public ResponseEntity<?> deletePost(@PathVariable Long storeId) {
        return storeRepository.findById(storeId).map(store -> {
            storeRepository.delete(store);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Store " + storeId + " not found."));
    }

//    public void deleteStore(@PathVariable Long id) {
//        storeRepository.deleteById(id);
//    }
}
