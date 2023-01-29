package com.example.springbootcacheredis.service;

import com.example.springbootcacheredis.model.Player;
import com.github.javafaker.Faker;
import jakarta.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.LongStream;
import lombok.SneakyThrows;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

  private final Map<Long, Player> players = new HashMap<>();
  private final Faker faker = new Faker();

  @PostConstruct
  public void init() {
    LongStream.range(1, 101)
        .mapToObj(idx -> new Player(idx, faker.name().firstName(), faker.name().lastName()))
        .forEach(player -> players.put(
            player.getId(), player));
  }

  @Cacheable(cacheNames = "players-cache")
  @SneakyThrows
  public Player getById(final Long id) {
    final var player = players.get(id);
    Thread.sleep(1500L);
    return player;
  }

  public Collection<Player> getAll() {
    return players.values();
  }

  @CachePut(cacheNames = "players-cache", key = "#player.id")
  public Player addOne(final Player player) {
    return players.put(player.getId(), player);
  }

  @CacheEvict(cacheNames = "players-cache", key = "#id")
  public boolean removeOne(final Long id) {
    return players.remove(id, players.get(id));
  }
}
