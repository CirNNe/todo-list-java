package View;

import Controller.ControllerAlerta;
import Controller.ControllerTarefa;
import java.util.Scanner;

public class View {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Scanner entrada = new Scanner(System.in);
        int opcoes = 5;

        while (opcoes != 0) {
            System.out.println("---- TODO LIST ----");
            System.out.println("1 - ADICIONAR TAREFA\n" +
                    "2 - MOSTRAR LISTA DE TAREFAS\n" +
                    "3 - FILTRAR UM TAREFA\n" +
                    "4 - EDITAR TAREFA\n" +
                    "5 - EXCLUIR UMA TAREFA\n" +
                    "6 - ADICIONAR ALERTA\n" +
                    "0 - SAIR\n");
            opcoes = entrada.nextInt();

            if(opcoes == 1) {

                Scanner inputPrioridade = new Scanner(System.in);
                Scanner inputAlerta = new Scanner(System.in);

                System.out.println("AVISO: EVITE INSERIR TAREFAS COM O MESMO NOME!");

                System.out.println("DIGITE O NOME DA TAREFA:");
                String nome = input.nextLine();

                System.out.println("DIGITE A CATEGORIA:");
                String categoria = input.nextLine();

                System.out.println("DIGITE O NIVEL DE PRIORIDADE (1-5):");
                int prioridade = inputPrioridade.nextInt();

                System.out.println("DIGITE A DATA DE ENTREGA DA TAREFA (dd/MM/yyyy)");
                String data = input.nextLine();

                System.out.println("DIGITE O HORARIO DE ENTREGA DA TAREFA (HH:mm)");
                String horario = input.nextLine();

                System.out.println("DIGITE O STATUS (Fazer, Fazendo, Feito):");
                String status = input.nextLine();

                ControllerTarefa.adicionarTarefa(nome, categoria, prioridade, data, horario, status);
            }

            else if (opcoes == 2) {
                int opcoesMostrar = 4;
                while(opcoesMostrar != 0) {
                    System.out.println("---- LISTAR POR ----\n" +
                            "1 - PRIORIDADE\n" +
                            "2 - CATEGORIA\n" +
                            "3 - DATA FINAL\n" +
                            "0 - SAIR");
                    opcoesMostrar = entrada.nextInt();
                    if(opcoesMostrar != 0) {
                        ControllerTarefa.lerTarefas(opcoesMostrar);
                    }
                }

            }

            else if (opcoes == 3) {
                Scanner inputTarefaUnica = new Scanner(System.in);
                System.out.println("DIGITE O NOME DA TAREFA DESEJADA");
                ControllerTarefa.lerTarefaUnica(inputTarefaUnica.nextLine());
            }

            else if (opcoes == 4) {
                Scanner inputTarefaEditar = new Scanner(System.in);
                Scanner inputPrioridade = new Scanner(System.in);

                System.out.println("AVISO: TAREFAS COM O MESMO NOME SERÃO AFETADAS!\n" +
                                    "DIGITE O NOME DA TAREFA A SER EDITADA");
                String nomeTarefaEditar = inputTarefaEditar.nextLine();

                System.out.println("DIGITE O NOVO NOME DA TAREFA");
                String novoNome = inputTarefaEditar.nextLine();

                System.out.println("DIGITE A NOVA CATEGORIA DA TAREFA");
                String novaCategoria = inputTarefaEditar.nextLine();

                System.out.println("DIGITE O NOVO NÍVEL DE PRIORIDADE DA TAREFA (1-5)");
                int novaPrioridade = inputPrioridade.nextInt();

                System.out.println("DIGITE A NOVA DATA DE ENTREGA DA TAREFA (dd/MM/yyyy)");
                String novaData = inputTarefaEditar.nextLine();

                System.out.println("DIGITE O NOVO HORÁRIO DE ENTREGA DA TAREFA (HH:mm)");
                String novoHorario = inputTarefaEditar.nextLine();

                System.out.println("DIGITE O NOVO STATUS DA TAREFA (Fazer, Fazendo, Feito)");
                String novoStatus = inputTarefaEditar.nextLine();

                ControllerTarefa.editaTarefa(nomeTarefaEditar, novoNome, novaCategoria,
                                            novaPrioridade, novaData, novoHorario, novoStatus);
            }

            else if (opcoes == 5) {
                Scanner inputDeletarTarefa = new Scanner(System.in);
                System.out.println("AVISO: TAREFAS COM O MESMO NOME SERÃO AFETADAS!\n" +
                                    "DIGITE O NOME DA TAREFA A SER DELETADA");
                ControllerTarefa.deletarTarefa(inputDeletarTarefa.nextLine());
            }

            else if (opcoes == 6) {
                Scanner inputAlerta = new Scanner(System.in);

                System.out.println("DIGITE O NOME DA TAREFA QUE DESEJA ADICIONAR O ALARME");
                String nome = inputAlerta.nextLine();

                System.out.println("DIGITE A DATA DO ALARME");
                String data = inputAlerta.nextLine();

                System.out.println("DIGITE A HORA DO ALARME");
                String hora = inputAlerta.nextLine();

                ControllerAlerta.criaAlertaTarefa(nome, data, hora);
            }
        }
    }
}
