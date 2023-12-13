package hoods.com.jetpetrescue.core.data


import androidx.compose.ui.graphics.Color
import hoods.com.jetpetrescue.features.home.domain.models.Animal
import hoods.com.jetpetrescue.features.home.domain.models.AnimalOwnerContact
import hoods.com.jetpetrescue.features.home.domain.models.Breeds
import hoods.com.jetpetrescue.features.home.domain.models.Colors

object DummyPetDataSource {
    private val ownersList = listOf(
        AnimalOwnerContact(email = "likander@yahoo.com", phone = "00000000000", address = "Egypt"),
        AnimalOwnerContact(email = "oujie@yahoo.com", phone = "00000000000", address = "England"),
        AnimalOwnerContact(email = "sara@yahoo.com", phone = "00000000000", address = "USA"),
        AnimalOwnerContact(email = "sophia@yahoo.com", phone = "00000000000", address = "Canda"),
    )
    val dogList = listOf(

        Animal(
            id = 0,
            name = "Hachiko",
            age = "Adult",
            gender = "Male",
            colors = Colors(
                primary = Color.Black.toString(),
                secondary = Color.Red.toString(),
                tertiary = Color.White.toString(),
            ),
            breeds = Breeds(
                primary = "Canada",
                secondary = null,
                mixed = false,
                unknown = false
            ),
            description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries,",
           distance = "2KM",
            type = "Male",
            tags = null,
            status = null,
            species = null,
            size = null,
            photos = null,
            currentPage = 1,
            animalOwnerContact = ownersList[0]
        ),

    )
}