/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE89_SQL_Injection__PropertiesFile_executeUpdate_10.java
Label Definition File: CWE89_SQL_Injection.label.xml
Template File: sources-sinks-10.tmpl.java
*/
/*
* @description
* CWE: 89 SQL Injection
* BadSource: PropertiesFile Read a value from a .properties file (in property named data)
* GoodSource: A hardcoded string
* Sinks: executeUpdate
*    GoodSink: prepared sqlstatement, executeUpdate
*    BadSink : raw query used in executeUpdate
* Flow Variant: 10 Control flow: if(IO.static_t) and if(IO.static_f)
*
* */

package testcases.CWE89_SQL_Injection;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;
import java.util.logging.Logger;

import java.util.Properties;

import java.io.FileInputStream;
import java.io.IOException;

import java.util.logging.Logger;

public class CWE89_SQL_Injection__PropertiesFile_executeUpdate_10 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        String data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(IO.static_t)
        {
            Logger log_bad = Logger.getLogger("local-logger");
            data = ""; /* init data */
            /* retrieve the property */
            Properties props = new Properties();
            FileInputStream finstr = null;
            try
            {
                finstr = new FileInputStream("../common/config.properties");
                props.load(finstr);
                data = props.getProperty("data");
            }
            catch( IOException ioe )
            {
                log_bad.warning("Error with stream reading");
            }
            finally
            {
                /* clean up stream reading objects */
                try {
                    if( finstr != null )
                    {
                        finstr.close();
                    }
                }
                catch( IOException ioe )
                {
                    log_bad.warning("Error closing buffread");
                }
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");

            /* FIX: Use a hardcoded string */
            data = "foo";

        }
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(IO.static_t)
        {
            Logger log2 = Logger.getLogger("local-logger");
            Connection conn_tmp2 = null;
            Statement sqlstatement = null;
            try
            {
                conn_tmp2 = IO.getDBConnection();
                sqlstatement = conn_tmp2.createStatement();
                /* POTENTIAL FLAW: place user input into dynamic sql query */
                int iResult = sqlstatement.executeUpdate("insert into users (status) values ('updated') where name='"+data+"'");
                IO.writeString("Updated " + iResult + " rows successfully.");
            }
            catch( SQLException se )
            {
                log2.warning("Error getting database connection");
            }
            finally
            {
                try {
                    if( sqlstatement != null )
                    {
                        sqlstatement.close();
                    }
                }
                catch( SQLException e )
                {
                    log2.warning("Error closing sqlstatement");
                }
                finally {
                    try {
                        if( conn_tmp2 != null )
                        {
                            conn_tmp2.close();
                        }
                    }
                    catch( SQLException e )
                    {
                        log2.warning("Error closing conn_tmp2");
                    }
                }
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            Logger log2 = Logger.getLogger("local-logger");

            Connection conn_tmp2 = null;
            PreparedStatement sqlstatement = null;

            try {
                /* FIX: use prepared sqlstatement */
                conn_tmp2 = IO.getDBConnection();
                sqlstatement = conn_tmp2.prepareStatement("insert into users (status) values ('updated') where name=?");
                sqlstatement.setString(1, data);

                int iResult = sqlstatement.executeUpdate();

                IO.writeString("Updated " + iResult + " rows successfully.");
            }
            catch( SQLException se )
            {
                log2.warning("Error getting database connection");
            }
            finally {
                try {
                    if( sqlstatement != null )
                    {
                        sqlstatement.close();
                    }
                }
                catch( SQLException e )
                {
                    log2.warning("Error closing sqlstatement");
                }
                finally {
                    try {
                        if( conn_tmp2 != null )
                        {
                            conn_tmp2.close();
                        }
                    }
                    catch( SQLException e )
                    {
                        log2.warning("Error closing conn_tmp2");
                    }
                }
            }

        }

    }

    /* goodG2B1() - use goodsource and badsink by changing first IO.static_t to IO.static_f */
    private void goodG2B1() throws Throwable
    {
        String data;
        /* INCIDENTAL: CWE 570 Statement is Always False */
        if(IO.static_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            Logger log_bad = Logger.getLogger("local-logger");
            data = ""; /* init data */
            /* retrieve the property */
            Properties props = new Properties();
            FileInputStream finstr = null;
            try
            {
                finstr = new FileInputStream("../common/config.properties");
                props.load(finstr);
                data = props.getProperty("data");
            }
            catch( IOException ioe )
            {
                log_bad.warning("Error with stream reading");
            }
            finally
            {
                /* clean up stream reading objects */
                try {
                    if( finstr != null )
                    {
                        finstr.close();
                    }
                }
                catch( IOException ioe )
                {
                    log_bad.warning("Error closing buffread");
                }
            }
        }
        else {

            java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");

            /* FIX: Use a hardcoded string */
            data = "foo";

        }
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(IO.static_t)
        {
            Logger log2 = Logger.getLogger("local-logger");
            Connection conn_tmp2 = null;
            Statement sqlstatement = null;
            try
            {
                conn_tmp2 = IO.getDBConnection();
                sqlstatement = conn_tmp2.createStatement();
                /* POTENTIAL FLAW: place user input into dynamic sql query */
                int iResult = sqlstatement.executeUpdate("insert into users (status) values ('updated') where name='"+data+"'");
                IO.writeString("Updated " + iResult + " rows successfully.");
            }
            catch( SQLException se )
            {
                log2.warning("Error getting database connection");
            }
            finally
            {
                try {
                    if( sqlstatement != null )
                    {
                        sqlstatement.close();
                    }
                }
                catch( SQLException e )
                {
                    log2.warning("Error closing sqlstatement");
                }
                finally {
                    try {
                        if( conn_tmp2 != null )
                        {
                            conn_tmp2.close();
                        }
                    }
                    catch( SQLException e )
                    {
                        log2.warning("Error closing conn_tmp2");
                    }
                }
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            Logger log2 = Logger.getLogger("local-logger");

            Connection conn_tmp2 = null;
            PreparedStatement sqlstatement = null;

            try {
                /* FIX: use prepared sqlstatement */
                conn_tmp2 = IO.getDBConnection();
                sqlstatement = conn_tmp2.prepareStatement("insert into users (status) values ('updated') where name=?");
                sqlstatement.setString(1, data);

                int iResult = sqlstatement.executeUpdate();

                IO.writeString("Updated " + iResult + " rows successfully.");
            }
            catch( SQLException se )
            {
                log2.warning("Error getting database connection");
            }
            finally {
                try {
                    if( sqlstatement != null )
                    {
                        sqlstatement.close();
                    }
                }
                catch( SQLException e )
                {
                    log2.warning("Error closing sqlstatement");
                }
                finally {
                    try {
                        if( conn_tmp2 != null )
                        {
                            conn_tmp2.close();
                        }
                    }
                    catch( SQLException e )
                    {
                        log2.warning("Error closing conn_tmp2");
                    }
                }
            }

        }
    }

    /* goodG2B2() - use goodsource and badsink by reversing statements in first if */
    private void goodG2B2() throws Throwable
    {
        String data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(IO.static_t)
        {
            java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");
            /* FIX: Use a hardcoded string */
            data = "foo";
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            Logger log_bad = Logger.getLogger("local-logger");

            data = ""; /* init data */

            /* retrieve the property */
            Properties props = new Properties();
            FileInputStream finstr = null;
            try {
                finstr = new FileInputStream("../common/config.properties");
                props.load(finstr);

                data = props.getProperty("data");
            }
            catch( IOException ioe )
            {
                log_bad.warning("Error with stream reading");
            }
            finally {
                /* clean up stream reading objects */
                try {
                    if( finstr != null )
                    {
                        finstr.close();
                    }
                }
                catch( IOException ioe )
                {
                    log_bad.warning("Error closing buffread");
                }
            }

        }
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(IO.static_t)
        {
            Logger log2 = Logger.getLogger("local-logger");
            Connection conn_tmp2 = null;
            Statement sqlstatement = null;
            try
            {
                conn_tmp2 = IO.getDBConnection();
                sqlstatement = conn_tmp2.createStatement();
                /* POTENTIAL FLAW: place user input into dynamic sql query */
                int iResult = sqlstatement.executeUpdate("insert into users (status) values ('updated') where name='"+data+"'");
                IO.writeString("Updated " + iResult + " rows successfully.");
            }
            catch( SQLException se )
            {
                log2.warning("Error getting database connection");
            }
            finally
            {
                try {
                    if( sqlstatement != null )
                    {
                        sqlstatement.close();
                    }
                }
                catch( SQLException e )
                {
                    log2.warning("Error closing sqlstatement");
                }
                finally {
                    try {
                        if( conn_tmp2 != null )
                        {
                            conn_tmp2.close();
                        }
                    }
                    catch( SQLException e )
                    {
                        log2.warning("Error closing conn_tmp2");
                    }
                }
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            Logger log2 = Logger.getLogger("local-logger");

            Connection conn_tmp2 = null;
            PreparedStatement sqlstatement = null;

            try {
                /* FIX: use prepared sqlstatement */
                conn_tmp2 = IO.getDBConnection();
                sqlstatement = conn_tmp2.prepareStatement("insert into users (status) values ('updated') where name=?");
                sqlstatement.setString(1, data);

                int iResult = sqlstatement.executeUpdate();

                IO.writeString("Updated " + iResult + " rows successfully.");
            }
            catch( SQLException se )
            {
                log2.warning("Error getting database connection");
            }
            finally {
                try {
                    if( sqlstatement != null )
                    {
                        sqlstatement.close();
                    }
                }
                catch( SQLException e )
                {
                    log2.warning("Error closing sqlstatement");
                }
                finally {
                    try {
                        if( conn_tmp2 != null )
                        {
                            conn_tmp2.close();
                        }
                    }
                    catch( SQLException e )
                    {
                        log2.warning("Error closing conn_tmp2");
                    }
                }
            }

        }
    }

    /* goodB2G1() - use badsource and goodsink by changing second IO.static_t to IO.static_f */
    private void goodB2G1() throws Throwable
    {
        String data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(IO.static_t)
        {
            Logger log_bad = Logger.getLogger("local-logger");
            data = ""; /* init data */
            /* retrieve the property */
            Properties props = new Properties();
            FileInputStream finstr = null;
            try
            {
                finstr = new FileInputStream("../common/config.properties");
                props.load(finstr);
                data = props.getProperty("data");
            }
            catch( IOException ioe )
            {
                log_bad.warning("Error with stream reading");
            }
            finally
            {
                /* clean up stream reading objects */
                try {
                    if( finstr != null )
                    {
                        finstr.close();
                    }
                }
                catch( IOException ioe )
                {
                    log_bad.warning("Error closing buffread");
                }
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");

            /* FIX: Use a hardcoded string */
            data = "foo";

        }
        /* INCIDENTAL: CWE 570 Statement is Always False */
        if(IO.static_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            Logger log2 = Logger.getLogger("local-logger");
            Connection conn_tmp2 = null;
            Statement sqlstatement = null;
            try
            {
                conn_tmp2 = IO.getDBConnection();
                sqlstatement = conn_tmp2.createStatement();
                /* POTENTIAL FLAW: place user input into dynamic sql query */
                int iResult = sqlstatement.executeUpdate("insert into users (status) values ('updated') where name='"+data+"'");
                IO.writeString("Updated " + iResult + " rows successfully.");
            }
            catch( SQLException se )
            {
                log2.warning("Error getting database connection");
            }
            finally
            {
                try {
                    if( sqlstatement != null )
                    {
                        sqlstatement.close();
                    }
                }
                catch( SQLException e )
                {
                    log2.warning("Error closing sqlstatement");
                }
                finally {
                    try {
                        if( conn_tmp2 != null )
                        {
                            conn_tmp2.close();
                        }
                    }
                    catch( SQLException e )
                    {
                        log2.warning("Error closing conn_tmp2");
                    }
                }
            }
        }
        else {

            Logger log2 = Logger.getLogger("local-logger");

            Connection conn_tmp2 = null;
            PreparedStatement sqlstatement = null;

            try {
                /* FIX: use prepared sqlstatement */
                conn_tmp2 = IO.getDBConnection();
                sqlstatement = conn_tmp2.prepareStatement("insert into users (status) values ('updated') where name=?");
                sqlstatement.setString(1, data);

                int iResult = sqlstatement.executeUpdate();

                IO.writeString("Updated " + iResult + " rows successfully.");
            }
            catch( SQLException se )
            {
                log2.warning("Error getting database connection");
            }
            finally {
                try {
                    if( sqlstatement != null )
                    {
                        sqlstatement.close();
                    }
                }
                catch( SQLException e )
                {
                    log2.warning("Error closing sqlstatement");
                }
                finally {
                    try {
                        if( conn_tmp2 != null )
                        {
                            conn_tmp2.close();
                        }
                    }
                    catch( SQLException e )
                    {
                        log2.warning("Error closing conn_tmp2");
                    }
                }
            }

        }
    }

    /* goodB2G2() - use badsource and goodsink by reversing statements in second if  */
    private void goodB2G2() throws Throwable
    {
        String data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(IO.static_t)
        {
            Logger log_bad = Logger.getLogger("local-logger");
            data = ""; /* init data */
            /* retrieve the property */
            Properties props = new Properties();
            FileInputStream finstr = null;
            try
            {
                finstr = new FileInputStream("../common/config.properties");
                props.load(finstr);
                data = props.getProperty("data");
            }
            catch( IOException ioe )
            {
                log_bad.warning("Error with stream reading");
            }
            finally
            {
                /* clean up stream reading objects */
                try {
                    if( finstr != null )
                    {
                        finstr.close();
                    }
                }
                catch( IOException ioe )
                {
                    log_bad.warning("Error closing buffread");
                }
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");

            /* FIX: Use a hardcoded string */
            data = "foo";

        }
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(IO.static_t)
        {
            Logger log2 = Logger.getLogger("local-logger");
            Connection conn_tmp2 = null;
            PreparedStatement sqlstatement = null;
            try
            {
                /* FIX: use prepared sqlstatement */
                conn_tmp2 = IO.getDBConnection();
                sqlstatement = conn_tmp2.prepareStatement("insert into users (status) values ('updated') where name=?");
                sqlstatement.setString(1, data);
                int iResult = sqlstatement.executeUpdate();
                IO.writeString("Updated " + iResult + " rows successfully.");
            }
            catch( SQLException se )
            {
                log2.warning("Error getting database connection");
            }
            finally
            {
                try {
                    if( sqlstatement != null )
                    {
                        sqlstatement.close();
                    }
                }
                catch( SQLException e )
                {
                    log2.warning("Error closing sqlstatement");
                }
                finally {
                    try {
                        if( conn_tmp2 != null )
                        {
                            conn_tmp2.close();
                        }
                    }
                    catch( SQLException e )
                    {
                        log2.warning("Error closing conn_tmp2");
                    }
                }
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            Logger log2 = Logger.getLogger("local-logger");

            Connection conn_tmp2 = null;
            Statement sqlstatement = null;

            try {
                conn_tmp2 = IO.getDBConnection();
                sqlstatement = conn_tmp2.createStatement();

                /* POTENTIAL FLAW: place user input into dynamic sql query */
                int iResult = sqlstatement.executeUpdate("insert into users (status) values ('updated') where name='"+data+"'");

                IO.writeString("Updated " + iResult + " rows successfully.");
            }
            catch( SQLException se )
            {
                log2.warning("Error getting database connection");
            }
            finally {
                try {
                    if( sqlstatement != null )
                    {
                        sqlstatement.close();
                    }
                }
                catch( SQLException e )
                {
                    log2.warning("Error closing sqlstatement");
                }
                finally {
                    try {
                        if( conn_tmp2 != null )
                        {
                            conn_tmp2.close();
                        }
                    }
                    catch( SQLException e )
                    {
                        log2.warning("Error closing conn_tmp2");
                    }
                }
            }

        }
    }

    public void good() throws Throwable
    {
        goodG2B1();
        goodG2B2();
        goodB2G1();
        goodB2G2();
    }

    /* Below is the main(). It is only used when building this testcase on
       its own for testing or for building a binary to use in testing binary
       analysis tools. It is not used when compiling all the testcases as one
       application, which is how source code analysis tools are tested. */
    public static void main(String[] args) throws ClassNotFoundException,
           InstantiationException, IllegalAccessException
    {
        mainFromParent(args);
    }
}
