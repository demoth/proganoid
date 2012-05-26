package org.demoth.ark2;

import com.sun.org.apache.xerces.internal.jaxp.DocumentBuilderFactoryImpl;
import it.randomtower.engine.ResourceManager;
import org.demoth.ark2.entities.Brick;
import org.demoth.ark2.entities.Player;
import org.demoth.ark2.states.LevelState;
import org.demoth.ark2.states.MenuState;
import org.newdawn.slick.*;
import org.newdawn.slick.state.GameState;
import org.newdawn.slick.state.StateBasedGame;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: daniil
 * Date: 5/4/12
 * Time: 8:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class ArkanoidGame extends StateBasedGame {

    public static int START_STATE = 0;
    public static int WIN_STATE = 1;
    public static int FAIL_STATE = 2;
    public static int LEVEL_STATE = 3;

    /**
     * Create a new state based game
     *
     * @param name The name of the game
     */
    public ArkanoidGame(String name) {
        super(name);
    }

    @Override
    public void initStatesList(GameContainer container) throws SlickException {
        ResourceManager.loadImage("ball", "res/ball.png", null);
        ResourceManager.loadImage("brick", "res/file.png", null);
        ResourceManager.loadImage("bonus", "res/bonus.png", null);
        ResourceManager.loadImage("paddle", "res/paddle.png", null);

        this.addState(new MenuState(START_STATE, container, "Ready? press space to begin"));
        this.addState(loadLevel(container, "res/levels/level1.xml"));
        this.addState(new MenuState(WIN_STATE, container, "You won! good work"));
        this.addState(new MenuState(FAIL_STATE, container, "You have failed! Please die"));
    }

    private GameState loadLevel(GameContainer container, String path) {
        LevelState state = new LevelState(LEVEL_STATE, container);
        DocumentBuilderFactory factory = new DocumentBuilderFactoryImpl();
        Player player = new Player(0, 0, ResourceManager.getImage("paddle"));
        player.y = container.getHeight() - player.getCurrentImage().getHeight();
        player.addType("PADDLE");
        state.player = player;
        state.add(player);

        try {
            Document document = factory.newDocumentBuilder().parse(new File(path));
            Element levelElement = (Element) document.getElementsByTagName("level").item(0);
            //String message = levelElement.getAttribute("message");
            state.back = new Image(levelElement.getAttribute("back"));
            NodeList nodeList = document.getElementsByTagName("brick");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Element brickElement = (Element) nodeList.item(i);
                int x = Integer.parseInt(brickElement.getAttribute("x"));
                int y = Integer.parseInt(brickElement.getAttribute("y"));
                Brick brick = new Brick(x, y);
                brick.addType("BRICK");
                brick.setGraphic(ResourceManager.getImage("brick"));
                brick.setHitBox(0, 0, brick.getCurrentImage().getWidth(), brick.getCurrentImage().getHeight(), true);
                state.add(brick);
            }
        } catch (SAXException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (ParserConfigurationException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (SlickException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return state;
    }

    public static void main(String[] args) {
        try {
            AppGameContainer container = new AppGameContainer(new ArkanoidGame(
                    "Some ark2"));
            container.setDisplayMode(800, 600, false);
            container.setTargetFrameRate(60);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
