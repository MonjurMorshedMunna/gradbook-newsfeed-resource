/*
package com.gradbook.gradbooknewsfeedresource.configs;

import com.gradbook.gradbooknewsfeedresource.models.ActivityLogger;
import com.gradbook.gradbooknewsfeedresource.models.User;
import com.gradbook.gradbooknewsfeedresource.models.UserRole;
import com.gradbook.gradbooknewsfeedresource.repositories.UserRepository;
import com.gradbook.gradbooknewsfeedresource.repositories.UserRoleRepository;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Aspect
@Component
public class NewsFeedAspect {

    @Autowired
    private KafkaTemplate<String, String> template;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;


    @After("execution( *  com.gradbook.gradbooknewsfeedresource.resources.NewsFeedResource.*(..))")
    public void tracing(JoinPoint joinPoint) throws Exception {
        ActivityLogger activityLogger = new ActivityLogger();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findOne(Long.parseLong( authentication.getPrincipal().toString()));
        activityLogger.setUserId(user.getId().toString());
        activityLogger.setClassName(joinPoint.getTarget().getClass().getName());
        activityLogger.setMethodName(joinPoint.getSignature().getName());
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        activityLogger.setAccessTime(timestamp);

        UserRole userRole = userRoleRepository.findByUser(user);
        activityLogger.setRoleId(userRole.getRoleId());

        ObjectMapper mapper = new ObjectMapper();
        String jsonToString = mapper.writeValueAsString(activityLogger);
        System.out.println("In the news feed ---> ");
        this.template.send("ums_logger", jsonToString);

    }
}
*/
