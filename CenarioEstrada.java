import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CenarioEstrada here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CenarioEstrada extends Cenario
{
    private String nomePlayer;
    /**
     * Constructor for objects of class CenarioEstrada.
     * 
     */
    public CenarioEstrada(Historico historico)
    {
        super(historico);
        setBackground("cenario.png");
        nomePlayer = Greenfoot.ask("Insira seu nome");
        setNomePlayer(nomePlayer);
    }
    

}
