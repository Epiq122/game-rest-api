package dev.robgleason.gameapi.rest;


import dev.robgleason.gameapi.dao.GameDAO;
import dev.robgleason.gameapi.entity.Game;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class GameRestController {

    private GameDAO gameDAO;
    // quick : inject game dao

    public GameRestController(GameDAO gameDAO) {
        this.gameDAO = gameDAO;
    }


    // expose "/games" and return a list of games

    @GetMapping("/games")
    public List<Game> findAll() {
        return gameDAO.findAll();
    }
}
