package bankingApplicationTask;

public class ObserverOne implements Observer {
    @Override
    public void onEvent(String data) {
        System.out.println("Data in ObserverOne: " + data);
    }
}
