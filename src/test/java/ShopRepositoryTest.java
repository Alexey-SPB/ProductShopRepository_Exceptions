import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {

    ShopRepository repo = new ShopRepository();

    Product product1 = new Product(1, "Соль", 10);
    Product product2 = new Product(2, "Мука", 100);
    Product product3 = new Product(3, "Масло", 1000);

    @BeforeEach
    public void setup() {
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
    }

    @Test
    public void removeById() {
        repo.removeById(product1.getId());

        Product[] expected = {product2, product3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeById2() {
        repo.remove(product1.getId());

        Product[] expected = {product2, product3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeByIdNonExc() {

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(10);
        });
    }
}
