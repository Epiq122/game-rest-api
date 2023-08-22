package dev.robgleason.gameapi.service;


import dev.robgleason.gameapi.entity.Game;
import dev.robgleason.gameapi.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameServiceImpl implements GameService {

    // set up constructor injection
    private GameRepository gameRepo;

    @Autowired
    public GameServiceImpl(GameRepository gameRepo) {
        this.gameRepo = gameRepo;
    }

    @Override
    public List<Game> findAll() {
        return gameRepo.findAll();
    }

    @Override
    public Game findById(int id) {
        Optional<Game> result = gameRepo.findById(id);
        Game game = null;
        if (result.isPresent()) {
            game = result.get();
        } else {
            throw new RuntimeException("Did not find game id - " + id);
        }
        return game;
    }


    @Override
    public Game save(Game game) {
        return gameRepo.save(game);
    }


    @Override
    public void deleteById(int id) {
        gameRepo.deleteById(id);
    }
}
