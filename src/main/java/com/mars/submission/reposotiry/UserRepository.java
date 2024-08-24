package com.mars.submission.reposotiry;

import com.mars.submission.reposotiry.model.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.Optional;

public interface UserRepository extends ElasticsearchRepository<User, Long> {
    Optional<User> findByUsername(String username);
}