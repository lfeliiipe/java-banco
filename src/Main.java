import java.util.Scanner;
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String cliente = "João da Silva";
        String tipoConta = "corrente";
        double saldo = 2500;

        String mensagemInicial = """
                *************************
                
                Dados Inciais do Cliente

                Nome: %s
                Tipo de Conta: %s
                Saldo Inicial: R$%.2f
                
                *************************
                """;
        System.out.println(String.format(mensagemInicial, cliente, tipoConta, saldo));

        Scanner leitor = new Scanner(System.in);
        int opcao = 0;
        while (opcao != 4) {
            String mensagemMenu = """
                    Operações: 
                    
                    1 - Consultar Saldo
                    2 - Receber Valor
                    3 - Transferir Valor
                    4 - Sair
                    
                    Digite a operação desejada: """;
            System.out.printf(mensagemMenu);
            opcao = leitor.nextInt();

            System.out.println("");

            if (opcao == 1) {
                System.out.println(String.format("Seu saldo é: R$%.2f", saldo));
            } else if (opcao == 2) {
                System.out.println("Informe o valor a receber: ");
                double valorRecebido = leitor.nextDouble();
                saldo += valorRecebido;
                System.out.println(String.format("Saldo atualizado: R$%.2f", saldo));
            } else if (opcao == 3) {
                System.out.println("Informe o valor que deseja transferir");
                double valorTransferencia = leitor.nextDouble();
                if (valorTransferencia > saldo) {
                    System.out.println("Saldo Insuficiente");
                } else {
                    saldo -= valorTransferencia;
                    System.out.println(String.format("Saldo atualizado: R$%.2f", saldo));
                }
            } else if (opcao == 4){
                System.out.println("Sessão Encerrada");
            } else {
                System.out.println("Operação Inválida");
            }

            System.out.println("");
        }
    }
}