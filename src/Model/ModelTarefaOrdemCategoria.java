package Model;

public class ModelTarefaOrdemCategoria extends ModelTarefa implements Comparable<ModelTarefa> {

    public ModelTarefaOrdemCategoria(String nome, String categoria, String dataTermino, int prioridade, String status) {
        super(nome, categoria, dataTermino, prioridade, status);
    }

    @Override
    public int compareTo(ModelTarefa categoria) {
        return String.valueOf(this.getCategoria()).compareToIgnoreCase(String.valueOf(categoria.getCategoria()));
    }
}
