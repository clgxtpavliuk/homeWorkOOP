package tests;

import endpoints.PetStoreStoreEndpoint;
import io.restassured.response.Response;
import models.Store;
import net.thucydides.core.annotations.Title;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Type;

//@RunWith(SerenityRunner.class)
public class CrudTestsPetStoreStoreEndpoint {

    public static final PetStoreStoreEndpoint PET_STORE_STORE_ENDPOINT = new PetStoreStoreEndpoint();

    @Test
    @Title("verification of get request")
    public void createStore() {
        //Given
        Store myStore = Store.createStore();

        //When
        Response storeResponse = PET_STORE_STORE_ENDPOINT.createStore(myStore);

        //Then
        long createdStoreId = storeResponse.body().as(Store.class).getId();
        Store createdStoreFromService = PET_STORE_STORE_ENDPOINT.getStoreByOrderId((int) createdStoreId).as((Type) Store.class);

        SoftAssertions assertions = new SoftAssertions();
        assertions.assertThat(createdStoreFromService.getStatus()).as("status").isEqualTo(myStore.getStatus());
        assertions.assertThat(createdStoreFromService.getPetId()).as("petId").isEqualTo(myStore.getPetId());
        assertions.assertAll();
    }

    @Test
    @Title("verification of post request")
    public void readStore() {
        //Given
        Store myStore = Store.createStore();
        Response storeResponse = PET_STORE_STORE_ENDPOINT.createStore(myStore);
        long createdStoreId = storeResponse.body().as(Store.class).getId();

        //When
        Store createdStoreFromService = PET_STORE_STORE_ENDPOINT.getStoreByOrderId((int) createdStoreId).as((Type) Store.class);

        //Then
        SoftAssertions assertions = new SoftAssertions();
        assertions.assertThat(createdStoreFromService.getQuantity()).as("quantity").isEqualTo(myStore.getQuantity());
        assertions.assertThat(createdStoreFromService.getStatus()).as("status").isEqualTo(myStore.getStatus());
        assertions.assertAll();
    }

    @Test
    @Title("verification of get inventory request")
    public void getInventoryStore() {
        //Given
        Store myStore = Store.createStore();

        //When
        Response response = PET_STORE_STORE_ENDPOINT.getPetByInventory();

        //Then
        SoftAssertions assertions = new SoftAssertions();
        assertions.assertThat(response.statusCode()).as("statusCode").isEqualTo(200);
        assertions.assertAll();
    }


    @Test
    @Title("verification of delete request")
    public void deleteStore() {
        //Given
        Store myStore = Store.createStore();
        Response storeResponse = PET_STORE_STORE_ENDPOINT.createStore(myStore);
        long createdStoreId = storeResponse.body().as(Store.class).getId();

        Store createdStoreFromService = PET_STORE_STORE_ENDPOINT.getStoreByOrderId((int) createdStoreId).body().as((Type) Store.class);

        //When
        PET_STORE_STORE_ENDPOINT.deleteStoreById(createdStoreFromService.getId());

        //Then
        Response petById = PET_STORE_STORE_ENDPOINT.getStoreByOrderId((int) createdStoreFromService.getId());
        Assertions.assertThat(petById.getStatusCode()).isEqualTo(404);
    }
}