package com.invillia.acme.resource;

import com.invillia.acme.resource.dto.StoreDTO;
import com.invillia.acme.service.StoreService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/store")
public class StoreResource {

    private StoreService storeService;

    StoreResource(StoreService storeService) {
        this.storeService = storeService;
    }

    @PostMapping
    public StoreDTO create(@RequestBody StoreDTO storeDTO) {
        return this.storeService.create(storeDTO);
    }

    @PutMapping
    public StoreDTO update(@RequestBody StoreDTO storeDTO) {
        return this.storeService.update(storeDTO);
    }

    @GetMapping(path = "/{id}")
    public StoreDTO update(@PathVariable(value = "id") Long id) {
        return this.storeService.findById(id);
    }

    @GetMapping(path = "/by-name/{name}")
    public StoreDTO update(@PathVariable(value = "name") String name) {
        return this.storeService.findByName(name);
    }

}
