package com.gradbook.gradbooknewsfeedresource.repositories;

import com.gradbook.gradbooknewsfeedresource.models.UserFriend;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Munna on 14-Jul-17.
 */

@Repository
@CacheConfig(cacheNames = "userFriendRepository")
public interface UserFriendRepository extends JpaRepository<UserFriend, Long> {

    //@Cacheable("findByUserId")
    @Cacheable("findByUserId(Long userId)")
    List<UserFriend> findByUserId(Long userId);


}
