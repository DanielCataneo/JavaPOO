package org.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Conexao conx = new Conexao();
        Connection conexao = conx.getConexao();
        ContatoDAO ContatoDAO = new ContatoDAO(conexao);
        Scanner scanner = new Scanner(System.in);

        int opcao;

        do {
            System.out.println("\nProductFesa. Escolha a opção desejada:");
            System.out.println("1. Inserir Contato");
            System.out.println("2. Buscar Contato");
            System.out.println("3. Atualizar Contato");
            System.out.println("4. Excluir Contato");
            System.out.println("5. Listar Todos os Contatos");
            System.out.println("0. Sair");
            System.out.print("Digite sua opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir o \n do scanner

            switch (opcao) {
                case 1:
                    inserirContato(ContatoDAO, scanner);
                    break;
                case 2:
                    int opcaoBusca;
                    System.out.println("\nSubmenu de Busca:");
                    System.out.println("1. Buscar por ID");
                    System.out.println("2. Buscar por Nome");
                    System.out.print("Digite sua opção: ");
                    opcaoBusca = scanner.nextInt();
                    scanner.nextLine();

                    switch (opcaoBusca) {
                        case 1:
                            buscarID(ContatoDAO, scanner);
                            break;
                        case 2:
                            buscarContato(ContatoDAO, scanner);
                            break;
                        default:
                            System.out.println("Opção inválida. Tente novamente.");
                    }
                    break;
                case 3:
                    atualizarContato(ContatoDAO, scanner);
                    break;
                case 4:
                    excluirContato(ContatoDAO, scanner);
                    break;
                case 5:
                    listarTodosContatos(ContatoDAO);
                    break;
                case 0:
                    System.out.println("Agradecemos por usar o ProductFesa...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
            System.out.println("Pressione qualquer tecla para seguir...");
            scanner.nextLine();
        } while (opcao != 0);
        scanner.close();
    }

    private static void inserirContato(ContatoDAO ContatoDAO, Scanner scanner) {
        System.out.print("Nome do Contato: ");
        String nome = scanner.nextLine();
        System.out.print("telefone do Contato: ");
        String telefone;
        try {
            telefone = scanner.nextLine();
            scanner.nextLine(); // Consumir o \n do scanner
        } catch (InputMismatchException e) {
            System.out.println("telefone inválido. Digite um número.");
            scanner.nextLine(); // Limpar o buffer do scanner
            return;
        }

        Contato Contato = new Contato(0, nome, telefone);
        try {
            ContatoDAO.inserir(Contato);
            System.out.println("Contato inserido com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao inserir Contato.");
        }
    }

    private static void buscarID(ContatoDAO ContatoDAO, Scanner scanner) {
        System.out.print("Digite o ID do Contato: ");
        int id;
        try {
            id = scanner.nextInt();
            scanner.nextLine(); // Consumir o \n do scanner
        } catch (InputMismatchException e) {
            System.out.println("ID inválido. Digite um número inteiro.");
            scanner.nextLine(); // Limpar o buffer do scanner
            return;
        }

        Contato Contato = null;
        try {
            Contato = ContatoDAO.buscarPorId(id);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao obter Contato por ID.");
        }

        if (Contato != null) {
            System.out.println("\nContato encontrado:");
            System.out.println(Contato);
        } else {
            System.out.println("Contato com o ID informado não encontrado.");
        }
    }

    private static void buscarContato(ContatoDAO ContatoDAO, Scanner scanner) {
        System.out.print("Digite o termo de busca: ");
        String termoBusca = scanner.nextLine();

        List<Contato> ContatosEncontrados = null;
        try {
            ContatosEncontrados = ContatoDAO.buscarPorNome(termoBusca);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao buscar Contatos.");
        }

        if (ContatosEncontrados != null && !ContatosEncontrados.isEmpty()) {
            System.out.println("\nContatos encontrados:");
            for (Contato Contato : ContatosEncontrados) {
                System.out.println(Contato);
            }
        } else {
            System.out.println("Nenhum Contato encontrado com o termo de busca informado.");
        }
    }

    private static void atualizarContato(ContatoDAO ContatoDAO, Scanner scanner) {
        System.out.print("Digite o ID do Contato a ser atualizado: ");
        String idString = scanner.nextLine();

        if (!validarId(idString, scanner)) {
            return; // ID inválido
        }

        int id = Integer.parseInt(idString);
        Contato Contato = null;
        try {
            Contato = ContatoDAO.buscarPorId(id);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao obter Contato por ID.");
            return;
        }

        if (Contato == null) {
            System.out.println("Contato com o ID informado não encontrado.");
            return;
        }

        System.out.print("Novo nome do Contato: ");
        String novoNome = scanner.nextLine();
        System.out.print("Novo telefone do Contato: ");
        String novotelefone;
        try {
            novotelefone = scanner.nextLine();
            scanner.nextLine(); // Consumir o \n do scanner
        } catch (InputMismatchException e) {
            System.out.println("telefone inválido. Digite um número.");
            scanner.nextLine(); // Limpar o buffer do scanner
            return;
        }

        Contato.setNome(novoNome);
        Contato.setTelefone(novotelefone);

        try {
            ContatoDAO.atualizar(Contato);
            System.out.println("Contato atualizado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao atualizar Contato.");
        }
    }

    private static void excluirContato(ContatoDAO ContatoDAO, Scanner scanner) {
        System.out.print("Digite o ID do Contato a ser excluído: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer após nextInt

        try {
            Contato Contato = ContatoDAO.buscarPorId(id);
            if (Contato == null) {
                System.out.println("Contato com o ID informado não encontrado.");
                return;
            }

            System.out.println("Contato encontrado:");
            System.out.println(Contato);
            System.out.print("Tem certeza que deseja excluir este Contato? (S/N): ");
            String confirmacao = scanner.nextLine();

            if (confirmacao.equalsIgnoreCase("S")) {
                ContatoDAO.excluir(id);
                System.out.println("Contato excluído com sucesso!");
            } else {
                System.out.println("Exclusão cancelada pelo usuário.");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao excluir Contato.");
            e.printStackTrace();
        }
    }


    private static void listarTodosContatos(ContatoDAO ContatoDAO) {
        try {
            List<Contato> Contatos = ContatoDAO.listarContatos();
            if (Contatos.isEmpty()) {
                System.out.println("Nenhum Contato cadastrado.");
            } else {
                Contatos.forEach(System.out::println);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar Contatos.");
            e.printStackTrace();
        }
    }

    private static boolean validarId(String idString, Scanner scanner) {
        try {
            Integer.parseInt(idString);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("ID inválido. Digite um número inteiro.");
            scanner.nextLine(); // Limpar o buffer do scanner
            return false;
        }
    }


}
