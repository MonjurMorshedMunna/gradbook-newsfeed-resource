package com.gradbook.gradbooknewsfeedresource.repositories;

import com.gradbook.gradbooknewsfeedresource.models.User;
import com.gradbook.gradbooknewsfeedresource.models.UserRole;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@CacheConfig(cacheNames = "userRoleRepository")
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

    @Cacheable("findByUser")
    UserRole findByUser(User user);
}
