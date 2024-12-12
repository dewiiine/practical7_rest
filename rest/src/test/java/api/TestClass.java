package api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestClass {

    /**
     * Добавить товар типа "Фрукт" без БД
     */
    @Test
    public void addFruit() {
        Steps steps = new Steps();

        // Создаем новый товар
        ProductMask newProduct = new ProductMask("Мандарин", "FRUIT", false);

        // Получаем количество товаров в списке
        int countProduct = steps.getProductCount();

        // Добавляем товар
        steps.createNewProduct(newProduct);

        // Получаем новое количество твоаров
        int countAfterAdd = steps.getProductCount();
        Assertions.assertEquals(countProduct + 1, countAfterAdd, "Количество товаров не увеличилось");

        // Сбрасываем данные в исходное состояние
        steps.resetTestData();

        // Получаем количество товаров после сброса данных
        int countAfterReset = steps.getProductCount();
        Assertions.assertEquals(countProduct, countAfterReset);

    }

    /**
     * Добавить товар типа "Овощ" без БД
     */
    @Test
    public void addVegetable() {
        Steps steps = new Steps();

        // Создаем новый товар
        ProductMask newProduct = new ProductMask("Батат", "VEGETABLE", true);

        // Получаем количество товаров в списке
        int countProduct = steps.getProductCount();

        // Добавляем товар
        steps.createNewProduct(newProduct);

        // Получаем новое количество твоаров
        int countAfterAdd = steps.getProductCount();
        Assertions.assertEquals(countProduct + 1, countAfterAdd, "Количество товаров не увеличилось");

        // Сбрасываем данные в исходное состояние
        steps.resetTestData();

        // Получаем количество товаров после сброса данных
        int countAfterReset = steps.getProductCount();
        Assertions.assertEquals(countProduct, countAfterReset);

    }

    /**
     * Добавить товар типа "Овощ" с БД
     */
    @Test
    public void addVegetableWithDb() {
        Steps steps = new Steps();

        // Создаем новый товар
        ProductMask newProduct = new ProductMask("Редиска", "VEGETABLE", false);

        // Получаем количество товаров в списке
        int countProduct = steps.getProductCount();
        // Получаем количество товаров в БД по FOOD_NAME
        int countProductDb = steps.getFoodCount(newProduct.getName());

        // Добавляем товар
        steps.createNewProduct(newProduct);

        // Получаем новое количество твоаров
        int countAfterAdd = steps.getProductCount();
        Assertions.assertEquals(countProduct + 1, countAfterAdd, "Количество товаров не увеличилось");
        // Получаем новое количество товаров в БД по FOOD_NAME
        int countAfterAddDb = steps.getFoodCount(newProduct.getName());
        Assertions.assertEquals(countProductDb + 1, countAfterAddDb,
                "Количество товаров в бд не увеличилось");

        // Сбрасываем данные в исходное состояние
        steps.resetTestData();

        // Получаем количество товаров после сброса данных
        int countAfterReset = steps.getProductCount();
        Assertions.assertEquals(countProduct, countAfterReset);

        // Получае количество товаров в БД по FOOD_NAME после сброса данных
        int countAfterResetDb = steps.getFoodCount(newProduct.getName());
        Assertions.assertEquals(countProductDb, countAfterResetDb);

    }

    /**
     * Добавить товар типа "Фрукт", уже существующего в БД
     */
    @Test
    public void addFruitWithDb() {
        Steps steps = new Steps();

        // Создаем новый товар
        ProductMask newProduct = new ProductMask("Апельсин", "FRUIT", true);

        // Получаем количество товаров в списке
        int countProduct = steps.getProductCount();
        // Получаем количество товаров в БД по FOOD_NAME
        int countProductDb = steps.getFoodCount(newProduct.getName());

        // Добавляем товар
        steps.createNewProduct(newProduct);

        // Получаем новое количество твоаров
        int countAfterAdd = steps.getProductCount();
        Assertions.assertEquals(countProduct + 1, countAfterAdd, "Количество товаров не увеличилось");
        // Получаем новое количество товаров в БД по FOOD_NAME
        int countAfterAddDb = steps.getFoodCount(newProduct.getName());
        Assertions.assertEquals(countProductDb + 1, countAfterAddDb,
                "Количество товаров в бд не увеличилось");

        // Сбрасываем данные в исходное состояние
        steps.resetTestData();

        // Получаем количество товаров после сброса данных
        int countAfterReset = steps.getProductCount();
        Assertions.assertEquals(countProduct, countAfterReset);

        // Получае количество товаров в БД по FOOD_NAME после сброса данных
        int countAfterResetDb = steps.getFoodCount(newProduct.getName());
        Assertions.assertEquals(countProductDb, countAfterResetDb);

    }
}