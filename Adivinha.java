//NOME: João vitor de Mello Lima
import java.util.Random;
public class Adivinha {
    private int numDeCopos;
    private JogosStatus jogoStatus = new JogosStatus();// Instanciando o objeto JogosStatus.
    /**
        Método que "printa" os atributos da classe JogosStatus, como life, score e etc...
       */
    public void showStatus() {
        System.out.println("Score: " + jogoStatus.getScore() + " | Vidas: " + jogoStatus.getLife() + " | Vitórias atuais: " + jogoStatus.getNovasConquistas() + " | Conquistas:" + jogoStatus.getConquistas());
    }
    /** 
        Método para aumentar o score, recebe de parâmetro um valor inteiro e através do método getter e setter atualiza o valor do atributo.
       */
    public void aumentarScore(int valor) {
        int newScore = jogoStatus.getScore() + valor;
        jogoStatus.setScore(newScore);
    }
    /** 
        Método para diminuir o life, recebe de parâmetro um valor inteiro e através do método getter e setter atualiza o valor do atributo.
       */
    public void diminuirLife(int valor) {
        int newLife = jogoStatus.getLife() - valor;
        jogoStatus.setLife(newLife);
    }
    /** 
        Método para aumentar as conquistas, recebe de parâmetro um valor inteiro e através do método getter e setter atualiza o valor do atributo.
       */
    public void aumentaConquistas(int valor) {
        int newConquistas = jogoStatus.getConquistas() + valor;
        jogoStatus.setConquistas(newConquistas);
    }
    /** 
        Método para aumentar as novasConquistas, recebe de parâmetro um valor inteiro e através do método getter e setter atualiza o valor do atributo.
       */
    public void aumentaNovasConquistas(int valor) {
        int newNovasConquistas = jogoStatus.getNovasConquistas() + valor;
        jogoStatus.setNovasConquistas(newNovasConquistas);
    }
    /** 
        Método que desenha copos enfileirados de 3 em 3, recebe de parâmetro "numCopos" que indica a quantidade de "colunas" de copos que o jogo vai ter e retorna a variável "copos" para ser "printada" depois.
       */
    public String metodoCopo(int numCopos) {
        // Desenho do copo.
        String copos = "";
        String copo01 = "   ----       ";
        String copo02 = "  /    \\      ";
        String copo03 = " |      |     ";
        String copo04 = "  \\____/      ";
        // Lógica para desenhar os copos enfileirados.
        for (int i = 0; i < numCopos; i++) {
            for (int j = 0; j < 3; j++) {
                copos += copo01;
            }
            copos += "\n";
            for (int j = 0; j < 3; j++) {
                copos += copo02;
            }
            copos += "\n";
            for (int j = 0; j < 3; j++) {
                copos += copo03;
            }
            copos += "\n";
            for (int j = 0; j < 3; j++) {
                copos += copo04;
            }
            copos += "\n";
        }
        numDeCopos = numCopos * 3;
        // numDeCopos vai ser usada para dizer ao jogador quantos copos tem na tela e o limite onde a bolinha pode estar.
        return copos;
    }
    /** 
        Aleatoriza a quantidade de colunas do metodoCopo().
       */
    public String aleatorizarMetodosCopos() {
        Random random = new Random();// Instanciando o objeto Random.
        int escolha = random.nextInt(4) + 1;
        return metodoCopo(escolha);
    }
    /** 
        Randomiza a posição da bolinha com base no número de copos.
       */
    public int bolinha() {
        Random random = new Random();// Instanciando o objeto Random.
        return random.nextInt(numDeCopos) + 1;
    }
    /**
        Método com a lógica do jogo de adivinhar.
       */
    public void playAdivinha() {
        do {
            showStatus();// Mostra os atributos/status do jogo,
            System.out.println(aleatorizarMetodosCopos());// "Printa" os copos com a quantidade de colunas aleatória.
            System.out.println("//////////////////////////////////////");
            int posicaoBolinha = bolinha();// Chama o método que define a posição da bolinha.
            int escolhaCopo = Teclado.leInt("A bolinha está em que copo?...[De 1 a " + numDeCopos + "]");// Uso da classe Teclado.
            if (escolhaCopo == posicaoBolinha) {
                aumentarScore(1);
                System.out.println("Você acertou!!");
                // Caso tenha acertado o score aumenta.
            } else {
                diminuirLife(1);
                System.out.println("Você errou!!");
                // Caso tenha errado o life diminui.
                // Lógica de continuação caso tenha chegado a 0 vidas.
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
            // Lógica de continuação caso tenha ganhado.
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
        } while (true);
    }
}