import java.util.logging.Level;
import java.io.*;

import java.sql.*;
import javax.crypto.Cipher;

public class Test1
{
    public void bad() throws Throwable
    {
        String data;

        data = "7e5tc4s3";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        if (data != null)
        {
            try
            {
                connection = DriverManager.getConnection("data-url", "root", data);
                preparedStatement = connection.prepareStatement("select * from test_table");
                resultSet = preparedStatement.executeQuery();
            }
            catch (SQLException exceptSql)
            {
                IO.logger.log(Level.WARNING, "Error with database connection", exceptSql);
            }
            finally
            {
                try
                {
                    if (resultSet != null)
                    {
                        resultSet.close();
                    }
                }
                catch (SQLException exceptSql)
                {
                    IO.logger.log(Level.WARNING, "Error closing ResultSet", exceptSql);
                }

                try
                {
                    if (preparedStatement != null)
                    {
                        preparedStatement.close();
                    }
                }
                catch (SQLException exceptSql)
                {
                    IO.logger.log(Level.WARNING, "Error closing PreparedStatement", exceptSql);
                }

                try
                {
                    if (connection != null)
                    {
                        connection.close();
                    }
                }
                catch (SQLException exceptSql)
                {
                    IO.logger.log(Level.WARNING, "Error closing Connection", exceptSql);
                }
            }
        }

    }

    
	public void bad2() {
		Cipher c = Cipher.getInstance("AES");
	}
	
	public void bad3() {
		Cipher c = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256ANDMGF1PADDING");
	}
	
	public void bad4() {
		Cipher c = Cipher.getInstance("Noekeon");
	}

}

