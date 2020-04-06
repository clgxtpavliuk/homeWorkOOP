package bankingApplicationTask;

public interface Observable {
    void subscribe(Observer observer);
    void generateEvent(String data);
}
