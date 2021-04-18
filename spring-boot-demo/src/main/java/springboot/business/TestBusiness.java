package springboot.business;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.concurrent.*;

@Service
public class TestBusiness {

    private ThreadPoolExecutor executor;

    @EventListener
    private void init(ApplicationReadyEvent event) {
//        executor = new ThreadPoolExecutor(
//                2,
//                2,
//                60,
//                TimeUnit.SECONDS,
//                new LinkedBlockingQueue<>(),
//                Executors.defaultThreadFactory(),
//                new ThreadPoolExecutor.CallerRunsPolicy());
//
//        response();
    }

    private void response() {
        for (int i = 0; i < 100000; i++) {
            final int t = i;
            executor.execute(() -> doResponse(t));
        }
    }

    private void doResponse(int i) {
        System.out.println("response:" + i);
        try {
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
