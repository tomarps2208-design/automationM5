package mProAGency;

import java.util.concurrent.ThreadLocalRandom;

public class panGenerator 
{
	public static String generatePAN(String type) {
       
        char first = (char) ('A' + ThreadLocalRandom.current().nextInt(26));
        char second = (char) ('A' + ThreadLocalRandom.current().nextInt(26));
        char third = (char) ('A' + ThreadLocalRandom.current().nextInt(26));
                char fourth;
        if(type.equalsIgnoreCase("individual")) {
            fourth = 'P';
        } else if(type.equalsIgnoreCase("company")) {
            fourth = 'C';
        } else {
            fourth = 'H';
        }
        
        char fifth = (char) ('A' + ThreadLocalRandom.current().nextInt(26));
        
        int digits = ThreadLocalRandom.current().nextInt(1000, 10000);  // 1000 to 9999
        
        char last = (char) ('A' + ThreadLocalRandom.current().nextInt(26));
        
        return "" + first + second + third + fourth + fifth + digits + last;
    }

}
