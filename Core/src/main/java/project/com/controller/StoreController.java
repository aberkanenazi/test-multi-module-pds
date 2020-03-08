package project.com.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import project.com.model.Store;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import project.com.persistance.StoreRepository;
import project.com.service.StoreServiceImpl;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/v1/stores")
public class StoreController {
    @Autowired
    private StoreServiceImpl storeService;

    /**
     * Method used to save an object
     *
     * @param store
     */
    @PostMapping
    @ResponseBody
    public ResponseEntity<Store> save(@RequestBody Store store, UriComponentsBuilder uriComponentsBuilder) {
        this.storeService.save(store);
        UriComponents uriComponents = uriComponentsBuilder.path("/api/v1/stores/{id}").buildAndExpand(store.getStoreId());
        return ResponseEntity.status(HttpStatus.CREATED)
                .location(uriComponents.toUri())
                .body(store);
    }

    /**
     * Method used to retrieve all objects
     *
     * @return stores
     */
    @GetMapping("/")
    public List<Store> findAll() {
        List<Store> stores = this.storeService.findAll();
        return stores;
    }

    /**
     * Method used to retrieve an object by its Id
     *
     * @param storeId
     * @return prototype
     */
    @GetMapping("/{storeId}")
    public Optional<Store> findById(@PathVariable("storeId") String storeId) {
        Optional<Store> store = this.storeService.findById(storeId);
        return store;
    }

    /**
     * Method used to insert OR update an object
     *
     * @param store
     */
    @PutMapping
    public void update(@RequestBody Store store) {
        this.storeService.save(store);
    }

    /**
     * Method used to delete all objects
     */
    @DeleteMapping
    public void deleteAll(){ this.storeService.deleteAll(); }

    /**
     * Method used to delete an object by its Id
     *
     * @param storeId
     */
    @DeleteMapping("/{storeId}")
    public void delete(@PathVariable("storeId") String storeId) {
        this.storeService.deleteById(storeId);
    }


}
