package ro.paneabogdan.homework;

public class Main {

    public static void main(String[] args) {

        FestivalCoordinator festivalCoordinator = new FestivalCoordinator("Gate nr. 1");
        Thread t1 = new Thread(festivalCoordinator);
        t1.start();
        festivalCoordinator.startFestivalStatisticsThread();
    }
}
