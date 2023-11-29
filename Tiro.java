import greenfoot.*;

public class Tiro extends Actor {
    private int speed; 
    private Actor alvo;
    private GreenfootSound somZumbi;
    private GreenfootSound somTiro;

    public Tiro(int speed, Actor alvo) {
        this.speed = speed;
        this.alvo = alvo;

        GreenfootImage imagemTiro = new GreenfootImage("tiro.png");
        
        int novaLargura = imagemTiro.getWidth() / 20; 
        int novaAltura = imagemTiro.getHeight() / 20; 
        imagemTiro.scale(novaLargura, novaAltura);
        
        setImage(imagemTiro);
        
        somZumbi = new GreenfootSound("zombieDeath3.wav");
        somZumbi.setVolume(80);
    }

    public void act() {
         if (alvo != null) {
            // Calcule a direção em relação ao alvo
            int deltaX = alvo.getX() - getX();
            int deltaY = alvo.getY() - getY();
            double angle = Math.atan2(deltaY, deltaX);
            
            // Defina a rotação do tiro para apontar na direção do alvo
            setRotation((int) Math.toDegrees(angle));
            
            // Movimente o tiro na direção do alvo com a velocidade definida
            int x = getX() + (int)(Math.cos(angle) * speed);
            int y = getY() + (int)(Math.sin(angle) * speed);
            setLocation(x, y);
            
            if (isTouching(Inimigo.class)) {
                // Se houver colisão, remove o inimigo do mundo
                removeInimigo();
                somZumbi.play();// barulho de zumbi ao morrer
                removeTiro();
            }
        }
    }
    
    public void atirarPara(Actor alvo) {
        this.alvo = alvo;
    }
    
     private void removeInimigo() {
        World world = getWorld();
        if (world != null && alvo != null) {
            world.removeObject(alvo);
        }
    }
    
    private void removeTiro(){
        World world = getWorld();
        if (world != null && alvo != null) {
            world.removeObject(this);
        }
    }
}
