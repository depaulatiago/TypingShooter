import greenfoot.*;
import java.util.ArrayList;

public class Inimigo extends Actor {
    private String palavra;
    private boolean estaDerrotado;
    private boolean aguardandoRemocao;
    private GreenfootImage imagemTexto;
    private GreenfootImage imagemCombinada;
    private int contadorInimigos;
    private int contadorRemocao;
    private Actor alvo;
    private GreenfootSound somTiro;
    private boolean jogoAcabou;
    private ArrayList<String> palavras;
    private boolean inimigoChegou;
    
    public Inimigo() {
        estaDerrotado = false;
        aguardandoRemocao = false;
        inimigoChegou = false;
        jogoAcabou = false;
        
        somTiro = new GreenfootSound("rifle.wav");
        somTiro.setVolume(70);

        setImage(imagemCombinada);
        
    }
    
        public void verificarColisao() {
            if (!((Cenario) getWorld()).jogoAcabou()) {
            Cenario mundo = (Cenario) getWorld();
            Jogador jogador = mundo.getJogador();
    
            if (!estaDerrotado && Greenfoot.isKeyDown("enter") && jogador != null) {
                String palavraDigitada = jogador.getPalavraDigitada();
                if (palavraDigitada.equalsIgnoreCase(palavra)) {
                    estaDerrotado = true;
                    jogador.limparPalavraDigitada();
                    aguardandoRemocao = true;
    
                    Tiro tiro = new Tiro(12, alvo);
                    mundo.addObject(tiro, jogador.getX(), jogador.getY());
    
                    tiro.atirarPara(this);
                    somTiro.play();
                    
                    mundo.aumentarPontos(10);
                    jogador.turnTowards(getX(), getY());
                }
            }
        }
    }
    
    public void act() {
        if (!((Cenario) getWorld()).jogoAcabou()) {
            setLocation(getX(), getY() + 1);
            
            if (getY() == 705) {
                // Chama o método na classe Cenário para encerrar o jogo
                ((Cenario) getWorld()).encerrarJogo();
            }
    
            verificarColisao(); // Mova essa linha para dentro da verificação
        }
    }

    
    public boolean estaderrotado(){
        return estaDerrotado;
    }

    // faça um metodo de acesso para cada atributo prorivado
    public String getPalavra() {
        return palavra;
    }

    public boolean estaDerrotado() {
        return estaDerrotado;
    }

    public boolean aguardandoRemocao() {
        return aguardandoRemocao;
    }

    public GreenfootImage getImagemTexto() {
        return imagemTexto;
    }

    public GreenfootImage getImagemCombinada() {
        return imagemCombinada;
    }

    public int getContadorInimigos() {
        return contadorInimigos;
    }   

    public int getContadorRemocao() {
        return contadorRemocao;
    }

    public Actor getAlvo() {
        return alvo;
    }

    public GreenfootSound getSomTiro() {
        return somTiro;
    }

    public boolean isJogoAcabou() {
        return jogoAcabou;
    }
    
    public ArrayList<String> getArrayPalavras(){
        return palavras;
    }

    //crie um metodo modificador para cada atributo privado

    public void setPalavra(String palavra) {
        this.palavra = palavra;
    }

    public void setEstaDerrotado(boolean estaDerrotado) {
        this.estaDerrotado = estaDerrotado;
    }

    public void setAguardandoRemocao(boolean aguardandoRemocao) {
        this.aguardandoRemocao = aguardandoRemocao;
    }

    public void setImagemTexto(GreenfootImage imagemTexto) {
        this.imagemTexto = imagemTexto;
    }

    public void setImagemCombinada(GreenfootImage imagemCombinada) {
        this.imagemCombinada = imagemCombinada;
    }

    public void setContadorInimigos(int contadorInimigos) {
        this.contadorInimigos = contadorInimigos;
    }

    public void setContadorRemocao(int contadorRemocao) {
        this.contadorRemocao = contadorRemocao;
    }

    public void setAlvo(Actor alvo) {
        this.alvo = alvo;
    }

    public void setSomTiro(GreenfootSound somTiro) {
        this.somTiro = somTiro;
    }

    public void setJogoAcabou(boolean jogoAcabou) {
        this.jogoAcabou = jogoAcabou;
    }

    public void setPalavras(ArrayList<String> palavras) {
        this.palavras = palavras;
    }

    
}

