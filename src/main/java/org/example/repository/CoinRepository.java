package org.example.repository;

import org.example.dto.CoinTransactionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.example.entity.coin;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@Repository
@EnableAutoConfiguration
public class CoinRepository {

    @Autowired
    private EntityManager entityManager;


    @Transactional
    public coin insert (coin Coin){
        entityManager.persist(Coin);
        return Coin;
    }
    @Transactional
    public coin update(coin Coin){
        entityManager.merge(Coin);
        return  Coin;
    }

    public List<CoinTransactionDTO> getAll(){
        String jpql = "select new org.example.dto.CoinTransactionDTO(c.name, sum(c.quantity)) from coin c group by c.name";
        TypedQuery<CoinTransactionDTO>query = entityManager.createQuery(jpql,CoinTransactionDTO.class);
        return query.getResultList();
    }
/*
    public List<CoinTransactionDTO> getByName(String name){
        Object[] attr = new Object[]{ name};
        return jdbcTemplate.query(SELECT_BY_NAME, new RowMapper<CoinTransactionDTO>() {
            @Override
            public CoinTransactionDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                CoinTransactionDTO Coin = new CoinTransactionDTO();
                Coin.setId(rs.getInt("id"));
                Coin.setDateTime(rs.getTimestamp("datetime"));
                Coin.setName(rs.getString("name"));
                Coin.setPrice(rs.getBigDecimal("price"));
                Coin.setQuantity(rs.getBigDecimal("quantity"));
                System.out.println(rs.getTimestamp("datetime") + " i'M HERE ");
                return Coin;
            }
        },attr);
    }

    public int  remove (int id){
        jdbcTemplate.update(DELETE,id);
        return 1;
    }*/
}
