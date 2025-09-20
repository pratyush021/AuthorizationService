package com.spring.authorization.service;

import com.spring.authorization.entity.User;
import com.spring.authorization.entity.UserPrincipal;
import com.spring.authorization.repository.MyUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private MyUserRepository userRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Query query = new Query(Criteria.where("username").is(username));
//        User user = mongoTemplate.findOne(query, User.class);

//        List<User> userlist = mongoTemplate.findAll(User.class);
        User user = null;
        try {
            List<User> all = userRepository.findAll();
            user = userRepository.findByUsername(username);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        if(user == null) {
            throw new UsernameNotFoundException("User not found.");
        }

        return new UserPrincipal(user);
    }

}
