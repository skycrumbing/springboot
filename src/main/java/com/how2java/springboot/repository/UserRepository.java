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
//有时候一个类中可能会有多个缓存操作，而这些缓存操作可能是重复的。这个时候可以使用@CacheConfig
    //@CacheConfig是一个类级别的注解，允许共享缓存的名称、KeyGenerator、CacheManager 和CacheResolver
@CacheConfig(cacheNames = "user")
public interface UserRepository extends PagingAndSortingRepository<User,Integer> {
    //@Cacheable是用来声明方法是可缓存的。
    // 将结果存储到缓存中以便后续使用相同参数调用时不需执行实际的方法。直接从缓存中取值。最简单的格式需要制定缓存名称。
    @Cacheable(key = "#p0")
    User findById(int id);
    /**
     * 新增或修改时，如果缓存需要更新，且不干扰方法的执行,可以使用注解@CachePut。@CachePut标注的方法在执行
     * 前不会去检查缓存中是否存在之前执行过的结果，而是每次都会执行该方法，并将执行结果以键值对的形式存入指定的缓存中。
     */
    @CachePut(key = "#p0.id")
    User save(User user);

    @Transactional
    @Modifying
    int deleteById(int id);




}
