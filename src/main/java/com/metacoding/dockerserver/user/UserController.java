package com.metacoding.dockerserver.user;

import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import java.util.List;
import org.springframework.http.*;
import com.metacoding.dockerserver.core.util.Resp;
import org.springframework.data.redis.core.StringRedisTemplate;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserRepository userRepository;
    private final StringRedisTemplate redisTemplate;


    @GetMapping("/api/users")
    public ResponseEntity<?> findAll() {

        List<User> users = userRepository.findAll();

        Long count = redisTemplate.opsForValue()
                .increment("cnt:/api/users:total");
    
        return Resp.ok(Map.of("users", users,"count", count));
    }
    
}
