//NOME: João vitor de Mello Lima
public class JogosStatus{
    private int score;// Pontuação do jogador.
    private int life;// Vida do jogador;
    private int conquistas;// Conquistas/Vitórias de todos os jogos ganhos.
    private int novasConquistas;// Conquistas/Vitórias do jogo atual.
    /** 
        Construtor da classe JogosStatus com seus atributos.
       */
    public JogosStatus(){
         score = 0;
         life = 3;
         conquistas = 0;
         novasConquistas = 0;
    }
    /**
        Método para acessar o atributo novasConquistas.
       */
    public int getNovasConquistas(){
        return novasConquistas;
    }
    /**
        Método para acessar o atributo conquistas.
       */
    public int getConquistas(){
        return conquistas;
    }
    /**
        Método para acessar o atributo score.
       */
    public int getScore(){
        return score;
    }
    /**
        Método para acessar o atributo life.
       */
    public int getLife(){
        return life;
    }
    /**
        Método para reatribuir o valor do atributo score.
       */
    public void setScore(int score){
        this.score = score;
    }
    /**
        Método para reatribuir o valor do atributo life.
       */
    public void setLife(int life){
        this.life = life;
    }
    /**
        Método para reatribuir o valor do atributo conquistas.
       */
    public void setConquistas(int conquistas){
        this.conquistas = conquistas;
    }
    /**
        Método para reatribuir o valor do atributo novasConquistas.
       */
    public void setNovasConquistas(int novasConquistas){
        this.novasConquistas = novasConquistas;
    }
 }