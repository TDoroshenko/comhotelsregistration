package com.hotels.registration.dataprovider;

import com.hotels.registration.model.AccounBuilder;
import org.testng.annotations.DataProvider;
import static com.hotels.registration.utils.TestHelper.randomInt;

public class RegistrationDataProvider {

    @DataProvider
    public Object[][] registerNewHotel() {
        return new Object[][]{
                {new AccounBuilder()
                        .withNameOfNewHotel("Galiano" + randomInt())
                        .withGlobalRating("2")
                        .withDateOfConstruction("6/20/1993")
                        .withCountry("USA")
                        .withCity("Phoenix")
                        .withShortDescription("not so bad")
                        .withDescription("Or it is..")
                        .build()
//                },
//                {new AccounBuilder()
//                        .withNameOfNewHotel("Grain" + randomInt())
//                        .withGlobalRating("5")
//                        .withDateOfConstruction("6/7/1997")
//                        .withCountry("Ukraine")
//                        .withCity("Odesa")
//                        .withShortDescription("best ever")
//                        .withDescription("Really is.")
//                        .build()
                }
        };
    }
}
