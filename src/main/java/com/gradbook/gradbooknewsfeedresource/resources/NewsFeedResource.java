package com.gradbook.gradbooknewsfeedresource.resources;

import com.gradbook.gradbooknewsfeedresource.helpers.NewsFeedResourceHelper;
import com.gradbook.gradbooknewsfeedresource.models.NewsFeed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

/**
 * Created by Munna on 14-Jul-17.
 */
@RestController
public class NewsFeedResource {

    @Autowired
    private NewsFeedResourceHelper helper;

    @GetMapping("/newsFeed/getNewsFeed")
    List<NewsFeed> getNewsFeed(Principal principal){
        return helper.getNewsFeed(principal);
    }

    @GetMapping("/admin")
    String getAdminTest(Principal principal){
        return "THis is for admin";
    }

    @PostMapping("/newsFeed/saveNewsFeed")
    ResponseEntity<?> saveNewsFeed(Principal principal, @RequestBody NewsFeed newsFeed){
        return helper.saveNewsFeed(principal, newsFeed);
    }
}
