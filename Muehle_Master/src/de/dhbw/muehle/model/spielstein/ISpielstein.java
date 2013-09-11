/**
 * 
 */
package de.dhbw.muehle.model.spielstein;


/**
 * Ein Spielstein.
 * 
 * @author DHBW
 *
 */
public interface ISpielstein
{
    /**
     * Liefert die Farbe des Steines.
     * 
     * @return Farbe
     * 
     * @see ESpielsteinFarbe
     */
    public ESpielsteinFarbe getFarbe();
    
    /**
     * Liefert die aktuelle Position auf dem Spielfeld
     * 
     * @return Position
     * 
     * @see Position
     */
    public Position getPosition();
}
