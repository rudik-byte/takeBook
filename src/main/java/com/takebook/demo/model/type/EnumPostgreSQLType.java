package com.takebook.demo.model.type;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.type.EnumType;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

public class EnumPostgreSQLType  extends EnumType {
    public void nullSafeSet(PreparedStatement st, Object value, int index, SharedSessionContractImplementor session)
            throws HibernateException, SQLException {
        st.setObject(index, value != null ? ((Enum) value).name() : null, Types.OTHER);
    }
}
