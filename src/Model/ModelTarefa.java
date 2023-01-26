package Model;

public class ModelTarefa implements Comparable<ModelTarefa> {
    private String nome;
    private String categoria;
    private int prioridade;
    private String dataTermino;
    private String status;

    public ModelTarefa(){}

    public ModelTarefa(String nome, String categoria, int prioridade, String dataTermino, String status) {
        this.nome = nome;
        this.categoria = categoria;
        this.dataTermino = dataTermino;
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

    public String getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(String dataTermino) {
        this.dataTermino = dataTermino;
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
                dataTermino + "  -  " +
                status;
    }

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
