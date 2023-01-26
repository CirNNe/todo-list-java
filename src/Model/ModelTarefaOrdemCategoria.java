package Model;

public class ModelTarefaOrdemCategoria extends ModelTarefa implements Comparable<ModelTarefa> {

    public ModelTarefaOrdemCategoria(String nome, String categoria, int prioridade, String dataTermino, String status) {
        super(nome, categoria, prioridade, dataTermino, status);
    }

    @Override
    public int compareTo(ModelTarefa categoria) {
        return String.valueOf(this.getCategoria()).compareToIgnoreCase(String.valueOf(categoria.getCategoria()));
    }
}
