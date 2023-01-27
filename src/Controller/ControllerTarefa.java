package Controller;

import Model.*;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.*;

import static java.lang.Integer.parseInt;

public class ControllerTarefa {

    /**
     * Método para adicionar uma tarefa no arquivo.txt
     * @param tarefa que será adicionada no arquivo
     */
    public static void adicionarTarefa(ModelTarefa tarefa) {
        File arquivoTxt = new File("tarefas.txt");
        try (FileWriter escreverArquivo = new FileWriter(arquivoTxt, true);
             BufferedWriter escreveTarefa = new BufferedWriter(escreverArquivo)) {
            if (arquivoTxt.exists()) {

                escreveTarefa.write(/*tarefa.getNome() + "  -  " + tarefa.getCategoria() + "  -  " +
                        tarefa.getPrioridade() + "  -  " + tarefa.getDataFinal() +
                        "  -  " + tarefa.getStatus()*/tarefa.toString() + "\n");
            } else {
                arquivoTxt.createNewFile();
                escreveTarefa.write(tarefa.getNome() + "  -  " + tarefa.getCategoria() + "  -  " +
                        tarefa.getPrioridade() + "  -  " + tarefa.getDataFinal() +
                        "  -  " + tarefa.getStatus() + "\n");
            }
        } catch (Exception error) {
            System.out.println("ERRO AO TENTAR REGISTRAR TAREFA!");
        }
    }

    /**
     * Método mostra ao usuário as tarefas salvas em ordem de prioridade
     */
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

                    String[] camposLinha = linha.split("  -  ");
                    String nome = camposLinha[0];
                    String categoria = camposLinha[1];
                    int prioridade = parseInt(camposLinha[2]);

                    String[] campoDataFinal = camposLinha[3].split("/");
                    int dia = parseInt(campoDataFinal[0]);
                    int mes = parseInt(campoDataFinal[1]);
                    int ano = parseInt(campoDataFinal[2]);
                    LocalDate dataFinal = LocalDate.of(ano, mes, dia);

                    String status = camposLinha[4];

                    listaTarefas.add(new ModelTarefa(nome, categoria, prioridade, dataFinal, status));
                    Collections.sort(listaTarefas);

                    linha = bufferedReader.readLine();
                }

                if(listaTarefas.isEmpty()) {
                    System.out.println("NÃO HÁ TAREFAS PARA VISUALIZAR, COMECE ADICIONANDO ALGUMAS NA LISTA!");
                } else {
                    for (ModelTarefa i : listaTarefas) {
                        System.out.println(i);
                    }
                }

            } else {
                System.out.println("ARQUIVO DE TAREFAS NÃO ENCONTRADO!");
            }
        } catch (IOException error) {
            System.out.println("ERRO AO TENTAR LER O ARQUIVO!");
        }
    }

    /**
     * Método mostra ao usuário as tarefas salvas em ordem alfabética por categoria
     */
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

                    String[] camposLinha = linha.split("  -  ");
                    String nome = camposLinha[0];
                    String categoria = camposLinha[1];
                    int prioridade = parseInt(camposLinha[2]);

                    String[] campoDataFinal = camposLinha[3].split("/");
                    int dia = parseInt(campoDataFinal[0]);
                    int mes = parseInt(campoDataFinal[1]);
                    int ano = parseInt(campoDataFinal[2]);
                    LocalDate dataFinal = LocalDate.of(ano, mes, dia);

                    String status = camposLinha[4];

                    listaTarefas.add(new ModelTarefaOrdemCategoria(nome, categoria,  prioridade, dataFinal, status));
                    Collections.sort(listaTarefas);

                    linha = bufferedReader.readLine();
                }

                if(listaTarefas.isEmpty()) {
                    System.out.println("NÃO HÁ TAREFAS PARA VISUALIZAR, COMECE ADICIONANDO ALGUMAS NA LISTA!");
                } else {
                    for (ModelTarefa i : listaTarefas) {
                        System.out.println(i);
                    }
                }

            } else {
                System.out.println("ARQUIVO DE TAREFAS NÃO ENCONTRADO!");
            }
        } catch (IOException error) {
            System.out.println("ERRO AO TENTAR LER O ARQUIVO!");
        }
    }

    /**
     * Método mostra ao usuário as tarefas salvas em ordem por data
     */
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

                    String[] camposLinha = linha.split("  -  ");
                    String nome = camposLinha[0];
                    String categoria = camposLinha[1];
                    int prioridade = parseInt(camposLinha[2]);

                    String[] campoDataFinal = camposLinha[3].split("/");
                    int dia = parseInt(campoDataFinal[0]);
                    int mes = parseInt(campoDataFinal[1]);
                    int ano = parseInt(campoDataFinal[2]);
                    LocalDate dataFinal = LocalDate.of(ano, mes, dia);

                    String status = camposLinha[4];

                    listaTarefas.add(new ModelTarefaOrdemData(nome, categoria, prioridade, dataFinal, status));
                    Collections.sort(listaTarefas);

                    linha = bufferedReader.readLine();
                }
                if(listaTarefas.isEmpty()) {
                    System.out.println("NÃO HÁ TAREFAS PARA VISUALIZAR, COMECE ADICIONANDO ALGUMAS NA LISTA!");
                } else {
                    for (ModelTarefa i : listaTarefas) {
                        System.out.println(i);
                    }
                }

            } else {
                System.out.println("ARQUIVO DE TAREFAS NÃO ENCONTRADO!");
            }
        } catch (IOException error) {
            System.out.println("ERRO AO TENTAR LER O ARQUIVO!");
        }
    }

    /**
     * Método mostra ao usuário uma ou mais de uma tarefa referente ao nome que for passado
     * @param nomeTarefa que o usuário deseja visualizar
     */
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

                    String[] camposLinha = linha.split("  -  ");
                    String nome = camposLinha[0];
                    String categoria = camposLinha[1];
                    int prioridade = parseInt(camposLinha[2]);

                    String[] campoDataFinal = camposLinha[3].split("/");
                    int dia = parseInt(campoDataFinal[0]);
                    int mes = parseInt(campoDataFinal[1]);
                    int ano = parseInt(campoDataFinal[2]);
                    LocalDate dataFinal = LocalDate.of(ano, mes, dia);

                    String status = camposLinha[4];

                    if (nome.equalsIgnoreCase(nomeTarefa)) {
                        tarefa.add(new ModelTarefa(nome, categoria, prioridade, dataFinal, status));
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
    }

    /**
     * Método edita uma ou mais tarefas
     * @param nomeTarefaEditar que será editada
     * @param novoNome
     * @param novaCategoria
     * @param novaPrioridade
     * @param novoStatus
     */
    public static void editaTarefa(String nomeTarefaEditar, String novoNome, String novaCategoria, int novaPrioridade, int novoDia, int novoMes, int novoAno, String novoStatus) {
        File arquivoTxt = new File("tarefas.txt");
        List<ModelTarefa> listaTarefas = new ArrayList<>();
        ModelTarefa tarefaEditada = new ModelTarefa();
        ModelTarefa setDataFinal = new ModelTarefa();

        try (FileReader leitorArquivo = new FileReader(arquivoTxt);
             BufferedReader bufferedReader = new BufferedReader(leitorArquivo);
        ) {
            if (arquivoTxt.exists()) {
                String linha = bufferedReader.readLine();

                while (linha != null && !linha.isEmpty()) {

                    String[] camposLinha = linha.split("  -  ");
                    String nome = camposLinha[0];
                    String categoria = camposLinha[1];
                    int prioridade = parseInt(camposLinha[2]);

                    String[] campoDataFinal = camposLinha[3].split("/");
                    int dia = parseInt(campoDataFinal[0]);
                    int mes = parseInt(campoDataFinal[1]);
                    int ano = parseInt(campoDataFinal[2]);
                    LocalDate dataFinal = LocalDate.of(ano, mes, dia);

                    String status = camposLinha[4];

                    if (!nome.equalsIgnoreCase(nomeTarefaEditar)) {
                        listaTarefas.add(new ModelTarefa(nome, categoria, prioridade, dataFinal, status));
                    }
                    linha = bufferedReader.readLine();
                }

                setDataFinal.setAnoParaFinalizar(novoAno);
                setDataFinal.setMesParaFinalizar(novoMes);
                setDataFinal.setDiaParaFinalizar(novoDia);
                LocalDate dataFinal = LocalDate.of(novoAno, novoMes, novoDia);

                tarefaEditada.setNome(novoNome);
                tarefaEditada.setCategoria(novaCategoria);
                tarefaEditada.setPrioridade(novaPrioridade);
                tarefaEditada.setDataFinal(dataFinal);
                tarefaEditada.setStatus(novoStatus);

                listaTarefas.add(tarefaEditada);

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
            System.out.println("ERRO AO TENTAR LER O ARQUIVO!");
        }
    }

    /**
     * Método deleta uma ou mais tarefas do arquivo.txt
     * @param nomeTarefa a ser deletada
     */
    public static void deletarTarefa(String nomeTarefa){
        File arquivoTxt = new File("tarefas.txt");
        List<ModelTarefa> listaTarefas = new ArrayList<>();

        try (FileReader leitorArquivo = new FileReader(arquivoTxt);
             BufferedReader bufferedReader = new BufferedReader(leitorArquivo);
        ) {
            if (arquivoTxt.exists()) {
                String linha = bufferedReader.readLine();

                while (linha != null && !linha.isEmpty()) {

                    String[] camposLinha = linha.split("  -  ");
                    String nome = camposLinha[0];
                    String categoria = camposLinha[1];
                    int prioridade = parseInt(camposLinha[2]);

                    String[] campoDataFinal = camposLinha[3].split("/");
                    int dia = parseInt(campoDataFinal[0]);
                    int mes = parseInt(campoDataFinal[1]);
                    int ano = parseInt(campoDataFinal[2]);
                    LocalDate dataFinal = LocalDate.of(ano, mes, dia);

                    String status = camposLinha[4];

                    if(!nome.equalsIgnoreCase(nomeTarefa)) {
                        listaTarefas.add(new ModelTarefa(nome, categoria, prioridade, dataFinal, status));
                    }

                    linha = bufferedReader.readLine();
                }

                try (FileWriter escreverArquivo = new FileWriter(arquivoTxt, false);
                     BufferedWriter escreveTarefa = new BufferedWriter(escreverArquivo)
                ) {
                    for(int contador = 0; contador < listaTarefas.size(); contador ++) {
                        escreveTarefa.write(listaTarefas.get(contador) + "\n");
                    }
                    if(!listaTarefas.contains(nomeTarefa)) {
                        System.out.println("TAREFA DELETADA COM SUCESSO!");
                    }
                } catch (IOException error) {
                    System.out.println("ERRO AO TENTAR REGISTRAR TAREFA!");
                }
            } else {
                System.out.println("ARQUIVO DE TAREFAS NÃO ENCONTRADO!");
            }
        } catch (IOException error) {
            System.out.println("ERRO AO TENTAR LER O ARQUIVO!");
        }
    }
}
