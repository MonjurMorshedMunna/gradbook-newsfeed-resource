package com.gradbook.gradbooknewsfeedresource.repositories;

import com.gradbook.gradbooknewsfeedresource.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
