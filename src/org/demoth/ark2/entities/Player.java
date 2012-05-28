package org.demoth.ark2.entities;

import it.randomtower.engine.entity.Entity;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

/**
 * Created by IntelliJ IDEA.
 * User: daniil
 * Date: 5/4/12
 * Time: 9:39 PM
 */
public class Player extends Entity {

    public int lives = 1;
    public int score;

    public Player(float x, float y, Image image) {
        super(x, y, image);
        this.centered = true;
        //this.setHitBox(image.getWidth() / 2, image.getHeight() / 2, image.getWidth() / 2, image.getHeight() / 2);
        this.setHitBox(-image.getWidth()/2, -image.getHeight()/ 2, image.getWidth(), image.getHeight());
    }

    @Override
    public void update(GameContainer container, int delta) throws SlickException {
        super.update(container, delta);    //To change body of overridden methods use File | Settings | File Templates.
        Input input = container.getInput();
        x = input.getMouseX();
    }
}
