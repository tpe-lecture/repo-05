package tpe.oo.vererbung;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

import de.smits_net.games.framework.board.Board;
import de.smits_net.games.framework.image.ImageBase;
import de.smits_net.games.framework.sprite.Sprite;


/**
 * Spielfeld.
 */
public class GameBoard extends Board{
// TODO: Von Board ableiten

    /** Alien, das durch das Bild läuft. */
    private AlienSprite alien;

    /** Asteroid. */
    private Sprite asteroid;

    /** Hintergrundbild. */
    private Image background;

    /**
     * Erzeugt ein neues Board.
     */
    public GameBoard() {
// TODO: Einkommentieren
        // neues Spielfeld anlegen
        super(10, new Dimension(800, 600), Color.BLACK);

        // Hintergrundbild laden
        background = ImageBase.loadImage("assets/background");


        //Alien und Asteroid wird gezeichnet
        alien = new AlienSprite(this, new Point(700,300));
        asteroid = new Asteroid(this, new Point(50,430));
    }

    /**
     * Hintergrund zeichnen.
     */
    protected void drawBackground(Graphics g) {
        g.drawImage(background, 0, 0, null);
    }

    /**
     * Spielfeld neu zeichnen. Wird vom Framework aufgerufen.
     *
     * @param g Der Grafik-Kontext
     */
    public void drawGame(Graphics g) {
      
        
        asteroid.draw(g);
        alien.draw(g);
    }

    /**
     * Spielsituation updaten. Wird vom Framework aufgerufen.
     *
     * @return Spiel läuft weiter, solange diese methode <code>true</code>
     *      zurück gibt
     */
    public boolean updateGame() {

        // Die Objekte bewegen
        alien.move();
     
        asteroid.move();

        // Kollision erkennen
        if (alien.intersects(asteroid) && alien.isActive()) {
            alien.explode();
        }

        return true;
    }
}
