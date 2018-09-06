package com.how2java.springboot.repository;

import com.how2java.springboot.bean.User;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.PagingAndSortingRepository;

import javax.transaction.Transactional;

/**
 * Created by Administrator on 2018/9/4 0004.
 */
@CacheConfig(cacheNames = "user")
public interface UserRepository extends PagingAndSortingRepository<User,Integer> {
    @Cacheable(key = "#p0")
    User findById(int id);
//    在findById方法时加了个@Cacheable（key= "#p0")，#p0代表第一个参数，也就是id。
//    这句话加上之后，当你在调用findById时，就会先从redis的post缓存对象里去查询key等于传过来的id的值。如果没有，就去查表。
    /**
     * 新增或修改时
     */
    @CachePut(key = "#p0.id")
    User save(User user);

    @Transactional
    @Modifying
    int deleteById(int id);




}
