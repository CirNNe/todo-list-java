package Backend.Controller;

import Backend.Model.ModelAlerta;
import Backend.Model.ModelTarefa;
import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static java.lang.Integer.parseInt;

/**
 * Classe de controle dos alertas
 * criaAlertaTarefa: cria um alerta para uma tarefa desejada
 * mostraAlerta: ativa o alarme da tarefa mostrando no terminal
 * deletaAlerta: apaga um alerta desejado
 */
public class ControllerAlerta {

    /**
     * Método que cria um alarme para uma tarefa
     * Poderá ser definido mais de um alarme por tarefa
     * @param nomeTarefa nome da tarefa que se deseja definir o alarme
     * @param dataAlarme data em que o alarme será ativado no terminal (dd/MM/yyyy)
     * @param horaAlarme hora em que o alarme será ativado no terminal (HH:mm)
     */
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

    /**
     * Método que retorna um print no terminal dos alertas ativados
     * Se o alarme definido pelo usuário estiver igual a hora atual ou a hora atual estiver a frente do alarme, será printado no terminal
     */
    public static void mostraAlerta(){
        File arquivoAlertasTxt = new File("alertas.txt");
        List<ModelAlerta> alertas = new ArrayList<>();

        try (FileReader leitorArquivo = new FileReader(arquivoAlertasTxt);
             BufferedReader bufferedReader = new BufferedReader(leitorArquivo)
        ) {

            if (arquivoAlertasTxt.exists()) {
                String linha = bufferedReader.readLine();

                while (linha != null && !linha.isEmpty()) {

                    String[] camposLinha = linha.split("  -  ");
                    String nome = camposLinha[0];
                    String categoria = camposLinha[1];
                    int prioridade = parseInt(camposLinha[2]);
                    LocalDateTime dataFinal = LocalDateTime.parse(camposLinha[3]);
                    String status = camposLinha[4];
                    LocalDateTime alerta = LocalDateTime.parse(camposLinha[5]);

                    if(alerta.equals(LocalDateTime.now()) || LocalDateTime.now().isAfter(alerta)) {
                        alertas.add(new ModelAlerta(nome, categoria, prioridade, dataFinal, status, alerta));
                        Collections.sort(alertas);
                    }



                    linha = bufferedReader.readLine();
                }

                System.out.println("---- ALERTAS ----");
                if(alertas.isEmpty()) {

                    System.out.println("NÃO HÁ ALERTAS ATIVOS NO MOMENTO");
                } else {
                    for(ModelTarefa alerta : alertas) {
                        System.out.println(alerta);
                    }
                }

            } else {
                System.out.println("LISTA DE ALERTAS VAZIO");
            }
        } catch (IOException error) {
            System.out.println("ERRO AO TENTAR LER O ARQUIVO!");
        }
    }

    /**
     * Método para excluir um alerta específico ou mais de um com o mesmo nome
     * @param nomeTarefa nome da tarefa que deseja excluir o alarme
     */
    public static void deletaAlerta(String nomeTarefa) {
        File arquivoAlertasTxt = new File("alertas.txt");
        List<ModelAlerta> alertas = new ArrayList<>();

        try (FileReader leitorArquivo = new FileReader(arquivoAlertasTxt);
             BufferedReader bufferedReader = new BufferedReader(leitorArquivo)
        ) {

            if (arquivoAlertasTxt.exists()) {
                String linha = bufferedReader.readLine();

                while (linha != null && !linha.isEmpty()) {

                    String[] camposLinha = linha.split("  -  ");
                    String nome = camposLinha[0];
                    String categoria = camposLinha[1];
                    int prioridade = parseInt(camposLinha[2]);
                    LocalDateTime dataFinal = LocalDateTime.parse(camposLinha[3]);
                    String status = camposLinha[4];
                    LocalDateTime alerta = LocalDateTime.parse(camposLinha[5]);

                    if (!nome.equalsIgnoreCase(nomeTarefa)) {
                        alertas.add(new ModelAlerta(nome, categoria, prioridade, dataFinal, status, alerta));
                    }

                    linha = bufferedReader.readLine();
                }
            }
        } catch (IOException error) {
            System.out.println("ERRO AO TENTAR LER O ARQUIVO!");
        }

        try (FileWriter escreverArquivo = new FileWriter(arquivoAlertasTxt, false);
             BufferedWriter escreveTarefa = new BufferedWriter(escreverArquivo)
        ) {
            for (int contador = 0; contador < alertas.size(); contador++) {
                escreveTarefa.write(alertas.get(contador).getNome() + "  -  " + alertas.get(contador).getCategoria() +
                        "  -  " + alertas.get(contador).getPrioridade() + "  -  " + alertas.get(contador).getDataFinal() +
                        "  -  " + alertas.get(contador).getStatus() + "  -  " + alertas.get(contador).getAlerta() + "\n");
            }
        } catch (IOException error) {
            System.out.println("ERRO AO TENTAR REGISTRAR TAREFA!");
        }
    }
}
