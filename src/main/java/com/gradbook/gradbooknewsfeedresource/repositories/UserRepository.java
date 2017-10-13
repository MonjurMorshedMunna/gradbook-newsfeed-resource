package com.gradbook.gradbooknewsfeedresource.repositories;

import com.gradbook.gradbooknewsfeedresource.models.User;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Munna on 14-Jul-17.
 */
@Repository
@CacheConfig(cacheNames = "userRepository")
public interface UserRepository extends JpaRepository<User, Long> {
    @Cacheable("findByEmailAndPassword")
    User findByEmailAndPassword(String email, String password);
    @Cacheable("findByEmail")
    User findByEmail(String email);


}
