package lab2;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;

public class PersonTest{

    @Test
    public void PersonVerifyEquals(){
        EqualsVerifier.simple().forClass(Person.class).verify();
    }

}