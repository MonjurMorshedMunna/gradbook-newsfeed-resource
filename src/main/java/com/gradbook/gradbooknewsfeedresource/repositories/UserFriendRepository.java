package com.gradbook.gradbooknewsfeedresource.repositories;

import com.gradbook.gradbooknewsfeedresource.models.UserFriend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Munna on 14-Jul-17.
 */
@Repository
public interface UserFriendRepository extends JpaRepository<UserFriend, Long> {

    List<UserFriend> findByUserId(Long userId);


}
