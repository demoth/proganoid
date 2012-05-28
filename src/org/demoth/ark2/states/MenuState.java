package org.demoth.ark2.states;

import it.randomtower.engine.ResourceManager;
import it.randomtower.engine.World;
import org.demoth.ark2.ArkanoidGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

/**
 * Created by IntelliJ IDEA.
 * User: daniil
 * Date: 5/4/12
 * Time: 9:02 PM
 */
public class MenuState extends World {
    private boolean ready = false;
    private String message;

    public MenuState(int id, GameContainer container, String message) {
        super(id, container);
        this.message = message;
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        super.render(container, game, g);

        g.drawString(message, container.getWidth() / 2, container.getHeight() / 2);
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        //super.update(container, game, delta);    //To change body of overridden methods use File | Settings | File Templates.
        if (ready && id != ArkanoidGame.WIN_STATE && id != ArkanoidGame.FAIL_STATE) {
            game.enterState(ArkanoidGame.LEVEL_STATE, new FadeOutTransition(), new FadeInTransition());
        }

    }

    @Override
    public void keyPressed(int key, char c) {
        if (key == Input.KEY_SPACE) {
            ready = true;
        }
    }
}
