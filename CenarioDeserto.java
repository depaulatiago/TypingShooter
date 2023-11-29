import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CenarioDeserto here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CenarioDeserto extends Cenario
{
    private int pontos;
    public CenarioDeserto(Historico historico)
    {
        super(historico);
        setBackground("deserto.png");
        addPontos(250);
    }
}
