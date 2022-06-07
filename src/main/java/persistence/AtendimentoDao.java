package persistence;

import java.util.ArrayList;
import java.util.List;

import model.*;
import org.hibernate.SessionFactory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

public class AtendimentoDao implements IAtendimentoDao {

    private SessionFactory sf;

    public AtendimentoDao(SessionFactory sf) {
        this.sf = sf;
    }


    @Override
    public void insere(Atendimento atend) {
        EntityManager entityManager = (EntityManager) sf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(atend);
        transaction.commit();
    }

    @SuppressWarnings("unchecked")
    @Override
    public Atendimento selectOne(Atendimento atend) {
        StringBuffer buffer = new StringBuffer();
        buffer.append("SELECT * FROM atendimento a ");
        buffer.append("JOIN atendente t ON a.id_atendente = t.id ");
        buffer.append("JOIN cliente c ON c.cpf_cliente = c.id ");
        buffer.append("WHERE id = ?");
        EntityManager entityManager = (EntityManager) sf.createEntityManager();
        Query query = entityManager.createNativeQuery(buffer.toString());
        List<Object[]> lista = query.getResultList();
        Atendimento atendimento = new Atendimento();
        for (Object[] obj : lista) {
            Cliente cli = new Cliente();
            cli.setCpf(obj[0].toString());
            cli.setNome(obj[1].toString());
            cli.setEmail(obj[2].toString());
            cli.setCelular(obj[3].toString());
            cli.setPronomeTratamento(obj[4].toString());

            Atendente atendente = new Atendente();
            atendente.setEmail(obj[5].toString());
            atendente.setNome(obj[6].toString());
            atendente.setTelefone(obj[8].toString());

            atendimento.setCliente(cli);
            atendimento.setAtendente(atendente);
        }
        return atendimento;
    }

    @Override
    public List<Atendimento> selectOneCliente(Atendimento atend) {
        List<Atendimento> atendimentos = new ArrayList<Atendimento>();
        StringBuffer buffer = new StringBuffer();
        buffer.append("SELECT c.* FROM atendimento a ");
        buffer.append("JOIN atendente t ON a.id_atendente = t.id ");
        buffer.append("JOIN cliente c ON c.cpf_cliente = c.id ");
        buffer.append("WHERE id = ?");
        EntityManager entityManager = (EntityManager) sf.createEntityManager();
        Query query = entityManager.createNativeQuery(buffer.toString());
        List<Object[]> lista = query.getResultList();
        for (Object[] obj : lista) {
            Cliente cli = new Cliente();
            cli.setCpf(obj[0].toString());
            cli.setNome(obj[1].toString());
            cli.setEmail(obj[2].toString());
            cli.setCelular(obj[3].toString());
            cli.setPronomeTratamento(obj[4].toString());

            Atendente atendente = new Atendente();
            atendente.setEmail(obj[5].toString());
            atendente.setNome(obj[6].toString());
            atendente.setTelefone(obj[8].toString());

            Atendimento atendimento = new Atendimento();
            atendimento.setCliente(cli);
            atendimento.setAtendente(atendente);
            atendimentos.add(atendimento);

            atendimentos.add(atendimento);
        }

        return atendimentos;
    }

    @Override
    public List<Atendimento> selectOneAtendente(Atendimento atend) {
        List<Atendimento> atendimentos = new ArrayList<Atendimento>();
        StringBuffer buffer = new StringBuffer();
        buffer.append("SELECT t.* FROM atendimento a ");
        buffer.append("JOIN atendente t ON a.id_atendente = t.id ");
        buffer.append("JOIN cliente c ON c.cpf_cliente = c.id ");
        buffer.append("WHERE id = ?");
        EntityManager entityManager = (EntityManager) sf.createEntityManager();
        Query query = entityManager.createNativeQuery(buffer.toString());
        List<Object[]> lista = query.getResultList();
        for (Object[] obj : lista) {
            Cliente cli = new Cliente();
            cli.setCpf(obj[0].toString());
            cli.setNome(obj[1].toString());
            cli.setEmail(obj[2].toString());
            cli.setCelular(obj[3].toString());
            cli.setPronomeTratamento(obj[4].toString());

            Atendente atendente = new Atendente();
            atendente.setEmail(obj[5].toString());
            atendente.setNome(obj[6].toString());
            atendente.setTelefone(obj[8].toString());

            Atendimento atendimento = new Atendimento();
            atendimento.setCliente(cli);
            atendimento.setAtendente(atendente);
            atendimentos.add(atendimento);

            atendimentos.add(atendimento);
        }

        return atendimentos;
    }

    @Override
    public List<Atendimento> selectAll() {
        List<Atendimento> atendimentos = new ArrayList<Atendimento>();
        StringBuffer buffer = new StringBuffer();
        buffer.append("SELECT * FROM atendimento a");
        EntityManager entityManager = (EntityManager) sf.createEntityManager();
        Query query = entityManager.createNativeQuery(buffer.toString());
        List<Object[]> lista = query.getResultList();
        for (Object[] obj : lista) {
            Cliente cli = new Cliente();
            cli.setCpf(obj[0].toString());
            cli.setNome(obj[1].toString());
            cli.setEmail(obj[2].toString());
            cli.setCelular(obj[3].toString());
            cli.setPronomeTratamento(obj[4].toString());

            Atendente atendente = new Atendente();
            atendente.setEmail(obj[5].toString());
            atendente.setNome(obj[6].toString());
            atendente.setTelefone(obj[8].toString());

            Atendimento atendimento = new Atendimento();
            atendimento.setCliente(cli);
            atendimento.setAtendente(atendente);
            atendimentos.add(atendimento);
        }

        return atendimentos;
    }
}
