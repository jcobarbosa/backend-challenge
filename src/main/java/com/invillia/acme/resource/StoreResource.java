package com.invillia.acme.resource;

import com.invillia.acme.resource.dto.StoreDTO;
import com.invillia.acme.service.StoreService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/store")
public class StoreResource {

    private StoreService storeService;

    StoreResource(StoreService storeService) {
        this.storeService = storeService;
    }

    @ApiOperation(value = "Criar cadastro da empresa", response = StoreDTO.class)
    @PostMapping
    public StoreDTO create(@RequestBody StoreDTO storeDTO) {
        return this.storeService.create(storeDTO);
    }

    @ApiOperation(value = "Atualizar dados da empresa", response = StoreDTO.class)
    @PutMapping
    public StoreDTO update(@RequestBody StoreDTO storeDTO) {
        return this.storeService.update(storeDTO);
    }

    @ApiOperation(value = "Encontrar uma Empresa através do seu código (id)", response = StoreDTO.class)
    @GetMapping(path = "/{id}")
    public StoreDTO update(@PathVariable(value = "id") Long id) {
        return this.storeService.findById(id);
    }

    @ApiOperation(value = "Encontrar uma Empresa através do seu nome (completo)", response = StoreDTO.class)
    @GetMapping(path = "/by-name/{name}")
    public StoreDTO update(@PathVariable(value = "name") String name) {
        return this.storeService.findByName(name);
    }

}
