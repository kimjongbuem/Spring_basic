package fc;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class BeanScopeTests {
    @Test
    public void testIdentity(){
        // 동일성(객체주소가 같다) 동등성(객체의 값이 같다)

        A a1 = new A(10, "helloWorld");
        A a2 = new A(10, "helloWorld");
        A a3 = new A(5, "helloWorld");
        Assert.assertTrue(a1.equals(a2));
        Assert.assertFalse(a1.equals(a3));
    }
}

@EqualsAndHashCode
@AllArgsConstructor
class A{
    private int a1;
    private String a2;
}
