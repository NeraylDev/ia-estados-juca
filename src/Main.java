//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        enum State
        {
            SLEEPING,
            EATING,
            WORKING
        };

        State state = State.WORKING;

        int hunger = 0;
        int fatigue = 0;

        boolean started = false;

        while (true)
        {
            switch (state) {

                case SLEEPING:

                    if (!started)
                    {
                        System.out.println("Bateu um sono...");
                        started = true;
                    }

                    hunger += 1;
                    fatigue -= 10;

                    System.out.println("Dormindo...");

                    if (fatigue <= 0)
                    {
                        fatigue = 0;

                        if (hunger <= 10)
                            state = State.WORKING;
                        else
                            state = State.EATING;

                        started = false;
                    }

                    break;
                case EATING:

                    if (!started)
                    {
                        System.out.println("Bateu uma fome...");
                        started = true;
                    }

                    hunger -= 5;

                    System.out.println("Comendo...");

                    if (hunger <= 0)
                    {
                        hunger = 0;
                        System.out.println("Ufa! Já estou cheio...");
                        state = State.WORKING;

                        started = false;
                    }

                    break;
                case WORKING:

                    if (!started)
                    {
                        System.out.println("Hora de ir para o trabalho!");
                        started = true;
                    }

                    hunger += 2;
                    fatigue += 5;

                    System.out.println("Trabalhando...");

                    if (fatigue > 50)
                    {
                        state = State.SLEEPING;
                        started = false;
                    }
                    else if (hunger > 10)
                    {
                        state = State.EATING;
                        started = false;
                    }

                    break;

            }

            System.out.println("Fome: " + hunger);
            System.out.println("Cansaço: " + fatigue + "\n");

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

    }
}