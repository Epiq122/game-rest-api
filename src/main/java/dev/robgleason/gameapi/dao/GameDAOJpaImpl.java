package dev.robgleason.gameapi.dao;

import dev.robgleason.gameapi.entity.Game;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class GameDAOJpaImpl implements GameDAO {

    // define field for entity manager
    private EntityManager entityManager;

    @Autowired
    public GameDAOJpaImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    // set up constructor injection


    @Override
    public List<Game> findAll() {
        // create a query
        TypedQuery<Game> theQuery = entityManager.createQuery("FROM Game", Game.class);

        // execute query and get result list
        List<Game> games = theQuery.getResultList();

        return games;

    }

    @Override
    public Game findById(int id) {

        Game game = entityManager.find(Game.class, id);


        return game;
    }

    @Override
    public Game save(Game game) {

        Game dbGame = entityManager.merge(game);

        return dbGame;
    }

    @Override
    public void deleteById(int id) {

        Game game = entityManager.find(Game.class, id);

        entityManager.remove(game);

    }
}
