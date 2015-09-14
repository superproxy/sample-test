package test.dbunit;

import org.dbunit.DBTestCase;
import org.dbunit.DataSourceDatabaseTester;
import org.dbunit.IDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.junit.Test;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.io.FileInputStream;

public class SampleTest extends DBTestCase {

    @Resource
    DataSource dataSource;

    public SampleTest(String name) {
    }

    protected IDataSet getDataSet() throws Exception {
        return new FlatXmlDataSetBuilder().build(new FileInputStream("dataset.xml"));
    }

    @Override
    protected IDatabaseTester newDatabaseTester() throws Exception {
        return new DataSourceDatabaseTester(dataSource);
    }

    @Test
    public void test() {

    }

}