/**
 * SUNING APPLIANCE CHAINS.
 * Copyright (c) 2012-2012 All Rights Reserved.
 */
package dao;

import org.dbunit.DatabaseUnitException;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.database.QueryDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileOutputStream;
import java.sql.SQLException;

/**
 * 功能描述： 导出数据库中相关表的数据，以用于dbunit作数据库初始化，只供手动调用，不自动化执行
 */

public abstract class AbstractDbBaseExporter extends BaseDbUnitTest {
    IDatabaseConnection connection = null;

    @BeforeMethod
    public void beforeMethod() throws DatabaseUnitException, SQLException {
        connection = getConnection();
    }

    @AfterMethod
    public void afterMethod() throws SQLException {
        if (connection != null) {
            connection.close();
        }

    }

    protected void exportDataSet(String[] tables, String[] out) throws Exception {
        int i = 0;
        for (String table : tables) {
            QueryDataSet partialDataSet = new QueryDataSet(connection);
            partialDataSet.addTable(table);
            FlatXmlDataSet.write(partialDataSet, new FileOutputStream(out[i++]));
        }

    }

    protected void exportDataSet(String table, String out) throws Exception {

        exportDataSet(new String[]{table}, new String[]{out});
    }

    protected void exportDataSet(String table) throws Exception {
        exportDataSet(new String[]{table}, new String[]{table + ".xml"});
    }

}
