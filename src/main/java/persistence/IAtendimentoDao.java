package persistence;

import model.Atendimento;

import java.util.List;

public interface IAtendimentoDao {
    public void insere (Atendimento atend);
    public Atendimento selectOne(Atendimento atend);
    public List<Atendimento> selectOneCliente(Atendimento atend);
    public List<Atendimento> selectOneAtendente(Atendimento atend);
    public List<Atendimento> selectAll();
}
