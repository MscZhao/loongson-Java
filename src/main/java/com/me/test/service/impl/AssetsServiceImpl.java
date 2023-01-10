package com.me.test.service.impl;

import com.me.test.mapper.AssetsMapper;
import com.me.test.pojo.Assets;
import com.me.test.service.AssetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssetsServiceImpl implements AssetsService {

    @Autowired
    private AssetsMapper assetsMapper;

    @Override
    public void add(Assets assets) {
        assetsMapper.add(assets);
    }

    @Override
    public void delete(Integer id) {
        assetsMapper.delete(id);
    }

    @Override
    public void update(Assets assets) {
        assetsMapper.update(assets);
    }

    @Override
    public Assets queryById(Integer id) {
        return assetsMapper.queryById(id);
    }

    @Override
    public List<Assets> queryAll() {
        return assetsMapper.queryAll();
    }
}
