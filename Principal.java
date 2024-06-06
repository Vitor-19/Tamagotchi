//NOME: João vitor de Mello Lima
public class Principal  {
    // Método main.
    public static void main(String[] args) {
        boolean loop = true;
        // Loop principal.
        while (loop == true){
            String nomeTamagotchi = Teclado.leString("Qual o nome do seu tamagotchi?");// Uso da classe Teclado.
            Tamagotchi tamagotchi = new Tamagotchi(nomeTamagotchi);// Instanciando o objeto tamagotchi.
            Dialogos dialogos = new Dialogos();// Instanciando o objeto Dialogos.
            String dialogo_Inicial = dialogos.aleatorizarDialogoInicial();
            System.out.println(dialogo_Inicial);// "Printando" o diálogo inicial.
            String aparenciaFixa = tamagotchi.aparenciaFixa();// "Escolhendo" a "skin" do tamahotchi.
            // Loop secundário.
            while (tamagotchi.isEstaVivo()){
            System.out.println(aparenciaFixa);// "Printa a "skin" fixa do tamagotchi.
            tamagotchi.desejosAleatorios();// Roda os "desejos" do tamagotchi.        
            tamagotchi.verificaVida();// Verifica se ele está vivo.
            }
            // Sistema de reincarnação caso tenha morrido.
            do{
                String continuar = Teclado.leString("Deseja um novo tamagotchi? [Sim] ou [Não]");
                if (continuar.toLowerCase().equals("sim") || continuar.equals("1")){
                    loop = true;
                    break;
                }else if (continuar.toLowerCase().equals("não") || continuar.equals("2") || continuar.toLowerCase().equals("nao")){            
                    System.out.println("Obrigado por jogar!!");
                    loop = false;
                    break;
                }else{
                    System.out.println("Reposta inválida");
                }
             }while(true);
    }
  }
}

