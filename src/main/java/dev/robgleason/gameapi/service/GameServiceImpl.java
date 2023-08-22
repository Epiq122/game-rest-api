package dev.robgleason.gameapi.service;


import dev.robgleason.gameapi.dao.GameDAO;
import dev.robgleason.gameapi.entity.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameServiceImpl implements GameService {

    // set up constructor injection
    private GameDAO gameDAO;

    @Autowired
    public GameServiceImpl(GameDAO gameDAO) {
        this.gameDAO = gameDAO;
    }

    @Override
    public List<Game> findAll() {
        return gameDAO.findAll();
    }
}
