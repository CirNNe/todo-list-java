package Controller;

import Model.*;
import com.azul.tooling.in.Model;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class ControllerTarefa {
    public static void adicionarTarefa(ModelTarefa tarefa) {

        File arquivoTxt = new File("tarefas.txt");
        try (FileWriter escreverArquivo = new FileWriter(arquivoTxt, true);
             BufferedWriter escreveTarefa = new BufferedWriter(escreverArquivo)){
            if(arquivoTxt.exists()){
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
    }

    public static void lerTarefas() {
        File arquivoTxt = new File("tarefas.txt");
        List<ModelTarefa> listaTarefas = new ArrayList<>();



        try (FileReader leitorArquivo = new FileReader(arquivoTxt);
            BufferedReader bufferedReader = new BufferedReader(leitorArquivo)
            ) {
                if(arquivoTxt.exists()){
                    System.out.println("TAREFA | CATEGORIA | PRIORIDADE | DATA FINAL | STATUS");
                    String linha = bufferedReader.readLine();

                    while(linha != null && !linha.isEmpty()) {

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
                    for(ModelTarefa i : listaTarefas) {
                        System.out.println(i);
                    }

                } else {
                    System.out.println("ARQUIVO DE TAREFAS NÃO ENCONTRADO!");
                }
            } catch (IOException error) {
                System.out.println("ERRO AO TENTAR LER O ARQUIVO!");
        }
    }

    public static void lerTarefaUnica(String nomeTarefa) {
        File arquivoTxt = new File("tarefas.txt");
        List<ModelTarefa> tarefa = new ArrayList<>();

        try (FileReader leitorArquivo = new FileReader(arquivoTxt);
            BufferedReader bufferedReader = new BufferedReader(leitorArquivo)
            ) {

            if(arquivoTxt.exists()) {
                System.out.println("TAREFA | CATEGORIA | PRIORIDADE | DATA FINAL | STATUS");
                String linha = bufferedReader.readLine();

                while(linha != null && !linha.isEmpty()) {

                    String[] camposLinha = linha.split(";");
                    String nome = camposLinha[0];
                    String categoria = camposLinha[1];
                    String dataFinal = camposLinha[3];
                    int prioridade = Integer.parseInt(camposLinha[2]);
                    String status = camposLinha[4];
                    if(nome.equals(nomeTarefa)) {
                        tarefa.add(new ModelTarefa(nome, categoria, dataFinal, prioridade, status));
                    }

                    linha = bufferedReader.readLine();
                }
                if(tarefa.isEmpty()) {
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

    public static void deletarTarefa() {
        Path arquivoTxt = Paths.get("/home/tarefas.txt");
        if(Files.exists(arquivoTxt)) {
            // filtra o arquivo pela tarefa e apaga ela
        } else {
            // retorna que o arquivo não existe
        }
    }
}
