/**
 * 
 */
package de.dhbw.muehle.gui;

import java.util.List;

import de.dhbw.muehle.ISpielstein;
import de.dhbw.muehle.Position;




/**
 * Hier können die Schnittstellenmethoden definiert werden, über die später mit dem Core kommuniziert wird.
 * Dieses Interface wird von der Klasse ViewController implementiert.
 * Bei Bedarf können neue hinzugefügt werden.
 * 
 * @author Ammon93
 *
 */
public interface IViewController {    
    /**
     * Liefert die aktuelle Position des Spielsteins auf dem Spielfeld.
     * 
     * @param spielStein
     * @return Position
     * 
     * @see Position
     */
    public Position getPosition(ISpielstein spielStein);
    
    /**
     * Legt die Position des Spielsteins auf dem Spielfeld fest.
     * 
     * @param spielStein
     * @param position
     * @return List
     * 
     * @see Position
     */
    public List<ISpielstein> setPosition(ISpielstein spielStein, Position position);
    
    /**
     * Liefert eine Liste mit allen Spielsteinen, die sich aktuell auf dem Spielbrett befinden.
     * 
     * @return List
     * 
     * @see ISpielstein
     */
    public List<ISpielstein> getSpielSteine();
    
    /**
     * Löscht den Spielstein vom Spielbrett.
     * 
     * @param spielStein
     * @return List
     * 
     * @see ISpielstein
     */
    public List<ISpielstein> removeSpielStein(ISpielstein spielStein);
}