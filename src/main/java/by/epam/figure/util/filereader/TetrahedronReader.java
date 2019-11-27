package by.epam.figure.util.filereader;

import by.epam.figure.exception.DAOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TetrahedronReader implements AutoCloseable{
    private final static Logger logger = LogManager.getLogger(TetrahedronReader.class);
    private BufferedReader reader;

    public TetrahedronReader(File file) throws DAOException {
        try {
            this.reader = new BufferedReader(new FileReader(file));
        }
        catch (IOException e){
            throw new DAOException(e);
        }
    }

    public String getLine() throws DAOException {
        try {
            return reader.readLine();
        }
        catch (IOException e){
            throw new DAOException(e);
        }
    }

    public String getLine(int number) throws DAOException {
        try {
        String result = "";
        while (number-- > 0) {
            result = reader.readLine();
        }
        return result;
        }
        catch (IOException e){
            throw new DAOException(e);
        }
    }

    public void close() throws DAOException {
        try{
            reader.close();
        }
        catch (IOException e){
            throw new DAOException(e);
        }
    }
}
