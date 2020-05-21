package com.example.cloudfunctiontest.messaging;

import com.example.cloudfunctiontest.domain.Player;
import com.example.cloudfunctiontest.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.function.context.PollableBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.UUID;
import java.util.function.Function;
import java.util.function.Supplier;

@Service
public class ExampleCloudFunction {

    @Autowired
    private PlayerRepository playerRepository;

    @Bean
    public Function<Flux<Player>, Flux<Player>> playerUpdate() {
        return flux -> flux.flatMap(player -> playerRepository.save(player)).log("Saved player");
    }

    @PollableBean
    public Supplier<Flux<Player>> playerFeeder() {
       return () -> Flux.just(new Player(UUID.randomUUID().toString(), "Ronaldo"));
    }
}
