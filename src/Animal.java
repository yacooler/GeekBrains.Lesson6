public abstract class Animal {
    private static int totalAnimals;

    protected String name;
    protected String animalTypeName;
    protected float maxRunDistance;
    protected float maxSwimDistance;
    protected float maxJumpHeight;

    private static final float minFloat = 0.00001F;


    /**
     *
     * @param animalTypeName Вид животного
     * @param name Кличка животного
     * @param maxRunDistance Максимальная дистанция бега
     * @param maxSwimDistance Максимальная дистанция плавания
     * @param maxJumpHeight Максимальная высота прыжка
     */
    public Animal(String animalTypeName, String name, float maxRunDistance, float maxSwimDistance, float maxJumpHeight) {
        this(animalTypeName, name, maxRunDistance, maxSwimDistance, maxJumpHeight, 0);
    }


    /**
     *
     * @param animalTypeName Вид животного
     * @param name Кличка животного
     * @param maxRunDistance Максимальная дистанция бега
     * @param maxSwimDistance Максимальная дистанция плавания
     * @param maxJumpHeight Максимальная высота прыжка
     * @param randomPercent +/- Процент, на который будут рандомизироваться ненулевые характеристики
     */
    public Animal(String animalTypeName, String name, float maxRunDistance, float maxSwimDistance, float maxJumpHeight, int randomPercent) {

        this.animalTypeName = animalTypeName;
        this.name = name;

        if (randomPercent > 0){
            this.maxRunDistance = getRandomized(maxRunDistance, randomPercent);
            this.maxSwimDistance = getRandomized(maxSwimDistance, randomPercent);
            this.maxJumpHeight = getRandomized(maxJumpHeight, randomPercent);
        } else {
            this.maxRunDistance = maxRunDistance;
            this.maxSwimDistance = maxSwimDistance;
            this.maxJumpHeight = maxJumpHeight;
        }
        totalAnimals++;
    }

    /**
     * Приказывает животному плыть
     * @param swimDistance дистанция
     */
    public boolean swim(float swimDistance){
        System.out.printf("Плыви %.2f м!\n", swimDistance);
        if (ableToSwim() && swimDistance > this.maxSwimDistance){
            System.out.printf("%.2f - слишком большая дистанция для заплыва!\n", swimDistance);
        } else {
            return swimMethod(swimDistance);
        }

        return false;
    }


    /**
     * Метод, которым животное пользуется для плаванья
     * @param swimDistance дистанция
     * @return true, если удалось поплыть
     */
    protected abstract boolean swimMethod(float swimDistance);


    /**
     * Приказывает животному бежать
     * @param runDistance дистанция
     */
    public boolean run(float runDistance){
        System.out.printf("Беги %.2f м!\n", runDistance);
        if (ableToRun() && runDistance > this.maxRunDistance) {
            System.out.printf("%.2f - слишком далеко!\n", runDistance);
        } else {
            return runMethod(runDistance);
        }

        return false;
    }


    /**
     * Метод, которым животное пользуется для бега
     * @param runDistance дистанция
     * @return true, если удалось побежать
     */
    protected abstract boolean runMethod(float runDistance);


    /**
     * Приказывает животному прыгать через препятствие
     * @param jumpHeight высота прыжка
     */
    public boolean jump(float jumpHeight){
        System.out.printf("Прыгай на высоту %.2f м!\n", jumpHeight);
        if (ableToJump() && jumpHeight > this.maxJumpHeight){
            System.out.printf("%.2f - cлишком большая высота для прыжка!\n", jumpHeight);
        } else {
            return jumpMethod(jumpHeight);
        }

        return false;
    }

    /**
     * Метод, которым животное пользуется для прыжка
     * @param jumpHeight высота
     * @return true, если удалось подпрыгнуть
     */
    protected abstract boolean jumpMethod(float jumpHeight);



    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Вид=").append(animalTypeName).append(System.lineSeparator());
        sb.append("Имя=").append(name).append(System.lineSeparator());
        sb.append("Дальность бега=").append( !ableToRun() ? "Не бегает" : String.valueOf(maxRunDistance)).append(System.lineSeparator());
        sb.append("Дальность плавания=").append( !ableToSwim() ? "Не плавает" : String.valueOf(maxSwimDistance)).append(System.lineSeparator());
        sb.append("Высота прыжка=").append( !ableToJump() ? "Не прыгает" : String.valueOf(maxJumpHeight)).append(System.lineSeparator());
        return sb.toString();
    }

    /**
     * @return общее количество созданных животных
     */
    public static int getTotalAnimals() {
        return totalAnimals;
    }

    /**
     * @return Умеет ли животное бегать
     */
    public boolean ableToRun(){
        return maxRunDistance > minFloat;
    }

    /**
     * @return Умеет ли животное плавать
     */
    public boolean ableToSwim(){
        return maxSwimDistance > minFloat;
    }

    /**
     * @return Умеет ли животное бегать
     */
    public boolean ableToJump(){
        return maxJumpHeight > minFloat;
    }


    private static float getRandomized(float f, int percent){
        return (float) Math.round( (f + f * (percent / 100.00F) - Math.random() * f * 2 * (percent / 100.00F)) * 100) / 100;
    }

}
