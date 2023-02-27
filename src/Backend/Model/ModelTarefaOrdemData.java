package Backend.Model;


import java.time.LocalDateTime;

/**
 * Classe usada para rescrever o método compareTo da classe principal ModelTarefa
 */
public class ModelTarefaOrdemData extends ModelTarefa implements Comparable<ModelTarefa> {
    public ModelTarefaOrdemData(String nome, String categoria, int prioridade, LocalDateTime dataFinal, String status) {
        super(nome, categoria, prioridade, dataFinal, status);
    }

    /**
     *Método compara o objeto dataFinal dado com o atual
     *@param dataFinal o objeto que está sendo comparado
     *@return -1 se a dataFinal atual for maior que a passada, 1 se a dataFinal atual for menor que a passada, 0 se a dataFinal atual for igual a passada
     */
    @Override
    public int compareTo(ModelTarefa dataFinal) {
        return this.getDataFinal().compareTo(dataFinal.getDataFinal());
    }
}
