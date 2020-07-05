public class Dog extends Animal{

    private static int totalDogs;

    private static final String animalTypeName = "Собака";
    private static final float dogTypeRunDistance = 500.00F;
    private static final float dogTypeSwimDistance = 10.00F;
    private static final float dogTypeJumpHeight = 0.50F;


    public Dog(String name){
        this(name, 0);
    }


    /**
     * Создает пса с рандомизированными характеристиками
     * @param name Имя пса
     * @param randomPercent Процент +/- отклонения характеристики
     */
    public Dog(String name, int randomPercent){
        super(animalTypeName, name, dogTypeRunDistance, dogTypeSwimDistance, dogTypeJumpHeight, randomPercent);
        totalDogs++;
    }


    /**
     * Позволяет создать произвольного пса
     * @param name Имя пса
     * @param maxRunDistance Дальность бега
     * @param maxSwimDistance Дальность плавания
     * @param maxJumpHeight Высота прыжка
     */
    public Dog(String name, float maxRunDistance, float maxSwimDistance, float maxJumpHeight){
        super(animalTypeName, name, maxRunDistance, maxSwimDistance, maxJumpHeight, 0);
        totalDogs++;
    }

    /**
     * Метод, которым собака пользуется для плавания
     *
     * @param swimDistance дистанция
     */
    @Override
    public boolean swimMethod(float swimDistance) {
        if (ableToSwim()) {
            System.out.printf("%s проплывает %.2f м.\n", name, swimDistance);
            return true;
        }

        System.out.printf("Хотя собаки любят воду, %s почему-то не может плавать.\n", name);
        return false;
    }

    /**
     * Метод, которым собака пользуется для бега
     *
     * @param runDistance дистанция
     */
    @Override
    public boolean runMethod(float runDistance) {
        if (ableToRun()) {
            System.out.printf("%s пробегает %.2f м.\n", name, runDistance);
            return true;
        }

        System.out.printf("Собака %s не может бегать. Печально.\n", name);
        return false;
    }

    /**
     * Метод, которым собака пользуется для прыжка
     *
     * @param jumpHeight высота прыжка
     */
    @Override
    public boolean jumpMethod(float jumpHeight) {
        if (ableToJump()) {
            System.out.printf("%s подпрыгивает на %.2f м.\n", name, jumpHeight);
            return true;
        }

        System.out.printf("Собака %s не может прыгать.\n", name);
        return false;
    }

    /**
     *
     * @return Общее количество собак
     */
    public static int getTotalDogs() {
        return totalDogs;
    }
}
