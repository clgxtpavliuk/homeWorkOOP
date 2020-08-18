package tests;

import com.google.common.collect.ImmutableList;
import endpoints.PetStorePetEndpoint;
import io.restassured.response.Response;
import models.Category;
import models.Pet;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class SampleTestsPetStore {


    public static final endpoints.PetStorePetEndpoint PET_STORE_PET_ENDPOINT = new PetStorePetEndpoint();

    @BeforeAll
    public static void cleanUp() {
//        List<Pet> listOfPets = PET_STORE_PET_ENDPOINT
//                .getPetByStatus("available")
//                .body()
//                .jsonPath().getList("S", Pet.class);

//        listOfPets.stream()
////                .filter(pet -> "Barsik".equals(pet.getName()))
////                .forEach(pet -> PET_STORE_PET_ENDPOINT.deleteById(pet.getId()));

        PET_STORE_PET_ENDPOINT
                .getPetByStatus("available")
                .body()
                .jsonPath().getList("findAll {item -> item.name == 'Barsik'}", Pet.class)
                .stream()
                .forEach(pet -> PET_STORE_PET_ENDPOINT.deleteById(pet.getId()));
        System.out.println();
    }

    @Test
    public void verifyStatusCode() {
        PET_STORE_PET_ENDPOINT
                .getPetByStatus("available")
                .then()
                .statusCode(200);
    }

    @Test
    public void verifyBody() {
        PET_STORE_PET_ENDPOINT
                .getPetByStatus("available")
                .then()
                .assertThat()
                .body(Matchers.is(Matchers.not(Matchers.isEmptyOrNullString())));
    }

    @Test
    public void verifyNotExistingPetReturns404() {
        PET_STORE_PET_ENDPOINT
                .getPetById("ndfbjdfnajsn")
                .then()
                .statusCode(404);
    }

    @Test
    public void verifyPetCanBeCreated() {
        Category category = new Category();
        category.setId(123123);
        category.setName("Cats");

        Pet cat = new Pet();
        cat.setName("Barsik");
        cat.setCategory(category);
        //cat.setId();
        cat.setPhotoUrls(ImmutableList.of("SomeURL"));
        cat.setStatus("available");
        PET_STORE_PET_ENDPOINT
                .createPet(cat)
                .then()
                .statusCode(200);
    }

    @Test
    public void verifyBarsikHasIdAfterCreation() {
        Pet barsik = Pet.createBarsik();
        Response petResponse = PET_STORE_PET_ENDPOINT
                .createPet(barsik);
        Pet pet_fromService = petResponse.body().as(Pet.class);
        System.out.println(pet_fromService.getId());
    }

    @Test
    public void verifyBarsikHasIdAfterCreation2() {
        Pet barsik = Pet.createBarsik();
        Response petResponse = PET_STORE_PET_ENDPOINT
                .createPet(barsik);
        Pet pet_fromService = petResponse.body().as(Pet.class);
        Assertions.assertNotNull(pet_fromService.getId());
    }



//    private RequestSpecification createBaseSpec() {
//        return given()
//                .log().uri()
//                .baseUri(config.Config.PETSTORE_BASE_URL);
//    }
}