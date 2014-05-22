package jetbrick.samples.order;

import javax.sql.DataSource;
import jetbrick.dao.orm.DbHelper;
import jetbrick.ioc.IocFactory;
import jetbrick.ioc.annotations.Inject;
import jetbrick.ioc.annotations.IocBean;

@IocBean("jetbrick.dao.orm.DbHelper")
public class DbHelperFactory implements IocFactory<DbHelper> {
    @Inject("dataSource")
    private DataSource dataSource;

    @Override
    public DbHelper getObject() {
        return new DbHelper(dataSource);
    }
}