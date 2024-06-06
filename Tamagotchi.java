//NOME: João vitor de Mello Lima
import java.util.Random;
/** 
    Classe tamagotchi que possuí as variáveis do mesmo, método construtor, métodos de desejos, interface, getters e setters.
   */
public class Tamagotchi{
    private int peso; // Peso do tamagotchi.
    private int idade;// Idade\Dias que o tamagotchi viveu.
    private String nome;// Nome do Tamagotchi.
    private int permaneceuAcordado; // Variável para verificar as noites que o tamagotchi ficou acordado.
    private int karma; // Variável para medir as ações do jogador com tamagotchi (boas/más).
    private String personalidade;// Variável para definir a personalidade do tamagotchi com base no "karma".
    private boolean estaVivo;// Variável para saber se o tamagotchi está vivo.
    private AleatorizarAparencia aparencia = new AleatorizarAparencia();// Criação do objeto que aleatoriza a aparência do tamagotchi.
    private Dialogos dialogo = new Dialogos();// Criação do objeto que aleatoriza os diálogos.
    private Jogos jogo = new Jogos();// Criação do objeto que aleatoriza os jogos.
    /** 
     * Construtor da classe Tamagotchi com suas váriaveis, esse construtor recebe como parâmetro o nome do tamagotchi (que vai ser dado pelo jogador).
       */
    public Tamagotchi(String nome){
        this.nome = nome;// "This" evita problemas de escopo entre variáveis com mesmo nome.
        peso = 1;// Peso definido segundo as orientações do professor.
        idade = 0;// Idade/Dias definido segundo as orientações do professor.
        permaneceuAcordado = 0;
        karma = 0;
        estaVivo = true;
    }
    /** 
        Método getter usado para acessar o valor da variável nome.
       */
    public String getNome(){
        return nome;
    }
    /** 
         Método getter usado para acessar o valor da variável estaVivo (é usado "is" ao invés de "get" por ser uma variável do tipo boolean.).
       */
    public boolean isEstaVivo(){
        return estaVivo;
    }
    /**
        Método que altera a variável estaVivo para false (vai ser usada para encerar loops).
       */
    public void morrer(){
        estaVivo = false;
    }
    /**
        Método que verifica as condições de "morte" do tamagotchi segundo orientações do professor (o método morrer() é usado aqui).
       * O primeiro verifica se o tamagotchi ultrapassou a idade limite.
       * O segundo se passou do peso limite.
       * O terceiro se ficou abaixo do peso mínimo.
       */
    public void verificaVida(){
        if (idade >= 15){
            System.out.println(nome +" morreu de velhice!!");
            morrer();
        }
        if (peso > 20){
            System.out.println(nome + " Explodiu de tanto comer...");
            morrer();
        }
        if (peso <=0){
            System.out.println(nome + " Morreu desnutrido!!");
            morrer();
        }  
    }
    /** 
        Com base no karma, chama o método de diálogo "bom ou mau", armazena ele em "fala" e retorna.
       * Caso aconteça um imprevisto, ele sinaliza o valor inesperado de karma.
       */
    public String dialogosAleatorios(){
        String fala;
        if(karma >= 0){
            fala = dialogo.aleatorizarDialogoBom();
            return fala;
        }else if(karma < 0){
            fala = dialogo.aleatorizarDialogoMau();
            return fala;
        }else {
            throw new IllegalStateException("Valor inesperado: " + karma);
        }
    }
    /** 
         Faz a mesma coisa que o método anterior, so que dessa vez com diálogos especificos para o método fome. 
       */
    public String dialogosFomeAleatorios(){
        String fala;
        if(karma >= 0){
            fala = dialogo.aleatorizarDialogoFomeBom();
            return fala;
        }else if(karma < 0){
            fala = dialogo.aleatorizarDialogoFomeMau();
            return fala;
        }else{
            throw new IllegalStateException("Valor inesperado: " + karma);
        }
    }
    /** 
         Faz a mesma coisa que o método anterior, so que dessa vez com diálogos especificos para o método sono. 
       */
    public String dialogosSonoAleatorios(){
        String fala;
        if(karma >= 0){
            fala = dialogo.aleatorizarDialogoSonoBom();
            return fala;
        }else if(karma < 0){
            fala = dialogo.aleatorizarDialogoSonoMau();
            return fala;
        }else {
            throw new IllegalStateException("Valor inesperado: " + karma);
        }
    }
    /** 
         Faz a mesma coisa que o método anterior, so que dessa vez com diálogos especificos para o método jogar. 
       */
    public String dialogosJogarAleatorios(){
        String fala;
        if(karma >= 0){
            fala = dialogo.aleatorizarDialogoJogarBom();
            return fala;
        }else if(karma < 0){
            fala = dialogo.aleatorizarDialogoJogarMau();
            return fala;
        }else {
            throw new IllegalStateException("Valor inesperado: " + karma);
        }
    }  
    /** 
         Faz a mesma coisa que o método anterior, so que dessa vez com diálogos especificos para o método carente. 
       */
    public String dialogosCarenteAleatorios(){
        String fala;
        if(karma >= 0){
            fala = dialogo.aleatorizarDialogoCarenteBom();
            return fala;
        }else if(karma < 0){
            fala = dialogo.aleatorizarDialogoMau();
            return fala;
        }else {
            throw new IllegalStateException("Valor inesperado: " + karma);
        }
    }
    /** 
         Faz a mesma coisa que o método anterior, so que dessa vez com diálogos especificos para o método tedio. 
       */
    public String dialogosTedioAleatorios(){
        String fala;
        if(karma >= 0){
            fala = dialogo.aleatorizarDialogoTedioBom();
        }else if(karma < 0){
            fala = dialogo.aleatorizarDialogoTedioMau();
            return fala; 
        }else {
            throw new IllegalStateException("Valor inesperado: " + karma);
        }
        return fala;
    }
    /** 
         Método com a lógica do desejo "carente", com opcões de "Brincar" ou "Chutar", essas ações afetam diretamente no karma. 
        * Ele também chama dois métodos "gui() e desejoSono()", o primeiro é uma interface que mostra dados como o nome, peso e etc... O segundo é o método com a lógica de "sono"
        * Caso o jogador digite um comando inválido é mostrado uma mensagem de erro e o loop se repete.
        * O método aceita a escrita em minúsculo ou maiúsculo ou em dígitos (1 e 2) para facilitar e agilizar os testes.
       */
    public void desejoCarente(){
        do{
            String escolhaCarente = Teclado.leString(nome + " está carente...[Brincar] ou [Chutar]");// Uso da classe teclado
            if (escolhaCarente.toLowerCase().equals("brincar") || escolhaCarente.equals("1")){
                karma++;// Aumenta o karma em 1.
                System.out.println(dialogosCarenteAleatorios());//"Printa" o retorno do método dialogosCarenteAleatorios()
                System.out.println(gui());// Mostra o "gui" (Interface com dados do tamagotchi).
                desejoSono();// Chama o método de "desejoSono()".
                break;// Encerra o loop.
            }else if (escolhaCarente.toLowerCase().equals("chutar") || escolhaCarente.equals("2")){
                karma -= 5;//Diminui o karma.
                System.out.println(dialogo.aleatorizarDialogoCarenteMau());// Para evitar que o tamagotchi diga algo legal depois de ser chutado, ele chama diretamente os diálogos "carentes maus" sem passar pelo sistema de karma.
                break;// Encerra o loop.
            }
            else{
                System.out.println("Comando inválido");// Caso escreva algo inválido o loop reseta e uma mensagem de erro é printada.
            }
        }while(true);
    }
    /**
         Método com a lógica do desejo "jogar", influência o karma, chama o método play() do objeto "Jogo" e "printa" os diálogos específicos de jogo.
        * Para facilitar os testes permite a entrada de "sim/s minúsculo ou maiúsculo ou 1" ou "não/nao/n/ minúsculo ou maiúsculo ou 2".
       */
    public void desejoJogar(){
        do{
            String escolhaJogar = Teclado.leString(nome + " Quer jogar...[Sim] ou [Não]");// Uso da classe Teclado.
            if(escolhaJogar.toLowerCase().equals("sim") || escolhaJogar.equals("1") || escolhaJogar.toLowerCase().equals("s")){
                karma++;
                jogo.play();
                System.out.println(dialogosJogarAleatorios());
                break;
            }else if ((escolhaJogar.toLowerCase().equals("não") || escolhaJogar.equals("2") || escolhaJogar.toLowerCase().equals("nao") || escolhaJogar.toLowerCase().equals("n"))){
                karma--;
                System.out.println();
                break;
            }else {
                 System.out.println("Comando inválido");
            }
        }while(true);
    }
    /**
        Método com a lógica de sono.
       * Aumenta a idade e o karma e zera o permaneceuAcordado caso durma.
       * Aumenta o "permaneceuAcordado", diminui o karma caso não durma e "printa" um diálogo genérico..
       * Caso deixe de dormir 5 vezes, ele automaticamente dorme (aumenta a idade/días vividos), diminuí o karma, printa um diálogo genérico e zera o "permaneceuAcordado".
       * Aceita "dormir minúscula ou maiúscula e 1" ou "permanecer acordado minúscula ou maiúscula e 2".
       * Caso digite errado o loop retorna com uma mensagem de erro.
       */
    public void desejoSono(){
        do {
            String escolhaSono = Teclado.leString(nome + " está com sono...[Dormir] ou [Permanecer acordado]");// Uso da classe Teclado.
            if (escolhaSono.toLowerCase().equals("dormir") || escolhaSono.equals("1")){
                idade++;
                permaneceuAcordado = 0;
                karma++;
                System.out.println(dialogosSonoAleatorios());
                break;
            }else if (escolhaSono.toLowerCase().equals("permanecer acordado") || escolhaSono.equals("2")){
                permaneceuAcordado++;
                System.out.println(dialogosAleatorios());
                karma--;
                if (permaneceuAcordado == 5){
                    idade++;
                    karma -= 5;
                    System.out.println(dialogosAleatorios());
                    permaneceuAcordado = 0;
                    break;
                }  
                break;
            }
            else{
                System.out.println("Comando inválido");
            }
          }while(true);
    }
    /** 
       Método com a lógica da fome
       * Aumenta o peso em 5 e karma em 1 caso coma muito, "printa" um diálogo de fome.
       * Caso coma pouco aumenta peso e karma em 1, "printa" um diálogo de fome. 
       * Caso não coma perde 2 de peso e 1 de karma e "printa" um diálogo genérico.
       * Permite entradas como "comer muito/muito minúsculo ou maiúsculo" ou 1, "comer pouco/pouco minúscula ou maiúscula" ou 2, "não comer/nao comer minúscula ou maiúscula" ou 3.
       */
    public void desejoFome (){
        do {
            String escolhaFome = Teclado.leString(nome + " está com fome...[Comer muito],[Comer pouco] ou [Não comer]");//Uso da classe Teclado.
            if (escolhaFome.toLowerCase().equals("comer muito" ) || escolhaFome.toLowerCase().equals("muito")|| escolhaFome.equals("1")){
                peso += 5;
                System.out.println(dialogosFomeAleatorios());
                karma++;
                break;
            }else if (escolhaFome.toLowerCase().equals("comer pouco") || escolhaFome.toLowerCase().equals("pouco") || escolhaFome.equals("2")){
                peso++; 
                System.out.println(dialogosFomeAleatorios());
                karma++;
                break;
            }else if (escolhaFome.toLowerCase().equals("não comer") || escolhaFome.toLowerCase().equals("nao comer") || escolhaFome.equals("3")){
                peso -= 2;
                System.out.println(dialogosAleatorios());
                karma--;
                break;
            }
            else{
                System.out.println("Comando inválido");
            }
          } while(true);
    }
    /**
       Método com a lógica de tédio.
       * Caso corra, perde 4 de peso e ganha 5 "porque come muito logo em seguida", "printa" um diálogo de tédio, aumenta o karma.
       * Caso caminhe perde 1 de peso, "printa" um diálogo de tédio, aumenta o karma em 1, mostra o "gui" e sente "desejo de fome".
       * Caso não deixe sair "uma opção extra para permiter abaixar o karma em todos os desejos", aumenta o peso em 1, "printa" um diálogo genérico, perde 1 de karma.
       * permite entradas como "correr 10 minutos/correr minúsculo ou maiúsculo e 1 " ou "caminhar 10 minutos/caminhar minúsculo ou maiúsculo e 2" ou "não deixar sair/nao deixar sair minúsculo ou maiúsculo e 3"
       */
    public void desejoEntediado (){
        do {
            String escolhaTedio = Teclado.leString(nome + " está com tédio...[Correr 10 minutos], [Caminhar 10 minutos] ou [Não deixar sair]");//Uso da classe Teclado.
            if (escolhaTedio.toLowerCase().equals("correr 10 minutos")  || escolhaTedio.toLowerCase().equals("correr") || escolhaTedio.equals("1")){
                peso -= 4;
                peso += 5;
                System.out.println(dialogosTedioAleatorios());
                karma++;
                break;
            }else if (escolhaTedio.toLowerCase().equals("caminhar 10 minutos") || escolhaTedio.toLowerCase().equals("caminhar") || escolhaTedio.equals("2")){
                peso -= 1;
                System.out.println(dialogosTedioAleatorios());
                karma++;
                System.out.println(gui());
                desejoFome();
                break;
            }else if (escolhaTedio.toLowerCase().equals("não deixar sair") || escolhaTedio.toLowerCase().equals("nao deixar sair") || escolhaTedio.equals("3")){
                peso++;
                System.out.println(dialogosAleatorios());
                karma--;
                break;
            }
            else{
                System.out.println("Comando inválido");
            }
        }while(true);
    }
    /** 
        Método que escolhe um número de 0 a 4, e conforme o caso executa um desejo especifíco, "printa" o gui e encerra o loop.
       */
    public void desejosAleatorios(){
        Random random = new Random();// Instanciando o mètodo Random.
        int desejo = random.nextInt(5);// Escolhe um número aleatório de 1 a 4.
        switch (desejo){
            case 0:
                desejoSono();
                System.out.println(gui());
                break;
            case 1:
                desejoFome();
                System.out.println(gui());
                break;
            case 2:
                desejoEntediado();
                System.out.println(gui());
                break;
            case 3:
                desejoCarente();
                System.out.println(gui());
                break;
            case 4:
                desejoJogar();
                System.out.println(gui());
                break;  
        }
    }
    /** 
        Método que com base no karma define a personalide do tamagotchi.
        * Caso um imprevisto aconteça ele diz o valor inesperado de karma.
       */
    public void karmaCheck(){
        if(karma >= 0){
            personalidade = "Bom";
        }else if (karma < 0) { 
            personalidade = "Mau";
        }else {
            throw new IllegalStateException("Valor inesperado: " + karma);
        }
    }
    /** 
        Interface com dados do tamagotchi como o nome, peso, idade/dias e humor/personalidade.
        * Retorna o "status" para ser "printado" como mostrado antes.
       */
    public String gui(){
        karmaCheck();
        String status = ("Tamagotchi| Nome: "+nome+" / Peso: "+peso+" / Idade: "+idade+" dias"+" / Humor: "+personalidade);
        return status;
    }
    /**
       Chama o método que aleatoriza uma "skin" para o tamagotchi, salva ela em uma variável para depois "printar" ela.
       */
    public String aparenciaFixa(){
        String aparenciaFixa = (aparencia.aleatorizarAparenciaTamagotchi());
        return aparenciaFixa + "\n";
    }
}