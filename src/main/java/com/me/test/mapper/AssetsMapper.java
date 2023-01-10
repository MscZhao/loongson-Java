package com.me.test.mapper;

import com.me.test.pojo.Assets;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface AssetsMapper {

    /**
     * 增加一条数据
     * @param assets 数据
     */
    void add(Assets assets);

    /**
     * 删除一条数据
     * @param id 被删除数据的id
     */
    void delete(Integer id);

    /**
     * 修改一条数据
     * @param assets 修改的数据
     */
    void update(Assets assets);

    /**
     * 根据id去查询一条数据
     * @param id 查询的id
     */
    Assets queryById(Integer id);

    /**
     * 查询全部数据
     * @return
     */
    List<Assets> queryAll();
}
