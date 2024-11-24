
package view;

import controller.FuncionarioController;
import model.*;

import java.util.Scanner;

public class FuncionarioView {
    private FuncionarioController controller;
    private Scanner scanner;

    public FuncionarioView() {
        this.controller = new FuncionarioController();
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("1. Adicionar Funcionário");
            System.out.println("2. Listar Funcionários");
            System.out.println("3. Remover Funcionário");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1 -> adicionarFuncionario();
                case 2 -> listarFuncionarios();
                case 3 -> removerFuncionario();
                case 4 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 4);
    }

    private void adicionarFuncionario() {
        System.out.print("Digite o nome: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o salário: ");
        double salario = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Tipo de Funcionário: ");
        System.out.println("1. Desenvolvedor");
        System.out.println("2. Gerente");
        System.out.println("3. Treinador");
        System.out.println("4. Gerente Desenvolvedor");
        int tipo = scanner.nextInt();
        scanner.nextLine();

        Funcionario funcionario = switch (tipo) {
            case 1 -> new Desenvolvedor(nome, salario);
            case 2 -> new Gerente(nome, salario);
            case 3 -> new Treinador(nome, salario);
            case 4 -> new GerenteDesenvolvedor(nome, salario);
            default -> null;
        };

        if (funcionario != null) {
            controller.adicionarFuncionario(funcionario);
            System.out.println("Funcionário adicionado com sucesso!");
        } else {
            System.out.println("Tipo inválido.");
        }
    }

    private void listarFuncionarios() {
        System.out.println("Funcionários cadastrados:");
        for (Funcionario f : controller.listarFuncionarios()) {
            System.out.println(f.mostrarDetalhes());
        }
    }

    private void removerFuncionario() {
        System.out.print("Digite o nome do funcionário a ser removido: ");
        String nome = scanner.nextLine();
        if (controller.removerFuncionario(nome)) {
            System.out.println("Funcionário removido com sucesso.");
        } else {
            System.out.println("Funcionário não encontrado.");
        }
    }
}
