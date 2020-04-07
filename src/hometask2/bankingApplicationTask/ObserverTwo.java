package hometask2.bankingApplicationTask;

public class ObserverTwo implements Observer {
    @Override
    public void onEvent(String data) {
        System.out.println("Data in ObserverTwo: " + data);
    }
}
