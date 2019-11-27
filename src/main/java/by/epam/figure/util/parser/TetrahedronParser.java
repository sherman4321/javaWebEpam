package by.epam.figure.util.parser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TetrahedronParser {
    private final static Logger logger = LogManager.getLogger(TetrahedronParser.class);

    public List<Double> parse(String string){
        String regex="(([+-]?\\d+([.]\\d+)?\\s){11}([+-]?\\d+([.]\\d+)?))";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);

        List<Double> variables = new ArrayList<>();
        if(matcher.find()){
            String space=" ";
            String[] numbers=string.split(space);
            for (String number:numbers){
                variables.add(Double.valueOf(number));
            }
        }
        else{
            logger.warn("String doesn't match the regular");
        }
        return variables;
    }
}
