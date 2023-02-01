package Model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Classe que define um alerta
 */
public class ModelAlerta extends ModelTarefa{

    public ModelAlerta(String nome, String categoria, int prioridade, LocalDateTime dataFinal, String status, LocalDateTime alerta) {
        super(nome, categoria, prioridade, dataFinal, status, alerta);
    }

    @Override
    public String toString() {
        return getNome() + "  -  " +
                getCategoria() + "  -  " +
                getPrioridade() + "  -  " +
                getDataFinal().format(DateTimeFormatter.ofPattern("dd/MM/yy HH:mm")) + "  -  " +
                getStatus() + "  -  " +
                getAlerta().format(DateTimeFormatter.ofPattern("dd/MM/yy HH:mm"));
    }
}
