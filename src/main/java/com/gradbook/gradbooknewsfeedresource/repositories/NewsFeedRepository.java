package com.gradbook.gradbooknewsfeedresource.repositories;

import com.gradbook.gradbooknewsfeedresource.models.NewsFeed;
import com.gradbook.gradbooknewsfeedresource.models.User;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Munna on 14-Jul-17.
 */
@Repository
@CacheConfig(cacheNames = "newsFeed")
public interface NewsFeedRepository extends JpaRepository<NewsFeed, Long> {

    @Cacheable(value="findByUserIdOrderByLastModifiedAsc")
    List<NewsFeed> findByUserIdOrderByLastModifiedAsc(Long userId);

    //@Cacheable("newsFeed")
//    @Cacheable(value="newsfeed", key = "#root.args")
    @Cacheable(value="findByUserIdInOrderByLastModified")
    List<NewsFeed> findByUserIdInOrderByLastModified(List<Long> userIds);

}
