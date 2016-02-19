package org.sanelib.ils.core.dao.read;

import org.sanelib.ils.core.domain.view.DomainView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
@SuppressWarnings({"rawtypes", "unchecked"})
public class ViewServiceHelper {

    @Autowired
    DataSource dataSource;

    public Connection getConnection() throws SQLException {
        return this.dataSource.getConnection();
    }

    public <T extends DomainView> List<T> loadQuery(String query, ViewMapper mapper) {
        final List<T> list = new ArrayList<>();

        try (Connection connection = getConnection()) {
            ResultSet resultSet = connection.createStatement().executeQuery(query);
            DataResultSet rs = new DataResultSet(resultSet);
            while (rs.next()) {
                list.add((T) mapper.map(rs));
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public List<List> loadQueries(String queries, List<ViewMapper> mappers) throws SQLException {

        final List<List> list = new ArrayList<>();

        Statement stmt = getConnection().createStatement();
        boolean isResultSet = stmt.execute(queries);

        int count = 0;
        while(isResultSet) {
            List l = new ArrayList<>();
            DataResultSet rs = new DataResultSet(stmt.getResultSet());
            while(rs.next()) {
                l.add(mappers.get(count).map(rs));
            }
            rs.close();
            count ++;
            list.add(l);
            isResultSet = stmt.getMoreResults();
        }

        return list;
    }

    public <T extends DomainView> List<T> loadQuery(String query, Object[] values, ViewMapper mapper) {
        final List<T> list = new ArrayList<>();

        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            addQueryObjects(connection, statement, values);
            ResultSet resultSet = statement.executeQuery();
            DataResultSet rs = new DataResultSet(resultSet);
            while (rs.next()) {
                list.add((T) mapper.map(rs));
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    private void addQueryObjects(Connection connection, PreparedStatement statement, Object[] values) throws SQLException {
        Integer index = 1;
        for(Object o : values){
            if(o instanceof Collection){
                Array array = connection.createArrayOf("VARCHAR", ((List) o).toArray());
                statement.setArray(index, array);
            } else{
                statement.setObject(index, o);
            }
            index ++;
        }
    }
}
