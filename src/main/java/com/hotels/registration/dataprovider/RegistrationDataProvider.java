package com.hotels.registration.dataprovider;

import com.hotels.registration.model.AccounBuilder;
import org.testng.annotations.DataProvider;

public class RegistrationDataProvider {

    @DataProvider
    public Object[][] registerNewHotel(){
        return new Object[][]{
                new AccounBuilder()
                .withNameOfNewHotel()
        }
    }


}
