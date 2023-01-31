package Controller;

import Model.*;
import com.sun.org.apache.xpath.internal.operations.Mod;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;
import static java.lang.Integer.parseInt;

public class ControllerTarefa {

    /**
     * Método para adicionar uma tarefa no arquivo.txt
     * Recebe os parâmetros de uma tarefa
     * @param nome nome da tarefa
     * @param categoria categoria da tarefa
     * @param prioridade prioridade da tarefa (1-5)
     * @param data data final da entrega da tarefa
     * @param horario horario final da entrega da tarefa
     * @param status status atual da tarefa (fazer, fazendo, feito)
     */
    public static void adicionarTarefa(String nome, String categoria, int prioridade, String data, String horario, String status) {
        ModelTarefa tarefa = new ModelTarefa();

        String[] camposData = data.split("/");
        int dia = Integer.parseInt(camposData[0]);
        int mes = Integer.parseInt(camposData[1]);
        int ano = Integer.parseInt(camposData[2]);

        String[] camposHorario = horario.split(":");
        int hora = Integer.parseInt(camposHorario[0]);
        int minuto = Integer.parseInt(camposHorario[1]);

        LocalDateTime dataFinal = LocalDateTime.of(ano, mes, dia, hora, minuto);

        tarefa.setNome(nome);
        tarefa.setCategoria(categoria);
        tarefa.setPrioridade(prioridade);
        tarefa.setDataFinal(dataFinal);
        tarefa.setStatus(status);

        File arquivoTxt = new File("tarefas.txt");

        try (FileWriter escreverArquivo = new FileWriter(arquivoTxt, true);
             BufferedWriter escreveTarefa = new BufferedWriter(escreverArquivo)) {

            escreveTarefa.write(tarefa.getNome() + "  -  " + tarefa.getCategoria() + "  -  " +
                        tarefa.getPrioridade() + "  -  " + tarefa.getDataFinal() +
                        "  -  " + tarefa.getStatus() + "\n");

        } catch (Exception error) {
            System.out.println("ERRO AO TENTAR REGISTRAR TAREFA!");
        }
    }

    /**
     * Método mostra ao usuário as tarefas salvas em ordem de prioridade, categoria ou data
     * @param opcaoDeOrdenacao 1 para ordenar por prioridade, 2 para ordenar por categoria e 3 para ordenar por data de entrega
     */
    public static void lerTarefas(int opcaoDeOrdenacao) {
        File arquivoTxt = new File("tarefas.txt");

        List<ModelTarefa> listaTarefasOrdemPrioridade = new ArrayList<>();
        List<ModelTarefaOrdemCategoria> listaTarefasOrdemCategoria = new ArrayList<>();
        List<ModelTarefaOrdemData> listaTarefasOrdemData = new ArrayList<>();

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
                    LocalDateTime dataFinal = LocalDateTime.parse(camposLinha[3]);
                    String status = camposLinha[4];

                    if(opcaoDeOrdenacao == 1) {
                        listaTarefasOrdemPrioridade.add(new ModelTarefa(nome, categoria, prioridade, dataFinal, status));
                        Collections.sort(listaTarefasOrdemPrioridade);
                    } else if (opcaoDeOrdenacao == 2) {
                        listaTarefasOrdemCategoria.add(new ModelTarefaOrdemCategoria(nome, categoria, prioridade, dataFinal, status));
                        Collections.sort(listaTarefasOrdemCategoria);
                    } else if (opcaoDeOrdenacao == 3) {
                        listaTarefasOrdemData.add(new ModelTarefaOrdemData(nome, categoria, prioridade, dataFinal, status));
                        Collections.sort(listaTarefasOrdemData);
                    }

                    linha = bufferedReader.readLine();
                }
                if(opcaoDeOrdenacao == 1) {
                    if(listaTarefasOrdemPrioridade.isEmpty()) {
                        System.out.println("NÃO HÁ TAREFAS PARA VISUALIZAR, COMECE ADICIONANDO ALGUMAS NA LISTA!");
                    } else {
                        for (ModelTarefa i : listaTarefasOrdemPrioridade) {
                            System.out.println(i);
                        }
                    }
                } else if (opcaoDeOrdenacao == 2) {
                    if(listaTarefasOrdemCategoria.isEmpty()) {
                        System.out.println("NÃO HÁ TAREFAS PARA VISUALIZAR, COMECE ADICIONANDO ALGUMAS NA LISTA!");
                    } else {
                        Collections.sort(listaTarefasOrdemCategoria);
                        for (ModelTarefaOrdemCategoria i : listaTarefasOrdemCategoria) {
                            System.out.println(i);
                        }
                    }
                } else if (opcaoDeOrdenacao == 3) {
                    if(listaTarefasOrdemData.isEmpty()) {
                        System.out.println("NÃO HÁ TAREFAS PARA VISUALIZAR, COMECE ADICIONANDO ALGUMAS NA LISTA!");
                    } else {
                        for (ModelTarefa i : listaTarefasOrdemData) {
                            System.out.println(i);
                        }
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
                    LocalDateTime dataFinal = LocalDateTime.parse(camposLinha[3]);
                    String status = camposLinha[4];

                    if (nome.equalsIgnoreCase(nomeTarefa)) {
                        tarefa.add(new ModelTarefa(nome, categoria, prioridade, dataFinal, status));
                        Collections.sort(tarefa);
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
     * @param novoNome novo nome da tarefa editada
     * @param novaCategoria nova categoria da tarefa editada
     * @param novaPrioridade nova prioridade da tarefa editada
     * @param novoStatus novo status da tarefa editada
     */
    public static void editaTarefa(String nomeTarefaEditar, String novoNome, String novaCategoria, int novaPrioridade, String novaData, String novoHorario, String novoStatus) {
        File arquivoTxt = new File("tarefas.txt");

        List<ModelTarefa> listaTarefas = new ArrayList<>();
        List<ModelTarefa> listaTarefasEditar = new ArrayList<>();
        ModelTarefa tarefaEditada = new ModelTarefa();

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
                    LocalDateTime dataFinal = LocalDateTime.parse(camposLinha[3]);
                    String status = camposLinha[4];

                    if (!nome.equalsIgnoreCase(nomeTarefaEditar)) {
                        listaTarefas.add(new ModelTarefa(nome, categoria, prioridade, dataFinal, status));
                    }
                    if (nome.equalsIgnoreCase(nomeTarefaEditar)) {
                        listaTarefasEditar.add(new ModelTarefa(nome, categoria, prioridade, dataFinal, status));
                    }
                    linha = bufferedReader.readLine();
                }
            } else {
                System.out.println("ARQUIVO DE TAREFAS NÃO ENCONTRADO!");
            }
        } catch (IOException error) {
            System.out.println("ERRO AO TENTAR LER O ARQUIVO!");
        }
        if (listaTarefasEditar.isEmpty()) {
            System.out.println("TAREFA NÃO ENCONTRADA!");
        } else {
            String[] camposData = novaData.split("/");
            int dia = Integer.parseInt(camposData[0]);
            int mes = Integer.parseInt(camposData[1]);
            int ano = Integer.parseInt(camposData[2]);

            String[] camposHorario = novoHorario.split(":");
            int hora = Integer.parseInt(camposHorario[0]);
            int minuto = Integer.parseInt(camposHorario[1]);

            LocalDateTime dataFinal = LocalDateTime.of(ano, mes, dia, hora, minuto);

            tarefaEditada.setNome(novoNome);
            tarefaEditada.setCategoria(novaCategoria);
            tarefaEditada.setPrioridade(novaPrioridade);
            tarefaEditada.setDataFinal(dataFinal);
            tarefaEditada.setStatus(novoStatus);

            listaTarefas.add(tarefaEditada);

            try (FileWriter escreverArquivo = new FileWriter(arquivoTxt, false);
                 BufferedWriter escreveTarefa = new BufferedWriter(escreverArquivo)
            ) {
                for (int contador = 0; contador < listaTarefas.size(); contador++) {
                    escreveTarefa.write(listaTarefas.get(contador).getNome() + "  -  " + listaTarefas.get(contador).getCategoria() +
                            "  -  " + listaTarefas.get(contador).getPrioridade() + "  -  " + listaTarefas.get(contador).getDataFinal() +
                            "  -  " + listaTarefas.get(contador).getStatus() + "\n");
                }
            } catch (IOException error) {
                System.out.println("ERRO AO TENTAR REGISTRAR TAREFA!");
            }
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
                    LocalDateTime dataFinal = LocalDateTime.parse(camposLinha[3]);
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
                        escreveTarefa.write(listaTarefas.get(contador).getNome() + "  -  " + listaTarefas.get(contador).getCategoria() +
                                "  -  " + listaTarefas.get(contador).getPrioridade() + "  -  " + listaTarefas.get(contador).getDataFinal() +
                                "  -  " + listaTarefas.get(contador).getStatus() + "\n");
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
