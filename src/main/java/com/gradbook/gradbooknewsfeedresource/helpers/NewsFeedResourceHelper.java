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
import java.sql.Timestamp;
import java.util.ArrayList;
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
        userIds.add(loggedUser.getId());
        List<NewsFeed> newsFeeds = newsFeedRepository.findByUserIdInOrderByLastModified(userIds);
        List<NewsFeed> newNNewsFeeds = new ArrayList<>();
        for(NewsFeed newsFeed: newsFeeds){
            newsFeed.setUserName(userRepository.findOne(newsFeed.getUserId()).getEmail());
            newNNewsFeeds.add(newsFeed);
        }
        return newNNewsFeeds;
    }

    public ResponseEntity<?> saveNewsFeed(Principal principal, NewsFeed newsFeed){
        User loggedUser = userRepository.findOne(Long.parseLong(principal.getName()));
        newsFeed.setUserId(loggedUser.getId());
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        newsFeed.setLastModified(timestamp);
        newsFeedRepository.save(newsFeed);
        return ResponseEntity.ok("created");
    }
}
