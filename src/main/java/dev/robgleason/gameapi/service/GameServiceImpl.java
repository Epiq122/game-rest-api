package dev.robgleason.gameapi.service;


import dev.robgleason.gameapi.dao.GameDAO;
import dev.robgleason.gameapi.entity.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameServiceImpl implements GameService {


    private GameDAO gameDAO;

    @Autowired
    public GameServiceImpl(GameDAO gameDAO) {
        this.gameDAO = gameDAO;
    }

    @Override
    public List<Game> findAll() {
        return gameDAO.findAll();
    }

    @Override
    public Game findById(int id) {
        return gameDAO.findById(id);
    }

    @Transactional
    @Override
    public Game save(Game game) {
        return gameDAO.save(game);
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        gameDAO.deleteById(id);
    }
}
