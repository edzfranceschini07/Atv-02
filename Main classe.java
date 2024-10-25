import java.util.ArrayList;
import java.util.Scanner;

class Quarto {
    public int numero;
    public String tipo;
    public double precoDiario;
    public boolean disponivel;

    public Quarto(int numero, String tipo, double precoDiario) {
        this.numero = numero;
        this.tipo = tipo;
        this.precoDiario = precoDiario;
        this.disponivel = true;
    }
}

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
}

class Hotel {
    public ArrayList<Quarto> quartos = new ArrayList<>();
    public ArrayList<Reserva> reservas = new ArrayList<>();

    public void cadastrarQuarto(int numero, String tipo, double precoDiario) {
        Quarto novoQuarto = new Quarto(numero, tipo, precoDiario);
        quartos.add(novoQuarto);
    }

    public void cadastrarReserva(String nomeHospede, String dataCheckIn, String dataCheckOut, int numeroQuarto) {
        for (Quarto quarto : quartos) {
            if (quarto.numero == numeroQuarto && quarto.disponivel) {
                Reserva novaReserva = new Reserva(nomeHospede, dataCheckIn, dataCheckOut, numeroQuarto, quarto.tipo);
                reservas.add(novaReserva);
                quarto.disponivel = false;
                System.out.println("Reserva criada com sucesso!");
                return;
            }
        }
        System.out.println("Quarto indisponível.");
    }

    public void realizarCheckIn(int numeroQuarto) {
        for (Quarto quarto : quartos) {
            if (quarto.numero == numeroQuarto && quarto.disponivel) {
                quarto.disponivel = false;
                System.out.println("Check-in realizado com sucesso no quarto " + numeroQuarto);
                return;
            }
        }
        System.out.println("Check-in falhou: quarto indisponível.");
    }

    public void realizarCheckOut(int numeroQuarto) {
        for (Quarto quarto : quartos) {
            if (quarto.numero == numeroQuarto && !quarto.disponivel) {
                quarto.disponivel = true;
                System.out.println("Check-out realizado com sucesso no quarto " + numeroQuarto);
                return;
            }
        }
        System.out.println("Check-out falhou: quarto já está disponível.");
    }

    public void gerarRelatorioOcupacao() {
        System.out.println("Relatório de Ocupação de Quartos:");
        for (Quarto quarto : quartos) {
            if (!quarto.disponivel) {
                System.out.println("Quarto " + quarto.numero + " (" + quarto.tipo + ") está ocupado.");
            }
        }
    }

    public void gerarHistoricoReservas(String nomeHospede) {
        System.out.println("Histórico de Reservas do Hóspede " + nomeHospede + ":");
        for (Reserva reserva : reservas) {
            if (reserva.nomeHospede.equals(nomeHospede)) {
                System.out.println("Reserva: Quarto " + reserva.numeroQuarto + ", Tipo: " + reserva.tipoQuarto + 
                                   ", Check-in: " + reserva.dataCheckIn + ", Check-out: " + reserva.dataCheckOut);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Cadastrar Quarto\n2. Cadastrar Reserva\n3. Realizar Check-in\n4. Realizar Check-out\n5. Gerar Relatório de Ocupação\n6. Gerar Histórico de Reservas\n7. Sair");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Número do quarto:");
                    int numeroQuarto = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Tipo de quarto:");
                    String tipoQuarto = scanner.nextLine();
                    System.out.println("Preço diário:");
                    double preco = scanner.nextDouble();
                    hotel.cadastrarQuarto(numeroQuarto, tipoQuarto, preco);
                    break;
                case 2:
                    System.out.println("Nome do hóspede:");
                    String nomeHospede = scanner.next();
                    System.out.println("Data de check-in:");
                    String dataCheckIn = scanner.next();
                    System.out.println("Data de check-out:");
                    String dataCheckOut = scanner.next();
                    System.out.println("Número do quarto:");
                    int numQuarto = scanner.nextInt();
                    hotel.cadastrarReserva(nomeHospede, dataCheckIn, dataCheckOut, numQuarto);
                    break;
                case 3:
                    System.out.println("Número do quarto para check-in:");
                    int quartoCheckIn = scanner.nextInt();
                    hotel.realizarCheckIn(quartoCheckIn);
                    break;
                case 4:
                    System.out.println("Número do quarto para check-out:");
                    int quartoCheckOut = scanner.nextInt();
                    hotel.realizarCheckOut(quartoCheckOut);
                    break;
                case 5:
                    hotel.gerarRelatorioOcupacao();
                    break;
                case 6:
                    System.out.println("Nome do hóspede:");
                    String nome = scanner.next();
                    hotel.gerarHistoricoReservas(nome);
                    break;
                case 7:
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
