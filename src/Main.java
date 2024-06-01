import java.util.Scanner;
import java.util.logging.Logger;

public class Main
{
    public static void main(String[] args)
    {
        osnova osnova = new osnova(new Scanner(System.in));
        osnova.start();
    }
}

class osnova
{
    private final Scanner scanner;
    private final deistvie deistvie;

    public osnova(Scanner scanner)
    {
        this.scanner = scanner;
        this.deistvie = new deistvie();
    }

    public void start()
    {
        Logger logger = Logger.getLogger("MyLogger");
        while (true)
        {
            printMenu();
            try
            {
                int choice = scanner.nextInt();

                switch (choice)
                {
                    case 1:
                        deistvie.kazn(scanner);
                        break;
                    case 2:
                        deistvie.money(scanner);
                        break;
                    case 3:
                        deistvie.rab(scanner);
                        break;
                    case 4:
                        deistvie.pitka(scanner);
                        break;
                    case 5:
                        deistvie.sjech(scanner);
                        break;
                    default:
                        System.out.println("Выберите конкретный пункт");
                }
            }
            catch (Exception e)
            {
                logger.severe("Ошибка в printMenu" + e.getMessage());
            }
        }
    }

    private void printMenu()
    {
        System.out.println("Что сегодня будем делать?");
        System.out.println("1) казнить человека топором");
        System.out.println("2) Посчитать свои денюшки");
        System.out.println("3) завести себе раба");
        System.out.println("4) допросить окоянного");
        System.out.println("5) Сжечь еретиков");
    }
}

    class deistvie
    {
        private static final Logger logger = Logger.getLogger("deistvie");

        public void kazn(Scanner scanner)
        {
            try
            {
                System.out.println("Как зовут смертника?");
                String name = scanner.next();
                System.out.println("Что будем с ним делать?");
                System.out.println("1) убивать");
                System.out.println("2) миловать");
                int vibor = scanner.nextInt();
                Kazn kazn = new Kazn(name);
                if (vibor == 1)
                {
                    kazn.kill();
                }
                else if (vibor == 2)
                {
                    kazn.pardon();
                }
                else
                {
                    System.out.println("Ты по моему перепутал");
                }
            }
            catch (Exception e)
            {
                logger.severe("Ошибка в kazn" + e.getMessage());
            }
        }

        public void money(Scanner scanner)
        {
            try
            {
                System.out.println("С чего начнём?");
                System.out.println("1) текущий счёт");
                System.out.println("2) пополнить баланс");
                int vibor = scanner.nextInt();
                Money money = new Money();
                if (vibor == 1)
                {
                    money.Balance(100000);
                }
                else if (vibor == 2)
                {
                    money.dep(scanner);
                }
                else
                {
                    System.out.println("Ты по моему перепутал");
                }
            }
            catch (Exception e)
            {
                logger.severe("Ошибка в методе money: " + e.getMessage());
            }
        }

    public void rab(Scanner scanner)
    {
        try
        {
            System.out.println("Введите количество рабов которые вы хотите приобрести:");
            System.out.println("Негров:");
            int negroes = scanner.nextInt();
            System.out.println("Азиатов");
            int asians = scanner.nextInt();
            Rabi rab = new Rabi();
            rab.buyrab(negroes, asians);
        }
        catch (Exception e)
        {
            logger.severe("Ошибка в методе rab: " + e.getMessage());
        }
    }

    public void pitka(Scanner scanner)
    {
        try
        {
            System.out.println("Как зовут окоянного?");
            String name = scanner.next();
            System.out.println("Как будем его пытать?");
            String method = scanner.next();
            Pitkavibor pitkavibor = new Pitkavibor(name, method);
            pitkavibor.pitkago();
        }
        catch (Exception e)
        {
            logger.severe("Ошибка в методе pitka: " + e.getMessage());
        }
    }

    public void sjech(Scanner scanner)
    {
        try
        {
            System.out.println("Скольких сжечь?");
            int kolvo = scanner.nextInt();
            Burn burn = new Burn();
            burn.burneretics(kolvo);
        }
        catch (Exception e)
        {
            logger.severe("Ошибка в методе sjech: " + e.getMessage());
        }
    }
}

class Kazn
{
    private final String name;

    public Kazn(String name)
    {
        this.name = name;
    }

    public void kill()
    {
        System.out.println("Вы казнили " + name);
    }

    public void pardon()
    {
        System.out.println("Вы помиловали " + name);
    }
}

class Money
{
    private static final Logger logger = Logger.getLogger("deistvie");
    public void Balance(double balance)
    {
        System.out.println("Текущий счёт: " + balance + " рублей");
    }

    public void dep(Scanner scanner)
    {
        try
        {
            System.out.println("Сколько добавить денюшек? ");
            double amount = scanner.nextDouble();
            System.out.println("После пополнения счёта получилось " + (100000 + amount) + " рублей");
        }
        catch (Exception e)
        {
            logger.severe("Ошибка в методе rab: " + e.getMessage());
        }
    }
}

class Rabi
{
    public void buyrab(int negroes, int asians)
    {
        int vsego = negroes + asians;
        System.out.println("Всего вы купили " + vsego + " рабов");
    }
}

class Pitkavibor
{
    private final String name;
    private final String method;

    public Pitkavibor(String name, String method)
    {
        this.name = name;
        this.method = method;
    }

    public void pitkago()
    {
        System.out.println("Окоянного " + name + " вы пытали " + method);
    }
}

class Burn
{
    public void burneretics(int count)
    {
        System.out.println("Не хило, вы сожгли целых " + count + " еретиков");
    }
}