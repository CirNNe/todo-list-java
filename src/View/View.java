package View;

import Controller.ControllerTarefa;
import Model.ModelTarefa;
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
                    "0 - SAIR\n");
            opcoes = entrada.nextInt();

            if(opcoes == 1) {
                Scanner inputPrioridade = new Scanner(System.in);
                System.out.println("AVISO: EVITE INSERIR TAREFAS COM O MESMO NOME!");
                ModelTarefa parametrosTarefa = new ModelTarefa();
                System.out.println("DIGITE O NOME DA TAREFA:");
                parametrosTarefa.setNome(input.nextLine());
                System.out.println("DIGITE A CATEGORIA:");
                parametrosTarefa.setCategoria(input.nextLine());
                System.out.println("DIGITE O NIVEL DE PRIORIDADE (1-5):");
                parametrosTarefa.setPrioridade(inputPrioridade.nextInt());
                System.out.println("DIGITE A DATA FINAL (d/m/A):");
                parametrosTarefa.setDataTermino(input.nextLine());
                System.out.println("DIGITE O STATUS (Fazer, Fazendo, Feito):");
                parametrosTarefa.setStatus(input.nextLine());

                ControllerTarefa.adicionarTarefa(parametrosTarefa);
            }

            else if (opcoes == 2) {
                int opcoesMostrar = 4;
                while(opcoesMostrar != 0) {
                    System.out.println("LISTAR POR:\n" +
                            "1 - PRIORIDADE\n" +
                            "2 - CATEGORIA\n" +
                            "3 - DATA FINAL\n" +
                            "0 - SAIR");
                    opcoesMostrar = entrada.nextInt();
                    if(opcoesMostrar == 1) {
                        ControllerTarefa.lerTarefasOrdemPrioridade();
                    } else if (opcoesMostrar == 2) {
                        ControllerTarefa.lerTarefasOrdemCategoria();
                    } else if (opcoesMostrar == 3) {
                        ControllerTarefa.lerTarefasOrdemData();
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
                System.out.println("DIGITE A NOVA DATA FINAL DA TAREFA (d/m/A)");
                String dataFinal = inputTarefaEditar.nextLine();
                System.out.println("DIGITE O NOVO STATUS DA TAREFA (Fazer, Fazendo, Feito)");
                String novoStatus = inputTarefaEditar.nextLine();

                ControllerTarefa.editaTarefa(nomeTarefaEditar, novoNome, novaCategoria, novaPrioridade, dataFinal, novoStatus);
            }

            else if (opcoes == 5) {
                Scanner inputDeletarTarefa = new Scanner(System.in);
                System.out.println("AVISO: TAREFAS COM O MESMO NOME SERÃO AFETADAS!\n" +
                                    "DIGITE O NOME DA TAREFA A SER DELETADA");
                ControllerTarefa.deletarTarefa(inputDeletarTarefa.nextLine());
            }
        }
    }
}
