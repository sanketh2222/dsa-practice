import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Executor executor = Executors.newSingleThreadExecutor();
        // ExecutorService executorService = Executors.newFixedThreadPool(10);

        // for (int i = 0; i < 10; i++) {
        //     executorService.submit(new Sorter());
        // }

        String s1 = "30";
        String s2 = "3";
        System.out.println(s1.compareTo(s2));
        System.out.println(s1+s2);
        System.out.println(s2+s1);
        System.out.println((s1+s2).compareTo(s2+s1));

    }
}
