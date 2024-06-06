//NOME: João vitor de Mello Lima
import java.util.Random;
public class Secret{
    private String[] jogadas = {"pedra","papel","tesoura"};// Array que guarda as "jogadas" possíveis.
    private String escolhaJogador;
    private String jogada;
    JogosStatus jogoStatus = new JogosStatus();// Instanciando o objeto JogosStatus.
    /** 
        Método que "printa" os atuais atributos da classe JogosStatus, como score, life e etc...
       */
    public void showStatus(){
        System.out.println("Score: "+jogoStatus.getScore()+" | Vidas: "+jogoStatus.getLife()+" | Vitórias atuais: "+jogoStatus.getNovasConquistas()+" | Conquistas: "+jogoStatus.getConquistas());
    }
    /** 
        Método para aumentar o score, recebe de parâmetro um valor inteiro e através do método getter e setter atualiza o valor do atributo.
       */
    public void aumentarScore(int valor){
        int newScore = jogoStatus.getScore() + valor;
        jogoStatus.setScore(newScore);
    }
    /** 
        Método para diminuir o life, recebe de parâmetro um valor inteiro e através do método getter e setter atualiza o valor do atributo.
       */
    public void diminuirLife(int valor){
        int newLife = jogoStatus.getLife() - valor;
        jogoStatus.setLife(newLife);
    }
    /** 
        Método para aumentar as conquistas, recebe de parâmetro um valor inteiro e através do método getter e setter atualiza o valor do atributo.
       */
    public void aumentaConquistas(int valor){
        int newConquistas = jogoStatus.getConquistas() + valor;
        jogoStatus.setConquistas(newConquistas);
    }
    /** 
        Método para aumentar as novasConquistas, recebe de parâmetro um valor inteiro e através do método getter e setter atualiza o valor do atributo.
       */
    public void aumentaNovasConquistas(int valor){
        int newNovasConquistas = jogoStatus.getNovasConquistas() + valor;
        jogoStatus.setNovasConquistas(newNovasConquistas);
    }
    /**
        Método que aleatoriza a escolha do computador com base na array "jogadas" e retorna a mesma.
       */
    public String aleatorizarEscolhaPC (){
        Random random = new Random();// Instanciando o método random
        int indice  = random.nextInt(jogadas.length);// Escolhendo um número aleatorio do tamhanho da array "jogadas".
        String escolhaPC = jogadas[indice];// "Pegando" o item na posição aleatoria definida acima.
        return escolhaPC;// Retornando o item.
    }
    /** 
        Método com a lógica do jogo.
       */
    public void playSecret(){
        do{
            showStatus();// Chamada do método que mostra os atributos.
            /** Loop para garantir que o jogador escolha entre "Pedra", "Papel" ou "Tesoura" usando outras palavras para agilizar o processo.
               * Aceita os digitos ""pedra" em maiúsculo ou minúsculo" ou 1.
               * Aceita os digitos ""papel" em maiúsculo ou minúsculo" ou 2.
               * Aceita os digitos ""tesoura" em maiúsculo ou minúsculo" ou 3.
               */
            do{
                escolhaJogador = Teclado.leString("Você joga?... [Pedra], [Papel] ou [Tesoura]");
                if (escolhaJogador.toLowerCase().equals("pedra") || escolhaJogador.equals("1")){
                    jogada = "pedra";
                    break;
                }else if (escolhaJogador.toLowerCase().equals("papel") || escolhaJogador.equals("2")){
                    jogada = "papel";
                    break;
                }else if (escolhaJogador.toLowerCase().equals("tesoura") || escolhaJogador.equals("3")){
                    jogada = "tesoura";
                    break;
                }else {
                    System.out.println("Comando inválido!!");
                }
            }while(jogada == null);
            System.out.println("Sua jogada: "+jogada);// Mostra a escolha do jogador.
            String escolhaPC = aleatorizarEscolhaPC();// Chama o método que faz a escolha do computador e salva em uma variável.
            System.out.println("Jogador do computador : "+escolhaPC);// Mostra a escolha do computador.
            // Lógica para verificar quem ganhou.
            if(jogada.equals(escolhaPC)){
                System.out.println("Empate!!");
            }else if ((jogada.equals("pedra") && escolhaPC.equals("tesoura")) ||
                      (jogada.equals("papel") && escolhaPC.equals("pedra")) || 
                      (jogada.equals("tesoura") && escolhaPC.equals("papel"))){
                aumentarScore(1);// Aumenta o score em 1.
                System.out.println("Você ganhou!!");
            }else{
                diminuirLife(1);// diminui o life em 1.
                System.out.println("Você perdeu!!");
                // Lógica para caso fique sem vidas.
                if (jogoStatus.getLife() <= 0) {
                    System.out.println("Você ficou sem vidas...");
                    String desistir = Teclado.leString("Quer continuar?...[Sim] ou [Não]");
                    if (desistir.equalsIgnoreCase("sim") || desistir.equalsIgnoreCase("s") || desistir.equals("1")) {
                        jogoStatus.setScore(0);
                        jogoStatus.setLife(3);
                        jogoStatus.setNovasConquistas(0);
                        System.out.println("Próxima rodada!!");
                    } else if (desistir.equalsIgnoreCase("não") || desistir.equalsIgnoreCase("nao") || desistir.equalsIgnoreCase("n") || desistir.equals("2")) {
                        jogoStatus.setScore(0);
                        jogoStatus.setLife(3);
                        jogoStatus.setNovasConquistas(0);
                        break;
                    } else {
                        System.out.println("Comando inválido");
                        break;
                    }
                }
            }
            // Lógica para continuar caso ganhe o jogo.
            if (jogoStatus.getScore() == 3) {
                aumentaConquistas(1);
                aumentaNovasConquistas(1);
                System.out.println("Você ganhou o jogo!!");
                String desistir = Teclado.leString("Quer jogar novamente?...[Sim] ou [Não]");
                if (desistir.equalsIgnoreCase("sim") || desistir.equalsIgnoreCase("s") || desistir.equals("1")) {
                    jogoStatus.setScore(0);
                    jogoStatus.setLife(3);
                    System.out.println("Próxima rodada!!");
                } else if (desistir.equalsIgnoreCase("não") || desistir.equalsIgnoreCase("nao") || desistir.equalsIgnoreCase("n") || desistir.equals("2")) {
                    jogoStatus.setScore(0);
                    jogoStatus.setLife(3);
                    jogoStatus.setNovasConquistas(0);
                    break;
                } else {
                    System.out.println("Comando inválido");
                    break;
                }
            }
        }while(true);
    }
}