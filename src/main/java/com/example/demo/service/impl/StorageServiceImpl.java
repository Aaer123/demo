package com.example.demo.service.impl;


import com.example.demo.domain.Storage;
import com.example.demo.mapper.StorageMapper;
import com.example.demo.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StorageServiceImpl implements StorageService {

    @Autowired
    private StorageMapper storageMapper;

    @Override
    public void addStorageshop(Storage storage) {
        storageMapper.addStorageshop(storage);
    }

    @Override
    public Storage findStorage(int userid, String bookshopid) {
        Storage storage = storageMapper.findStorage(userid, bookshopid);
        return storage;
    }

    @Override
    public void updateStorageshop(Storage storage) {
        storageMapper.updateStorageshop(storage);
    }

    @Override
    public Storage fibd(String bookshopid) {
        Storage fibd = storageMapper.fibd(bookshopid);
        return fibd;
    }
}




