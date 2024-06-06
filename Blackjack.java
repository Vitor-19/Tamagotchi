//NOME: João vitor de Mello Lima
import java.util.Random;
public class Blackjack{
    int cartasJogador;
    int cartasPC;
    private JogosStatus jogoStatus = new JogosStatus();// Instanciando o objeto JogosStatus.
    /** 
        Método que "printa" os atuais atributos da classe JogosStatus, como score, life e etc...
       */
    public void showStatus(){
       System.out.println("Score: "+jogoStatus.getScore()+" | Vidas: "+jogoStatus.getLife()+" | Vitórias atuais: "+jogoStatus.getNovasConquistas()+" | Conquistas:"+jogoStatus.getConquistas());
    }
    /** 
        Método para aumentar as novasConquistas, recebe de parâmetro um valor inteiro e através do método getter e setter atualiza o valor do atributo.
       */
    public void aumentaNovasConquistas(int valor){
        int newNovasConquistas = jogoStatus.getNovasConquistas() + valor;
        jogoStatus.setNovasConquistas(newNovasConquistas);
    }
    /** 
        Método para aumentar as conquistas, recebe de parâmetro um valor inteiro e através do método getter e setter atualiza o valor do atributo.
       */
    public void aumentaConquistas(int valor){
        int newConquistas = jogoStatus.getConquistas() + valor;
        jogoStatus.setConquistas(newConquistas);
    }
    /** 
        Método para diminuir o life, recebe de parâmetro um valor inteiro e através do método getter e setter atualiza o valor do atributo.
       */
    public void diminuirLife(int valor){
        int newLife = jogoStatus.getLife() - valor;
        jogoStatus.setLife(newLife);
    }
    /** 
        Método para aumentar o score, recebe de parâmetro um valor inteiro e através do método getter e setter atualiza o valor do atributo.
       */
    public void aumentarScore(int valor){
        int newScore = jogoStatus.getScore() + valor;
        jogoStatus.setScore(newScore);
    }
    /** 
        Método com a lógica para escolher uma carta aleátoria.
       */
    public int aleatorizarCarta(){
       Random random = new Random();// Instanciando o objeto Random.
       int [] baralho = {2,3,4,5,6,7,8,9,10,10,10,10,1};
       int carta = random.nextInt(baralho.length); 
       return carta;
    }
    /** 
        Método que "distribui" duas cartas para o jogador e para o computador.
       */
    public void distribuirCartas(){
        for(int i = 0; i < 2; i++){
            cartasJogador += aleatorizarCarta();
            cartasPC += aleatorizarCarta();
        }
    }
    /** 
        Método que "printa" as "mãos" do jogador e do computador.
       */
    public void showStatusBlackjack(){
        System.out.println("Cartas do Jogador: " + cartasJogador);
        System.out.println("Cartas do Computador: " + cartasPC);
        System.out.println("///////////////////////////////////");
    }
    /** 
        Método para zerar as mãos do jogador e do computador.
       */
    public void zerarCartas(){
        cartasJogador = 0;
        cartasPC = 0;
    }
    /**
        Método com a lógica de jogo do Blackjack.
       */
    public void playBlackjack(){
        do{
            showStatus();// Exibe os atributos.
            distribuirCartas();// Distribui as cartas.
            showStatusBlackjack();// Mostra as "mãos".
            // Lógica para permitir a compra do jogador.
            while (cartasJogador < 21){
                String resposta = Teclado.leString("Mais uma carta?...[Sim] ou [Não]");
                // Aceita "sim/s maiúscula ou minúscula e 1" ou "não/nao/n maiúscula ou minúscula e 2".
                if (resposta.toLowerCase().equals("sim") || resposta.toLowerCase().equals("s") || resposta.equals("1")){
                   cartasJogador += aleatorizarCarta(); // "Compra uma carta".
                   System.out.println("Cartas do Jogador: "+cartasJogador);// Mostra a "mão".
                   System.out.println("///////////////////////////////////");
                }else if (resposta.toLowerCase().equals("não") || resposta.toLowerCase().equals("nao") || resposta.toLowerCase().equals("n") || resposta.equals("2")){
                    break;
                }else {
                    System.out.println("Comando inválido!!");
                }
            }
            // Lógica de compra do computador, ele compra enquanto tiver menos que 17 e enquanto o jogador tiver menos ou igual a 21.
            while (cartasPC < 17 && cartasJogador <= 21){
                cartasPC += aleatorizarCarta();// Compra uma carta.
                System.out.println("Cartas do Computador: "+cartasPC);// Mostra a "mão".
                System.out.println("///////////////////////////////////");
            }
            showStatusBlackjack();// Mostra as "mãos" do jogador e do computador uma última vez antes de saber o ganhador.
            // Lógica para verificar o ganhador.
            if ((cartasJogador <= 21 && cartasJogador > cartasPC) || cartasPC > 21){
                aumentarScore(1);// Aumenta o score em 1.
                zerarCartas();// Zera as "mãos".
                System.out.println("Você ganhou!!");
                // Caso o jogador tenha igual ou menos que 21 e mais que o computador ou caso o computador tenha mais de 21, o jogador ganha.
            }else if ((cartasJogador == cartasPC) || (cartasJogador > 21 && cartasPC > 21)){
                zerarCartas();
                System.out.println("Empate!!");
                // Caso os dois tenham a mesma quantidade de carta ou tenham excedido 21 o resultado é um empate.
            }else {
                diminuirLife(1);// Diminui o life em 1.
                zerarCartas();// Zera as "mãos".
                System.out.println("Você perdeu!!");
                // Caso não tenha dado empate ou vitória ao jogador, ele perde.
                
                // Lógica para continuar caso a vida chegue em 0.
                if(jogoStatus.getLife() <= 0){
                    System.out.println("Você ficou sem vidas...");
                    String desistir = Teclado.leString("Quer continuar?...[Sim] ou [Não]");
                    jogoStatus.setScore(0);
                    jogoStatus.setLife(3);
                    jogoStatus.setNovasConquistas(0);
                    if(desistir.toLowerCase().equals("sim") || desistir.toLowerCase().equals("s") || desistir.equals("1")){ 
                        System.out.println("Próxima rodada!!");
                    }else if(desistir.toLowerCase().equals("não") || desistir.toLowerCase().equals("nao") || desistir.toLowerCase().equals("n") || desistir.equals("2")){
                        break;
                    }else{
                          System.out.println("Comando inválido");
                          break;
                    }
                }
            }
            // Lógica para continuar caso tenha chegado a 3 scores.
            if (jogoStatus.getScore() == 3){
                aumentaConquistas(1);
                aumentaNovasConquistas(1);
                System.out.println("Você ganhou o jogo!!");
                String desistir = Teclado.leString("Quer jogar novamente?...[Sim] ou [Não]");
                if(desistir.toLowerCase().equals("sim") || desistir.toLowerCase().equals("s") || desistir.equals("1")){
                    jogoStatus.setScore(0);
                    jogoStatus.setLife(3);
                    jogoStatus.setNovasConquistas(0);
                    zerarCartas();
                    System.out.println("Próxima rodada!!");
                }else if(desistir.toLowerCase().equals("não") || desistir.toLowerCase().equals("nao") || desistir.toLowerCase().equals("n") || desistir.equals("2")){
                    jogoStatus.setScore(0);
                    jogoStatus.setLife(3);
                    jogoStatus.setNovasConquistas(0);
                    zerarCartas();
                    break;
                }else{
                    zerarCartas();
                    System.out.println("Comando inválido");
                    break;
                }
            }
        }while(true);
    }
}