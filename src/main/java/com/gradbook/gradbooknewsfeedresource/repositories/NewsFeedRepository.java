package com.gradbook.gradbooknewsfeedresource.repositories;

import com.gradbook.gradbooknewsfeedresource.models.NewsFeed;
import com.gradbook.gradbooknewsfeedresource.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Munna on 14-Jul-17.
 */
@Repository
public interface NewsFeedRepository extends JpaRepository<NewsFeed, Long> {

    List<NewsFeed> findByUserIdOrderByLastModifiedAsc(Long userId);


    List<NewsFeed> findByUserIdInOrderByLastModified(List<Long> userIds);

}
