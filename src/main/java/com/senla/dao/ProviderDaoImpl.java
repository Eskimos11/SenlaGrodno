package com.senla.dao;

import com.senla.api.dao.ProviderDao;
import com.senla.entity.Provider;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Component
public class ProviderDaoImpl implements ProviderDao {

    private Connection connection;

    public ProviderDaoImpl(Connection connection) {
        this.connection = connection;
    }

    private final static String INSERT_PROVIDER = "insert into providers(id,title) values (?,?)";
    private final static String DELETE_PROVIDER = "DELETE from providers where id=?";
    private final static String UPDATE_PROVIDER = "update providers set title=? where id=?";
    private final static String GET_BY_ID = "SELECT * FROM providers WHERE id = ?";


    @SneakyThrows
    @Override
    public void save(Provider provider) {
        try (final PreparedStatement statement = connection.prepareStatement(INSERT_PROVIDER)) {
            statement.setInt(1, provider.getId());
            statement.setString(2, provider.getTitle());
            statement.execute();
        }
    }


    @Override
    @SneakyThrows
    public void delete(Provider provider) {
        try (final PreparedStatement statement = connection.prepareStatement(DELETE_PROVIDER)) {
            statement.setInt(1, provider.getId());
            statement.executeUpdate();
        }
    }

    @Override
    @SneakyThrows
    public Provider update(Provider provider) {
        try (final PreparedStatement statement = connection.prepareStatement(UPDATE_PROVIDER)) {
            statement.setString(1, provider.getTitle());
            statement.setInt(2, provider.getId());
            statement.executeUpdate();
        }
        return provider;
    }

    @SneakyThrows
    @Override
    public Provider getById(Integer id) {
        Provider provider = null;
        try (final PreparedStatement statement = connection.prepareStatement("SELECT * FROM providers WHERE id = ?")) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            rs.next();
            provider = parseProvider(rs);
        }
        return provider;
    }

    @SneakyThrows
    public static Provider parseProvider(ResultSet resultSet) {
        Provider provider = new Provider();
        provider.setId(resultSet.getInt("id"));
        provider.setTitle(resultSet.getString("title"));
        return provider;
    }
}




