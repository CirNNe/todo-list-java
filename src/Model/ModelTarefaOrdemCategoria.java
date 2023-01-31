package Model;

import java.time.LocalDateTime;

/**
 * Classe usada para rescrever o método compareTo da classe principal ModelTarefa
 */
public class ModelTarefaOrdemCategoria extends ModelTarefa implements Comparable<ModelTarefa> {

    public ModelTarefaOrdemCategoria(String nome, String categoria, int prioridade, LocalDateTime dataFinal, String status) {
        super(nome, categoria, prioridade, dataFinal, status);
    }

    /**
     * Método compara o objeto categoria dado com o atual
     *
     * @param categoria o objeto que está sendo comparado
     * @return -1 se a categoria atual for maior que a passada, 1 se a categoria atual for menor que a passada, 0 se a categoria atual for igual a passada
     */
    public int compareTo(ModelTarefa categoria) {
        return this.getCategoria().compareToIgnoreCase(categoria.getCategoria());
    }
}
