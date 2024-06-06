//NOME: João vitor de Mello Lima
import java.util.Random;
public class Jogos{
    private Matematica matematica = new Matematica(); // Instanciando o objeto Matematica.
    private Adivinha adivinha = new Adivinha();// Instanciando o objeto Adivinha.
    private Blackjack blackjack = new Blackjack();// Instanciando o objeto Blackjack.
    private Secret segredo = new Secret();// Instanciando o objeto Secret.
    private JogosStatus jogoStatus = new JogosStatus();// Instanciando o objeto JogosStatus.
    private String imfihlo;// Palavra em Zulu para "Segredo".
    /** 
         Método para "desbloquear" um jogo secreto, com base na quantidade de conquistas.
       */
    public String playSegredo(){
        if(jogoStatus.getConquistas() >= 5){
            imfihlo = "playSecret";
            return imfihlo;
        }else{
            imfihlo = "playBlackjack";
            return imfihlo;
        }
    }
    /** 
         Método que com base no retorno do método "playSegredo()", executa um jogo de Blackjack ou um jogo secreto.
       */
    public void imfihlo(){
        if (playSegredo().equals("playSecret")){
            segredo.playSecret();
        }else{
            blackjack.playBlackjack();
        }
    }
    /**
        Método que escolhe de 0 a 2 e dependendo do caso retorna um método que inicializa um jogo específico.
       */
    public void play(){ 
        Random random = new Random();// Instanciando o objeto Random.
        int escolha = random.nextInt(4);// Escolhendo o número aleatório de 0 a 2.
        switch(escolha) {
            case 0:
                matematica.playMat();
                break;
            case 1:
                adivinha.playAdivinha();
                break;
            case 2:
                blackjack.playBlackjack();
                break;
            case 3:
                imfihlo();
                break;
            default:
                matematica.playMat();// Em caso de erro o jogo padrão é o Matematica.
                break;
 
        }  
    }
}
