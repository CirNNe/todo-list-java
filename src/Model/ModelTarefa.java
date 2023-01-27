package Model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * Classe que define uma tarefa
 */
public class ModelTarefa implements Comparable<ModelTarefa> {
    private String nome;
    private String categoria;
    private int prioridade;
    private int diaParaFinalizar;
    private int mesParaFinalizar;
    private int anoParaFinalizar;
    private LocalDate dataFinal;
    private String status;

    public ModelTarefa(){}

    public ModelTarefa(String nome, String categoria, int prioridade, LocalDate dataFinal, String status) {
        this.nome = nome;
        this.categoria = categoria;
        this.dataFinal = dataFinal;
        this.prioridade = prioridade;
        this.status = status;
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

    public int getDiaParaFinalizar() {
        return diaParaFinalizar;
    }

    public void setDiaParaFinalizar(int diaParaFinalizar) {
        this.diaParaFinalizar = diaParaFinalizar;
    }

    public int getMesParaFinalizar() {
        return mesParaFinalizar;
    }

    public void setMesParaFinalizar(int mesParaFinalizar) {
        this.mesParaFinalizar = mesParaFinalizar;
    }

    public int getAnoParaFinalizar() {
        return anoParaFinalizar;
    }

    public void setAnoParaFinalizar(int anoParaFinalizar) {
        this.anoParaFinalizar = anoParaFinalizar;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(LocalDate dataFinal) {
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



    @Override
    public String toString() {
        return nome + "  -  " +
                categoria + "  -  " +
                prioridade + "  -  " +
                dataFinal.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)) + "  -  " +
                status;
    }

    /**
     * Método compara o objeto prioridade dado com o atual
     * @param prioridade o objeto que está sendo comparado
     * @return -1 se a prioridade atual for maior que a passada, 1 se a prioridade atual for menor que a passada, 0 se a prioridade atual for igual a passada
     */
    @Override
    public int compareTo(ModelTarefa prioridade) {
        if(this.getPrioridade() > prioridade.getPrioridade()) {
            return -1;
        } if(this.getPrioridade() < prioridade.getPrioridade()) {
            return 1;
        }
        return 0;
    }
}
