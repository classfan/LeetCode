package password;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class PasswordValidatorTest {

    @Test
    public void should_return_false_1(){
        PasswordValidator validator = new PasswordValidator(8);
        assertFalse(validator.isValid("abc123"));
    }

    @Test
    public void should_return_false_2(){
        PasswordValidator validator = new PasswordValidator(8);
        assertFalse(validator.isValid("~~---=++~~###123"));
    }

    @Test
    public void should_return_true(){
        PasswordValidator validator = new PasswordValidator(8);
        assertTrue(validator.isValid("~~-eee--=++~~###123"));
    }
}
