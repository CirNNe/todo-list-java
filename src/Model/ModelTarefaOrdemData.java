package Model;

public class ModelTarefaOrdemData extends ModelTarefa implements Comparable<ModelTarefa> {
    public ModelTarefaOrdemData(String nome, String categoria, String dataTermino, int prioridade, String status) {
        super(nome, categoria, dataTermino, prioridade, status);
    }

    @Override
    public int compareTo(ModelTarefa dataFinal) {
        return String.valueOf(this.getDataTermino()).compareToIgnoreCase(String.valueOf(dataFinal.getDataTermino()));
    }
}
