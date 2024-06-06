//NOME: João vitor de Mello Lima
import java.util.Random;
public class Matematica{
    int a;
    int b;
    JogosStatus jogoStatus = new JogosStatus();// Instanciando o objeto JogoStatus.
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
        Escolhe um número aleatório de 1 a 100, salva ele na variável "a" e retorna ela..
       */
    public int numAleatorioA(){
        Random random = new Random();// Instanciando o objeto Random.
        a = random.nextInt(100) + 1;
        return a;
    }
    /**
        Escolhe um número aleatório de 1 a 100, salva ele na variável "b" e retorna ela..
       */
    public int numAleatorioB(){
        Random random = new Random();// Instanciando o objeto Random.
        b = random.nextInt(100) + 1;
        return b;
    }
    /** 
        Método com a lógica do jogo de somar.
       */
    public int matematicaSoma(){
        int a =  numAleatorioA();// Salva o valor aleatório de a.
        int b =  numAleatorioB();// Salva o valor aleatório de b.
        System.out.println("Quanto é "+a+" + "+b+" ?");// Pergunta quanto é a + b.
        int awns = Teclado.leInt("Palpite: ");// Uso da classe Teclado.
        // Verifica se a resposta é igual a "a + b".
        if (awns == a + b){
            System.out.println("Você está certo!!");
            return 0;// Retorna 0 caso tenha acertado.
        }else {
            System.out.println("Você errou!!");
            return 1;
            // Retorna 1 caso tenha errado.
        }
    }
    /** 
        Método com a lógica do jogo de subtrair.
       */
    public int matematicaSub(){
        int a =  numAleatorioA();// Salva o valor aleatório de a.
        int b =  numAleatorioB();// Salva o valor aleatório de b.
        System.out.println("Quanto é "+a+" - "+b+" ?");// Pergunta quanto é a - b.
        int awns = Teclado.leInt("Palpite: ");// Uso da classe Teclado.
        // Verifica se a resposta é igual a "a - b".
        if (awns == a - b){
            System.out.println("Você está certo!!");
            return 0;// Retorna 0 caso tenha acertado.
        }else {
            System.out.println("Você errou!!");
            return 1;// Retorna 1 caso tenha errado.
        }
    }
    /** 
        Método com a lógica do jogo de multiplicar.
       */
    public int matematicaMult(){
        int a =  numAleatorioA();// Salva o valor aleatório de a.
        int b =  numAleatorioB();// Salva o valor aleatório de b.
        System.out.println("Quanto é "+a+" * "+b+" ?");// Pergunta quanto é a * b.
        int awns= Teclado.leInt("Palpite: ");// Uso da classe Teclado.
        // Verifica se a resposta é igual a "a * b".
        if (awns == a * b){
            System.out.println("Você está certo!!");
            return 0;// Retorna 0 caso tenha acertado.
        }else {
            System.out.println("Você errou!!");
            return 1;// Retorna 1 caso tenha errado.
        }
    }
    /**
        Método que escolhe um inteiro de 0 a 3, e com base no número escolhido retorna o método do jogo.
       */
    public int aleatorizarJogosMatematica(){ 
        Random random = new Random();// Instaciando o objeto Random.
        int escolha = random.nextInt(3); 
        
        switch(escolha) {
            case 0:
                return matematicaSoma();
            case 1:
                return matematicaSub();
            case 2:
                return matematicaMult();
            default:
                return matematicaSoma();// Em caso de algum erro o padrão é retornar o jogo de somar.
        }
    }
    /** 
        Método com a lógica do jogo.
       */
    public void playMat(){
        // Loop Principal do jogo Matematica.
        do{
            showStatus(); // Mostra os Atributos.
            int resultado = aleatorizarJogosMatematica();// Salva o jogo escolhido.
            if(resultado == 0){
              aumentarScore(1);// Aumenta em 1 o score caso o retorno do jogo escolhido seja 0.
            }else if(resultado == 1){
                diminuirLife(1);// Diminui em 1 o life caso o retorno do jogo escolhifo seja 1.
                if(jogoStatus.getLife() <= 0){
                    // Caso o jogador fique sem vidas, ele pode continuar ou desistir.
                    System.out.println("Você ficou sem vidas...");
                    String desistir = Teclado.leString("Quer continuar?...[Sim] ou [Não]");// Uso da classe Teclado.
                    jogoStatus.setScore(0);// Zera o score.
                    jogoStatus.setLife(3);// Volta as vidas para 3.
                    jogoStatus.setNovasConquistas(0);// Zera as conquistas do jogo atual
                    // Aceita "sim/s maiúsculo e minúsculo e 1" ou "não/nao/n maiúsculo ou minúsculo ou 2".
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
            // Caso o score chegue a 5 aumenta as conquistas e as novasConquistas e te da a opção de continuar ou parar.
            if (jogoStatus.getScore() == 5){
                System.out.println("Você ganhou o jogo!!");
                aumentaConquistas(1);
                aumentaNovasConquistas(1);
                String desistir = Teclado.leString("Quer jogar novamente?...[Sim] ou [Não]");// Uso da classe Teclado.
                // Aceita "sim/s maiúsculo e minúsculo e 1" ou "não/nao/n maiúsculo ou minúsculo ou 2".
                if(desistir.toLowerCase().equals("sim") || desistir.toLowerCase().equals("s") || desistir.equals("1")){
                    jogoStatus.setScore(0);// Zera o score.
                    jogoStatus.setLife(3);// Reseta a vida.
                    System.out.println("Próxima rodada!!");
                }else if(desistir.toLowerCase().equals("não") || desistir.toLowerCase().equals("nao") || desistir.toLowerCase().equals("n") || desistir.equals("2")){
                    jogoStatus.setScore(0);// Zera o score
                    jogoStatus.setLife(3);// Reseta a vida.
                    jogoStatus.setNovasConquistas(0);// zera as novasConquistas.
                    break;
                }else{
                    System.out.println("Comando inválido");
                    break;
                }               
            }
        }while(true);
    }  
}