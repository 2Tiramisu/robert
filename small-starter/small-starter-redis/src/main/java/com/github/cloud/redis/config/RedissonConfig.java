package com.github.cloud.redis.config;

import com.github.cloud.redis.lock.DistributedLocker;
import com.github.cloud.redis.lock.RedissLockUtil;
import com.github.cloud.redis.lock.RedissonDistributedLocker;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

@Configuration
public class RedissonConfig {

    @Bean(destroyMethod = "shutdown")
    public RedissonClient redisson() throws IOException {
        Config config = Config.fromYAML(new ClassPathResource("redisson-single.yml").getInputStream());
        return Redisson.create(config);
    }


    @Bean
    public DistributedLocker distributedLocker() throws IOException {
        RedissonDistributedLocker locker = new RedissonDistributedLocker();
        locker.setRedissonClient(redisson());
        RedissLockUtil.setLocker(locker);
        return locker;
    }
}
