package serenity.bdd.steps;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import serenity.bdd.steps.serenity.EndUserSteps;

public class DefinitionSteps {

    @Steps
    EndUserSteps endUser;

    @Given("the user is on the Wikionary home page")
    public void givenTheUserIsOnTheWikionaryHomePage() {
        endUser.is_the_home_page();
    }

    @When("the user looks up the definition of the word '$word'")
    public void whenTheUserLooksUpTheDefinitionOf(String word) {
        endUser.looks_for(word);
    }

    @Then("the definition is equals to '$definition'")
    public void thenTheyShouldSeeADefinitionContainingTheWords(String definition) {
        endUser.should_see_definition(definition);
    }

    @Given("Barsic is created")
    public void givenBarsicIsCreated() {
        endUser.createBarsik();
    }

    @When("we get the response of creation on the endpoint")
    public void whenWeGetTheResponseOfCreationOnTheEndpoint() {
        endUser.createPet();
    }

    @Then("we verify that created pet is Barsic")
    public void thenWeVerifyThatCreatedPetIsBarsic() {
        endUser.verifyPet();
    }

    @Given("the pet is created")
    public void givenThePetIsCreated() {
        endUser.createPetForUpdate();
    }

    @When("the user updates pet")
    public void whenTheUserUpdatesPet() {
        endUser.createPet();
    }

    @Then("the pet is updated")
    public void thePetIsUpdated() {
        endUser.checkUpdatePet();
    }
}
