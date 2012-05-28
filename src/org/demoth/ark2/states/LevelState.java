package org.demoth.ark2.states;

import it.randomtower.engine.ME;
import it.randomtower.engine.ResourceManager;
import it.randomtower.engine.World;
import org.demoth.ark2.ArkanoidGame;
import org.demoth.ark2.entities.Ball;
import org.demoth.ark2.entities.Brick;
import org.demoth.ark2.entities.Player;
import org.newdawn.slick.*;
import org.newdawn.slick.state.GameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: daniil
 * Date: 5/4/12
 * Time: 9:03 PM
 */
public class LevelState extends World {
    Ball ball;
    public Player player;
    public Image back;


    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        super.init(container, game);    //To change body of overridden methods use File | Settings | File Templates.

    }

    public LevelState(int id, GameContainer container) {
        super(id, container);
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        g.drawImage(back, 0, 0);
        super.render(container, game, g);
        g.drawString("Score: " + player.score,0,0);
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        super.update(container, game, delta);    //To change body of overridden methods use File | Settings | File Templates.
        if (ME.world.getNrOfEntities("BRICK") == 0 && ME.world.getNrOfEntities("BONUS") == 0) {
            ResourceManager.getSound("win").play();
            game.enterState(ArkanoidGame.WIN_STATE, new FadeOutTransition(), new FadeInTransition());
        }
        if (ME.world.getNrOfEntities("BALL") == 0) {
            game.enterState(ArkanoidGame.FAIL_STATE, new FadeOutTransition(), new FadeInTransition());
        }
    }
}
