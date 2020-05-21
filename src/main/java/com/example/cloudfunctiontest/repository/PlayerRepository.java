package com.example.cloudfunctiontest.repository;


import com.example.cloudfunctiontest.domain.Player;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface PlayerRepository extends ReactiveMongoRepository<Player, String> {

}
