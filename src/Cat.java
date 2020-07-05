public class Cat extends Animal{

    private static int totalCats;

    private static final String animalTypeName = "Кот";
    public static final float catTypeRunDistance = 200.00F;
    public static final float catTypeSwimDistance = 0.00F;
    public static final float catTypeJumpHeight = 2.00F;



    public Cat(String name){
        this(name, 0);
    }


    /**
     * Создает кота с рандомизированными характеристиками
     * @param name Имя кота
     * @param randomPercent Процент +/- отклонения характеристики
     */
    public Cat(String name, int randomPercent){
        super(animalTypeName, name, catTypeRunDistance, catTypeSwimDistance, catTypeJumpHeight, randomPercent);
        totalCats++;
    }


    /**
     * Позволяет создать произвольного кота
     * @param name Имя кота
     * @param maxRunDistance Дальность бега
     * @param maxSwimDistance Дальность плавания
     * @param maxJumpHeight Высота прыжка
     */
    public Cat(String name, float maxRunDistance, float maxSwimDistance, float maxJumpHeight){
        super(animalTypeName, name, maxRunDistance, maxSwimDistance, maxJumpHeight, 0);
        totalCats++;
    }

    /**
     * Метод, которым кот пользуется для плавания
     *
     * @param swimDistance дистанция
     */
    @Override
    public boolean swimMethod(float swimDistance) {
        if (ableToSwim()) {
            System.out.printf("Хотя коты обычно не плавают, %s бросается в воду и проплывает %.2f м.\n", name, swimDistance);
            return true;
        }

        System.out.printf("%s подходит к воде и удивленно смотрит на вас. Коты не плавают!\n", name);
        return false;
    }

    /**
     * Метод, которым кот пользуется для бега
     *
     * @param runDistance дистанция
     */
    @Override
    public boolean runMethod(float runDistance) {
        if (ableToRun()) {
            System.out.printf("%s пробегает %.2f м.\n", name, runDistance);
            return true;
        }

        System.out.printf("Кот %s не может бегать. Печально.\n", name);
        return false;
    }

    /**
     * Метод, которым кот пользуется для прыжка
     *
     * @param jumpHeight высота прыжка
     */
    @Override
    public boolean jumpMethod(float jumpHeight) {
        if (ableToJump()) {
            System.out.printf("%s подпрыгивает на %.2f м.\n", name, jumpHeight);
            return true;
        }

        System.out.printf("Кот %s не может прыгать.\n", name);
        return false;
    }

    /**
     *
     * @return Общее количество котов
     */
    public static int getTotalCats() {
        return totalCats;
    }
}
