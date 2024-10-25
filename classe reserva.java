import java.util.Scanner;

class Reserva {
    public String nomeHospede;
    public String dataCheckIn;
    public String dataCheckOut;
    public int numeroQuarto;
    public String tipoQuarto;

    public Reserva(String nomeHospede, String dataCheckIn, String dataCheckOut, int numeroQuarto, String tipoQuarto) {
        this.nomeHospede = nomeHospede;
        this.dataCheckIn = dataCheckIn;
        this.dataCheckOut = dataCheckOut;
        this.numeroQuarto = numeroQuarto;
        this.tipoQuarto = tipoQuarto;
    }

    public void exibirInformacoes() {
        System.out.println("Nome do Hóspede: " + nomeHospede);
        System.out.println("Check-in: " + dataCheckIn);
        System.out.println("Check-out: " + dataCheckOut);
        System.out.println("Quarto Número: " + numeroQuarto);
        System.out.println("Tipo de Quarto: " + tipoQuarto);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome do hóspede:");
        String nomeHospede = scanner.nextLine();

        System.out.println("Digite a data de check-in:");
        String dataCheckIn = scanner.nextLine();

        System.out.println("Digite a data de check-out:");
        String dataCheckOut = scanner.nextLine();

        System.out.println("Digite o número do quarto:");
        int numeroQuarto = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Digite o tipo de quarto:");
        String tipoQuarto = scanner.nextLine();

        Reserva reserva = new Reserva(nomeHospede, dataCheckIn, dataCheckOut, numeroQuarto, tipoQuarto);

        System.out.println("\nInformações da Reserva:");
        reserva.exibirInformacoes();
    }
}
