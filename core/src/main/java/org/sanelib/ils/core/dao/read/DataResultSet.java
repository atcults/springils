package org.sanelib.ils.core.dao.read;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public final class DataResultSet {

    private final ResultSet rs;
    private final Map<String, Integer> columns;

    public DataResultSet(ResultSet rs) throws SQLException {
        this.rs = rs;
        this.columns = mapTableColumnIndex(rs);
    }

    static Map<String, Integer> mapTableColumnIndex(final ResultSet rs) throws SQLException {
        final ResultSetMetaData rsmd = rs.getMetaData();
        int columns = rsmd.getColumnCount();

        final Map<String, Integer> map = new HashMap<>(columns);
        for (int i = 1; i <= columns; i++) {
            map.put(getColumnKey(rsmd.getTableName(i), rsmd.getColumnName(i)), i);
        }
        return map;
    }

    static String getColumnKey(final String tableName, final String columnName) {
        return String.format("%s.%s", tableName, columnName);
    }

    public boolean next() throws SQLException {
        return this.rs.next();
    }

    public void close() throws SQLException {
        this.rs.close();
    }

    public int getInt(final String tableName, final String columnName) throws SQLException {
        return this.rs.getInt(this.columns.get(getColumnKey(tableName, columnName)));
    }

    public String getString(final String tableName, final String columnName) throws SQLException {
        return this.rs.getString(this.columns.get(getColumnKey(tableName, columnName)));
    }

    public boolean getBoolean(final String tableName, final String columnName) throws SQLException {
        return this.rs.getBoolean(this.columns.get(getColumnKey(tableName, columnName)));
    }

    public byte getByte(final String tableName, final String columnName) throws SQLException {
        return this.rs.getByte(this.columns.get(getColumnKey(tableName, columnName)));
    }

    public short getShort(final String tableName, final String columnName) throws SQLException {
        return this.rs.getShort(this.columns.get(getColumnKey(tableName, columnName)));
    }

    public long getLong(final String tableName, final String columnName) throws SQLException {
        return this.rs.getLong(this.columns.get(getColumnKey(tableName, columnName)));
    }

    public float getFloat(final String tableName, final String columnName) throws SQLException {
        return this.rs.getFloat(this.columns.get(getColumnKey(tableName, columnName)));
    }

    public double getDouble(final String tableName, final String columnName) throws SQLException {
        return this.rs.getDouble(this.columns.get(getColumnKey(tableName, columnName)));
    }

    public BigDecimal getBigDecimal(final String tableName, final String columnName) throws SQLException {
        return this.rs.getBigDecimal(this.columns.get(getColumnKey(tableName, columnName)));
    }

    public byte[] getBytes(final String tableName, final String columnName) throws SQLException {
        return this.rs.getBytes(this.columns.get(getColumnKey(tableName, columnName)));
    }

    public Date getDate(final String tableName, final String columnName) throws SQLException {
        return new Date(this.rs.getDate(this.columns.get(getColumnKey(tableName, columnName))).getTime());
    }

    public <T> T getObject(final String tableName, final String columnName, Class<T> type) throws SQLException {
        return this.rs.getObject(this.columns.get(getColumnKey(tableName, columnName)), type);
    }
}