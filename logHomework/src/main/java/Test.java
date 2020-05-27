import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.List;


public class Test {
    private static Logger logger = LogManager.getRootLogger();


    public static void main(String[] args) {
        logger.log(Level.getLevel("CUSTOMER"), "The application started");
       List <Citizen> citizens = new ArrayList<Citizen>();
       Citizen citizen1 = createCitizen("John", "Doe", "Boy", "Dog", 2);
        Citizen citizen2 = createCitizen("Vasia", "Pupkin", "Female", "Cat", 2);
        Citizen citizen3 = createCitizen("Jane", "Air", "Male", "Dear", -4);
       citizens.add(citizen1);
       logger.info("Citizen {} {} added", citizen1.getName(), citizen1.getSurname());
        citizens.add(citizen2);
        logger.info("Citizen {} {} added", citizen2.getName(), citizen2.getSurname());
        citizens.add(citizen3);
        logger.info("Citizen {} {} added", citizen3.getName(), citizen3.getSurname());

       StatisticGenerator statisticGenerator = new StatisticGenerator();
       statisticGenerator.whoHasCats(citizens);
       statisticGenerator.whoHasTwoChildren(citizens);
       statisticGenerator.createFootballTeam(citizens);
    }

    public static Citizen createCitizen(String name, String surname, String sex, String domesticAnimal, int children) {
        Citizen citizen = new Citizen();
        if (name == null || name.isEmpty()) {
            logger.warn("Name can not be {}", name);
        } else {
            citizen.setName(name);
        }
        if (surname == null || surname.isEmpty()) {
            logger.warn("Surname can not be {}", surname);
        } else {
            citizen.setSurname(surname);
        }
        if (children < 0) {
            logger.warn("Incorrect number of children {}", children);
        } else {
            citizen.setChildren(children);
        }
        Sex sex1 = Sex.valueOfSex(sex);
        if (sex1 == null) {
            logger.warn("Incorrect sex {}", sex);
        } else {
            citizen.setSex(sex1);
        }
        DomesticAnimal domesticAnimal1 = DomesticAnimal.valueOfDomesticAnimal(domesticAnimal);
        if (domesticAnimal1 == null) {
            logger.warn("Incorrect domestic animal {}", domesticAnimal);
        } else {
            citizen.setDomesticAnimal(domesticAnimal1);
        }
        return citizen;
    }
}
