import java.util.Random;

public class Main {

    private static Random random = new Random();

    public static void main(String[] args) {

        testObjects();

    }

    private static void testObjects(){
        //Коты по умолчанию - не плавают
        Cat grumpyCat = new Cat("Tardar Sauce");
        //Мару не плавает, но у него разброс характеристик
        Cat maruCat = new Cat("Мару", 20);
        //Плавающий кот. Рандомайзера в полный конструктор не предусмотрено, т.к. мы точно знаем, чего хотим
        Cat swimmingCat = new Cat("Джаз", Cat.catTypeRunDistance, 5.0F, Cat.catTypeJumpHeight);
        //Собака, которая умеет всё, с разбросом характеристик
        Dog lessyDog = new Dog("Лесси", 20);
        //Хатико умеет только сидеть :( . Рандомайзера в полный конструктор не предусмотрено, т.к. мы точно знаем, чего хотим
        Dog hatikoDog = new Dog("Хатико",0.0F, 0.0F, 0.0F);

        System.out.println("Всего животных создано:" + Animal.getTotalAnimals());
        System.out.println("Всего котов создано:" + Cat.getTotalCats());
        System.out.println("Всего собак создано:" + Dog.getTotalDogs());
        System.out.println();

        catAction(grumpyCat);
        catAction(maruCat);
        catAction(swimmingCat);

        dogAction(lessyDog);
        dogAction(hatikoDog);

    }

    private static void catAction(Cat cat){
        System.out.println("===============================\nПеред нами:");
        System.out.println(cat);
        cat.run((float) random.nextInt(150) + 100);
        cat.swim((float) random.nextInt(10));
        cat.jump(((float) random.nextInt(10)) / 2 + 0.1F);
        System.out.println();
    }

    private static void dogAction(Dog dog){
        System.out.println("===============================\nПеред нами:");
        System.out.println(dog);
        dog.run((float) random.nextInt(150) + 400);
        dog.swim((float) random.nextInt(100));
        dog.jump(((float) random.nextInt(5)) / 10 + 0.1F);
        System.out.println();
    }

}
