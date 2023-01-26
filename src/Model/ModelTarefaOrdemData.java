package Model;

public class ModelTarefaOrdemData extends ModelTarefa implements Comparable<ModelTarefa> {
    public ModelTarefaOrdemData(String nome, String categoria, int prioridade, String dataTermino, String status) {
        super(nome, categoria, prioridade, dataTermino, status);
    }

    @Override
    public int compareTo(ModelTarefa dataFinal) {
        return this.getDataTermino().compareToIgnoreCase(dataFinal.getDataTermino());
    }
}
