package Controller;

import Model.*;
import java.io.*;
import java.util.*;

public class ControllerTarefa {

    public static void adicionarTarefa(ModelTarefa tarefa) {

        File arquivoTxt = new File("tarefas.txt");
        try (FileWriter escreverArquivo = new FileWriter(arquivoTxt, true);
             BufferedWriter escreveTarefa = new BufferedWriter(escreverArquivo)) {
            if (arquivoTxt.exists()) {

                escreveTarefa.write(tarefa.getNome() + ";" + tarefa.getCategoria() + ";" +
                        tarefa.getPrioridade() + ";" + tarefa.getDataTermino() +
                        ";" + tarefa.getStatus() + "\n");
            } else {
                arquivoTxt.createNewFile();
                escreveTarefa.write(tarefa.getNome() + ";" + tarefa.getCategoria() + ";" +
                        tarefa.getPrioridade() + ";" + tarefa.getDataTermino() +
                        ";" + tarefa.getStatus() + "\n");
            }
        } catch (Exception error) {
            System.out.println("ERRO AO TENTAR REGISTRAR TAREFA!");
        }
    } // OK

    public static void lerTarefasOrdemPrioridade() {
        File arquivoTxt = new File("tarefas.txt");
        List<ModelTarefa> listaTarefas = new ArrayList<>();

        try (FileReader leitorArquivo = new FileReader(arquivoTxt);
             BufferedReader bufferedReader = new BufferedReader(leitorArquivo)
        ) {
            if (arquivoTxt.exists()) {
                System.out.println("TAREFA | CATEGORIA | PRIORIDADE | DATA FINAL | STATUS");
                String linha = bufferedReader.readLine();

                while (linha != null && !linha.isEmpty()) {

                    String[] camposLinha = linha.split(";");
                    String nome = camposLinha[0];
                    String categoria = camposLinha[1];
                    String dataFinal = camposLinha[3];
                    int prioridade = Integer.parseInt(camposLinha[2]);
                    String status = camposLinha[4];

                    listaTarefas.add(new ModelTarefa(nome, categoria, dataFinal, prioridade, status));
                    Collections.sort(listaTarefas);

                    linha = bufferedReader.readLine();
                }
                for (ModelTarefa i : listaTarefas) {
                    System.out.println(i);
                }

            } else {
                System.out.println("ARQUIVO DE TAREFAS NÃO ENCONTRADO!");
            }
        } catch (IOException error) {
            System.out.println("ERRO AO TENTAR LER O ARQUIVO!");
        }
    } // OK

    public static void lerTarefasOrdemCategoria() {
        File arquivoTxt = new File("tarefas.txt");
        List<ModelTarefaOrdemCategoria> listaTarefas = new ArrayList<>();

        try (FileReader leitorArquivo = new FileReader(arquivoTxt);
             BufferedReader bufferedReader = new BufferedReader(leitorArquivo)
        ) {
            if (arquivoTxt.exists()) {
                System.out.println("TAREFA | CATEGORIA | PRIORIDADE | DATA FINAL | STATUS");
                String linha = bufferedReader.readLine();

                while (linha != null && !linha.isEmpty()) {

                    String[] camposLinha = linha.split(";");
                    String nome = camposLinha[0];
                    String categoria = camposLinha[1];
                    String dataFinal = camposLinha[3];
                    int prioridade = Integer.parseInt(camposLinha[2]);
                    String status = camposLinha[4];

                    listaTarefas.add(new ModelTarefaOrdemCategoria(nome, categoria, dataFinal, prioridade, status));
                    Collections.sort(listaTarefas);

                    linha = bufferedReader.readLine();
                }
                for (ModelTarefa i : listaTarefas) {
                    System.out.println(i);
                }

            } else {
                System.out.println("ARQUIVO DE TAREFAS NÃO ENCONTRADO!");
            }
        } catch (IOException error) {
            System.out.println("ERRO AO TENTAR LER O ARQUIVO!");
        }
    } // OK

    public static void lerTarefasOrdemData() {
        File arquivoTxt = new File("tarefas.txt");
        List<ModelTarefaOrdemData> listaTarefas = new ArrayList<>();

        try (FileReader leitorArquivo = new FileReader(arquivoTxt);
             BufferedReader bufferedReader = new BufferedReader(leitorArquivo)
        ) {
            if (arquivoTxt.exists()) {
                System.out.println("TAREFA | CATEGORIA | PRIORIDADE | DATA FINAL | STATUS");
                String linha = bufferedReader.readLine();

                while (linha != null && !linha.isEmpty()) {

                    String[] camposLinha = linha.split(";");
                    String nome = camposLinha[0];
                    String categoria = camposLinha[1];
                    String dataFinal = camposLinha[3];
                    int prioridade = Integer.parseInt(camposLinha[2]);
                    String status = camposLinha[4];

                    listaTarefas.add(new ModelTarefaOrdemData(nome, categoria, dataFinal, prioridade, status));
                    Collections.sort(listaTarefas);

                    linha = bufferedReader.readLine();
                }
                for (ModelTarefa i : listaTarefas) {
                    System.out.println(i);
                }

            } else {
                System.out.println("ARQUIVO DE TAREFAS NÃO ENCONTRADO!");
            }
        } catch (IOException error) {
            System.out.println("ERRO AO TENTAR LER O ARQUIVO!");
        }
    } // OK

    public static void lerTarefaUnica(String nomeTarefa) {
        File arquivoTxt = new File("tarefas.txt");
        List<ModelTarefa> tarefa = new ArrayList<>();

        try (FileReader leitorArquivo = new FileReader(arquivoTxt);
             BufferedReader bufferedReader = new BufferedReader(leitorArquivo)
        ) {

            if (arquivoTxt.exists()) {
                System.out.println("TAREFA | CATEGORIA | PRIORIDADE | DATA FINAL | STATUS");
                String linha = bufferedReader.readLine();

                while (linha != null && !linha.isEmpty()) {

                    String[] camposLinha = linha.split(";");
                    String nome = camposLinha[0];
                    String categoria = camposLinha[1];
                    String dataFinal = camposLinha[3];
                    int prioridade = Integer.parseInt(camposLinha[2]);
                    String status = camposLinha[4];
                    if (nome.equals(nomeTarefa)) {
                        tarefa.add(new ModelTarefa(nome, categoria, dataFinal, prioridade, status));
                    }

                    linha = bufferedReader.readLine();
                }
                if (tarefa.isEmpty()) {
                    System.out.println("TAREFA NÃO ENCONTRADA, VERIFIQUE O NOME E TENTE NOVAMENTE!");
                } else {
                    for (ModelTarefa i : tarefa) {
                        System.out.println(i);
                    }
                }
            }
        } catch (IOException error) {
            System.out.println("ERRO AO TENTAR LER O ARQUIVO!");
        }
    } // OK

    public static void editaTarefa(String nomeTarefa) {

    }

    public static void deletarTarefa(String nomeTarefa){
        File arquivoTxt = new File("tarefas.txt");
        List<ModelTarefa> listaTarefas = new ArrayList<>();

        try (FileReader leitorArquivo = new FileReader(arquivoTxt);
             BufferedReader bufferedReader = new BufferedReader(leitorArquivo);


        ) {

            if (arquivoTxt.exists()) {
                String linha = bufferedReader.readLine();

                while (linha != null && !linha.isEmpty()) {

                    String[] camposLinha = linha.split(";");
                    String nome = camposLinha[0];
                    String categoria = camposLinha[1];
                    String dataFinal = camposLinha[3];
                    int prioridade = Integer.parseInt(camposLinha[2]);
                    String status = camposLinha[4];

                    if(!nome.equalsIgnoreCase(nomeTarefa)) {
                        listaTarefas.add(new ModelTarefa(nome, categoria, dataFinal, prioridade, status));
                    }

                    linha = bufferedReader.readLine();
                }

                try (FileWriter escreverArquivo = new FileWriter(arquivoTxt, false);
                     BufferedWriter escreveTarefa = new BufferedWriter(escreverArquivo)
                ) {
                    for(int contador = 0; contador < listaTarefas.size(); contador ++) {
                        escreveTarefa.write(listaTarefas.get(contador) + "\n");
                    }
                } catch (IOException error) {
                    System.out.println("ERRO AO TENTAR REGISTRAR TAREFA!");
                }

            } else {
                System.out.println("ARQUIVO DE TAREFAS NÃO ENCONTRADO!");
            }
        } catch (IOException error) {

        }


    } // OK
}
