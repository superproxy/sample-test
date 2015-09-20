package dao;

import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.ext.db2.Db2MetadataHandler;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.sql.SQLException;

public class BaseDbUnitTest extends BaseDaoTest {
    @Autowired
    DataSource dataSource;

    /**
     * 功能描述： 建立数据库连接
     *
     * @return 返回值
     * @throw 异常描述
     */

    protected DatabaseConnection getConnection() throws DatabaseUnitException, SQLException {
        DatabaseConnection databaseConnection = new DatabaseConnection(dataSource.getConnection());
        DatabaseConfig config = databaseConnection.getConfig();
        config.setProperty(DatabaseConfig.PROPERTY_METADATA_HANDLER, new Db2MetadataHandler());
        config.setProperty(DatabaseConfig.PROPERTY_BATCH_SIZE, Integer.valueOf(50));
        config.setProperty(DatabaseConfig.FEATURE_BATCHED_STATEMENTS, true);
        return databaseConnection;
    }

}
