package Controller;

import Model.ModelTarefa;
import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.Integer.parseInt;

public class ControllerAlerta {

    public static void criaAlertaTarefa(String nomeTarefa, String dataAlarme, String horaAlarme) {

        File arquivoTarefasTxt = new File("tarefas.txt");
        File arquivoAlertasTxt = new File("alertas.txt");

        List<ModelTarefa> tarefaAlerta = new ArrayList<>();
        ModelTarefa tarefa = new ModelTarefa();


        try (FileReader leitorArquivo = new FileReader(arquivoTarefasTxt);
             BufferedReader bufferedReader = new BufferedReader(leitorArquivo)
        ) {

            if (arquivoTarefasTxt.exists()) {
                String linha = bufferedReader.readLine();

                while (linha != null && !linha.isEmpty()) {

                    String[] camposLinha = linha.split("  -  ");
                    String nome = camposLinha[0];
                    String categoria = camposLinha[1];
                    int prioridade = parseInt(camposLinha[2]);
                    LocalDateTime dataFinal = LocalDateTime.parse(camposLinha[3]);
                    String status = camposLinha[4];

                    if (nome.equalsIgnoreCase(nomeTarefa)) {
                        tarefaAlerta.add(new ModelTarefa(nome, categoria, prioridade, dataFinal, status));
                        Collections.sort(tarefaAlerta);
                    }

                    linha = bufferedReader.readLine();
                }
            }
        } catch (IOException error) {
            System.out.println("ERRO AO TENTAR LER O ARQUIVO!");
        }

        if(tarefaAlerta.isEmpty()) {
            System.out.println("NÃO FOI POSSÍVEL ENCONTRAR A TAREFA, VERIFIQUE O NOME NOVAMENTE!");
        } else {
            String[] camposDataAlarme = dataAlarme.split("/");
            int dia = Integer.parseInt(camposDataAlarme[0]);
            int mes = Integer.parseInt(camposDataAlarme[1]);
            int ano = Integer.parseInt(camposDataAlarme[2]);

            String[] camposHoraAlarme = horaAlarme.split(":");
            int hora = Integer.parseInt(camposHoraAlarme[0]);
            int minuto = Integer.parseInt(camposHoraAlarme[1]);

            LocalDateTime defineAlerta = LocalDateTime.of(ano, mes, dia, hora, minuto);

            tarefa.setAlerta(defineAlerta);

            try (FileWriter escreverArquivo = new FileWriter(arquivoAlertasTxt, true);
                 BufferedWriter escreveTarefa = new BufferedWriter(escreverArquivo)
            ) {
                for (int contador = 0; contador < tarefaAlerta.size(); contador++) {
                    escreveTarefa.write(tarefaAlerta.get(contador).getNome() + "  -  " + tarefaAlerta.get(contador).getCategoria() +
                            "  -  " + tarefaAlerta.get(contador).getPrioridade() + "  -  " + tarefaAlerta.get(contador).getDataFinal() +
                            "  -  " + tarefaAlerta.get(contador).getStatus() + "  -  " + tarefa.getAlerta() + "\n");
                }
            } catch (IOException error) {
                System.out.println("ERRO AO TENTAR REGISTRAR TAREFA!");
            }
        }
    }
}
