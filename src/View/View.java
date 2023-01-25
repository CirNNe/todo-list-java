package View;

import Controller.ControllerTarefa;
import Model.ModelTarefa;
import java.util.Scanner;

public class View {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Scanner entrada = new Scanner(System.in);
        int opcoes = 1;

        while (opcoes > 0) {
            System.out.println("---- TODO LIST ----");
            System.out.println("1 - ADICIONAR TAREFA\n" +
                    "2 - MOSTRAR LISTA DE TAREFAS\n" +
                    "3 - FILTRAR UM TAREFA\n" +
                    "4 - EDITAR TAREFA\n" +
                    "5 - EXCLUIR UMA TAREFA\n" +
                    "0 - SAIR\n");
            opcoes = entrada.nextInt();

            if(opcoes == 1) {
                ModelTarefa parametrosTarefa = new ModelTarefa();
                System.out.println("DIGITE O NOME DA TAREFA:");
                parametrosTarefa.setNome(input.nextLine());
                System.out.println("DIGITE A CATEGORIA:");
                parametrosTarefa.setCategoria(input.nextLine());
                System.out.println("DIGITE A DATA FINAL (d/m/A):");
                parametrosTarefa.setDataTermino(input.nextLine());
                System.out.println("DIGITE O STATUS (Fazer, Fazendo, Feito):");
                parametrosTarefa.setStatus(input.nextLine());
                System.out.println("DIGITE O NIVEL DE PRIORIDADE (1-5):");
                parametrosTarefa.setPrioridade(input.nextInt());

                ControllerTarefa.adicionarTarefa(parametrosTarefa);

            } else if (opcoes == 2) {

                // implementar um While para a escolha da ordem de exibição das tarefas

                System.out.println("LISTAR POR:\n" +
                        "1 - PRIORIDADE\n" +
                        "2 - CATEGORIA\n" +
                        "3 - DATA FINAL\n" +
                        "0 - SAIR");
                ControllerTarefa listaTarefas = new ControllerTarefa();
                listaTarefas.lerTarefas();

            } else if (opcoes == 3) {
                ControllerTarefa.lerTarefaUnica(input.next());
            }
        }
    }
}
