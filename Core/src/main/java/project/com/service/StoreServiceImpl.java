package project.com.service;

import project.com.model.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.com.persistance.StoreRepository;

import java.util.List;
import java.util.Optional;


@Service
public class StoreServiceImpl implements ServiceImpl<Store> {

    @Autowired
    private StoreRepository storeRepository;

    @Autowired
    public void setStoreRepository(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    @Override
    public Store save(Store store) {
        return this.storeRepository.save(store);
    }

    @Override
    public List<Store> findAll() {
        return this.storeRepository.findAll();

    }

    @Override
    public Optional<Store> findById(String id) {
        return this.storeRepository.findById(id);
    }

    @Override
    public void deleteAll() {
        this.storeRepository.deleteAll();
    }

    @Override
    public void deleteById(String id) {
        storeRepository.deleteById(id);
    }
}
