package org.demoth.ark2.entities;

import it.randomtower.engine.entity.Entity;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 * Created by IntelliJ IDEA.
 * User: daniil
 * Date: 5/10/12
 * Time: 1:02 AM
 * To change this template use File | Settings | File Templates.
 */
public abstract class Bonus extends Entity {

    public float vy = 0.1f;

    public abstract void affect(Player player);

    protected Bonus(float x, float y, Image image) {
        super(x, y, image);
        centered = true;
    }

    @Override
    public void update(GameContainer container, int delta) throws SlickException {
        super.update(container, delta);
        y += vy * delta;
    }
}
