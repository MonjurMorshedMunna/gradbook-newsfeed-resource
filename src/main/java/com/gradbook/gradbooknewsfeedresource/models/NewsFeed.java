package com.gradbook.gradbooknewsfeedresource.models;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Munna on 14-Jul-17.
 */
@Entity
@Cacheable
@Table(name="news_feed")
public class NewsFeed {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    @Column(name="user_id")
    private Long userId;

    @Column(name="feed")
    private String feed;

    @Column(name="last_modified")
    private Timestamp lastModified;


    public NewsFeed(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFeed() {
        return feed;
    }

    public void setFeed(String feed) {
        this.feed = feed;
    }

    public Timestamp getLastModified() {
        return lastModified;
    }

    public void setLastModified(Timestamp lastModified) {
        this.lastModified = lastModified;
    }
}
