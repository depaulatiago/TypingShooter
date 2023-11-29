import greenfoot.*;
import java.util.List;
import java.util.Random;
import java.util.ArrayList;
import java.lang.String;
import java.lang.Object;

public class Cenario extends World {
    private Jogador jogador;
    private int tempoDesdeUltimoSpawn;
    private int pontos;
    private int taxaDeSpawn;
    private GreenfootSound musicaGame;
    private boolean jogoAcabou;
    private Cenario CenarioDeserto;
    private boolean trocouFase;
    private String nomePlayer;
    private Historico historico;
    
    public Cenario(Historico historico) {
        super(460, 730, 1);
        
        this.historico = historico;
        
        trocouFase = false;
        
        musicaGame = new GreenfootSound("musicadefundo.mp3");
        musicaGame.setVolume(25);
        
        
        preparar();
        
        gerarInimigoVerde();
        gerarInimigoVermelho();
        
        atualizarExibicaoDePontos();
        taxaDeSpawn = 200;
    }

    public void act() {
        if (!jogoAcabou) {
        novoCenario();
        
        tempoDesdeUltimoSpawn++;
        musicaGame.playLoop();
        
        if (tempoDesdeUltimoSpawn >= taxaDeSpawn) {
            gerarInimigoVerde();
            gerarInimigoVermelho();
            
            tempoDesdeUltimoSpawn = 0;
            
            if (pontos >= 100) {
                taxaDeSpawn = 150; // Reduza a taxa para aumentar a frequencia de spawn
            } else if (pontos >= 150) {
                taxaDeSpawn = 125; // Reduza ainda mais a taxa
            } else if (pontos >= 200) {
                taxaDeSpawn = 100; // Reduza ainda mais a taxa
            } else if (pontos >= 250) {
                taxaDeSpawn = 90; // Reduza ainda mais a taxa
            } else if (pontos >= 250) {
                taxaDeSpawn = 80; // Reduza ainda mais a taxa
            }
        }
    }
    verificarReiniciar();
}


    //Metodo para obter o jogador
    public Jogador getJogador() {
        return jogador;
    }

    private void preparar() {
        jogador = new Jogador();
        addObject(jogador, getWidth() / 2, getHeight() - 100);
    }

    //Metodo para gerar inmigos
    private void gerarInimigoVerde() {
        int x = Greenfoot.getRandomNumber(getWidth() - 50);
        int y = Greenfoot.getRandomNumber(getHeight() / 6);

        //faz com que se o inimigo fosse dar spawn na extremidade direita,
        //ele seja puxado para a esquerda
        if (x >= 450) { 
            x -= 60;
        }
        //faz com que se o inimigo fosse dar spawn na extremidade direita,
        //ele seja puxado para a direita
        if (x <= 50) {
            x += 60;
        }

        addObject(new InimigoVerde(), x, y);
    }
    
    private void gerarInimigoVermelho() {
        int x = Greenfoot.getRandomNumber(getWidth() - 50);
        int y = Greenfoot.getRandomNumber(getHeight() / 6);

        //faz com que se o inimigo fosse dar spawn na extremidade direita,
        //ele seja puxado para a esquerda
        if (x >= 450) { 
            x -= 60;
        }
        //faz com que se o inimigo fosse dar spawn na extremidade direita,
        //ele seja puxado para a direita
        if (x <= 50) {
            x += 60;
        }

        addObject(new InimigoVermelho(), x, y);
    }
        
    //aumenta os pontos
    public void aumentarPontos(int quantidade) {
        pontos += quantidade;
        atualizarExibicaoDePontos();
    }

    //exibe os pontos
    private void atualizarExibicaoDePontos() {
        GreenfootImage imagemTexto = new GreenfootImage("Pontos: " + pontos, 24, Color.WHITE, Color.YELLOW, Color.YELLOW);
        showText("Pontos: " + pontos, 70, 30);
    }
  
    public void encerrarJogo() {
        historico.setInfo(getNomePlayer(), pontos);
        showText("GAME OVER", getWidth() / 2, getHeight() / 2 - 10);
        showText("PRESS ENTER FOR RESTART", getWidth() / 2 , getHeight() / 2 + 10);
        jogoAcabou = true;
    }
        
        private void verificarReiniciar() {
        if (jogoAcabou && Greenfoot.isKeyDown("ENTER")) {
            Greenfoot.setWorld(new CenarioEstrada(historico));
            Greenfoot.start();
        }
    }
    
    public int getPontos(){
        return pontos;
    }
    
    public boolean jogoAcabou(){
        return jogoAcabou;
    }
    
    public void novoCenario(){
        if (getPontos()>=250){
            trocouFase = true;
            Greenfoot.setWorld(new CenarioDeserto(historico));
        }
    }
    
    public boolean getTrocouFase(){
        return trocouFase;
    }
    
    public void addPontos(int pontos){
        pontos += this.pontos;    
    }
    
    public void setNomePlayer(String nomePlayer){
        this.nomePlayer = nomePlayer;
    }
    
    public String getNomePlayer(){
        return nomePlayer;
    }
}
