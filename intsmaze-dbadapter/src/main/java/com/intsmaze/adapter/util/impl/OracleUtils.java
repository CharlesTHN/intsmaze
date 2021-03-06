package com.intsmaze.adapter.util.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.intsmaze.adapter.util.AbstractDataBaseUtils;

/** 
 * @author:YangLiu
 * @date:2017年11月7日 下午1:41:43 
 * @describe: 
 */
public final class OracleUtils extends AbstractDataBaseUtils {
	
	private static final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
	
	public void init() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private OracleUtils() {
	}

	public Connection getConnection() throws SQLException {
//		return DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl", "position_product", "position_product");
		return DriverManager.getConnection(this.getUrl()+this.getDbName(), this.getUser(), this.getPassword());
	}

	public void free(ResultSet rs, Statement st, Connection conn) {
		try {
			if (rs != null) {
                rs.close();
            }
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (st != null) {
                    st.close();
                }
			} catch (SQLException e) {
				e.printStackTrace();
			} 
			finally {
				if (conn != null) {
                    try {
                        conn.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
			}
		}
	}
	
	public void free(ResultSet rs, Statement st) {
		try {
			if (rs != null) {
                rs.close();
            }
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (st != null) {
                    st.close();
                }
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		}
	}
	

}
