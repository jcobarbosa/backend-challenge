package com.invillia.acme.service;

import com.invillia.acme.entity.Store;
import com.invillia.acme.repository.StoreRepository;
import com.invillia.acme.resource.dto.StoreDTO;
import com.invillia.acme.util.ObjectMapperUtil;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StoreService {

    private StoreRepository storeRepository;

    StoreService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    public StoreDTO findById(Long id) {
        Optional<Store> store = storeRepository.findById(id);
        if (store.isPresent()) {
            return ObjectMapperUtil.convert(store.get(), StoreDTO.class);
        }
        return null;
    }

    public StoreDTO findByName(String name) {
        return ObjectMapperUtil.convert(storeRepository.findByName(name), StoreDTO.class);
    }

    public StoreDTO create(StoreDTO storeDto) {
        Store store = ObjectMapperUtil.convert(storeDto, Store.class);
        return saveOrUpdate(store);
    }

    public StoreDTO update(StoreDTO storeDto) {
        Store store = ObjectMapperUtil.convert(storeDto, Store.class);
        return saveOrUpdate(store);
    }

    private StoreDTO saveOrUpdate(Store storeToPersist) {
        return ObjectMapperUtil.convert(storeRepository.save(storeToPersist), StoreDTO.class);
    }
}
