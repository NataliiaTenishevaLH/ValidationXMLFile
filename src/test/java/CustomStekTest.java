import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CustomStekTest {

    @Test
    public void testMethodCheckAdding() {
        CustomStek customStek = new CustomStek();
        //Проверяем, что добавится первый элемент
        CustomStek mock = mock(CustomStek.class);
        when(mock.checkAdding("<begin>")).thenReturn(customStek.checkAdding("<begin>"));
        Assertions.assertEquals(mock.checkAdding("<begin>"), true);

        //Проверяем, что последующий такой же элемет не добавится
        customStek.add("<begin>");
        when(mock.checkAdding("<begin>")).thenReturn(customStek.checkAdding("<begin>"));
        Assertions.assertEquals(mock.checkAdding("<begin>"), false);
        //и будет удален предыдущий идентичный
        Assertions.assertEquals(customStek.getSize(), 0);

        //Проверяем, что не добавится элемент, который находится не вначале списка
        customStek.add("<user>");
        customStek.add("<name>");
        customStek.add("<name>");
        when(mock.checkAdding("<user>")).thenReturn(customStek.checkAdding("<user>"));
        Assertions.assertEquals(mock.checkAdding("<user>"), false);
        //и будет удален элемент, который находится не вначале списка
        Assertions.assertEquals(customStek.getSize(), 0);
    }
}
