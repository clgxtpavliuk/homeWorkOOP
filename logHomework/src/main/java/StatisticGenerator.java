import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;


public class StatisticGenerator {
    private int numberOfCats;
    private int haveTwoChildren;
    private boolean readyForFootballTeam = false;
    private static Logger logger = LogManager.getLogger("Statistic");

    public void whoHasCats(List<Citizen> citizens) {
        for (Citizen c: citizens) {
            if (c.getDomesticAnimal() == DomesticAnimal.CAT) {
                numberOfCats ++;
            }
        }
        logger.info("{} citizens have cats", numberOfCats );
    }

    public void whoHasTwoChildren(List<Citizen> citizens) {
        for (Citizen c: citizens) {
            if (c.getChildren() == 2) {
                haveTwoChildren ++;
            }
        }
        logger.info("{} citizens have two children", haveTwoChildren);
    }

    public void createFootballTeam(List<Citizen> citizens) {
        if (citizens.size() >= 11) {
            readyForFootballTeam = true;
            logger.info("It is possible to create the football team");
        }
        logger.info("Not enough citizens for football team");

    }
}
