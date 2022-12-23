import java.util.logging.Level;
import java.io.*;

import java.sql.*;
import javax.crypto.Cipher;
import java.util.Properties;
import java.util.Arrays;

public class Test1
{
    public void bad() throws Throwable
    {
        String data;

        char[] password = new char[0];
        try (InputStream inputStream = new FileInputStream("application.properties")) {
            Properties properties = new Properties();
            properties.load(inputStream);
            password = properties.getProperty("password").toCharArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        data = String.valueOf(password);
        Arrays.fill(password, ' ');

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
		Cipher c = Cipher.getInstance("RSA/ECB/OAEPWITHSHA1ANDMGF1PADDING");
	}
	
	public void bad4() {
		Cipher c = Cipher.getInstance("Noekeon");
	}

}

