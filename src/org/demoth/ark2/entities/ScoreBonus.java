package org.demoth.ark2.entities;

import it.randomtower.engine.ME;
import it.randomtower.engine.ResourceManager;
import it.randomtower.engine.entity.Entity;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 * Created by IntelliJ IDEA.
 * User: user
 * Date: 11.05.12
 * Time: 15:08
 * To change this template use File | Settings | File Templates.
 */
public class ScoreBonus extends Bonus{

    public ScoreBonus(float x, float y, Image image) {
        super(x, y, image);
        this.setHitBox(-image.getWidth()/2, -image.getHeight()/ 2, image.getWidth(), image.getHeight());
        this.addType("BONUS");
    }

    @Override
    public void affect(Player player) {
        player.score += 50;
    }

    @Override
    public void update(GameContainer container, int delta) throws SlickException {
        super.update(container, delta);
        Entity player = collide("PADDLE", x, y);
        if (player != null) {
            ME.remove(this);
            ResourceManager.getSound("bonusPickup").play();
            affect((Player) player);
        }
        if (y > container.getHeight()) {
            ME.remove(this);
        }    
    }
}
