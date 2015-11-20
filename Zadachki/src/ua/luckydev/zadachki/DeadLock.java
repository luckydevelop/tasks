package ua.luckydev.zadachki;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class DeadLock
{

    ExecutorService executorService = Executors.newFixedThreadPool(3);

//    public void fight (Knight k1, Knight k2)
//    {
//        Knight kmax = k1.id>k2.id ? k1:k2;
//        Knight kmin = k1.id>k2.id ? k2:k1;
//
//        synchronized (k1)
//        {
//            synchronized (k2)
//            {
//                k2.live = 0;
//                k1.experience+=100;
//            }
//
//        }
//
//    }
//

}