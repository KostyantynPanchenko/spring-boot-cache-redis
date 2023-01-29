package com.example.springbootcacheredis.controller;

import com.example.springbootcacheredis.model.Player;
import com.example.springbootcacheredis.service.PlayerService;
import java.util.Collection;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/players")
@RequiredArgsConstructor
@Slf4j
class PlayerController {

  private final PlayerService service;

  @GetMapping
  Collection<Player> all() {
    return service.getAll();
  }

  @GetMapping("/{id}")
  Player getOne(@PathVariable(name = "id") final Long id) {
    log.info("Got a request...");
    final var player = service.getById(id);
    log.info("Returning player {}", player);
    return player;
  }

  @PostMapping
  ResponseEntity<Player> saveOne(@RequestBody final Player player) {
    return new ResponseEntity<>(service.addOne(player), HttpStatusCode.valueOf(201));
  }

  @DeleteMapping("/{id}")
  ResponseEntity<Player> deleteOne(@PathVariable(name = "id") final Long id) {
    service.removeOne(id);
    return new ResponseEntity<>(HttpStatusCode.valueOf(204));
  }
}
