package Backend.Model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Classe que define uma tarefa
 */
public class ModelTarefa implements Comparable<ModelTarefa> {
    private String nome;
    private String categoria;
    private int prioridade;
    private LocalDateTime dataFinal;
    private String status;
    private LocalDateTime alerta;

    public ModelTarefa(){}

    public ModelTarefa(String nome, String categoria, int prioridade, LocalDateTime dataFinal, String status) {
        this.nome = nome;
        this.categoria = categoria;
        this.dataFinal = dataFinal;
        this.prioridade = prioridade;
        this.status = status;
    }

    public ModelTarefa(String nome, String categoria, int prioridade, LocalDateTime dataFinal, String status, LocalDateTime alerta) {
        this.nome = nome;
        this.categoria = categoria;
        this.dataFinal = dataFinal;
        this.prioridade = prioridade;
        this.status = status;
        this.alerta = alerta;
    }

    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public LocalDateTime getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(LocalDateTime dataFinal) {
        this.dataFinal = dataFinal;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getAlerta() {
        return alerta;
    }

    public void setAlerta(LocalDateTime alerta) {
        this.alerta = alerta;
    }

    @Override
    public String toString() {
        return nome + "  -  " +
                categoria + "  -  " +
                prioridade + "  -  " +
                dataFinal.format(DateTimeFormatter.ofPattern("dd/MM/yy HH:mm")) + "  -  " +
                status;
    }

    @Override
    public int compareTo(ModelTarefa prioridade) {
        if (this.getPrioridade() < prioridade.getPrioridade()) {
            return 1;
        }
        if (this.getPrioridade() > prioridade.getPrioridade()) {
            return -1;
        }
        return 0;
    }
}
