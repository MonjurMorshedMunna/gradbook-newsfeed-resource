package com.gradbook.gradbooknewsfeedresource.helpers;

import com.gradbook.gradbooknewsfeedresource.models.NewsFeed;
import com.gradbook.gradbooknewsfeedresource.models.User;
import com.gradbook.gradbooknewsfeedresource.models.UserFriend;
import com.gradbook.gradbooknewsfeedresource.repositories.NewsFeedRepository;
import com.gradbook.gradbooknewsfeedresource.repositories.UserFriendRepository;
import com.gradbook.gradbooknewsfeedresource.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by Munna on 14-Jul-17.
 */
@Component
public class NewsFeedResourceHelper {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private NewsFeedRepository newsFeedRepository;

    @Autowired
    private UserFriendRepository userFriendRepository;

    public List<NewsFeed> getNewsFeed(Principal principal){
        User loggedUser = userRepository.findOne(Long.parseLong(principal.getName()));
        List<UserFriend> userFriends = userFriendRepository.findByUserId(loggedUser.getId());
        List<Long> userIds = userFriends.stream().map(f->f.getId()).collect(Collectors.toList());
        List<NewsFeed> newsFeeds = newsFeedRepository.findByUserIdInOrderByLastModified(userIds);
        return newsFeeds;
    }

    public ResponseEntity<?> saveNewsFeed(Principal principal, NewsFeed newsFeed){
        newsFeedRepository.save(newsFeed);
        return ResponseEntity.ok("created");
    }
}
