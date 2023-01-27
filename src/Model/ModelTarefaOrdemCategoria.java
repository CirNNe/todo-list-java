package Model;

import java.time.LocalDate;

/**
 * Classe usada para rescrever o método compareTo da classe principal ModelTarefa
 */
public class ModelTarefaOrdemCategoria extends ModelTarefa implements Comparable<ModelTarefa> {

    public ModelTarefaOrdemCategoria(String nome, String categoria, int prioridade, LocalDate dataFinal, String status) {
        super(nome, categoria, prioridade, dataFinal, status);
    }

    /**
     *Método compara o objeto categoria dado com o atual
     *@param categoria o objeto que está sendo comparado
     *@return -1 se a categoria atual for maior que a passada, 1 se a categoria atual for menor que a passada, 0 se a categoria atual for igual a passada
     */
    @Override
    public int compareTo(ModelTarefa categoria) {
        return String.valueOf(this.getCategoria()).compareToIgnoreCase(String.valueOf(categoria.getCategoria()));
    }
}
